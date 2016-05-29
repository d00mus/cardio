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
@Table(name = "REF_INFO_SOURCE_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefInfoSourceType.findAll", query = "SELECT r FROM RefInfoSourceType r"),
    @NamedQuery(name = "RefInfoSourceType.findById", query = "SELECT r FROM RefInfoSourceType r WHERE r.id = :id"),
    @NamedQuery(name = "RefInfoSourceType.findByCode", query = "SELECT r FROM RefInfoSourceType r WHERE r.code = :code"),
    @NamedQuery(name = "RefInfoSourceType.findByName", query = "SELECT r FROM RefInfoSourceType r WHERE r.name = :name")})
public class RefInfoSourceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="REF_INFO_SOURCE_TYPE_ID_GENERATOR", sequenceName="REF_INFO_SOURCE_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REF_INFO_SOURCE_TYPE_ID_GENERATOR")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    private String code;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String name;
    
    /*
    @OneToMany(mappedBy = "refInfoSrcTypeId", fetch = FetchType.EAGER)
    private List<Patient> patientList;
*/
    
    public RefInfoSourceType() {
    }

    public RefInfoSourceType(Integer id) {
        this.id = id;
    }

    public RefInfoSourceType(Integer id, String code, String name) {
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
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
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
        if (!(object instanceof RefInfoSourceType)) {
            return false;
        }
        RefInfoSourceType other = (RefInfoSourceType) object;
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
