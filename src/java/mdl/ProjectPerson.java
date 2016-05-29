package mdl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PROJECT_PERSON", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectPerson.findAll", query = "SELECT p FROM ProjectPerson p"),
    @NamedQuery(name = "ProjectPerson.findById", query = "SELECT p FROM ProjectPerson p WHERE p.id = :id"),
    @NamedQuery(name = "ProjectPerson.findByEmployeId", query = "SELECT p FROM ProjectPerson p WHERE p.employe = :employe")})
public class ProjectPerson implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PROJECT_PERSON_ID_GENERATOR", sequenceName="PROJECT_PERSON_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_PERSON_ID_GENERATOR")
    
    private Long id;
    
    @JoinColumn(name = "EMPLOYE_ID",referencedColumnName = "ID",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private PartnerEmploye employe;
    
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID",nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private CardioProject project;

    public ProjectPerson() {
    }

    public ProjectPerson(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PartnerEmploye getEmploye() {
        return employe;
    }

    public void setEmploye(PartnerEmploye employe) {
        this.employe = employe;
    }

    public CardioProject getProject() {
        return project;
    }

    public void setProject(CardioProject project) {
        this.project = project;
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
        if (!(object instanceof ProjectPerson)) {
            return false;
        }
        ProjectPerson other = (ProjectPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.ProjectPerson[ id=" + id + " ]";
    }
    
}
