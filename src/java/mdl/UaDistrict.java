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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "UA_DISTRICT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UaDistrict.findAll", query = "SELECT u FROM UaDistrict u"),
    @NamedQuery(name = "UaDistrict.findById", query = "SELECT u FROM UaDistrict u WHERE u.id = :id"),
    @NamedQuery(name = "UaDistrict.findByRusName", query = "SELECT u FROM UaDistrict u WHERE u.rusName = :rusName"),
    @NamedQuery(name = "UaDistrict.findByUkrName", query = "SELECT u FROM UaDistrict u WHERE u.ukrName = :ukrName")})
public class UaDistrict implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Size(max = 128)
    @Column(name = "RUS_NAME")
    private String rusName;
    @Size(max = 128)
    @Column(name = "UKR_NAME")
    private String ukrName;
    @JoinColumn(name = "STATE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UaState stateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "district", fetch = FetchType.EAGER)
    private List<UaTown> uaTownList;

    public UaDistrict() {
    }

    public UaDistrict(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRusName() {
        return rusName;
    }

    public void setRusName(String rusName) {
        this.rusName = rusName;
    }

    public String getUkrName() {
        return ukrName;
    }

    public void setUkrName(String ukrName) {
        this.ukrName = ukrName;
    }

    public UaState getStateId() {
        return stateId;
    }

    public void setStateId(UaState stateId) {
        this.stateId = stateId;
    }

    @XmlTransient
    @JsonIgnore
    public List<UaTown> getUaTownList() {
        return uaTownList;
    }

    public void setUaTownList(List<UaTown> uaTownList) {
        this.uaTownList = uaTownList;
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
        if (!(object instanceof UaDistrict)) {
            return false;
        }
        UaDistrict other = (UaDistrict) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rusName;
    }
    
}
