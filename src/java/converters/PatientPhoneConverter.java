/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import mdl.PatientPhone;
import view_beans.PatientEditBean;

/**
 * Конвертер номеров телефонов, при создании/редактировании пациентов
 * @author d00mus
 */
  @FacesConverter("patientPhoneConverter")
  public class PatientPhoneConverter implements Converter{
      
        @Inject PatientEditBean patientEditBean;

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
//            System.out.println("patientPhoneConverter:getAsObject:"+value);
            if(value==null || "null".equals(value))return null;
            
            //long id = Long.valueOf(value);
//            patientTableBean.getSelected() --где-то тут может быть нулл!! если мы сходу попёрлись смотреть анкету!!
            for (PatientPhone t : patientEditBean.getCurrent().getPatientPhoneList()) {
                
             if(t.getPhoneRaw() !=null && value.equals(t.getPhoneRaw())){//искать будем по номеру телефона
                 return t;//отдаём первый найденный
             }   
            }
            return null;
        }

        @Override
        //строковым представлением телефона является сам номер
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            if( (value !=null) && (value instanceof  PatientPhone)){
               if(((PatientPhone)value).getId()!=null){ 
               return ((PatientPhone)value).getPhoneRaw();
             }
            }
          return null;  
       }
      
  }
    
