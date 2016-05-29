/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "PATIENT_FEELING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientFeeling.findAll", query = "SELECT p FROM PatientFeeling p"),
    @NamedQuery(name = "PatientFeeling.findById", query = "SELECT p FROM PatientFeeling p WHERE p.id = :id"),
    @NamedQuery(name = "PatientFeeling.findByCode", query = "SELECT p FROM PatientFeeling p WHERE p.code = :code"),
    @NamedQuery(name = "PatientFeeling.findByName", query = "SELECT p FROM PatientFeeling p WHERE p.name = :name")})
public class PatientFeeling implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    private String name;
/*    
    @OneToMany(mappedBy = "cmnFeelingId", fetch = FetchType.EAGER)
    private List<PatientCall> patientCallList;
*/
    public PatientFeeling() {
    }

    public PatientFeeling(Integer id) {
        this.id = id;
    }

    public PatientFeeling(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
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

    /*
    @XmlTransient
    @JsonIgnore
    public List<PatientCall> getPatientCallList() {
        return patientCallList;
    }

    public void setPatientCallList(List<PatientCall> patientCallList) {
        this.patientCallList = patientCallList;
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
        if (!(object instanceof PatientFeeling)) {
            return false;
        }
        PatientFeeling other = (PatientFeeling) object;
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
