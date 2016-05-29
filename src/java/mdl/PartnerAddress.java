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
 * Список адресов партнёров(их отделения)
 * @author d00mus
 */
@Entity
@Table(name = "PARTNER_ADDRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerAddress.findAll", query = "SELECT p FROM PartnerAddress p"),
    @NamedQuery(name = "PartnerAddress.findById", query = "SELECT p FROM PartnerAddress p WHERE p.id = :id"),
    @NamedQuery(name = "PartnerAddress.findByName", query = "SELECT p FROM PartnerAddress p WHERE p.name = :name"),
    @NamedQuery(name = "PartnerAddress.findByPhone", query = "SELECT p FROM PartnerAddress p WHERE p.phone = :phone"),
    @NamedQuery(name = "PartnerAddress.findByStreet", query = "SELECT p FROM PartnerAddress p WHERE p.street = :street"),
    @NamedQuery(name = "PartnerAddress.findByHouse", query = "SELECT p FROM PartnerAddress p WHERE p.house = :house"),
    @NamedQuery(name = "PartnerAddress.findByUaTown", query = "SELECT p FROM PartnerAddress p WHERE p.uaTown = :uaTown"),
    @NamedQuery(name = "PartnerAddress.findByUaState", query = "SELECT p FROM PartnerAddress p WHERE p.uaState = :uaState")})
public class PartnerAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PARTNER_ADDRESS_ID_GENERATOR", sequenceName="PARTNER_ADDRESS_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTNER_ADDRESS_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 128)
    private String phone;
    
    @Size(max = 255)
    private String street;
    
    @Size(max = 100)
    private String house;
    
    @JoinColumn(name = "UA_TOWN_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UaTown uaTown;
    
    @JoinColumn(name = "UA_STATE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UaState uaState;
    
    @JoinColumn(name = "PARTNER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioPartner partner;
    

    public PartnerAddress() {
    }

    public PartnerAddress(Long id) {
        this.id = id;
    }

    public PartnerAddress(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public UaTown getUaTown() {
        return uaTown;
    }

    public void setUaTown(UaTown uaTown) {
        this.uaTown = uaTown;
    }

    public UaState getUaState() {
        return uaState;
    }

    public void setUaState(UaState uaState) {
        this.uaState = uaState;
    }

    public CardioPartner getPartner() {
        return partner;
    }

    public void setPartner(CardioPartner partner) {
        this.partner = partner;
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
        if (!(object instanceof PartnerAddress)) {
            return false;
        }
        PartnerAddress other = (PartnerAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    /**
     * Сформировать полный адрес
     * @return 
     */
    public String getAddress(){
        return street+" "+house;
    }
    
}
