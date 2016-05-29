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
@Table(name = "USER_OCCUPATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserOccupation.findAll", query = "SELECT u FROM UserOccupation u"),
    @NamedQuery(name = "UserOccupation.findById", query = "SELECT u FROM UserOccupation u WHERE u.id = :id"),
    @NamedQuery(name = "UserOccupation.findByStartDate", query = "SELECT u FROM UserOccupation u WHERE u.startDate = :startDate"),
    @NamedQuery(name = "UserOccupation.findByEndDate", query = "SELECT u FROM UserOccupation u WHERE u.endDate = :endDate"),
    @NamedQuery(name = "UserOccupation.findByPosition", query = "SELECT u FROM UserOccupation u WHERE u.position = :position")})
public class UserOccupation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="USER_OCCUPATION_ID_GENERATOR", sequenceName="USER_OCCUPATION_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_OCCUPATION_ID_GENERATOR")
    private Integer id;
    
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Size(max = 255)
    private String position;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioUser user;
    
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioCompany company;

    public UserOccupation() {
    }

    public UserOccupation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserOccupation)) {
            return false;
        }
        UserOccupation other = (UserOccupation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.UserOccupation[ id=" + id + " ]";
    }
    
}
