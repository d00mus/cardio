package view_beans;

import dao.CardioPartnerFacade;
import dao.PartnerEmployeFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.CardioPartner;
import viewModel.PartnerEmployeListVM;
import viewModel.PartnerEmployeVM;

/**
 *
 * @author d00mus
 */
@SessionScoped
@Named("employeEditBean")
public class EmployeEditBean implements Serializable{

    @EJB
    private PartnerEmployeFacade dao;
    
    @EJB
    private CardioPartnerFacade partnerDao;
    
    
    @Inject
    private PartnerEmployeVM partnerEmployeVM;
    
    @Inject
    private PartnerEmployeListVM partnerEmployeListVM;
    
    
    private List<CardioPartner> partners;
    
    @PostConstruct
    private void init(){
        partners = partnerDao.findAll();
    }
    
    
    public void refresh(){
      partnerEmployeVM.setCurrent(dao.refresh(partnerEmployeVM.getCurrent().getId()));
       partners = partnerDao.findAll();
      
    }
    
/**
     * Метод для автокомплита предприятий
     * @param query
     * @return 
     */
    public List<CardioPartner> partnerAutoComplete(String query){
        
            ArrayList<CardioPartner> partnerSuggestion = new ArrayList<CardioPartner>();
            int i=0;
            for (CardioPartner t : partners) {
                if (t.getName().toLowerCase().indexOf(query.toLowerCase()) >= 0) {
                    partnerSuggestion.add(t);
                 i++;
                }
             if(i>30) break;  
            }
       return partnerSuggestion;
    }    
    
    
  /**
     * Сохранить модификации в базе
     */
    public void save() throws ValidatorException {

     //выполнить проверки перед сохранением
     if (!preSaveCheck()){
         return;
     }
        
     String details=null;   
     
     try{
      if(partnerEmployeVM.isCurrIsNew()){//Если режим создания нового предприятия
        dao.create(partnerEmployeVM.getCurrent());
         details = "Сотрудник создан";
          partnerEmployeListVM.refresh();
      }else{
        dao.edit(partnerEmployeVM.getCurrent());
        details = "Сохранено в базе";
        refresh();
      }  
      
      partnerEmployeVM.setCurrIsNew(false);
      partnerEmployeVM.setNewEmploye(false);
              
     }catch(Throwable t){
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,t.getMessage(),"Ошибка работы с базой");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
       return;  
     }
      
     
       refresh();
      
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,details,details);  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        
         updateCaption();  
          partnerEmployeListVM.clearFilter();
         
    }

    /**
     * Проверки перед сохранением
     * @return 
     */
    private boolean preSaveCheck() {
     return true;        
    }

    /**
     * Обновить заголовок после сохранения
     */
    private void updateCaption() {
    }
    
//============= геттеры и сеттеры ==============
    
    
}
