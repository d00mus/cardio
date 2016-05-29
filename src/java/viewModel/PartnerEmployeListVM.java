/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viewModel;

import dao.CardioPartnerFacade;
import dao.PartnerEmployeFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.CardioPartner;
import mdl.PartnerEmploye;
import view_beans.PartnerEditBean;

/**
 * Список всех сотрудников
 * @author d00mus
 */
@SessionScoped
@Named("partnerEmployeListVMBean")
public class PartnerEmployeListVM implements Serializable{

@EJB
    private PartnerEmployeFacade dao;

    private List<PartnerEmploye> value;

    private List<PartnerEmploye> filtered;

    @Inject
    private PartnerEditBean partnerEditBean;
    
    @Inject
    private PartnerEmployeVM partnerEmployeVM;
    
    public PartnerEmployeListVM() {
    }
    
    @PostConstruct
    private void init(){
        
    value = dao.findAll();
   
    }
    
    /**
     * Перечитать из базы список сотрудников
     */
    public void refresh(){
      value = dao.findAll();
       clearFilter(); 
    }
    
    /**
     * Очистить фильтр
     */
    public void clearFilter(){
       filtered = null; 
    }
    
    /**
     * Перейти к просмотру (сотрудника) в контекте указанной компании
     * @param comp
     * @return 
     */
    public String goToCompany(CardioPartner comp){
      partnerEditBean.startEdit(comp, "employe_list");
     return "partner_edit?faces-redirect=true";   
    }

    
    /**
     * Перейти к правке выбраного сотрудника
     * @param toEdit
     * @return 
     */
    public String goEdit(PartnerEmploye toEdit){
        partnerEmployeVM.setCurrent(toEdit);
        partnerEmployeVM.setNewEmploye(false);
      return "employe_edit?faces-redirect=true";  
    };
    
    
    
    /**
     * Перейти к созданию нового сотрудника
     * @return 
     */
    public String goCreateNew(){
        partnerEmployeVM.startCreateNew();
        partnerEmployeVM.setNewEmploye(true);
      return "employe_edit?faces-redirect=true";  
    }
    
    
//----------- геттеры и сеттеры -------------------------   
    public List<PartnerEmploye> getValue() {
        return value;
    }

    public void setValue(List<PartnerEmploye> value) {
        this.value = value;
    }

    public List<PartnerEmploye> getFiltered() {
        return filtered;
    }

    public void setFiltered(List<PartnerEmploye> filtered) {
        this.filtered = filtered;
    }
    
    
    
}
