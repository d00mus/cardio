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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "CARDIO_PROJECT", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardioProject.findAll", query = "SELECT c FROM CardioProject c"),
    @NamedQuery(name = "CardioProject.findById", query = "SELECT c FROM CardioProject c WHERE c.id = :id"),
    @NamedQuery(name = "CardioProject.findByName", query = "SELECT c FROM CardioProject c WHERE c.name = :name"),
    @NamedQuery(name = "CardioProject.findByNotes", query = "SELECT c FROM CardioProject c WHERE c.notes = :notes"),
    @NamedQuery(name = "CardioProject.findByUserId", query = "SELECT c FROM CardioProject c WHERE c.user = :user"),
    @NamedQuery(name = "CardioProject.findByPartnerId", query = "SELECT c FROM CardioProject c WHERE c.partner = :partner")})
public class CardioProject implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="CARDIO_PROJECT_ID_GENERATOR", sequenceName="CARDIO_PROJECT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARDIO_PROJECT_ID_GENERATOR")
    private Long id;
    
    @Size(max = 255)
    private String name;
    
    @Size(max = 255)
    private String notes;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser user;
    
    @JoinColumn(name = "PARTNER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioPartner partner;
    
    @JoinColumn(name = "CONTACT_PERS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PartnerEmploye contactPers;

    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    @ManyToOne
    private ProjectStatus status;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project",orphanRemoval = true)
    private List<ProjectEvent> projectEventList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project", orphanRemoval = true)
    private List<ProjectEquipment> projectEquipmentList;
    
    @OneToMany(mappedBy = "project")
    private List<ProjectPerson> projectPersonList;

    public CardioProject() {
    }

    public CardioProject(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public CardioUser getUser() {
        return user;
    }

    public void setUser(CardioUser user) {
        this.user = user;
    }

    public CardioPartner getPartner() {
        return partner;
    }

    public void setPartner(CardioPartner partner) {
        this.partner = partner;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    @XmlTransient
    @JsonIgnore
    public List<ProjectEvent> getProjectEventList() {
        return projectEventList;
    }

    public void setProjectEventList(List<ProjectEvent> projectEventList) {
        this.projectEventList = projectEventList;
    }

    @XmlTransient
    @JsonIgnore
    public List<ProjectEquipment> getProjectEquipmentList() {
        return projectEquipmentList;
    }

    public void setProjectEquipmentList(List<ProjectEquipment> projectEquipmentList) {
        this.projectEquipmentList = projectEquipmentList;
    }
    
    @XmlTransient
    @JsonIgnore
    public String getStoreItemListAsString() {
        StringBuilder sb = new StringBuilder();
        for(ProjectEquipment pi:projectEquipmentList){
            sb.append(pi.getModel().getName()).append(", ");
        }
        if(sb.length()>2){
            sb.setLength(sb.length()-2);
        }
        return sb.toString();
    }
    

    @XmlTransient
    @JsonIgnore
    public List<ProjectPerson> getProjectPersonList() {
        return projectPersonList;
    }

    public void setProjectPersonList(List<ProjectPerson> projectPersonList) {
        this.projectPersonList = projectPersonList;
    }

    public PartnerEmploye getContactPers() {
        return contactPers;
    }

    public void setContactPers(PartnerEmploye contactPers) {
        this.contactPers = contactPers;
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
        if (!(object instanceof CardioProject)) {
            return false;
        }
        CardioProject other = (CardioProject) object;
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
