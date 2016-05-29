/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author d00mus
 */
@FacesConverter("RusTimeConverter")
public class TimeConverter implements Converter{
    private SimpleDateFormat f=new SimpleDateFormat("HH:mm:ss");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//               System.out.println("TimeConverter:getAsObject called, value = "+value);

        try {
            return f.parse(value);
        } catch (ParseException ex) {
            Logger.getLogger(TimeConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
  //             System.out.println("TimeConverter:getAsObject:null returned!");
      return null;  
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
//      System.out.println("TimeConverter:getAsString called, value.toString = "+value.toString()+", class = "+value.getClass().getSimpleName());
        if(value instanceof Date){
          return f.format((Date)value);
        }
//               System.out.println("TimeConverter:getAsString:null returned!");
       return null; 
    }
    
    
}
