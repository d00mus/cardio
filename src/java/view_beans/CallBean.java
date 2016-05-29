/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view_beans;

import dao.PatientCallFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import mdl.PatientCall;

/**
 * Звонок пациенту
 * @author d00mus
 */
@SessionScoped
@Named("callBean")
//@ManagedBean
//@javax.faces.bean.SessionScoped()
public class CallBean implements Serializable {
    
    private PatientCall current;
    
    @EJB
    private PatientCallFacade callDao;    

    private boolean viewOnly=false;
    
    public PatientCall getCurrent() {
        return current;
    }

    public void setCurrent(PatientCall current) {
        this.current = current;
    }
    
    /*
    Вернутся к анкете пациента
    */
    public String goToCallList(){
        if(current!=null){
           return "patient_profile?faces-redirect=true&id="+current.getPatientId().getId()+"&tabId=2"; 
        }else return "patient_profile?faces-redirect=true";
    }
    
    
    /**
     * Сохранить звонок в базе
     * @return 
     */
    public String commit(){
     
        
      callDao.create(current);
      
      
      return goToCallList();
    }

    public boolean isViewOnly() {
        return viewOnly;
    }

    public void setViewOnly(boolean viewOnly) {
        this.viewOnly = viewOnly;
    }

    
    
}
