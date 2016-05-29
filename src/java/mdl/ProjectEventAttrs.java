package mdl;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PROJECT_EVENT_ATTRS", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectEventAttrs.findAll", query = "SELECT p FROM ProjectEventAttrs p"),
    @NamedQuery(name = "ProjectEventAttrs.findByEvent", query = "SELECT p FROM ProjectEventAttrs p WHERE p.event = :event"),
    @NamedQuery(name = "ProjectEventAttrs.findByTextField", query = "SELECT p FROM ProjectEventAttrs p WHERE p.textField = :textField"),
    @NamedQuery(name = "ProjectEventAttrs.findByItemNo", query = "SELECT p FROM ProjectEventAttrs p WHERE p.itemNo = :itemNo"),
    @NamedQuery(name = "ProjectEventAttrs.findByDateField", query = "SELECT p FROM ProjectEventAttrs p WHERE p.dateField = :dateField"),
    @NamedQuery(name = "ProjectEventAttrs.findByIsProxyExist", query = "SELECT p FROM ProjectEventAttrs p WHERE p.isProxyExist = :isProxyExist"),
    @NamedQuery(name = "ProjectEventAttrs.findByConference", query = "SELECT p FROM ProjectEventAttrs p WHERE p.conference = :conference"),
    @NamedQuery(name = "ProjectEventAttrs.findByCpSubject", query = "SELECT p FROM ProjectEventAttrs p WHERE p.cpSubject = :cpSubject"),
    @NamedQuery(name = "ProjectEventAttrs.findByPayStatus", query = "SELECT p FROM ProjectEventAttrs p WHERE p.payStatus = :payStatus"),
    @NamedQuery(name = "ProjectEventAttrs.findByUser", query = "SELECT p FROM ProjectEventAttrs p WHERE p.user = :user"),
    @NamedQuery(name = "ProjectEventAttrs.findByCompany", query = "SELECT p FROM ProjectEventAttrs p WHERE p.company = :company")})
public class ProjectEventAttrs implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @PrimaryKeyJoinColumn(name = "EVENT_ID",referencedColumnName = "ID")
    @OneToOne(optional = false)
    private ProjectEvent event;
    
    @Size(max = 4000)
    @Column(name = "TEXT_FIELD")
    private String textField;
    
    @Size(max = 32)
    @Column(name = "ITEM_NO")
    private String itemNo;
    
    @Column(name = "DATE_FIELD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateField;
    
    @Column(name = "IS_PROXY_EXIST")
    private String isProxyExist;
    
    @Column(name = "CONFERENCE_ID")
    private Long conference;
    
    @JoinColumn(name = "CP_SUBJECT_ID",referencedColumnName = "ID")
    @ManyToOne
    private PartnerEvntCpSubj cpSubject;
    
    @JoinColumn(name = "PAY_STATUS",referencedColumnName = "ID")
    @ManyToOne
    private PartnerEvntAttrPayStat payStatus;
    
    @JoinColumn(name = "USER_ID",referencedColumnName = "ID")
    @ManyToOne
    private CardioUser user;
    
    @JoinColumn(name = "COMPANY_ID",referencedColumnName = "ID")
    @ManyToOne
    private CardioCompany company;
    

    public ProjectEventAttrs() {
    }


    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Date getDateField() {
        return dateField;
    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }

    public Boolean getIsProxyExist() {
        return Boolean.valueOf(isProxyExist);
    }

    public void setIsProxyExist(Boolean isProxyExist) {
        this.isProxyExist = isProxyExist.toString();
    }

    public Long getConference() {
        return conference;
    }

    public void setConference(Long conference) {
        this.conference = conference;
    }

    public PartnerEvntCpSubj getCpSubject() {
        return cpSubject;
    }

    public void setCpSubject(PartnerEvntCpSubj cpSubject) {
        this.cpSubject = cpSubject;
    }

    public PartnerEvntAttrPayStat getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(PartnerEvntAttrPayStat payStatus) {
        this.payStatus = payStatus;
    }

    public CardioUser getUser() {
        return user;
    }

    public void setUser(CardioUser user) {
        this.user = user;
    }

    public CardioCompany getCompany() {
        return company;
    }

    public void setCompany(CardioCompany company) {
        this.company = company;
    }

    public ProjectEvent getProjectEvent() {
        return event;
    }

    public void setProjectEvent(ProjectEvent projectEvent) {
        this.event = projectEvent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (event != null ? event.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectEventAttrs)) {
            return false;
        }
        ProjectEventAttrs other = (ProjectEventAttrs) object;
        if ((this.event == null && other.event != null) || (this.event != null && !this.event.equals(other.event))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.ProjectEventAttrs[ event=" + event + " ]";
    }
    
}
