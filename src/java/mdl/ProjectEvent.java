package mdl;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PROJECT_EVENT", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectEvent.findAll", query = "SELECT p FROM ProjectEvent p"),
    @NamedQuery(name = "ProjectEvent.findById", query = "SELECT p FROM ProjectEvent p WHERE p.id = :id"),
    @NamedQuery(name = "ProjectEvent.findByEventDate", query = "SELECT p FROM ProjectEvent p WHERE p.eventDate = :eventDate"),
    @NamedQuery(name = "ProjectEvent.findByCreateDate", query = "SELECT p FROM ProjectEvent p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "ProjectEvent.findByLabel", query = "SELECT p FROM ProjectEvent p WHERE p.label = :label"),
    @NamedQuery(name = "ProjectEvent.findByTypeId", query = "SELECT p FROM ProjectEvent p WHERE p.type = :type"),
    @NamedQuery(name = "ProjectEvent.findBySubjId", query = "SELECT p FROM ProjectEvent p WHERE p.subj = :subj"),
    @NamedQuery(name = "ProjectEvent.findByEmployeId", query = "SELECT p FROM ProjectEvent p WHERE p.employe = :employe"),
    @NamedQuery(name = "ProjectEvent.findByUserId", query = "SELECT p FROM ProjectEvent p WHERE p.user = :user")})
public class ProjectEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PROJECT_EVENT_ID_GENERATOR", sequenceName="PROJECT_EVENT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_EVENT_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    @Size(max = 2000)
    private String label;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private PartnerEventType type;
    
    @JoinColumn(name = "SUBJ_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PartnerEventSubj subj;
    
    @JoinColumn(name = "EMPLOYE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PartnerEmploye employe;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser user;
    
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioProject project;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "event")
    private ProjectEventAttrs attrs;

    public ProjectEvent() {
    }

    public ProjectEvent(Long id) {
        this.id = id;
    }

    public ProjectEvent(Long id, Date eventDate, Date createDate) {
        this.id = id;
        this.eventDate = eventDate;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public PartnerEventType getType() {
        return type;
    }

    public void setType(PartnerEventType type) {
        this.type = type;
    }

    public PartnerEventSubj getSubj() {
        return subj;
    }

    public void setSubj(PartnerEventSubj subj) {
        this.subj = subj;
    }

    public PartnerEmploye getEmploye() {
        return employe;
    }

    public void setEmploye(PartnerEmploye employeId) {
        this.employe = employeId;
    }

    public CardioUser getUser() {
        return user;
    }

    public void setUser(CardioUser user) {
        this.user = user;
    }

    public CardioProject getProject() {
        return project;
    }

    public void setProject(CardioProject project) {
        this.project = project;
    }

    public ProjectEventAttrs getAttrs() {
        return attrs;
    }

    public void setAttrs(ProjectEventAttrs attrs) {
        this.attrs = attrs;
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
        if (!(object instanceof ProjectEvent)) {
            return false;
        }
        ProjectEvent other = (ProjectEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{ProjectEvent:" + id + "}";
    }
    
}
