
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
@Table(name = "STORE_ITEM_TYPE", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreItemType.findAll", query = "SELECT s FROM StoreItemType s"),
    @NamedQuery(name = "StoreItemType.findById", query = "SELECT s FROM StoreItemType s WHERE s.id = :id"),
    @NamedQuery(name = "StoreItemType.findByCode", query = "SELECT s FROM StoreItemType s WHERE s.code = :code"),
    @NamedQuery(name = "StoreItemType.findByName", query = "SELECT s FROM StoreItemType s WHERE s.name = :name")})
public class StoreItemType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="STORE_ITEM_TYPE_ID_GENERATOR", sequenceName="STORE_ITEM_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STORE_ITEM_TYPE_ID_GENERATOR")
    private Integer id;
    
    @Size(max = 128)
    private String code;
    
    @Size(max = 255)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<StoreItemModel> modelList;

    public StoreItemType() {
    }

    public StoreItemType(Integer id) {
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
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.code);
        hash = 13 * hash + Objects.hashCode(this.name);
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
        final StoreItemType other = (StoreItemType) obj;
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
