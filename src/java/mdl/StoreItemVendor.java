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
@Table(name = "STORE_ITEM_VENDOR", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreItemVendor.findAll", query = "SELECT s FROM StoreItemVendor s"),
    @NamedQuery(name = "StoreItemVendor.findById", query = "SELECT s FROM StoreItemVendor s WHERE s.id = :id"),
    @NamedQuery(name = "StoreItemVendor.findByCode", query = "SELECT s FROM StoreItemVendor s WHERE s.code = :code"),
    @NamedQuery(name = "StoreItemVendor.findByName", query = "SELECT s FROM StoreItemVendor s WHERE s.name = :name")})
public class StoreItemVendor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="STORE_ITEM_VENDOR_ID_GENERATOR", sequenceName="STORE_ITEM_VENDOR_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STORE_ITEM_VENDOR_ID_GENERATOR")
    
    private Integer id;
    
    @Size(max = 128)
    private String code;
    
    @Size(max = 255)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor")
    private List<StoreItemModel> modelList;
    

    public StoreItemVendor() {
    }

    public StoreItemVendor(Integer id) {
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
    public List<StoreItemModel> getModelList() {
        return modelList;
    }

    @XmlTransient
    @JsonIgnore
    public void setModelList(List<StoreItemModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.code);
        hash = 53 * hash + Objects.hashCode(this.name);
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
        final StoreItemVendor other = (StoreItemVendor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return name;
    }
    
}
