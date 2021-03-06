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
@Table(name = "VIP_RANK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VipRank.findAll", query = "SELECT v FROM VipRank v"),
    @NamedQuery(name = "VipRank.findById", query = "SELECT v FROM VipRank v WHERE v.id = :id"),
    @NamedQuery(name = "VipRank.findByCode", query = "SELECT v FROM VipRank v WHERE v.code = :code"),
    @NamedQuery(name = "VipRank.findByName", query = "SELECT v FROM VipRank v WHERE v.name = :name")})
public class VipRank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="VIP_RANK_ID_GENERATOR", sequenceName="VIP_RANK_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIP_RANK_ID_GENERATOR")
    private Long id;
    @Size(max = 16)
    @Column(name = "CODE")
    private String code;
    @Size(max = 64)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "vipRankId")
    private List<Patient> patientList;

    public VipRank() {
    }

    public VipRank(Long id) {
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
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
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
        if (!(object instanceof VipRank)) {
            return false;
        }
        VipRank other = (VipRank) object;
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
