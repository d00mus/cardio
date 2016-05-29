/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "PARTNER_EVENT_SUBJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerEventSubj.findAll", query = "SELECT p FROM PartnerEventSubj p"),
    @NamedQuery(name = "PartnerEventSubj.findById", query = "SELECT p FROM PartnerEventSubj p WHERE p.id = :id"),
    @NamedQuery(name = "PartnerEventSubj.findByCode", query = "SELECT p FROM PartnerEventSubj p WHERE p.code = :code"),
    @NamedQuery(name = "PartnerEventSubj.findByName", query = "SELECT p FROM PartnerEventSubj p WHERE p.name = :name")})
public class PartnerEventSubj implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IS_DATE_VISIBLE")
    private String isDateVisible;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IS_TEXT_VISIBLE")
    private String isTextVisible;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IS_NUM_VISIBLE")
    private String isNumVisible;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IS_COMP_VISIBLE")
    private String isCompVisible;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IS_USER_VISIBLE")
    private String isUserVisible;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IS_PROXY_VISIBLE")
    private String isProxyVisible;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IS_CONFERECE_VISIBLE")
    private String isConfereceVisible;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IS_CP_SUBJ_VISIBLE")
    private String isCpSubjVisible;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "IS_PAY_STATUS_VISIBLE")
    private String isPayStatusVisible;
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    private String code;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subj")
    private List<PartnerEvent> partnerEventList;

    public PartnerEventSubj() {
    }

    public PartnerEventSubj(Integer id) {
        this.id = id;
    }

    public PartnerEventSubj(Integer id, String code, String name) {
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
    public List<PartnerEvent> getPartnerEventList() {
        return partnerEventList;
    }

    public void setPartnerEventList(List<PartnerEvent> partnerEventList) {
        this.partnerEventList = partnerEventList;
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
        if (!(object instanceof PartnerEventSubj)) {
            return false;
        }
        PartnerEventSubj other = (PartnerEventSubj) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public PartnerEventSubj(Integer id, String code, String name, String isDateVisible, String isTextVisible, String isNumVisible, String isCompVisible, String isUserVisible, String isProxyVisible, String isConfereceVisible, String isCpSubjVisible, String isPayStatusVisible) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.isDateVisible = isDateVisible;
        this.isTextVisible = isTextVisible;
        this.isNumVisible = isNumVisible;
        this.isCompVisible = isCompVisible;
        this.isUserVisible = isUserVisible;
        this.isProxyVisible = isProxyVisible;
        this.isConfereceVisible = isConfereceVisible;
        this.isCpSubjVisible = isCpSubjVisible;
        this.isPayStatusVisible = isPayStatusVisible;
    }

    
    public String getIsDateVisible() {
        return isDateVisible;
    }

    public void setIsDateVisible(String isDateVisible) {
        this.isDateVisible = isDateVisible;
    }

    public String getIsTextVisible() {
        return isTextVisible;
    }

    public void setIsTextVisible(String isTextVisible) {
        this.isTextVisible = isTextVisible;
    }

    public String getIsNumVisible() {
        return isNumVisible;
    }

    public void setIsNumVisible(String isNumVisible) {
        this.isNumVisible = isNumVisible;
    }

    public String getIsCompVisible() {
        return isCompVisible;
    }

    public void setIsCompVisible(String isCompVisible) {
        this.isCompVisible = isCompVisible;
    }

    public String getIsUserVisible() {
        return isUserVisible;
    }

    public void setIsUserVisible(String isUserVisible) {
        this.isUserVisible = isUserVisible;
    }

    public String getIsProxyVisible() {
        return isProxyVisible;
    }

    public void setIsProxyVisible(String isProxyVisible) {
        this.isProxyVisible = isProxyVisible;
    }

    public String getIsConfereceVisible() {
        return isConfereceVisible;
    }

    public void setIsConfereceVisible(String isConfereceVisible) {
        this.isConfereceVisible = isConfereceVisible;
    }

    public String getIsCpSubjVisible() {
        return isCpSubjVisible;
    }

    public void setIsCpSubjVisible(String isCpSubjVisible) {
        this.isCpSubjVisible = isCpSubjVisible;
    }

    public String getIsPayStatusVisible() {
        return isPayStatusVisible;
    }

    public void setIsPayStatusVisible(String isPayStatusVisible) {
        this.isPayStatusVisible = isPayStatusVisible;
    }
       
}
