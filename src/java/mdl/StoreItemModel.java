
package mdl;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "STORE_ITEM_MODEL", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreItemModel.findAll", query = "SELECT s FROM StoreItemModel s"),
    @NamedQuery(name = "StoreItemModel.findById", query = "SELECT s FROM StoreItemModel s WHERE s.id = :id"),
    @NamedQuery(name = "StoreItemModel.findByCode", query = "SELECT s FROM StoreItemModel s WHERE s.code = :code"),
    @NamedQuery(name = "StoreItemModel.findByName", query = "SELECT s FROM StoreItemModel s WHERE s.name = :name")})
public class StoreItemModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="STORE_ITEM_MODEL_ID_GENERATOR", sequenceName="STORE_ITEM_MODEL_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STORE_ITEM_MODEL_ID_GENERATOR")
    private Integer id;
    
    @Size(max = 128)
    private String code;
    
    @Size(max = 255)
    private String name;

    @JoinColumn(name = "VENDOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private StoreItemVendor vendor;
    
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private StoreItemType type;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private List<StoreItem> storeItemList;

    public StoreItemModel() {
    }

    public StoreItemModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StoreItemVendor getVendor() {
        return vendor;
    }

    public void setVendor(StoreItemVendor vendor) {
        this.vendor = vendor;
    }

    
    public StoreItemType getType() {
        return type;
    }

    public void setType(StoreItemType type) {
        this.type = type;
    }
    
    @XmlTransient
    @JsonIgnore
    public List<StoreItem> getStoreItemList() {
        return storeItemList;
    }

    public void setStoreItemList(List<StoreItem> storeItemList) {
        this.storeItemList = storeItemList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.code);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.vendor);
        hash = 97 * hash + Objects.hashCode(this.type);
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
        final StoreItemModel other = (StoreItemModel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.vendor, other.vendor)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return name;
    }
    
}
