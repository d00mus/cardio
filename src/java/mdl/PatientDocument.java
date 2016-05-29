/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PATIENT_DOCUMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientDocument.findAll", query = "SELECT p FROM PatientDocument p"),
    @NamedQuery(name = "PatientDocument.findById", query = "SELECT p FROM PatientDocument p WHERE p.id = :id"),
    @NamedQuery(name = "PatientDocument.findByFileName", query = "SELECT p FROM PatientDocument p WHERE p.fileName = :fileName"),
    @NamedQuery(name = "PatientDocument.findByFileDate", query = "SELECT p FROM PatientDocument p WHERE p.fileDate = :fileDate"),
    @NamedQuery(name = "PatientDocument.findByFileSize", query = "SELECT p FROM PatientDocument p WHERE p.fileSize = :fileSize"),
    @NamedQuery(name = "PatientDocument.findByUploadDate", query = "SELECT p FROM PatientDocument p WHERE p.uploadDate = :uploadDate"),
    @NamedQuery(name = "PatientDocument.findByDescription", query = "SELECT p FROM PatientDocument p WHERE p.description = :description"),
    @NamedQuery(name = "PatientDocument.findByPatientId", query = "SELECT p FROM PatientDocument p WHERE p.patient = :patient")
})
public class PatientDocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PATIENT_DOCUMENT_ID_GENERATOR", sequenceName="PATIENT_DOCUMENT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_DOCUMENT_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FILE_NAME")
    private String fileName;
    
    @Column(name = "FILE_DATE")
    @Temporal(TemporalType.DATE)
    private Date fileDate;
    
    @Column(name = "FILE_SIZE")
    private Integer fileSize;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPLOAD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate = new Date();
    
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Lob
    @Column(name = "FILE_DATA")
    @Basic(fetch=FetchType.LAZY)
    private byte[] fileData;
    
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Patient patient;

    public PatientDocument() {
    }

    public PatientDocument(Long id) {
        this.id = id;
    }

    public PatientDocument(Long id, String fileName, Date uploadDate) {
        this.id = id;
        this.fileName = fileName;
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

    public Date getFileDate() {
        return fileDate;
    }

    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
        if (!(object instanceof PatientDocument)) {
            return false;
        }
        PatientDocument other = (PatientDocument) object;
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
