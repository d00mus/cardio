/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Table(name = "PARTNER_EVNT_CP_SUBJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerEvntCpSubj.findAll", query = "SELECT p FROM PartnerEvntCpSubj p"),
    @NamedQuery(name = "PartnerEvntCpSubj.findById", query = "SELECT p FROM PartnerEvntCpSubj p WHERE p.id = :id"),
    @NamedQuery(name = "PartnerEvntCpSubj.findByCode", query = "SELECT p FROM PartnerEvntCpSubj p WHERE p.code = :code"),
    @NamedQuery(name = "PartnerEvntCpSubj.findByName", query = "SELECT p FROM PartnerEvntCpSubj p WHERE p.name = :name")})
public class PartnerEvntCpSubj implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Size(max = 32)
    private String code;
    @Size(max = 255)
    private String name;
    @OneToMany(mappedBy = "cpSubjectId")
    private List<PartnerEventAttrs> partnerEventAttrsList;

    public PartnerEvntCpSubj() {
    }

    public PartnerEvntCpSubj(Integer id) {
        this.id = id;
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
    public List<PartnerEventAttrs> getPartnerEventAttrsList() {
        return partnerEventAttrsList;
    }

    public void setPartnerEventAttrsList(List<PartnerEventAttrs> partnerEventAttrsList) {
        this.partnerEventAttrsList = partnerEventAttrsList;
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
        if (!(object instanceof PartnerEvntCpSubj)) {
            return false;
        }
        PartnerEvntCpSubj other = (PartnerEvntCpSubj) object;
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
