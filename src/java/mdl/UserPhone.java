/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "USER_PHONE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPhone.findAll", query = "SELECT u FROM UserPhone u"),
    @NamedQuery(name = "UserPhone.findById", query = "SELECT u FROM UserPhone u WHERE u.id = :id"),
    @NamedQuery(name = "UserPhone.findByPhone", query = "SELECT u FROM UserPhone u WHERE u.phone = :phone"),
    @NamedQuery(name = "UserPhone.findByNotes", query = "SELECT u FROM UserPhone u WHERE u.notes = :notes"),
    @NamedQuery(name = "UserPhone.findByPhoneType", query = "SELECT u FROM UserPhone u WHERE u.phoneType = :phoneType")})
public class UserPhone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="USER_PHONE_ID_GENERATOR", sequenceName="USER_PHONE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_PHONE_ID_GENERATOR")
    private Integer id;
    
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 32)
    private String phone;
    
    @Size(max = 255)
    private String notes;
    
    @JoinColumn(name = "PHONE_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private TelType phoneType;
    
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser user;

    public UserPhone() {
    }

    public UserPhone(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TelType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(TelType phoneType) {
        this.phoneType = phoneType;
    }

    public CardioUser getUser() {
        return user;
    }

    public void setUser(CardioUser user) {
        this.user = user;
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
        if (!(object instanceof UserPhone)) {
            return false;
        }
        UserPhone other = (UserPhone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.UserPhone[ id=" + id + " ]";
    }
    
}
