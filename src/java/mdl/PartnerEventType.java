/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Table(name = "PARTNER_EVENT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerEventType.findAll", query = "SELECT p FROM PartnerEventType p"),
    @NamedQuery(name = "PartnerEventType.findById", query = "SELECT p FROM PartnerEventType p WHERE p.id = :id"),
    @NamedQuery(name = "PartnerEventType.findByCode", query = "SELECT p FROM PartnerEventType p WHERE p.code = :code"),
    @NamedQuery(name = "PartnerEventType.findByName", query = "SELECT p FROM PartnerEventType p WHERE p.name = :name")})
public class PartnerEventType implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    private String code;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<PartnerEvent> partnerEventList;

    public PartnerEventType() {
    }

    public PartnerEventType(Integer id) {
        this.id = id;
    }

    public PartnerEventType(Integer id, String code, String name) {
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
    public List<PartnerEvent> getPartnerEventList() {
        return partnerEventList;
    }

    public void setPartnerEventList(List<PartnerEvent> partnerEventList) {
        this.partnerEventList = partnerEventList;
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
        if (!(object instanceof PartnerEventType)) {
            return false;
        }
        PartnerEventType other = (PartnerEventType) object;
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
