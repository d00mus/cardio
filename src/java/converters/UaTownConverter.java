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
import mdl.UaTown;


/**
 *
 * @author d00mus
 */
@FacesConverter("UaTownConverter")
public class UaTownConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      System.out.println("UaTownConverter:getAsObject()called:"+value);
      return null;  
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      System.out.println("UaTownConverter:getAsString()called");
     return ((UaTown)value).getRusName();
    }

    
}
