
package mdl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PF_THEME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PfTheme.findAll", query = "SELECT p FROM PfTheme p"),
    @NamedQuery(name = "PfTheme.findByThemeName", query = "SELECT p FROM PfTheme p WHERE p.themeName = :themeName")})
public class PfTheme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "THEME_NAME")
    private String themeName;

    public PfTheme() {
    }

    public PfTheme(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (themeName != null ? themeName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PfTheme)) {
            return false;
        }
        PfTheme other = (PfTheme) object;
        if ((this.themeName == null && other.themeName != null) || (this.themeName != null && !this.themeName.equals(other.themeName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return themeName;
    }
    
}
