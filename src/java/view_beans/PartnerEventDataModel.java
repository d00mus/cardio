/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view_beans;

import java.io.Serializable;
import java.util.List;  
import javax.faces.model.ListDataModel;  
import mdl.PartnerEvent;
import org.primefaces.model.SelectableDataModel;  

/**
 *
 * @author d00mus
 */
public class PartnerEventDataModel extends ListDataModel<PartnerEvent> implements SelectableDataModel<PartnerEvent>,Serializable{

    private List<PartnerEvent> data;
    
    public PartnerEventDataModel(){
    }
        
    public PartnerEventDataModel(List<PartnerEvent> data ){
        super(data);
        this.data = data;
    }
    
    @Override
    public Object getRowKey(PartnerEvent object) {
        
        if(object!=null && data!=null){
         return data.indexOf(object);
        }
      return null;  
    }

    @Override
    public PartnerEvent getRowData(String rowKey) {
        
        Integer index=null;
        if(rowKey!=null && !rowKey.trim().isEmpty()){
         index = Integer.valueOf(rowKey);
        }
        
        if(index!=null&&index>=0){
          return data.get(index);
        }
       return null; 
    }
    
}
