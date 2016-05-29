package view_beans;

import dao.StoreItemFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import mdl.StoreItem;
import mdl.StoreItemType;
import mdl.StoreItemVendor;

/**
 *
 * @author d00mus
 */
@Named("TempStoreBean")
@SessionScoped
public class TempStoreBean implements Serializable{
    
 //остатки на складе
 private List<StoreItem> storeRestItems;   

 //поставлено партнёрам
 private List<StoreItem> deliveredItems;   
 
 
 private List<StoreItem> filteredStoreRestItems;   

 //поставлено партнёрам
 private List<StoreItem> filteredDeliveredItems;   
 
 private Integer tabIdx=0;
 
 //новый вендор при добавлении
 private StoreItemVendor newStoreItemVendor;
 
 //новый тип при добавлении
 private StoreItemType newStoreItemType;
 
 
 @EJB
 private StoreItemFacade dao;
 
 private StoreItem newItem = new StoreItem();
 
 
 @PostConstruct
 private void init(){
     updateStore();
 }
 
    //перечитать склад
    public void updateStore() {
        filteredStoreRestItems = null;
        filteredDeliveredItems = null;

        List<StoreItem> allItems = dao.findAll();

        storeRestItems = new ArrayList<StoreItem>();
        deliveredItems = new ArrayList<StoreItem>();

        for (StoreItem si : allItems) {

            if (si.getStatus() != null) {
                if ("ON_STORE".equals(si.getStatus().getCode())) {
                    storeRestItems.add(si);
                } else if ("DELIVERED".equals(si.getStatus().getCode())) {
                    deliveredItems.add(si);
                }

            }
        }
      allItems = null;  
    }

    
    /**
     * Удалить запись на складе
     * @param item 
     */
    public void deleteItem(StoreItem item){
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Удалено","Удалено");  
      try{
         dao.remove(item);
        updateStore();
        newItem = item;
      }catch(Throwable t){
          t.printStackTrace();
       msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка!",t.toString());  
      }  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    
    public boolean isPartnerVisible(){
      if(newItem.getStatus()!=null && "DELIVERED".equals(newItem.getStatus().getCode()) ){
        return true; 
      }  
          
     return false;   
    }
    
    public void hadleItemStatus(){
        
      if(newItem.getPartner()!=null){
        if(newItem.getStatus()!=null && "ON_STORE".equals(newItem.getStatus().getCode())){
         newItem.setPartner(null);
          FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Ошибка ввода","Статус \"На складе\" не совсестим с партнёром");  
           FacesContext.getCurrentInstance().addMessage(null, msg);  
        }
          
      }  
        
    }
    
    /**
     * Добавить на склад новую запись
     */
    public void addItem(){
        boolean haveErrors=false;
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Добавлено","Добавлено");  
       
      //выполнить проверку полей
      
      if(newItem.getStore()==null){
         haveErrors=true; 
          msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка","Склад - обязательно!");  
           FacesContext.getCurrentInstance().addMessage(null, msg);            
      } 
      
      if(newItem.getModel()==null){
         haveErrors=true; 
          msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка","Модель - обязательно!");  
           FacesContext.getCurrentInstance().addMessage(null, msg);            
      }

      
      if(newItem.getStatus()==null){
         haveErrors=true; 
          msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка","Статус - обязательно!");  
           FacesContext.getCurrentInstance().addMessage(null, msg);            
      }
      
      if(haveErrors){
          return;
      }
      
     try{   
         dao.create(newItem);
        updateStore();
       newItem = new StoreItem();
     }catch(Throwable t){
         t.printStackTrace();
       msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка!",t.toString());  
     }  
     FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
 
 
 //======геттеры и сеттеры ===========================
    public List<StoreItem> getStoreRestItems() {
        return storeRestItems;
    }

    public void setStoreRestItems(List<StoreItem> storeRestItems) {
        this.storeRestItems = storeRestItems;
    }

    public List<StoreItem> getDeliveredItems() {
        return deliveredItems;
    }

    public void setDeliveredItems(List<StoreItem> deliveredItems) {
        this.deliveredItems = deliveredItems;
    }

    public StoreItem getNewItem() {
        return newItem;
    }

    public void setNewItem(StoreItem newItem) {
        this.newItem = newItem;
    }

    public List<StoreItem> getFilteredStoreRestItems() {
        return filteredStoreRestItems;
    }

    public void setFilteredStoreRestItems(List<StoreItem> filteredStoreRestItems) {
        this.filteredStoreRestItems = filteredStoreRestItems;
    }

    public List<StoreItem> getFilteredDeliveredItems() {
        return filteredDeliveredItems;
    }

    public void setFilteredDeliveredItems(List<StoreItem> filteredDeliveredItems) {
        this.filteredDeliveredItems = filteredDeliveredItems;
    }

    public Integer getTabIdx() {
        return tabIdx;
    }

    public void setTabIdx(Integer tabIdx) {
        this.tabIdx = tabIdx;
    }

    public StoreItemVendor getNewStoreItemVendor() {
        return newStoreItemVendor;
    }

    public void setNewStoreItemVendor(StoreItemVendor newStoreItemVendor) {
        this.newStoreItemVendor = newStoreItemVendor;
    }

    public StoreItemType getNewStoreItemType() {
        return newStoreItemType;
    }

    public void setNewStoreItemType(StoreItemType newStoreItemType) {
        this.newStoreItemType = newStoreItemType;
    }
 
    
 

 
}
