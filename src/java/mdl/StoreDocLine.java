package mdl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "STORE_DOC_LINE", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreDocLine.findAll", query = "SELECT s FROM StoreDocLine s"),
    @NamedQuery(name = "StoreDocLine.findById", query = "SELECT s FROM StoreDocLine s WHERE s.id = :id")})
public class StoreDocLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="STORE_DOC_LINE_ID_GENERATOR", sequenceName="STORE_DOC_LINE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STORE_DOC_LINE_ID_GENERATOR")
    
    private Long id;
    
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private StoreItem item;
    
    @JoinColumn(name = "DOCUMENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private StoreDocument document;

    public StoreDocLine() {
    }

    public StoreDocLine(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreItem getItem() {
        return item;
    }

    public void setItem(StoreItem item) {
        this.item = item;
    }

    public StoreDocument getDocument() {
        return document;
    }

    public void setDocument(StoreDocument document) {
        this.document = document;
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
        if (!(object instanceof StoreDocLine)) {
            return false;
        }
        StoreDocLine other = (StoreDocLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.StoreDocLine[ id=" + id + " ]";
    }
    
}
