/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PARTNER_EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerEvent.findAll", query = "SELECT p FROM PartnerEvent p"),
    @NamedQuery(name = "PartnerEvent.findById", query = "SELECT p FROM PartnerEvent p WHERE p.id = :id"),
    @NamedQuery(name = "PartnerEvent.findByEventDate", query = "SELECT p FROM PartnerEvent p WHERE p.eventDate = :eventDate"),
    @NamedQuery(name = "PartnerEvent.findByCreateDate", query = "SELECT p FROM PartnerEvent p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "PartnerEvent.findByLabel", query = "SELECT p FROM PartnerEvent p WHERE p.label = :label"),
    @NamedQuery(name = "PartnerEvent.findByUserId", query = "SELECT p FROM PartnerEvent p WHERE p.user = :user"),
    @NamedQuery(name = "PartnerEvent.findByPartnerId", query = "SELECT p FROM PartnerEvent p WHERE p.partner = :partner")})
public class PartnerEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PARTNER_EVENT_ID_GENERATOR", sequenceName="PARTNER_EVENT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTNER_EVENT_ID_GENERATOR")
    
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date eventDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    @Size(max = 255)
    
    private String label;
    

    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser user;

    
    @JoinColumn(name = "PARTNER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioPartner partner;
    
    /*
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "partnerEvent")
    private PartnerEventAttrs partnerEventAttrs;
    */
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PartnerEventType type;
    
    @JoinColumn(name = "SUBJ_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PartnerEventSubj subj;
    
//    @OneToOne(optional = false,mappedBy = "event",cascade = CascadeType.ALL)
    @OneToOne(optional = false,mappedBy = "event",cascade = CascadeType.ALL)
    private PartnerEventAttrs attrs = new PartnerEventAttrs();
    
    
    @ManyToOne(optional = true)
    @JoinColumn(name="EMPLOYE_ID",referencedColumnName = "ID")
    private PartnerEmploye employe;
    
    
    @Transient
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public PartnerEvent() {
        
    }

    public PartnerEvent(Long id) {
        this.id = id;
    }

    public PartnerEvent(Long id, Date eventDate, Date createDate) {
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
    
    /**
     * Получить дату как строку
    */
    public String getEventDateStr(){
        if(eventDate!=null){
          return dateFormat.format(eventDate);
        }else return null;
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

    public PartnerEventAttrs getAttrs() {
        return attrs;
    }

    public void setAttrs(PartnerEventAttrs attrs) {
        this.attrs = attrs;
    }

    public PartnerEmploye getEmploye() {
        return employe;
    }

    public void setEmploye(PartnerEmploye employe) {
        this.employe = employe;
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
        if (!(object instanceof PartnerEvent)) {
            return false;
        }
        PartnerEvent other = (PartnerEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{PartnerEvent:" + id + "}";
    }
    
}
