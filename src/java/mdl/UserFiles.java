/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.ByteArrayInputStream;
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
@Table(name = "USER_FILES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserFiles.findAll", query = "SELECT u FROM UserFiles u"),
    @NamedQuery(name = "UserFiles.findById", query = "SELECT u FROM UserFiles u WHERE u.id = :id"),
    @NamedQuery(name = "UserFiles.findByFileName", query = "SELECT u FROM UserFiles u WHERE u.fileName = :fileName"),
    @NamedQuery(name = "UserFiles.findByFileDate", query = "SELECT u FROM UserFiles u WHERE u.fileDate = :fileDate"),
    @NamedQuery(name = "UserFiles.findByDescription", query = "SELECT u FROM UserFiles u WHERE u.description = :description"),
    @NamedQuery(name = "UserFiles.findByUploaded", query = "SELECT u FROM UserFiles u WHERE u.uploaded = :uploaded")})
public class UserFiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic
    @SequenceGenerator(name="USER_FILES_ID_GENERATOR", sequenceName="USER_FILES_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_FILES_ID_GENERATOR")
    private Integer id;
    
    @Size(max = 255)
    @Column(name = "FILE_NAME")
    private String fileName;
    
    @Column(name = "FILE_DATE")
    @Temporal(TemporalType.DATE)
    private Date fileDate;
    
    @Size(max = 255)
    private String description;
    
    @Lob
    @Column(name = "FILE_DATA")
    @Basic(fetch=FetchType.LAZY)
    private byte[] fileData;
    
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploaded = new Date();
    
    @OneToMany(mappedBy = "avatarFile")
    private List<CardioUser> cardioUserList;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser user;

    public UserFiles() {
    }

    public UserFiles(Integer id) {
        this.id = id;
    }

    public UserFiles(Integer id, Date uploaded) {
        this.id = id;
        this.uploaded = uploaded;
    }

    
    public StreamedContent getJpgFileDataAsStream(){
      return new DefaultStreamedContent( new ByteArrayInputStream(fileData),"image/jpg",fileName);
    }
    
    //================ геттеры и сеттеры =============================
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getUploaded() {
        return uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    @XmlTransient
    @JsonIgnore
    public List<CardioUser> getCardioUserList() {
        return cardioUserList;
    }

    public void setCardioUserList(List<CardioUser> cardioUserList) {
        this.cardioUserList = cardioUserList;
    }

    public CardioUser getUser() {
        return user;
    }

    public void setUser(CardioUser user) {
        this.user = user;
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
        if (!(object instanceof UserFiles)) {
            return false;
        }
        UserFiles other = (UserFiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.UserFiles[ id=" + id + " ]";
    }
    
}
