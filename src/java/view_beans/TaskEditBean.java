
package view_beans;

import dao.CardioPartnerFacade;
import dao.TaskFacade;
import dao.UaStateFacade;
import dao.UaTownFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.CardioPartner;
import mdl.PartnerEmploye;
import mdl.PartnerEmployePhone;
import mdl.StoreItem;
import mdl.StoreItemType;
import mdl.StoreItemVendor;
import mdl.Task;
import mdl.TaskEquipment;
import mdl.UaState;
import mdl.UaTown;

/**
 *
 * @author d00mus
 */
@Named("taskEditBean")
@SessionScoped
public class TaskEditBean implements Serializable{

   
   private Task current;
   private boolean isCreateNewMode=true;
   private String editCaption="Создать новую задачу";
   
   @Inject
   private ProjectListBean listBean;
   
   @EJB
   private TaskFacade taskDao;
   
   
   @EJB
   private UaTownFacade townDao;

   @EJB
   private UaStateFacade stateDao;
   
   
   private List<UaTown> towns;
      
   private List<UaState> states;
   
   private UaState selectedState = null;
   
   private StoreItem itemToAdd;
   
   
   @EJB
   private CardioPartnerFacade partnerDao;
   
   private List<CardioPartner> partners;
   
   private TaskEquipment newEquipment = new TaskEquipment();
      //для добавления новых стор-айтемов
   private StoreItemType newStoreItemType;
   private StoreItemVendor newStoreItemVendor;

   
   public void createNew(){
     current = new Task();  
      isCreateNewMode = true;
       editCaption="Создать новую задачу";
        selectedState = null;
   }

   @PostConstruct
   private void init(){
     towns = townDao.findAll();
     states = stateDao.findAll();
     partners = partnerDao.findAll();

   }
   
   
   /**
    * Начать редактирование существующего таска
    * @param t 
    */
   public void beginEdit(Task t){
       isCreateNewMode=false;
        current=t;
         editCaption="Поправить задачу";
           selectedState = null;
   }
   
   /**
    * При выборе нового партнёра
    * @param event 
    */
   public void partnerSelectionChanged(final AjaxBehaviorEvent event){
       /**
        * обнулить город, если выбрана другая область
        */
       if(current.getUaTown() != null && current.getUaTown().getId() != selectedState.getId()) {
          current.setUaTown(null);
          current.setPerson(null);
          current.setPersonAux(null);
          current.setPersonPhone(null);
          current.setPersonPhoneAux(null);
       }
   }

//------------------------------------------------------------------------   
   
   public void contPersSelectionChanged(final AjaxBehaviorEvent event){
          current.setPersonPhone(null);
          current.setPersonPhoneAux(null);
   }

   
//------------------------------------------------------------------------   

   /**
    * авто дополнение контактных персон
    * @param query
    * @return 
    */
    public List<String> contPersAutoComplete(String query){

        if (current.getPartner() == null) {
            List<String> result = new ArrayList<String>();
              result.add("учреждение не выбрано!");
            return result;
        }
        
        List<PartnerEmploye> emplList = current.getPartner().getPartnerEmployeList();
        List<String> result = new ArrayList<String>();
        for(PartnerEmploye p:emplList) {
            if(p.getFio().toLowerCase().indexOf(query.toLowerCase()) >=0) {
               result.add(p.getFio());
            }
        }
        return result;
    }
    
//------------------------------------------------------------------------   

    public List<String> contPersPhoneAutoComplete(String query){

        if (current.getPerson() == null) {
            List<String> result = new ArrayList<String>();
              result.add("вбить руками");
            return result;
        }
        
        List<PartnerEmployePhone> phoneList = current.getPerson().getPartnerEmployePhoneList();
        List<String> result = new ArrayList<String>();
        for(PartnerEmployePhone p:phoneList) {
            if(p.getPhone().toLowerCase().indexOf(query.toLowerCase()) >=0) {
               result.add(p.getPhone());
            }
        }
        return result;
    }
    
//------------------------------------------------------------------------   
   
  /**
     * Метод для автокомплита учреждений
     * @param query
     * @return 
     */
    public List<CardioPartner> partnerAutoComplete(String query){
            List<CardioPartner> partnerSuggestion = new ArrayList<CardioPartner>();
            int i=0;
            for (CardioPartner t : partners ) {
                if (t.getName().toLowerCase().indexOf(query.toLowerCase()) >= 0){
                    if(selectedState == null ||selectedState.getId() == t.getJurAddrUaState().getId() ){
                       partnerSuggestion.add(t);
                    }
                 i++;
                }
             if(i>50) break;  
            }
            return partnerSuggestion;
    }    
   
   
//------------------------------------------------------------------------   
   /**
    * Сохранить изменения
    */
   public void save(){
       System.out.println("task edit: save called!");
       
     String msgText;  
     FacesMessage msg;
    try{   
     if(isCreateNewMode){
       taskDao.create(current);
       //обновить список таксов в списке
       listBean.updateMyTasks();
        listBean.updateTasks();
         msgText="Задача создана";
         beginEdit(current);
     }  else{
         
        taskDao.edit(current);
         taskDao.refresh(current.getId());
       
         msgText="Сохранено";
     }
      msg = new FacesMessage(FacesMessage.SEVERITY_INFO,msgText,"Сохранено");  
     
    }catch(Throwable t){
        t.printStackTrace();
       msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,t.toString(),"Ошибка");  
        
    }
    
     FacesContext.getCurrentInstance().addMessage(null, msg);  
   }
//---------------------------------------------------------------------------   
   
   public List<UaState> stateAutoComplete(String query) {
       if (query==null || query.isEmpty()) {
           return states;
       }
       
       List<UaState> stateSuggesion = new ArrayList<UaState>();
       
       for(UaState state:states) {
          if(  state.getRusName().toLowerCase().indexOf(query.toLowerCase()) >=0
             ||state.getUkrName().toLowerCase().indexOf(query.toLowerCase()) >=0) {     
              stateSuggesion.add(state);
          } 
       }
   return stateSuggesion;    
   }
   
//---------------------------------------------------------------------------   
   private List<UaTown> filterTownListByStates(UaState state) {
       if(state == null) return Collections.EMPTY_LIST;
       List<UaTown> result = new ArrayList<UaTown>();
       for (UaTown t : towns ) {
           if (t.getState().getId() == state.getId()) {
               result.add(t);
           }
       }
       return result;
   }
   
//---------------------------------------------------------------------------   
   
    /**
     * Метод для автокомплита городов
     * @param query
     * @return 
     */
    public List<UaTown> townAutoComplete(String query) {
            List<UaTown> townSuggestion = new ArrayList<UaTown>();
            int i=0;
            for (UaTown t : filterTownListByStates(selectedState) ) {
                if (t.getUkrName().toLowerCase().indexOf(query.toLowerCase()) >= 0){
                    townSuggestion.add(t);
                 i++;
                }
             if (i > 50) break;  
            }
            return townSuggestion;
    }
//---------------------------------------------------------------------------   
   
    
    /**
     * Добавить в задачу оборудование
     */
    public void addItem(){
       if(itemToAdd!=null){ 
           List<StoreItem> storeItemList = current.getStoreItemList();
           //проверить наличие в списке
           if(storeItemList.contains(itemToAdd))return;
          storeItemList.add(itemToAdd);
         FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Добавлено","Добавлено");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
       }
    }
//---------------------------------------------------------------------------   
    
    
    /**
     * Удалить из задачи оборудование
     * @param item 
     */
    public void delItem(StoreItem item){
       current.getStoreItemList().remove(item);
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Удалено","Удалено");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
//---------------------------------------------------------------------------   
    
   
    //==========геттеры и сеттеры=====================
    public Task getCurrent() {
        if(current==null){
          createNew();  
        }
        return current;
    }

    public void setCurrent(Task current) {
        this.current = current;
    }

    public String getEditCaption() {
        return editCaption;
    }

    public void setEditCaption(String editCaption) {
        this.editCaption = editCaption;
    }

    public StoreItem getItemToAdd() {
        return itemToAdd;
    }

    public void setItemToAdd(StoreItem itemToAdd) {
        this.itemToAdd = itemToAdd;
    }

    
    public UaState getSelectedState() {
        if (current.getUaTown() != null) {
            return current.getUaTown().getState();
        }
        return selectedState;
    }

    public void setSelectedState(UaState selectedState) {
        if (current.getUaTown() != null && current.getUaTown().getState().getId() != selectedState.getId()) {
            current.setUaTown(null);
        }
        
        this.selectedState = selectedState;
    }

    public String getSelectedPerson() {
        return current.getContPersonName();
    }

            
    public void setSelectedPerson(String name) {
        //попробовать найти данную персону по фио среди всех у данного учреждения
        if (current.getPartner() == null) {
            current.setPersonAux(name);
            return;
        }
       List<PartnerEmploye> partnerEmployeList = current.getPartner().getPartnerEmployeList();
       
       for(PartnerEmploye p: partnerEmployeList) {
           if(p.getFio().toLowerCase().trim().equals(name.toLowerCase().trim())) {
             current.setPerson(p);
             break;
           }
       }
       
       //если не удалось найти персону по фио
       if (current.getPerson() == null) {
           current.setPersonAux(name);
       }
    }

    public TaskEquipment getNewEquipment() {
        return newEquipment;
    }

    public void setNewEquipment(TaskEquipment newEquipment) {
        this.newEquipment = newEquipment;
    }

    public StoreItemType getNewStoreItemType() {
        return newStoreItemType;
    }

    public void setNewStoreItemType(StoreItemType newStoreItemType) {
        this.newStoreItemType = newStoreItemType;
    }

    public StoreItemVendor getNewStoreItemVendor() {
        return newStoreItemVendor;
    }

    public void setNewStoreItemVendor(StoreItemVendor newStoreItemVendor) {
        this.newStoreItemVendor = newStoreItemVendor;
    }
    
    
    

//-----------------------------------------------------------------------
    public String getSelectedPersPhone() {
        return current.getContPersonPhone();
    }

            
    public void setSelectedPersPhone(String name) {
        //попробовать найти данный телефон среди всех у данного сотрудника
        if (current.getPerson() == null) {
            current.setPersonPhoneAux(name);
            return;
        }
       List<PartnerEmployePhone> personPhoneList = current.getPerson().getPartnerEmployePhoneList();
       
       for(PartnerEmployePhone p: personPhoneList) {
           if(p.getPhone().toLowerCase().trim().equals(name.toLowerCase().trim())) {
             current.setPersonPhone(p);
             break;
           }
       }
       
       //если не удалось найти персону по фио
       if (current.getPersonPhone() == null) {
           current.setPersonPhoneAux(name);
       }
    }

// ----------------------------------
    
    /**
     * Добавить новое оборудование
     */
   public void addNewEquipment(){
      newEquipment.setTask(current);
     current.getTaskEquipmentList().add(newEquipment);
    newEquipment = new TaskEquipment();
    
     FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Оборудование добавлено","Оборудование добавлено");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  

   }
    
    
//  --------------------------------
   /**
    * Удалить оборудование
     * @param forDel
    */
   public void delEquipment(TaskEquipment forDel){
         current.getTaskEquipmentList().remove(forDel);
        forDel.setTask(null);
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Оборудование удалено","Оборудование удалено");  
      FacesContext.getCurrentInstance().addMessage(null, msg);  
    newEquipment = forDel;
   }
    
    
}
