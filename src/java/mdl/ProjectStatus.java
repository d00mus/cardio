package mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
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
@Table(name = "PROJECT_STATUS", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectStatus.findAll", query = "SELECT p FROM ProjectStatus p"),
    @NamedQuery(name = "ProjectStatus.findById", query = "SELECT p FROM ProjectStatus p WHERE p.id = :id"),
    @NamedQuery(name = "ProjectStatus.findByCode", query = "SELECT p FROM ProjectStatus p WHERE p.code = :code"),
    @NamedQuery(name = "ProjectStatus.findByName", query = "SELECT p FROM ProjectStatus p WHERE p.name = :name")})
public class ProjectStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    private String code;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String name;
    
    @OneToMany(mappedBy = "status")
    private List<CardioProject> cardioProjectList;

    public ProjectStatus() {
    }

    public ProjectStatus(Integer id) {
        this.id = id;
    }

    public ProjectStatus(Integer id, String code, String name) {
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

    @XmlTransient
    @JsonIgnore
    public List<CardioProject> getCardioProjectList() {
        return cardioProjectList;
    }

    public void setCardioProjectList(List<CardioProject> cardioProjectList) {
        this.cardioProjectList = cardioProjectList;
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
        if (!(object instanceof ProjectStatus)) {
            return false;
        }
        ProjectStatus other = (ProjectStatus) object;
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
