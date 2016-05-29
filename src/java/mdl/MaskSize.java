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
@Table(name = "MASK_SIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaskSize.findAll", query = "SELECT m FROM MaskSize m"),
    @NamedQuery(name = "MaskSize.findById", query = "SELECT m FROM MaskSize m WHERE m.id = :id"),
    @NamedQuery(name = "MaskSize.findByCode", query = "SELECT m FROM MaskSize m WHERE m.code = :code"),
    @NamedQuery(name = "MaskSize.findByName", query = "SELECT m FROM MaskSize m WHERE m.name = :name")})
public class MaskSize implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="MASK_SIZE_ID_GENERATOR", sequenceName="MASK_SIZE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MASK_SIZE_ID_GENERATOR")
    private Long id;
    
    @Size(max = 32)
    private String code;
    
    @Size(max = 64)
    private String name;

    public MaskSize() {
    }

    public MaskSize(Long id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaskSize)) {
            return false;
        }
        MaskSize other = (MaskSize) object;
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
