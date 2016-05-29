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
@Table(name = "CUSHION_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CushionType.findAll", query = "SELECT c FROM CushionType c"),
    @NamedQuery(name = "CushionType.findById", query = "SELECT c FROM CushionType c WHERE c.id = :id"),
    @NamedQuery(name = "CushionType.findByCode", query = "SELECT c FROM CushionType c WHERE c.code = :code"),
    @NamedQuery(name = "CushionType.findByName", query = "SELECT c FROM CushionType c WHERE c.name = :name")})
public class CushionType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="CUSHION_TYPE_ID_GENERATOR", sequenceName="CUSHION_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSHION_TYPE_ID_GENERATOR")
    private Long id;
    @Size(max = 16)
    @Column(name = "CODE")
    private String code;
    @Size(max = 64)
    @Column(name = "NAME")
    private String name;
    
/*    
    @OneToMany(mappedBy = "cushionTypeId")
    private List<Psg> psgList;
*/
    public CushionType() {
    }

    public CushionType(Long id) {
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
        if (!(object instanceof CushionType)) {
            return false;
        }
        CushionType other = (CushionType) object;
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
