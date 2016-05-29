/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "CPAP_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CpapType.findAll", query = "SELECT c FROM CpapType c"),
    @NamedQuery(name = "CpapType.findById", query = "SELECT c FROM CpapType c WHERE c.id = :id"),
    @NamedQuery(name = "CpapType.findByCode", query = "SELECT c FROM CpapType c WHERE c.code = :code"),
    @NamedQuery(name = "CpapType.findByName", query = "SELECT c FROM CpapType c WHERE c.name = :name")})
public class CpapType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="CPAP_TYPE_ID_GENERATOR", sequenceName="CPAP_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CPAP_TYPE_ID_GENERATOR")
    private Long id;
    @Size(max = 64)
    @Column(name = "CODE")
    private String code;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    /*
    @OneToMany(mappedBy = "cpapTypeId")
    private List<Psg> psgList;
   */
    public CpapType() {
    }

    public CpapType(Long id) {
        this.id = id;
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

    /*
    @XmlTransient
    public List<Psg> getPsgList() {
        return psgList;
    }

    public void setPsgList(List<Psg> psgList) {
        this.psgList = psgList;
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
        if (!(object instanceof CpapType)) {
            return false;
        }
        CpapType other = (CpapType) object;
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
