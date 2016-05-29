/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "PARTNER_EVENT_ATTRS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerEventAttrs.findAll", query = "SELECT p FROM PartnerEventAttrs p"),
    @NamedQuery(name = "PartnerEventAttrs.findByEvent", query = "SELECT p FROM PartnerEventAttrs p WHERE p.event = :event"),
    @NamedQuery(name = "PartnerEventAttrs.findByTextField", query = "SELECT p FROM PartnerEventAttrs p WHERE p.textField = :textField"),
    @NamedQuery(name = "PartnerEventAttrs.findByItemNo", query = "SELECT p FROM PartnerEventAttrs p WHERE p.itemNo = :itemNo"),
    @NamedQuery(name = "PartnerEventAttrs.findByDateField", query = "SELECT p FROM PartnerEventAttrs p WHERE p.dateField = :dateField"),
    @NamedQuery(name = "PartnerEventAttrs.findByIsProxyExist", query = "SELECT p FROM PartnerEventAttrs p WHERE p.isProxyExist = :isProxyExist"),
    @NamedQuery(name = "PartnerEventAttrs.findByConferenceId", query = "SELECT p FROM PartnerEventAttrs p WHERE p.conferenceId = :conferenceId"),
    @NamedQuery(name = "PartnerEventAttrs.findByPayStatus", query = "SELECT p FROM PartnerEventAttrs p WHERE p.payStatus = :payStatus"),
    @NamedQuery(name = "PartnerEventAttrs.findByUser", query = "SELECT p FROM PartnerEventAttrs p WHERE p.user = :user"),
    @NamedQuery(name = "PartnerEventAttrs.findByCompany", query = "SELECT p FROM PartnerEventAttrs p WHERE p.company = :company")})
public class PartnerEventAttrs implements Serializable {
  
    private static final long serialVersionUID = 1L;
    @Id
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "ID",nullable = false,unique = true)
    @OneToOne(optional = false,cascade = CascadeType.REMOVE)
    private PartnerEvent event;
    
    @JoinColumn(name = "PAY_STATUS", referencedColumnName = "ID")
    @ManyToOne
    private PartnerEvntAttrPayStat payStatus;
    
    
    @Size(max = 4000)
    @Column(name = "TEXT_FIELD")
    private String textField;
    
    @Size(max = 32)
    @Column(name = "ITEM_NO")
    private String itemNo;
    
    @Column(name = "DATE_FIELD")
    @Temporal(TemporalType.DATE)
    private Date dateField;
    
    @Column(name = "IS_PROXY_EXIST")
    private String isProxyExist;
    
    @Column(name = "CONFERENCE_ID")
    private Long conferenceId;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser user;
    
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioCompany company;
    
    @JoinColumn(name = "CP_SUBJECT_ID", referencedColumnName = "ID")
    @ManyToOne
    private PartnerEvntCpSubj cpSubjectId;
    
    /*
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PartnerEvent partnerEvent;
    */

    public PartnerEventAttrs() {
    }

    public PartnerEventAttrs(PartnerEvent event) {
        this.event = event;
    }

    public PartnerEvent getEvent() {
        return event;
    }

    public void setEvent(PartnerEvent event) {
        this.event = event;
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

    public Long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Long conferenceId) {
        this.conferenceId = conferenceId;
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

    public PartnerEvntCpSubj getCpSubjectId() {
        return cpSubjectId;
    }

    public void setCpSubjectId(PartnerEvntCpSubj cpSubjectId) {
        this.cpSubjectId = cpSubjectId;
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
        if (!(object instanceof PartnerEventAttrs)) {
            return false;
        }
        PartnerEventAttrs other = (PartnerEventAttrs) object;
        if ((this.event == null && other.event != null) || (this.event != null && !this.event.equals(other.event))) {
            return false;
        }
        return true;
    }


    public PartnerEvntAttrPayStat getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(PartnerEvntAttrPayStat payStatus) {
        this.payStatus = payStatus;
    }

   
    @Override
    public String toString() {
        return event.toString();
    }
    
}
