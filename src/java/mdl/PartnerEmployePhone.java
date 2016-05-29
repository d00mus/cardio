/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@Table(name = "PARTNER_EMPLOYE_PHONE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerEmployePhone.findAll", query = "SELECT p FROM PartnerEmployePhone p"),
    @NamedQuery(name = "PartnerEmployePhone.findById", query = "SELECT p FROM PartnerEmployePhone p WHERE p.id = :id"),
    @NamedQuery(name = "PartnerEmployePhone.findByPhone", query = "SELECT p FROM PartnerEmployePhone p WHERE p.phone = :phone"),
    @NamedQuery(name = "PartnerEmployePhone.findByNotes", query = "SELECT p FROM PartnerEmployePhone p WHERE p.notes = :notes")})
public class PartnerEmployePhone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PARTNER_EMPLOYE_PHONE_ID_GENERATOR", sequenceName="PARTNER_EMPLOYE_PHONE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTNER_EMPLOYE_PHONE_ID_GENERATOR")
    private Long id;
    
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    private String phone;
    
    @Size(max = 255)
    private String notes;
    
    @JoinColumn(name = "EMPLOYE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PartnerEmploye employe;

    public PartnerEmployePhone() {
    }

    public PartnerEmployePhone(Long id) {
        this.id = id;
    }

    public PartnerEmployePhone(Long id, String phone) {
        this.id = id;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public PartnerEmploye getEmploye() {
        return employe;
    }

    public void setEmploye(PartnerEmploye employe) {
        this.employe = employe;
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
        if (!(object instanceof PartnerEmployePhone)) {
            return false;
        }
        PartnerEmployePhone other = (PartnerEmployePhone) object;
        
        if(this.id!=null && other.id!=null && this.id.equals(other.id)){
            return true;
        }
        
        if(  this.phone!=null && this.phone.equals(other.phone)
           && this.employe!=null && other.employe!=null 
           && this.employe.equals(other.employe)
           ){
            return true;
           }
            ;
            
        return false;
    }

    @Override
    public String toString() {
        return phone;
    }
    
}
