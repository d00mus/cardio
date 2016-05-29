package view_beans;

import dao.CardioPartnerFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.CardioPartner;

/**
 *
 * @author d00mus
 */
@Named("partnerListBean")
@SessionScoped
public class PartnerListBean implements Serializable {

    @EJB
    private CardioPartnerFacade dao;

    private List<CardioPartner> value;

    private List<CardioPartner> filtered;
    
    @Inject
    private PartnerEditBean editBean;

    public PartnerListBean() {
    }
    
    @PostConstruct
    private void init(){
        
    value = dao.findAll();
   
    }

    public List<CardioPartner> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<CardioPartner> filtered) {
        this.filtered = filtered;
    }

    public List<CardioPartner> getValue() {
        return value;
    }

    public void setValue(List<CardioPartner> value) {
        this.value = value;
    }

    /**
     * Создать новое предприятие
     *
     * @return
     */
    public String goCreateNew() {
        
         editBean.startCreateNew();
        return "partner_edit?faces-redirect=true";
    }
    
//-----------------------------------------------------------------------
    /**
     * перейти к правке соотв партнёра
     * @param edited
     * @return 
     */
    public String goEdit(CardioPartner edited){
        if(editBean==null){
            System.out.println("Ошибка! editBean is null!!");
            
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Системная ошибка","Ошибка 5001");  
              FacesContext.getCurrentInstance().addMessage(null, msg);  
            
          return null;  
        }
            
         editBean.startEdit(edited, null);
       return "partner_edit?faces-redirect=true";
    }
//----------------------------------------------------------------------------
    /**
     * удалить партнёра
     * @param forClose 
     */
    public void closePartner(CardioPartner forClose) {
        dao.closeRecord(forClose);
       value = dao.findAll(); 
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Удалено", "Учреждение удалено");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
//---------------------------------------------
    /**
     * Очистить фильтр на таблице
     *
     * @return
     */
    public String clearFilter() {
         filtered=null;
        value=dao.findAll();
      return null;
    }

}
