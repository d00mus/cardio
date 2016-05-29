package mdl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
    @NamedQuery(name = "Task.findById", query = "SELECT t FROM Task t WHERE t.id = :id"),
    @NamedQuery(name = "Task.findByPlanDate", query = "SELECT t FROM Task t WHERE t.planDate = :planDate"),
    @NamedQuery(name = "Task.findByFactDate", query = "SELECT t FROM Task t WHERE t.factDate = :factDate"),
    @NamedQuery(name = "Task.findByPerson", query = "SELECT t FROM Task t WHERE t.person = :person"),
    @NamedQuery(name = "Task.findByNotes", query = "SELECT t FROM Task t WHERE t.notes = :notes"),
    @NamedQuery(name = "Task.findByUaTownId", query = "SELECT t FROM Task t WHERE t.uaTown = :uaTown"),
    @NamedQuery(name = "Task.findByUserId", query = "SELECT t FROM Task t WHERE t.user = :user"),
    @NamedQuery(name = "Task.findByPartnerId", query = "SELECT t FROM Task t WHERE t.partner = :partner")})
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="TASK_ID_GENERATOR", sequenceName="TASK_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASK_ID_GENERATOR")
    
    private Long id;
    
    @Column(name = "PLAN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date planDate;
    
    @Column(name = "FACT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date factDate;
    
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private PartnerEmploye person;
    
    @Size(max = 4000)
    private String notes;

    @Column(name = "CONT_PERS_AUX")
    private String personAux;
    
    @JoinColumn(name = "CONT_PERS_PHONE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private PartnerEmployePhone personPhone;
        
    
    @Column(name = "CONT_PERS_PHONE_AUX")
    private String personPhoneAux;
    
    
    @JoinColumn(name = "UA_TOWN_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UaTown uaTown;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser user;
    
    @JoinColumn(name = "PARTNER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioPartner partner;
    
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TaskType type;
    
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TaskStatus status;

    @JoinColumn(name = "ENGINEER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser engineer;
    
    
    @OneToMany
    @JoinTable(name = "TASK_STORE_ITEM"
              ,joinColumns = {@JoinColumn(name="TASK_ID")}
              ,inverseJoinColumns = {@JoinColumn(name="ITEM_ID")})    
    private List<StoreItem> storeItemList=new ArrayList<StoreItem>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task", orphanRemoval = true)
    private List<TaskEquipment> taskEquipmentList = new ArrayList<TaskEquipment>();
    
    
    public Task() {
    }

    public Task(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Date getFactDate() {
        return factDate;
    }

    public void setFactDate(Date factDate) {
        this.factDate = factDate;
    }

    public PartnerEmploye getPerson() {
        return person;
    }

    public void setPerson(PartnerEmploye person) {
        this.person = person;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public UaTown getUaTown() {
        return uaTown;
    }

    public void setUaTown(UaTown uaTown) {
        this.uaTown = uaTown;
    }

    public CardioUser getUser() {
        return user;
    }

    public void setUser(CardioUser user) {
        this.user = user;
    }

    public CardioPartner getPartner() {
        return partner;
    }

    public void setPartner(CardioPartner partner) {
        this.partner = partner;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public CardioUser getEngineer() {
        return engineer;
    }

    public void setEngineer(CardioUser engineer) {
        this.engineer = engineer;
    }

    public String getPersonAux() {
        return personAux;
    }

    public void setPersonAux(String personAux) {
        this.personAux = personAux;
    }

    public PartnerEmployePhone getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(PartnerEmployePhone personPhone) {
        this.personPhone = personPhone;
    }

    public String getPersonPhoneAux() {
        return personPhoneAux;
    }

    public void setPersonPhoneAux(String personPhoneAux) {
        this.personPhoneAux = personPhoneAux;
    }

    
    public String getContPersonName() {
       if (person !=null){
           return person.getFio();
       } 
       return personAux;
    }

    
    public String getContPersonPhone() {
        if (personPhone != null) {
            return personPhone.getPhone();
        }
        return personPhoneAux;
    }

    @XmlTransient
    @JsonIgnore
    public List<StoreItem> getStoreItemList() {
        return storeItemList;
    }

    public void setStoreItemList(List<StoreItem> storeItemList) {
        this.storeItemList = storeItemList;
    }

    @XmlTransient
    @JsonIgnore
    public List<TaskEquipment> getTaskEquipmentList() {
        return taskEquipmentList;
    }

    public void setTaskEquipmentList(List<TaskEquipment> taskEquipmentList) {
        this.taskEquipmentList = taskEquipmentList;
    }
    
    
    
    @XmlTransient
    @JsonIgnore
    public String getStoreItemListAsString() {
        StringBuilder sb = new StringBuilder();
        for(TaskEquipment ti:taskEquipmentList){
            sb.append(ti.getModel().getName()).append(", ");
        }
        if(sb.length()>2){
            sb.setLength(sb.length()-2);
        }
        return sb.toString();
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
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "mdl.Task[ id=" + id + " ]";
    }
    
}
