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
@Table(name = "MASK_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaskType.findAll", query = "SELECT m FROM MaskType m"),
    @NamedQuery(name = "MaskType.findById", query = "SELECT m FROM MaskType m WHERE m.id = :id"),
    @NamedQuery(name = "MaskType.findByCode", query = "SELECT m FROM MaskType m WHERE m.code = :code"),
    @NamedQuery(name = "MaskType.findByName", query = "SELECT m FROM MaskType m WHERE m.name = :name")})
public class MaskType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="MASK_TYPE_ID_GENERATOR", sequenceName="MASK_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MASK_TYPE_ID_GENERATOR")
    private Long id;
    @Size(max = 16)
    @Column(name = "CODE")
    private String code;
    @Size(max = 64)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "oxymatMaskTypeId")
    private List<Psg> psgList;
    @OneToMany(mappedBy = "cpapMaskTypeId")
    private List<Psg> psgList1;

    public MaskType() {
    }

    public MaskType(Long id) {
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

    @XmlTransient
    public List<Psg> getPsgList() {
        return psgList;
    }

    public void setPsgList(List<Psg> psgList) {
        this.psgList = psgList;
    }

    @XmlTransient
    public List<Psg> getPsgList1() {
        return psgList1;
    }

    public void setPsgList1(List<Psg> psgList1) {
        this.psgList1 = psgList1;
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
        if (!(object instanceof MaskType)) {
            return false;
        }
        MaskType other = (MaskType) object;
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
