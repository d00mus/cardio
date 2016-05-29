package mdl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
 * Фирмы - партнёры кардио
 * @author d00mus
 */
@Entity
@Table(name = "CARDIO_PARTNER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardioPartner.findAll", query = "SELECT c FROM CardioPartner c"),
    @NamedQuery(name = "CardioPartner.findById", query = "SELECT c FROM CardioPartner c WHERE c.id = :id"),
    @NamedQuery(name = "CardioPartner.findByName", query = "SELECT c FROM CardioPartner c WHERE c.name = :name"),
    @NamedQuery(name = "CardioPartner.findByPhone", query = "SELECT c FROM CardioPartner c WHERE c.phone = :phone"),
    @NamedQuery(name = "CardioPartner.findByJurAddrStreet", query = "SELECT c FROM CardioPartner c WHERE c.jurAddrStreet = :jurAddrStreet"),
    @NamedQuery(name = "CardioPartner.findByJurAddrHouse", query = "SELECT c FROM CardioPartner c WHERE c.jurAddrHouse = :jurAddrHouse"),
    @NamedQuery(name = "CardioPartner.findByInn", query = "SELECT c FROM CardioPartner c WHERE c.inn = :inn"),
    @NamedQuery(name = "CardioPartner.findByWww", query = "SELECT c FROM CardioPartner c WHERE c.www = :www"),
    @NamedQuery(name = "CardioPartner.findByEmail", query = "SELECT c FROM CardioPartner c WHERE c.email = :email"),
    @NamedQuery(name = "CardioPartner.findByJurAddrUaTown", query = "SELECT c FROM CardioPartner c WHERE c.jurAddrUaTown = :jurAddrUaTown"),
    @NamedQuery(name = "CardioPartner.findByJurAddrUaState", query = "SELECT c FROM CardioPartner c WHERE c.jurAddrUaState = :jurAddrUaState"),
    @NamedQuery(name = "CardioPartner.findByManager", query = "SELECT c FROM CardioPartner c WHERE c.manager = :manager")})
public class CardioPartner implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="CARDIO_PARTNER_ID_GENERATOR", sequenceName="CARDIO_PARTNER_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARDIO_PARTNER_ID_GENERATOR")
    
    private Long id;
    
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioPartnerType type;
    
    
    @Size(max = 255)
    private String name;
    @NotNull
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 128)
    private String phone;
    
    @Size(max = 128)
    private String phone1;
    
    @Size(max = 255)
    @Column(name = "JUR_ADDR_STREET")
    private String jurAddrStreet;
    
    @Size(max = 100)
    @Column(name = "JUR_ADDR_HOUSE")
    private String jurAddrHouse;
    
    @Size(max = 16)
    @NotNull
    private String inn;
    
    @Size(max = 1024)
    private String www;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 1024)
    private String email;
    
    //поправить ссылки!
    @JoinColumn(name = "JUR_ADDR_UA_TOWN_ID", referencedColumnName = "ID",nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private UaTown jurAddrUaTown;

    
    @JoinColumn(name = "JUR_ADDR_UA_STATE_ID", referencedColumnName = "ID",nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private UaState jurAddrUaState;
    
    
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private CardioUser manager;
    
    @Column(name = "IS_CLOSED")
    private String closed;
    
    //TODO:for del!!??
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partner",orphanRemoval = true)
    private List<PartnerAddress> partnerAddressList = new ArrayList<>();
    
    @OneToMany(mappedBy = "partner",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PartnerBankRecv> partnerBankRecvList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partner",orphanRemoval = true)
    private List<PartnerEvent> partnerEventList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partner",orphanRemoval = true)
    private List<PartnerEmploye> partnerEmployeList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partner",orphanRemoval = true)
    private List<CardioProject> partnerProjectList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partner",orphanRemoval = true)
    private List<Task> partnerTaskList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partner",orphanRemoval = true)
    private List<StoreItem> storeItemList = new ArrayList<>();
    
    public CardioPartner() {
    }

    public CardioPartner(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
    public String getJurAddrStreet() {
        return jurAddrStreet;
    }

    public void setJurAddrStreet(String jurAddrStreet) {
        this.jurAddrStreet = jurAddrStreet;
    }

    public String getJurAddrHouse() {
        return jurAddrHouse;
    }

    public void setJurAddrHouse(String jurAddrHouse) {
        this.jurAddrHouse = jurAddrHouse;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UaTown getJurAddrUaTown() {
        return jurAddrUaTown;
    }

    public void setJurAddrUaTown(UaTown jurAddrUaTown) {
        this.jurAddrUaTown = jurAddrUaTown;
    }

    public UaState getJurAddrUaState() {
        return jurAddrUaState;
    }

    public void setJurAddrUaState(UaState jurAddrUaStateId) {
        this.jurAddrUaState = jurAddrUaStateId;
    }

    public CardioUser getManager() {
        return manager;
    }

    public void setManager(CardioUser manager) {
        this.manager = manager;
    }

    @XmlTransient
    @JsonIgnore
    public List<PartnerAddress> getPartnerAddressList() {
        return partnerAddressList;
    }

    public void setPartnerAddressList(List<PartnerAddress> partnerAddressList) {
        this.partnerAddressList = partnerAddressList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PartnerBankRecv> getPartnerBankRecvList() {
        return partnerBankRecvList;
    }

    public void setPartnerBankRecvList(List<PartnerBankRecv> partnerBankRecvList) {
        this.partnerBankRecvList = partnerBankRecvList;
    }

        public List<PartnerEvent> getPartnerEventList() {
        return partnerEventList;
    }

    public void setPartnerEventList(List<PartnerEvent> partnerEventList) {
        this.partnerEventList = partnerEventList;
    }
    
  
    public List<PartnerEmploye> getPartnerEmployeList() {
        return partnerEmployeList;
    }

    public void setPartnerEmployeList(List<PartnerEmploye> partnerEmployeList) {
        this.partnerEmployeList = partnerEmployeList;
    }

    public List<CardioProject> getPartnerProjectList() {
        return partnerProjectList;
    }

    public void setPartnerProjectList(List<CardioProject> partnerProjectList) {
        this.partnerProjectList = partnerProjectList;
    }

    public List<Task> getPartnerTaskList() {
        return partnerTaskList;
    }

    public void setPartnerTaskList(List<Task> partnerTaskList) {
        this.partnerTaskList = partnerTaskList;
    }

    public List<StoreItem> getStoreItemList() {
        return storeItemList;
    }

    public void setStoreItemList(List<StoreItem> storeItemList) {
        this.storeItemList = storeItemList;
    }

    public boolean isClosed() {
        return Boolean.valueOf(closed);
    }

    public void setClosed(boolean closed) {
        this.closed = Boolean.toString(closed);
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
        if (!(object instanceof CardioPartner)) {
            return false;
        }
        CardioPartner other = (CardioPartner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    /**
     * Получить полный адрес
     * @return 
     */
    public String getAddress(){
        
      return jurAddrStreet+" "+jurAddrHouse;  
    }

   

    public CardioPartnerType getType() {
        return type;
    }

    public void setType(CardioPartnerType type) {
        this.type = type;
    }

    
}
