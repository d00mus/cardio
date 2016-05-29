/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PATIENT_PHOTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientPhoto.findAll", query = "SELECT p FROM PatientPhoto p"),
    @NamedQuery(name = "PatientPhoto.findById", query = "SELECT p FROM PatientPhoto p WHERE p.id = :id"),
    @NamedQuery(name = "PatientPhoto.findByFileName", query = "SELECT p FROM PatientPhoto p WHERE p.fileName = :fileName"),
    @NamedQuery(name = "PatientPhoto.findByDescription", query = "SELECT p FROM PatientPhoto p WHERE p.description = :description"),
    @NamedQuery(name = "PatientPhoto.findByPhotoDate", query = "SELECT p FROM PatientPhoto p WHERE p.photoDate = :photoDate"),
    @NamedQuery(name = "PatientPhoto.findByUploadDate", query = "SELECT p FROM PatientPhoto p WHERE p.uploadDate = :uploadDate")})
public class PatientPhoto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PATIENT_PHOTO_ID_GENERATOR", sequenceName="PATIENT_PHOTO_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_PHOTO_ID_GENERATOR")
    private Long id;
    
    @Size(max = 255)
    @Column(name = "FILE_NAME")
    private String fileName;
    
    @Size(max = 2000)
    private String description;
    
    @Column(name = "PHOTO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date photoDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPLOAD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate = new Date();
    
    @Lob
    @Column(name = "FILE_DATA")
    private byte[] fileData;
    
    /*
    @OneToMany(mappedBy = "avatarId", fetch = FetchType.EAGER)
    private List<Patient> patientList;
    */
    
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patientId;

    public PatientPhoto() {
    }

    public PatientPhoto(Long id) {
        this.id = id;
    }

    public PatientPhoto(Long id, Date uploadDate) {
        this.id = id;
        this.uploadDate = uploadDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPhotoDate() {
        return photoDate;
    }

    public void setPhotoDate(Date photoDate) {
        this.photoDate = photoDate;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    
    public StreamedContent getFileDataAsStream(){
        if(fileData == null || fileData.length == 0){
            return null;
        }
      return new DefaultStreamedContent( new ByteArrayInputStream(fileData),"image/jpg",fileName);
    }
/*    
    @XmlTransient
    @JsonIgnore
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
*/
    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientPhoto)) {
            return false;
        }
        PatientPhoto other = (PatientPhoto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fileName;
    }
    
}
