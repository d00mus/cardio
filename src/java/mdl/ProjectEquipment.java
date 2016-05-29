/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PROJECT_EQUIPMENT", catalog = "", schema = "CARDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectEquipment.findAll", query = "SELECT p FROM ProjectEquipment p"),
    @NamedQuery(name = "ProjectEquipment.findById", query = "SELECT p FROM ProjectEquipment p WHERE p.id = :id"),
    @NamedQuery(name = "ProjectEquipment.findByAmount", query = "SELECT p FROM ProjectEquipment p WHERE p.amount = :amount"),
    @NamedQuery(name = "ProjectEquipment.findByNotes", query = "SELECT p FROM ProjectEquipment p WHERE p.notes = :notes")})
public class ProjectEquipment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name="PROJECT_EQUIPMENT_ID_GENERATOR", sequenceName="PROJECT_EQUIPMENT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_EQUIPMENT_ID_GENERATOR")
    
    private Long id;
    
    private Long amount;
    
    @Size(max = 255)
    private String notes;
    
    @JoinColumn(name = "MODEL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private StoreItemModel model;
    
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CardioProject project;

    public ProjectEquipment() {
    }

    public ProjectEquipment(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public StoreItemModel getModel() {
        return model;
    }

    public void setModel(StoreItemModel model) {
        this.model = model;
    }

    public CardioProject getProject() {
        return project;
    }

    public void setProject(CardioProject project) {
        this.project = project;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if(object==null) return false;
        
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectEquipment)) {
            return false;
        }
        ProjectEquipment other = (ProjectEquipment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        
        
        boolean result=false;
        
        //если айдишки у обоих есть, тогда сравниваем только их
        if(this.id!=null && other.id!=null){
          result = (this.id.equals(other.id));
          
        
        return result;  
        }
        
        //если айдишек у обоих нет, тогда сравниваем все поля
        if(this.id==null && other.id==null){
          
          if(this.model!=null){
             result = (other.model!=null);
               result=result&&this.model.equals(other.model);
          }else result=(other.model==null);
          
          if(this.project!=null&&result){
             result = (other.project!=null);
              result&=this.project.equals(other.project);
          }else result=(other.project==null);
              
          if(this.notes!=null&&result){
             result = (other.notes!=null);
              result=result&&this.notes.equals(other.notes);
          }else result=(other.notes==null);
          
          
          if(this.amount!=null&&result){
             result = (other.amount!=null);
              result=result&&this.amount.equals(other.amount);
          }else result=(other.amount==null);
        }
        
        
        return result;
    }

    @Override
    public String toString() {
        return "mdl.ProjectEquipment[ id=" + id + " ]";
    }
    
}
