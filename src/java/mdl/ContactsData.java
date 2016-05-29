/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "CONTACTS_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactsData.findAll", query = "SELECT c FROM ContactsData c"),
    @NamedQuery(name = "ContactsData.findById", query = "SELECT c FROM ContactsData c WHERE c.id = :id"),
    @NamedQuery(name = "ContactsData.findByContact", query = "SELECT c FROM ContactsData c WHERE c.contact = :contact")})
public class ContactsData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="CONTACT_DATA_ID_GENERATOR", sequenceName="CONTACT_DATA_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACT_DATA_ID_GENERATOR")
    private Long id;
    @Size(max = 2000)
    private String contact;
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private ContactType typeId;
    @JoinColumn(name = "CONTACTS_ID", referencedColumnName = "ID")
    @ManyToOne
    private Contacts contactsId;

    public ContactsData() {
    }

    public ContactsData(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ContactType getTypeId() {
        return typeId;
    }

    public void setTypeId(ContactType typeId) {
        this.typeId = typeId;
    }

    public Contacts getContactsId() {
        return contactsId;
    }

    public void setContactsId(Contacts contactsId) {
        this.contactsId = contactsId;
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
        if (!(object instanceof ContactsData)) {
            return false;
        }
        ContactsData other = (ContactsData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.ContactsData[ id=" + id + " ]";
    }
    
}
