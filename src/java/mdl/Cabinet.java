/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "CABINET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cabinet.findAll", query = "SELECT c FROM Cabinet c"),
    @NamedQuery(name = "Cabinet.findById", query = "SELECT c FROM Cabinet c WHERE c.id = :id"),
    @NamedQuery(name = "Cabinet.findByCode", query = "SELECT c FROM Cabinet c WHERE c.code = :code"),
    @NamedQuery(name = "Cabinet.findByName", query = "SELECT c FROM Cabinet c WHERE c.name = :name")})
public class Cabinet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="CABINET_ID_GENERATOR", sequenceName="CABINET_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CABINET_ID_GENERATOR")
    private Long id;
    @Size(max = 64)
    @Column(name = "CODE")
    private String code;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabinetId")
    private List<Psg> psgList;

    public Cabinet() {
    }

    public Cabinet(Long id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabinet)) {
            return false;
        }
        Cabinet other = (Cabinet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return code;
    }
    
}
