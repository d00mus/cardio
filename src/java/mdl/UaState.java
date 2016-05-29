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
@Table(name = "UA_STATE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UaState.findAll", query = "SELECT u FROM UaState u"),
    @NamedQuery(name = "UaState.findById", query = "SELECT u FROM UaState u WHERE u.id = :id"),
    @NamedQuery(name = "UaState.findByRusName", query = "SELECT u FROM UaState u WHERE u.rusName = :rusName"),
    @NamedQuery(name = "UaState.findByUkrName", query = "SELECT u FROM UaState u WHERE u.ukrName = :ukrName")})
public class UaState implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "RUS_NAME")
    private String rusName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "UKR_NAME")
    
    private String ukrName;
    
    /*
    @OneToMany(mappedBy = "uaStateId", fetch = FetchType.EAGER)
    private List<DoctorsExternal> doctorsExternalList;
    
    @OneToMany(mappedBy = "adrUaStateId", fetch = FetchType.EAGER)
    private List<Patient> patientList;
    */
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId", fetch = FetchType.EAGER)
    private List<UaDistrict> uaDistrictList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state", fetch = FetchType.EAGER)
    private List<UaTown> uaTownList;

    public UaState() {
    }

    public UaState(Integer id) {
        this.id = id;
    }

    public UaState(Integer id, String rusName, String ukrName) {
        this.id = id;
        this.rusName = rusName;
        this.ukrName = ukrName;
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

    /*
    @XmlTransient
    @JsonIgnore
    public List<DoctorsExternal> getDoctorsExternalList() {
        return doctorsExternalList;
    }

    public void setDoctorsExternalList(List<DoctorsExternal> doctorsExternalList) {
        this.doctorsExternalList = doctorsExternalList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Patient> getPatientList() {
        return patientList;
    }
    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

*/
    
    @XmlTransient
    @JsonIgnore
    public List<UaDistrict> getUaDistrictList() {
        return uaDistrictList;
    }

    public void setUaDistrictList(List<UaDistrict> uaDistrictList) {
        this.uaDistrictList = uaDistrictList;
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
        if (!(object instanceof UaState)) {
            return false;
        }
        UaState other = (UaState) object;
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
