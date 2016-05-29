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
@Table(name = "EX_DOC_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExDocType.findAll", query = "SELECT e FROM ExDocType e"),
    @NamedQuery(name = "ExDocType.findById", query = "SELECT e FROM ExDocType e WHERE e.id = :id"),
    @NamedQuery(name = "ExDocType.findByCode", query = "SELECT e FROM ExDocType e WHERE e.code = :code"),
    @NamedQuery(name = "ExDocType.findByName", query = "SELECT e FROM ExDocType e WHERE e.name = :name")})
public class ExDocType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="EX_DOC_TYPE_ID_GENERATOR", sequenceName="EX_DOC_TYPE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EX_DOC_TYPE_ID_GENERATOR")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "docTypeId")
    private List<DoctorsExternal> doctorsExternalList;

    public ExDocType() {
    }

    public ExDocType(Long id) {
        this.id = id;
    }

    public ExDocType(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
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
    public List<DoctorsExternal> getDoctorsExternalList() {
        return doctorsExternalList;
    }

    public void setDoctorsExternalList(List<DoctorsExternal> doctorsExternalList) {
        this.doctorsExternalList = doctorsExternalList;
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
        if (!(object instanceof ExDocType)) {
            return false;
        }
        ExDocType other = (ExDocType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.ExDocType[ id=" + id + " ]";
    }
    
}
