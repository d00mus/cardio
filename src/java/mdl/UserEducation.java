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
@Table(name = "USER_EDUCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserEducation.findAll", query = "SELECT u FROM UserEducation u"),
    @NamedQuery(name = "UserEducation.findById", query = "SELECT u FROM UserEducation u WHERE u.id = :id"),
    @NamedQuery(name = "UserEducation.findByUniver", query = "SELECT u FROM UserEducation u WHERE u.univer = :univer"),
    @NamedQuery(name = "UserEducation.findBySpec", query = "SELECT u FROM UserEducation u WHERE u.spec = :spec"),
    @NamedQuery(name = "UserEducation.findByDiplomNo", query = "SELECT u FROM UserEducation u WHERE u.diplomNo = :diplomNo"),
    @NamedQuery(name = "UserEducation.findByEndDate", query = "SELECT u FROM UserEducation u WHERE u.endDate = :endDate")})
public class UserEducation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="USER_EDUCATION_ID_GENERATOR", sequenceName="USER_EDUCATION_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_EDUCATION_ID_GENERATOR")
    private Integer id;
    
    @Size(max = 255)
    private String univer;
    
    @Size(max = 255)
    private String spec;
    
    @Size(max = 255)
    @Column(name = "DIPLOM_NO")
    private String diplomNo;
    
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser user;

    public UserEducation() {
    }

    public UserEducation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniver() {
        return univer;
    }

    public void setUniver(String univer) {
        this.univer = univer;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getDiplomNo() {
        return diplomNo;
    }

    public void setDiplomNo(String diplomNo) {
        this.diplomNo = diplomNo;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CardioUser getUser() {
        return user;
    }

    public void setUser(CardioUser user) {
        this.user = user;
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
        if (!(object instanceof UserEducation)) {
            return false;
        }
        UserEducation other = (UserEducation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.UserEducation[ id=" + id + " ]";
    }
    
}
