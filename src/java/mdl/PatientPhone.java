/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "PATIENT_PHONE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientPhone.findAll", query = "SELECT p FROM PatientPhone p"),
    @NamedQuery(name = "PatientPhone.findById", query = "SELECT p FROM PatientPhone p WHERE p.id = :id"),
    @NamedQuery(name = "PatientPhone.findByPhoneRaw", query = "SELECT p FROM PatientPhone p WHERE p.phoneRaw = :phoneRaw"),
    @NamedQuery(name = "PatientPhone.findByNotes", query = "SELECT p FROM PatientPhone p WHERE p.notes = :notes"),
    @NamedQuery(name = "PatientPhone.findByCountryCode", query = "SELECT p FROM PatientPhone p WHERE p.countryCode = :countryCode"),
    @NamedQuery(name = "PatientPhone.findByLevel1Code", query = "SELECT p FROM PatientPhone p WHERE p.level1Code = :level1Code"),
    @NamedQuery(name = "PatientPhone.findByLevel2Code", query = "SELECT p FROM PatientPhone p WHERE p.level2Code = :level2Code"),
    @NamedQuery(name = "PatientPhone.findByPhoneNumber", query = "SELECT p FROM PatientPhone p WHERE p.phoneNumber = :phoneNumber")})
public class PatientPhone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PATIENT_PHONE_ID_GENERATOR", sequenceName="PATIENT_PHONE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATIENT_PHONE_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PHONE_RAW")
    private String phoneRaw;
    
    @Size(max = 255)
    private String notes;
    
    @Size(max = 4)
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    
    @Size(max = 8)
    @Column(name = "LEVEL1_CODE")
    private String level1Code;
    
    @Size(max = 8)
    @Column(name = "LEVEL2_CODE")
    private String level2Code;
    
    @Size(max = 16)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    
    /*
    @OneToMany(mappedBy = "famMemberPhoneId", fetch = FetchType.EAGER)
    private List<Patient> patientList;
    
    @OneToMany(mappedBy = "partnerPhoneId", fetch = FetchType.EAGER)
    private List<Patient> patientList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phoneId", fetch = FetchType.EAGER)
    private List<PatientCall> patientCallList;
    */
    
    @JoinColumn(name = "TEL_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private TelType telTypeId;
    
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patientId;

    public PatientPhone() {
    }

    public PatientPhone(Long id) {
        this.id = id;
    }

    public PatientPhone(Long id, String phoneRaw) {
        this.id = id;
        this.phoneRaw = phoneRaw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneRaw() {
        return phoneRaw;
    }

    public void setPhoneRaw(String phoneRaw) {
        this.phoneRaw = phoneRaw;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLevel1Code() {
        return level1Code;
    }

    public void setLevel1Code(String level1Code) {
        this.level1Code = level1Code;
    }

    public String getLevel2Code() {
        return level2Code;
    }

    public void setLevel2Code(String level2Code) {
        this.level2Code = level2Code;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    @XmlTransient
    @JsonIgnore
    public List<Patient> getPatientList1() {
        return patientList1;
    }

    public void setPatientList1(List<Patient> patientList1) {
        this.patientList1 = patientList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<PatientCall> getPatientCallList() {
        return patientCallList;
    }
    public void setPatientCallList(List<PatientCall> patientCallList) {
        this.patientCallList = patientCallList;
    }
*/

    public TelType getTelTypeId() {
        return telTypeId;
    }

    public void setTelTypeId(TelType telTypeId) {
        this.telTypeId = telTypeId;
    }

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
        boolean result = false;
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientPhone)) {
            return false;
        }
        PatientPhone other = (PatientPhone) object;
        if ((this.id == null && other.id != null) //если текущая ID null а сравниваемая - не нулл
            || (this.id != null && !this.id.equals(other.id))//или, если текущая ID не null и не равна сравниваемой
                 
                ) {
            result = false;
        }
        
        if( this.id!=null && this.id.equals(other.id)  || (this.phoneRaw.equals(other.phoneRaw) && this.id==null && other.id==null) ){
          result = true;
        } 
        
     return result;   
    }

    @Override
    public String toString() {
        return phoneRaw;
    }
    
}
