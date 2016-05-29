/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package converters;

import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import mdl.PatientPhone;
import view_beans.CallBean;

/**
 *
 * @author d00mus
 */
@FacesConverter("phonesConverter")
//@RequestScoped
public class PhonesConverter  implements Converter{
    
    @Inject
    CallBean callBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        /*
        Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
        
        Object o = sessionMap.get("callBean");
        if(o!=null && o instanceof CallBean){
           callBean = (CallBean)o;
            }else{
            throw new RuntimeException("PhonesConverter:callBean is null!");
        }
    */
//        System.out.println("PhonesConverter.getAsObject():"+value);//TODO:debug!!
        
//        System.out.println("callBean:"+callBean);//TODO:debug!!
        if(callBean == null){
           throw new RuntimeException("PhonesConverter:callBean is null!");
        }
        
        if(callBean!=null && callBean.getCurrent()!=null && callBean.getCurrent().getPatientId()!=null){
            List<PatientPhone> patientPhoneList = callBean.getCurrent().getPatientId().getPatientPhoneList();
            if(patientPhoneList!=null){
                for(PatientPhone phone:patientPhoneList){
                    if(phone.getPhoneRaw().trim().equals(value.trim())){
                        return phone;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
//        System.out.println("PhonesConverter.getAsString():"+value);//TODO:debug!!
        if(value!=null && value instanceof PatientPhone){
         return ((PatientPhone)value).getPhoneRaw();
       }
        return null;
    }

    public CallBean getCallBean() {
        return callBean;
    }

    public void setCallBean(CallBean callBean) {
        this.callBean = callBean;
    }
    
    
    
}
