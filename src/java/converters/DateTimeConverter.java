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
@FacesConverter("RusDateTimeConverter")
public class DateTimeConverter implements Converter{
    private SimpleDateFormat f=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return f.parse(value);
        } catch (ParseException ex) {
            Logger.getLogger(DateTimeConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
      return null;  
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Date){
          return f.format((Date)value);
        }
       return null; 
    }
    
    
}
