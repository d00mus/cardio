/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "PARTNER_BANK_RECV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerBankRecv.findAll", query = "SELECT p FROM PartnerBankRecv p"),
    @NamedQuery(name = "PartnerBankRecv.findById", query = "SELECT p FROM PartnerBankRecv p WHERE p.id = :id"),
    @NamedQuery(name = "PartnerBankRecv.findByTypeCode", query = "SELECT p FROM PartnerBankRecv p WHERE p.typeCode = :typeCode"),
    @NamedQuery(name = "PartnerBankRecv.findByAccount", query = "SELECT p FROM PartnerBankRecv p WHERE p.account = :account"),
    @NamedQuery(name = "PartnerBankRecv.findByBankName", query = "SELECT p FROM PartnerBankRecv p WHERE p.bankName = :bankName"),
    @NamedQuery(name = "PartnerBankRecv.findByBankMfo", query = "SELECT p FROM PartnerBankRecv p WHERE p.bankMfo = :bankMfo"),
    @NamedQuery(name = "PartnerBankRecv.findByInn", query = "SELECT p FROM PartnerBankRecv p WHERE p.inn = :inn"),
    @NamedQuery(name = "PartnerBankRecv.findByRecvName", query = "SELECT p FROM PartnerBankRecv p WHERE p.recvName = :recvName"),
    @NamedQuery(name = "PartnerBankRecv.findByNotes", query = "SELECT p FROM PartnerBankRecv p WHERE p.notes = :notes"),
    @NamedQuery(name = "PartnerBankRecv.findByCloseDate", query = "SELECT p FROM PartnerBankRecv p WHERE p.closeDate = :closeDate")})
public class PartnerBankRecv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PARTNER_BANK_RECV_ID_GENERATOR", sequenceName="PARTNER_BANK_RECV_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTNER_BANK_RECV_ID_GENERATOR")
    private Long id;
    
    @Size(max = 32)
    @Column(name = "TYPE_CODE")
    private String typeCode = "ACCOUNT";//по умолчанию - банковский счёт
    
    @Size(max = 255)
    private String account;
    
    @Size(max = 255)
    @Column(name = "BANK_NAME")
    private String bankName;
    
    @Size(max = 32)
    @Column(name = "BANK_MFO")
    private String bankMfo;
    
    @Size(max = 32)
    private String inn;
    
    @Size(max = 255)
    @Column(name = "RECV_NAME")
    private String recvName;
    
    @Size(max = 255)
    private String notes;
    
    @Column(name = "CLOSE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closeDate;
    
    @JoinColumn(name = "PARTNER_ID", referencedColumnName = "ID")
    @ManyToOne
    private CardioPartner partner;

    public PartnerBankRecv() {
    }

    public PartnerBankRecv(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankMfo() {
        return bankMfo;
    }

    public void setBankMfo(String bankMfo) {
        this.bankMfo = bankMfo;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public CardioPartner getPartner() {
        return partner;
    }

    public void setPartner(CardioPartner partner) {
        this.partner = partner;
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
        if (!(object instanceof PartnerBankRecv)) {
            return false;
        }
        PartnerBankRecv other = (PartnerBankRecv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PartnerBankRecv[ id=" + id + " ]";
    }
    
}
