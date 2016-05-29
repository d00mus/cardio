/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "PARTNER_EMPLOYE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerEmploye.findAll", query = "SELECT p FROM PartnerEmploye p"),
    @NamedQuery(name = "PartnerEmploye.findById", query = "SELECT p FROM PartnerEmploye p WHERE p.id = :id"),
    @NamedQuery(name = "PartnerEmploye.findByFirstName", query = "SELECT p FROM PartnerEmploye p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "PartnerEmploye.findByLastName", query = "SELECT p FROM PartnerEmploye p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "PartnerEmploye.findByMiddleName", query = "SELECT p FROM PartnerEmploye p WHERE p.middleName = :middleName"),
    @NamedQuery(name = "PartnerEmploye.findBySex", query = "SELECT p FROM PartnerEmploye p WHERE p.sex = :sex"),
    @NamedQuery(name = "PartnerEmploye.findByBirthDate", query = "SELECT p FROM PartnerEmploye p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "PartnerEmploye.findByIsDoc", query = "SELECT p FROM PartnerEmploye p WHERE p.isDoc = :isDoc"),
    @NamedQuery(name = "PartnerEmploye.findByRefCount", query = "SELECT p FROM PartnerEmploye p WHERE p.refCount = :refCount"),
    @NamedQuery(name = "PartnerEmploye.findByEmail1", query = "SELECT p FROM PartnerEmploye p WHERE p.email1 = :email1"),
    @NamedQuery(name = "PartnerEmploye.findByEmail2", query = "SELECT p FROM PartnerEmploye p WHERE p.email2 = :email2"),
    @NamedQuery(name = "PartnerEmploye.findByWww", query = "SELECT p FROM PartnerEmploye p WHERE p.www = :www"),
    @NamedQuery(name = "PartnerEmploye.findByUaState", query = "SELECT p FROM PartnerEmploye p WHERE p.uaState = :uaState"),
    @NamedQuery(name = "PartnerEmploye.findByManagerId", query = "SELECT p FROM PartnerEmploye p WHERE p.manager = :manager"),
    @NamedQuery(name = "PartnerEmploye.findByManager2Id", query = "SELECT p FROM PartnerEmploye p WHERE p.manager2 = :manager2"),
    @NamedQuery(name = "PartnerEmploye.findByPartnerId", query = "SELECT p FROM PartnerEmploye p WHERE p.partner = :partner")})
public class PartnerEmploye implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PARTNER_EMPLOYE_ID_GENERATOR", sequenceName="PARTNER_EMPLOYE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTNER_EMPLOYE_ID_GENERATOR")
    private Long id;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Size(max = 255)
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "SEX")
    private DbGenderEnum sex = DbGenderEnum.M;
    
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IS_DOC")
    private String isDoc="true";
    
    @Column(name = "REF_COUNT")
    private Integer refCount;
    
    @Size(max = 1024)
    private String email1;
    
    @Size(max = 1024)
    private String email2;
    
    @Size(max = 1024)
    private String www;
    
    @JoinColumn(name = "UA_STATE_ID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.DETACH)
    private UaState uaState;
    
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.DETACH)
    private CardioUser manager;
    
    @JoinColumn(name = "MANAGER2_ID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.DETACH)
    private CardioUser manager2;
    
    @Column(name = "NOTES")
    private String notes;
    
    @NotNull
    @JoinColumn(name = "PARTNER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false,cascade = CascadeType.REMOVE)
    private CardioPartner partner;
    
    
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Position position;
    
    @JoinColumn(name = "DOCTOR_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private DoctorType doctorType;
    
    @JoinColumn(name = "DOCTOR_RANK_ID", referencedColumnName = "ID")
    @ManyToOne
    private DoctorRank doctorRank;
    
    @JoinColumn(name = "DOCTOR_PRIORITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private DoctorPriority doctorPriority;
    
    @JoinColumn(name = "DOCTOR_POSITION_ID", referencedColumnName = "ID")
    @ManyToOne
    private DoctorPosition doctorPosition;
    
    @JoinColumn(name = "DOCTOR_DIVISION_ID", referencedColumnName = "ID")
    @ManyToOne
    private DoctorDivision doctorDivision;
    
    @JoinColumn(name = "DOCTOR_ASSOC_ID", referencedColumnName = "ID")
    @ManyToOne
    private DoctorAssoc doctorAssoc;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employe")
    private List<PartnerEmployePhone> partnerEmployePhoneList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employe")
    private List<PartnerEvent> partnerEventList = new ArrayList<PartnerEvent>();
    

    public PartnerEmploye() {
    }

    public PartnerEmploye(Long id) {
        this.id = id;
    }

    public PartnerEmploye(Long id, String firstName, String lastName, String isDoc) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isDoc = isDoc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public DbGenderEnum getSex() {
        return sex;
    }

    public void setSex(DbGenderEnum sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isDoc() {
        return Boolean.valueOf(isDoc);
    }

    public void setDoc(boolean isDoc) {
        this.isDoc = String.valueOf(isDoc);
    }

    public Integer getRefCount() {
        return refCount;
    }

    public void setRefCount(Integer refCount) {
        this.refCount = refCount;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public UaState getUaState() {
        return uaState;
    }

    public void setUaState(UaState uaState) {
        this.uaState = uaState;
    }

    public CardioUser getManager() {
        return manager;
    }

    public void setManager(CardioUser manager) {
        this.manager = manager;
    }

    public CardioUser getManager2() {
        return manager2;
    }

    public void setManager2(CardioUser manager2) {
        this.manager2 = manager2;
    }

    public CardioPartner getPartner() {
        return partner;
    }

    public void setPartner(CardioPartner partner) {
        this.partner = partner;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public DoctorType getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(DoctorType doctorType) {
        this.doctorType = doctorType;
    }

    public DoctorRank getDoctorRank() {
        return doctorRank;
    }

    public void setDoctorRank(DoctorRank doctorRank) {
        this.doctorRank = doctorRank;
    }

    public DoctorPriority getDoctorPriority() {
        return doctorPriority;
    }

    public void setDoctorPriority(DoctorPriority doctorPriority) {
        this.doctorPriority = doctorPriority;
    }

    public DoctorPosition getDoctorPosition() {
        return doctorPosition;
    }

    public void setDoctorPosition(DoctorPosition doctorPosition) {
        this.doctorPosition = doctorPosition;
    }

    public DoctorDivision getDoctorDivision() {
        return doctorDivision;
    }

    public void setDoctorDivision(DoctorDivision doctorDivision) {
        this.doctorDivision = doctorDivision;
    }

    public DoctorAssoc getDoctorAssoc() {
        return doctorAssoc;
    }

    public void setDoctorAssoc(DoctorAssoc doctorAssoc) {
        this.doctorAssoc = doctorAssoc;
    }

    @XmlTransient
    @JsonIgnore
    public List<PartnerEmployePhone> getPartnerEmployePhoneList() {
        if(partnerEmployePhoneList==null){
         partnerEmployePhoneList = new ArrayList<PartnerEmployePhone>();   
        } 
        return partnerEmployePhoneList;
    }

    public void setPartnerEmployePhoneList(List<PartnerEmployePhone> partnerEmployePhoneList) {
        this.partnerEmployePhoneList = partnerEmployePhoneList;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<PartnerEvent> getPartnerEventList() {
        if(partnerEventList==null){
          partnerEventList = new ArrayList<PartnerEvent>();   
        }
        return partnerEventList;
    }

    public void setPartnerEventList(List<PartnerEvent> partnerEventList) {
        this.partnerEventList = partnerEventList;
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
        if (!(object instanceof PartnerEmploye)) {
            return false;
        }
        
        PartnerEmploye other = (PartnerEmploye) object;
        if((this.id != null) && (other != null) && (this.id.equals(other.id))){
            return true;
        };
        
        if((this.firstName!=null) && (other.firstName!=null)
           &&(this.firstName.equals(other.firstName))
           &&(this.lastName!=null)&&(other.lastName!=null)
           &&(this.lastName.equals(other.lastName))     
           &&(this.partner!=null)&&(other.partner!=null)
           &&(this.partner.equals(other.partner))     
          )return true;
      
        
      return false;      
    }

    @Override
    public String toString() {
        return lastName +" "+firstName;
    }
    
    public String getFio(){
        String r = lastName +" "+firstName;
       if(middleName!=null){
           return r+" "+middleName;
       }
      return r; 
    }
    
}
