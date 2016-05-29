/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "PSG_ATTR_APNOE_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgAttrApnoeType.findAll", query = "SELECT p FROM PsgAttrApnoeType p"),
    @NamedQuery(name = "PsgAttrApnoeType.findById", query = "SELECT p FROM PsgAttrApnoeType p WHERE p.id = :id"),
    @NamedQuery(name = "PsgAttrApnoeType.findByCode", query = "SELECT p FROM PsgAttrApnoeType p WHERE p.code = :code"),
    @NamedQuery(name = "PsgAttrApnoeType.findByName", query = "SELECT p FROM PsgAttrApnoeType p WHERE p.name = :name"),
    @NamedQuery(name = "PsgAttrApnoeType.findByShortName", query = "SELECT p FROM PsgAttrApnoeType p WHERE p.shortName = :shortName")})
public class PsgAttrApnoeType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "SHORT_NAME")
    private String shortName;
    /*
    @OneToMany(mappedBy = "apnoeTypeId")
    private List<PsgAttrApnoe> psgAttrApnoeList;
   */
    public PsgAttrApnoeType() {
    }

    public PsgAttrApnoeType(Integer id) {
        this.id = id;
    }

    public PsgAttrApnoeType(Integer id, String code, String name, String shortName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.shortName = shortName;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /*
    @XmlTransient
    @JsonIgnore
    public List<PsgAttrApnoe> getPsgAttrApnoeList() {
        return psgAttrApnoeList;
    }

    public void setPsgAttrApnoeList(List<PsgAttrApnoe> psgAttrApnoeList) {
        this.psgAttrApnoeList = psgAttrApnoeList;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsgAttrApnoeType)) {
            return false;
        }
        PsgAttrApnoeType other = (PsgAttrApnoeType) object;
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
