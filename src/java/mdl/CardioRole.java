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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "CARDIO_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardioRole.findAll", query = "SELECT c FROM CardioRole c"),
    @NamedQuery(name = "CardioRole.findById", query = "SELECT c FROM CardioRole c WHERE c.id = :id"),
    @NamedQuery(name = "CardioRole.findByRoleName", query = "SELECT c FROM CardioRole c WHERE c.roleName = :roleName"),
    @NamedQuery(name = "CardioRole.findByDescription", query = "SELECT c FROM CardioRole c WHERE c.description = :description")})
public class CardioRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="CARDIO_ROLE_ID_GENERATOR", sequenceName="CARDIO_ROLE_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARDIO_ROLE_ID_GENERATOR")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Size(max = 64)
    private String description;
/*    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private List<CardioUserRoles> cardioUserRolesList;
*/
    public CardioRole() {
    }

    public CardioRole(Long id) {
        this.id = id;
    }

    public CardioRole(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

/*    
    @XmlTransient
    public List<CardioUserRoles> getCardioUserRolesList() {
        return cardioUserRolesList;
    }

    public void setCardioUserRolesList(List<CardioUserRoles> cardioUserRolesList) {
        this.cardioUserRolesList = cardioUserRolesList;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardioRole)) {
            return false;
        }
        CardioRole other = (CardioRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return roleName;
    }
    
}
