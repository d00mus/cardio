/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

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

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "DOCTORS_EXTERNAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoctorsExternal.findAll", query = "SELECT d FROM DoctorsExternal d"),
    @NamedQuery(name = "DoctorsExternal.findById", query = "SELECT d FROM DoctorsExternal d WHERE d.id = :id"),
    @NamedQuery(name = "DoctorsExternal.findByFio", query = "SELECT d FROM DoctorsExternal d WHERE d.fio = :fio"),
    @NamedQuery(name = "DoctorsExternal.findByBirthDate", query = "SELECT d FROM DoctorsExternal d WHERE d.birthDate = :birthDate"),
    @NamedQuery(name = "DoctorsExternal.findBySendRankId", query = "SELECT d FROM DoctorsExternal d WHERE d.sendRankId = :sendRankId"),
    @NamedQuery(name = "DoctorsExternal.findByDocTypeId", query = "SELECT d FROM DoctorsExternal d WHERE d.docTypeId = :docTypeId"),
    @NamedQuery(name = "DoctorsExternal.findByContactsId", query = "SELECT d FROM DoctorsExternal d WHERE d.contactsId = :contactsId")})
public class DoctorsExternal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="DOCTORS_EXTERNAL_ID_GENERATOR", sequenceName="DOCTORS_EXTERNAL_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCTORS_EXTERNAL_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String fio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    
    @JoinColumn(name = "SEND_RANK_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private SendRank sendRankId;
    
    @JoinColumn(name = "DOC_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private ExDocType docTypeId;
    
    @JoinColumn(name = "CONTACTS_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Contacts contactsId;
    
    @JoinColumn(name = "UA_TOWN_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private UaTown uaTownId;
    
    @JoinColumn(name = "UA_STATE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private UaState uaStateId;
    
    @OneToMany(mappedBy = "refInfoDocId", fetch = FetchType.EAGER)
    private List<Patient> patientList;

    public DoctorsExternal() {
    }

    public DoctorsExternal(Long id) {
        this.id = id;
    }

    public DoctorsExternal(Long id, String fio, Date birthDate) {
        this.id = id;
        this.fio = fio;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public SendRank getSendRankId() {
        return sendRankId;
    }

    public void setSendRankId(SendRank sendRankId) {
        this.sendRankId = sendRankId;
    }

    public ExDocType getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(ExDocType docTypeId) {
        this.docTypeId = docTypeId;
    }

    public Contacts getContactsId() {
        return contactsId;
    }

    public void setContactsId(Contacts contactsId) {
        this.contactsId = contactsId;
    }

    public UaTown getUaTownId() {
        return uaTownId;
    }

    public void setUaTownId(UaTown uaTownId) {
        this.uaTownId = uaTownId;
    }

    public UaState getUaStateId() {
        return uaStateId;
    }

    public void setUaStateId(UaState uaStateId) {
        this.uaStateId = uaStateId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
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
        if (!(object instanceof DoctorsExternal)) {
            return false;
        }
        DoctorsExternal other = (DoctorsExternal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fio;
    }
    
}
