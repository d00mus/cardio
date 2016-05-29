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
@Table(name = "DOCUMENT_TYPE", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentType.findAll", query = "SELECT d FROM DocumentType d"),
    @NamedQuery(name = "DocumentType.findById", query = "SELECT d FROM DocumentType d WHERE d.id = :id"),
    @NamedQuery(name = "DocumentType.findByCode", query = "SELECT d FROM DocumentType d WHERE d.code = :code"),
    @NamedQuery(name = "DocumentType.findByName", query = "SELECT d FROM DocumentType d WHERE d.name = :name")})
public class DocumentType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    private String code;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<StoreDocument> storeDocumentList;

    public DocumentType() {
    }

    public DocumentType(Integer id) {
        this.id = id;
    }

    public DocumentType(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
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
    public List<StoreDocument> getStoreDocumentList() {
        return storeDocumentList;
    }

    public void setStoreDocumentList(List<StoreDocument> storeDocumentList) {
        this.storeDocumentList = storeDocumentList;
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
        if (!(object instanceof DocumentType)) {
            return false;
        }
        DocumentType other = (DocumentType) object;
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
