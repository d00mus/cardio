package mdl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "STORE_ITEM", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreItem.findAll", query = "SELECT s FROM StoreItem s"),
    @NamedQuery(name = "StoreItem.findById", query = "SELECT s FROM StoreItem s WHERE s.id = :id"),
    @NamedQuery(name = "StoreItem.findBySerial", query = "SELECT s FROM StoreItem s WHERE s.serial = :serial"),
    @NamedQuery(name = "StoreItem.findByDeliverDate", query = "SELECT s FROM StoreItem s WHERE s.deliverDate = :deliverDate"),
    @NamedQuery(name = "StoreItem.findByExpenseDate", query = "SELECT s FROM StoreItem s WHERE s.expenseDate = :expenseDate"),
    @NamedQuery(name = "StoreItem.findByReturnDate", query = "SELECT s FROM StoreItem s WHERE s.returnDate = :returnDate")})
public class StoreItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="STORE_ITEM_ID_GENERATOR", sequenceName="STORE_ITEM_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STORE_ITEM_ID_GENERATOR")
    
    private Long id;
    
    @Size(max = 128)
    private String serial;
    
    @Column(name = "DELIVER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliverDate;
    
    @Column(name = "EXPENSE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expenseDate;
    
    @Column(name = "RETURN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private StoreItemStatus status;
    
    @JoinColumn(name = "MODEL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private StoreItemModel model;
    
    @JoinColumn(name = "STORE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioStore store;
    
    @JoinColumn(name = "PARTNER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioPartner partner;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private List<StoreDocLine> storeDocLineList;
    
    
    public StoreItem() {
    }

    public StoreItem(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public StoreItemStatus getStatus() {
        return status;
    }

    public void setStatus(StoreItemStatus status) {
        this.status = status;
    }

    public StoreItemModel getModel() {
        return model;
    }

    public void setModel(StoreItemModel model) {
        this.model = model;
    }

    public CardioStore getStore() {
        return store;
    }

    public void setStore(CardioStore store) {
        this.store = store;
    }

    public CardioPartner getPartner() {
        return partner;
    }

    public void setPartner(CardioPartner partner) {
        this.partner = partner;
    }
    
    

    @XmlTransient
    @JsonIgnore
    public List<StoreDocLine> getStoreDocLineList() {
        return storeDocLineList;
    }

    public void setStoreDocLineList(List<StoreDocLine> storeDocLineList) {
        this.storeDocLineList = storeDocLineList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.serial);
        hash = 37 * hash + Objects.hashCode(this.status);
        hash = 37 * hash + Objects.hashCode(this.model);
        hash = 37 * hash + Objects.hashCode(this.store);
        hash = 37 * hash + Objects.hashCode(this.partner);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StoreItem other = (StoreItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.serial, other.serial)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.store, other.store)) {
            return false;
        }
        if (!Objects.equals(this.partner, other.partner)) {
            return false;
        }
        return true;
    }
    


    @Override
    public String toString() {
        return "mdl.StoreItem[ id=" + id + " ]";
    }
    
}
