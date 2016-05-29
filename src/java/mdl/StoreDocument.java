package mdl;

import java.io.Serializable;
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
@Table(name = "STORE_DOCUMENT", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreDocument.findAll", query = "SELECT s FROM StoreDocument s"),
    @NamedQuery(name = "StoreDocument.findById", query = "SELECT s FROM StoreDocument s WHERE s.id = :id"),
    @NamedQuery(name = "StoreDocument.findByPostDate", query = "SELECT s FROM StoreDocument s WHERE s.postDate = :postDate"),
    @NamedQuery(name = "StoreDocument.findByDocNo", query = "SELECT s FROM StoreDocument s WHERE s.docNo = :docNo"),
    @NamedQuery(name = "StoreDocument.findByDescription", query = "SELECT s FROM StoreDocument s WHERE s.description = :description"),
    @NamedQuery(name = "StoreDocument.findByUserId", query = "SELECT s FROM StoreDocument s WHERE s.user = :user"),
    @NamedQuery(name = "StoreDocument.findByPartnerId", query = "SELECT s FROM StoreDocument s WHERE s.partner = :partner")})
public class StoreDocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="STORE_DOCUMENT_ID_GENERATOR", sequenceName="STORE_DOCUMENT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STORE_DOCUMENT_ID_GENERATOR")
    private Long id;
    
    @Column(name = "POST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    
    @Size(max = 128)
    @Column(name = "DOC_NO")
    private String docNo;
    
    @Size(max = 255)
    private String description;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser user;
    
    @JoinColumn(name = "PARTNER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioPartner partner;
    
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private DocumentType type;
    
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private DocumentStatus status;
    
    @JoinColumn(name = "STORE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioStore store;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private List<StoreDocLine> storeDocLineList;

    public StoreDocument() {
    }

    public StoreDocument(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public CardioStore getStore() {
        return store;
    }

    public void setStore(CardioStore store) {
        this.store = store;
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoreDocument)) {
            return false;
        }
        StoreDocument other = (StoreDocument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return docNo;
    }
    
}
