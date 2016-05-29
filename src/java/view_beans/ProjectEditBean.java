
package view_beans;

import dao.CardioPartnerFacade;
import dao.CardioProjectFacade;
import dao.UaTownFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import mdl.CardioProject;
import mdl.ProjectEvent;
import mdl.ProjectEventAttrs;
import mdl.ProjectEquipment;
import mdl.StoreItemType;
import mdl.StoreItemVendor;
import mdl.UaTown;

/**
 *
 * @author d00mus
 */
@Named("projectEditBean")
@SessionScoped
public class ProjectEditBean implements Serializable{

   
   private CardioProject current=new CardioProject();
   private boolean isCreateNewMode=true;
   private String editCaption="Создать новый проект";
   
   @EJB
   private CardioProjectFacade projectDao;
   
   @Inject
   private ProjectListBean listBean;
   
   @Inject
   private LoginBean loginBean;
   
   
   @EJB
   private UaTownFacade townDao;
   
   private List<UaTown> towns;

   @EJB
   private CardioPartnerFacade partnerDao;
   
   private List<CardioPartner> partners;

   
   private ProjectEquipment newEquipment = new ProjectEquipment();
   
   //для добавления новых стор-айтемов
   private StoreItemType newStoreItemType;
   private StoreItemVendor newStoreItemVendor;
      
   
  //=======поддержка фильтра по событиям=========
    //список отфильтрованнных событий
    private List<ProjectEvent> filteredEvents;
    
    private String fltEventLabel;
    
    private String fltEventUser;
    
    private String fltEventSubj;
    
    private String fltEventType;
    
    private ProjectEvent newEvent=new ProjectEvent();
    
    private ProjectEventAttrs newEventAttrs = new ProjectEventAttrs();
    
    //активный индекс в табе
    private int activeIndex = 0;
    
    private boolean doCreateNew;//признак того, что идёт создание нового пользователя


    //поддержка выделения строк в событиях
    private ProjectEventDataModel eventDataModel;
    
    //выбранная строка с событием
    private ProjectEvent selectedEventRow = new ProjectEvent();//чтоб не было нулл поинтер..   
    
   

   /**
     * Очистить фильтр событий
     */
   public void clearFilter(){
       filteredEvents = null;
       clearSelection();
   } 
   
   /**
    * Очистить выделение
    */
   public void clearSelection(){
    eventDataModel = new ProjectEventDataModel(current.getProjectEventList());
     selectedEventRow = new ProjectEvent();
   }    
   
   
   public void createNew(){
     current = new CardioProject();  
      isCreateNewMode=true;
       editCaption="Создать новый проект";
        newEquipment = new ProjectEquipment();
          eventDataModel =  new ProjectEventDataModel(current.getProjectEventList());
           selectedEventRow = new ProjectEvent();
        
   }

   @PostConstruct
   private void init(){
     towns = townDao.findAll();
     partners = partnerDao.findAll();
   }
   
   
   /**
    * Начать редактирование существующего таска
    * @param t 
    */
   public void beginEdit(CardioProject t){
       isCreateNewMode=false;
        current=t;
         editCaption="Поправить проект";
          newEquipment = new ProjectEquipment();
           eventDataModel =  new ProjectEventDataModel(current.getProjectEventList());
            selectedEventRow = new ProjectEvent();
          
   }
   
   /**
    * При выборе нового партнёра
    * @param event 
    */
   public void partnerSelectionChanged(final AjaxBehaviorEvent event){
       //сбросить ответственую персону
       current.setContactPers(null);
   }
   
   
   /**
    * Сохранить изменения в проекте
    */
   public void save(){
       
     String msgText;  
     FacesMessage msg;
     
     //debug
     System.out.println("projectEditBean.save(): called");
     
    try{   
     if(isCreateNewMode){
       projectDao.create(current);
       //обновить список таксов в списке
       listBean.updateMyProjects();
        listBean.updateProjects();
         msgText="Проект создан";
         beginEdit(current);
     }  else{
         
        projectDao.edit(current);
         projectDao.refresh(current.getId());
       
         msgText="Сохранено";
     }
      msg = new FacesMessage(FacesMessage.SEVERITY_INFO,msgText,"Сохранено");  
     
    }catch(Throwable t){
        t.printStackTrace();
       msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,t.toString(),"Ошибка");  
        
    }
    
     FacesContext.getCurrentInstance().addMessage(null, msg);  
   }
   
    /**
     * Метод для автокомплита городов
     * @param query
     * @return 
     */
    public List<UaTown> townAutoComplete(String query){
/*        
         boolean useState=false;//использовать ограничение по области?
         Integer curStateId=null;
         if(current.getAdrUaStateId()!=null){
             useState=true;
             curStateId = current.getAdrUaStateId().getId();
         }
             
         useState = false;//TODO: пока не используем ограничение по области!!
  */       
            List<UaTown> townSuggestion = new ArrayList<UaTown>();
            int i=0;
            for (UaTown t : towns ) {
                if (t.getUkrName().toLowerCase().indexOf(query.toLowerCase()) >= 0){
/*                    
                     &&(!useState ||(curStateId == t.getStateId().getId()))     
                        ) {
*/                
                    townSuggestion.add(t);
                 i++;
                }
             if(i>50) break;  
            }
            return townSuggestion;
    }
   
    
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
                    partnerSuggestion.add(t);
                 i++;
                }
             if(i>50) break;  
            }
            return partnerSuggestion;
    }    
    
    
    
    /**
     * Добавить новое оборудование
     */
   public void addNewEquipment(){
      newEquipment.setProject(current);
     current.getProjectEquipmentList().add(newEquipment);
    newEquipment = new ProjectEquipment();
    
     FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Оборудование добавлено","Оборудование добавлено");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  

   }
   
   
   /**
    * Удалить оборудование
    */
   public void delEquipment(ProjectEquipment forDel){
         current.getProjectEquipmentList().remove(forDel);
        forDel.setProject(null);
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Оборудование удалено","Оборудование удалено");  
      FacesContext.getCurrentInstance().addMessage(null, msg);  
    newEquipment = forDel;
   }
    
//============ работа с событиями ================

   
    public void editSelectedEvent(){
     selectedEventRow.setCreateDate(new Date());
     selectedEventRow.setUser(loginBean.getCurrentUser());
     
     FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Правки внесены, надо сохранить","Поправлено");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
   }
    
    /**
     * Добавить событие
     */
    public void addEvent(){
       newEvent.setProject(current);
       newEvent.setAttrs(newEventAttrs);
       newEventAttrs.setProjectEvent(newEvent);
        newEvent.setCreateDate(new Date());
        current.getProjectEventList().add(newEvent);
         newEvent.setUser(loginBean.getCurrentUser());//юзер-создатель
         
         newEvent = new ProjectEvent();
         newEventAttrs = new ProjectEventAttrs();
       
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Событие добавлено","Добавлено");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    
    
    /**
     * Удалить событие
     * @param forDel
     */
    public void delEvent(ProjectEvent forDel){
        
       current.getProjectEventList().remove(forDel);
         newEvent = forDel;
         if(forDel.getAttrs() !=null){
           newEventAttrs = forDel.getAttrs();
         }
         
          forDel.setProject(null);
       //сообщить      
       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Событие удалёно","Удалено");  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
    }   
   
   
   
    //==========геттеры и сеттеры=====================
    public CardioProject getCurrent() {
        if(current==null){
          createNew();  
        }
        return current;
    }

    public void setCurrent(CardioProject current) {
        this.current = current;
    }

    public String getEditCaption() {
        return editCaption;
    }

    public void setEditCaption(String editCaption) {
        this.editCaption = editCaption;
    }

    public ProjectEquipment getNewEquipment() {
        return newEquipment;
    }

    public void setNewEquipment(ProjectEquipment newEquipment) {
        this.newEquipment = newEquipment;
    }

    public List<ProjectEvent> getFilteredEvents() {
        return filteredEvents;
    }

    public void setFilteredEvents(List<ProjectEvent> filteredEvents) {
        this.filteredEvents = filteredEvents;
    }

    public String getFltEventLabel() {
        return fltEventLabel;
    }

    public void setFltEventLabel(String fltEventLabel) {
        this.fltEventLabel = fltEventLabel;
    }

    public String getFltEventUser() {
        return fltEventUser;
    }

    public void setFltEventUser(String fltEventUser) {
        this.fltEventUser = fltEventUser;
    }

    public String getFltEventSubj() {
        return fltEventSubj;
    }

    public void setFltEventSubj(String fltEventSubj) {
        this.fltEventSubj = fltEventSubj;
    }

    public String getFltEventType() {
        return fltEventType;
    }

    public void setFltEventType(String fltEventType) {
        this.fltEventType = fltEventType;
    }

    public ProjectEvent getNewEvent() {
        return newEvent;
    }

    public void setNewEvent(ProjectEvent newEvent) {
        this.newEvent = newEvent;
    }

    public ProjectEventAttrs getNewEventAttrs() {
        return newEventAttrs;
    }

    public void setNewEventAttrs(ProjectEventAttrs newEventAttrs) {
        this.newEventAttrs = newEventAttrs;
    }

    public ProjectEventDataModel getEventDataModel() {
        return eventDataModel;
    }

    public void setEventDataModel(ProjectEventDataModel aEventDataModel) {
        this.eventDataModel = aEventDataModel;
    }

    public ProjectEvent getSelectedEventRow() {
        return selectedEventRow;
    }

    public void setSelectedEventRow(ProjectEvent aSelectedEventRow) {
        this.selectedEventRow = aSelectedEventRow;
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

    public int getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(int activeIndex) {
        this.activeIndex = activeIndex;
    }
   
    
    
    
    
}
