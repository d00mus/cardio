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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "UA_TOWN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UaTown.findAll", query = "SELECT u FROM UaTown u"),
    @NamedQuery(name = "UaTown.findById", query = "SELECT u FROM UaTown u WHERE u.id = :id"),
    @NamedQuery(name = "UaTown.findByRusName", query = "SELECT u FROM UaTown u WHERE u.rusName = :rusName"),
    @NamedQuery(name = "UaTown.findByUkrName", query = "SELECT u FROM UaTown u WHERE u.ukrName = :ukrName")})
public class UaTown implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="UA_TOWN_ID_GENERATOR", sequenceName="UA_TOWN_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UA_TOWN_ID_GENERATOR")
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
    
    @OneToMany(mappedBy = "uaTownId", fetch = FetchType.EAGER)
    private List<DoctorsExternal> doctorsExternalList;
    
    @OneToMany(mappedBy = "workUaTownId", fetch = FetchType.EAGER)
    private List<Patient> patientList;
    
    @OneToMany(mappedBy = "adrUaTownId", fetch = FetchType.EAGER)
    private List<Patient> patientList1;
    */
    
    @JoinColumn(name = "STATE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UaState state;
    
    @JoinColumn(name = "DISTRICT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UaDistrict district;

    public UaTown() {
    }

    public UaTown(Integer id) {
        this.id = id;
    }

    public UaTown(Integer id, String rusName, String ukrName) {
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

    @XmlTransient
    @JsonIgnore
    public List<Patient> getPatientList1() {
        return patientList1;
    }

    public void setPatientList1(List<Patient> patientList1) {
        this.patientList1 = patientList1;
    }
*/
    public UaState getState() {
        return state;
    }

    public void setState(UaState state) {
        this.state = state;
    }

    public UaDistrict getDistrict() {
        return district;
    }

    public void setDistrict(UaDistrict district) {
        this.district = district;
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
        if (!(object instanceof UaTown)) {
            return false;
        }
        UaTown other = (UaTown) object;
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
