/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "CONTACT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactType.findAll", query = "SELECT c FROM ContactType c"),
    @NamedQuery(name = "ContactType.findById", query = "SELECT c FROM ContactType c WHERE c.id = :id"),
    @NamedQuery(name = "ContactType.findByCode", query = "SELECT c FROM ContactType c WHERE c.code = :code"),
    @NamedQuery(name = "ContactType.findByName", query = "SELECT c FROM ContactType c WHERE c.name = :name"),
    @NamedQuery(name = "ContactType.findByDescription", query = "SELECT c FROM ContactType c WHERE c.description = :description"),
    @NamedQuery(name = "ContactType.findByRegexp", query = "SELECT c FROM ContactType c WHERE c.regexp = :regexp")})
public class ContactType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="CONTACT_TYPE_ID_GENERATOR", sequenceName="CONTACT_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACT_TYPE_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    private String code;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    private String name;
    
    @Size(max = 128)
    private String description;
    
    @Size(max = 2000)
    private String regexp;
    
    @OneToMany(mappedBy = "typeId")
    private List<ContactsData> contactsDataList;

    public ContactType() {
    }

    public ContactType(Long id) {
        this.id = id;
    }

    public ContactType(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    @XmlTransient
    public List<ContactsData> getContactsDataList() {
        return contactsDataList;
    }

    public void setContactsDataList(List<ContactsData> contactsDataList) {
        this.contactsDataList = contactsDataList;
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
        if (!(object instanceof ContactType)) {
            return false;
        }
        ContactType other = (ContactType) object;
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
