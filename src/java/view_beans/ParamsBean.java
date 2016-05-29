/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view_beans;

import dao.PatientFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.Patient;

/**
 * Бин для чтения параметров запроса, для инициализации сессионных бинов
 * @author d00mus
 */
@RequestScoped
//@Named("paramsBean")
@ManagedBean(eager = true,name="paramsBean")
public class ParamsBean {

@Inject
PatientProfileBean profileBean;   

@Inject
PsgBean  psgBean;
    
/**
 * ID выбранного к просмотру PSG
 */    
@ManagedProperty(name = "psgId",value = "#{param.psgId}")
private long psgId;

/**
 * ID выбранного к просмотру таба
 */
@ManagedProperty(name = "tabId",value = "#{param.tabId}")
private int tabId=0;



@PostConstruct
private void init(){
//тут надо инициировать сессонные бины..    
 if(id != 0){
    profileBean.setCurrentById(id);
    profileBean.setTabId(tabId);
 }   
 
 
 if(psgId!=0){//если передали параметр psgId
   psgBean.loadPsgById(psgId);  
 }
 
// System.out.println("ParamsBean:init() psgId="+psgId);
}    



    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
    }



/**
 * ID выбраной анкеты
 */

@ManagedProperty(name = "id",value = "#{param.id}")
private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getPsgId() {
        return psgId;
    }

    public void setPsgId(long psgId) {
        this.psgId = psgId;
    }
    
    
}
