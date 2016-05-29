package mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "STORE_ITEM_STATUS", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreItemStatus.findAll", query = "SELECT s FROM StoreItemStatus s"),
    @NamedQuery(name = "StoreItemStatus.findById", query = "SELECT s FROM StoreItemStatus s WHERE s.id = :id"),
    @NamedQuery(name = "StoreItemStatus.findByCode", query = "SELECT s FROM StoreItemStatus s WHERE s.code = :code"),
    @NamedQuery(name = "StoreItemStatus.findByName", query = "SELECT s FROM StoreItemStatus s WHERE s.name = :name")})
public class StoreItemStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    
    @Size(max = 30)
    private String code;
    
    @Size(max = 64)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private List<StoreItem> storeItemList;

    public StoreItemStatus() {
    }

    public StoreItemStatus(Integer id) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreItemStatus)) {
            return false;
        }
        StoreItemStatus other = (StoreItemStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
