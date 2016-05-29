/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viewModel;

import dao.PartnerEventFacade;
import java.io.Serializable;
import java.util.List;  
import javax.faces.model.ListDataModel;  
import mdl.PartnerEmploye;
import org.primefaces.model.SelectableDataModel;  

/**
 * Модель данных для выбора текущей строки редактируемого сотрудника
 * @author d00mus
 */
public class PartnerEmplDataModel extends ListDataModel<PartnerEmploye> implements SelectableDataModel<PartnerEmploye>,Serializable{

    private List<PartnerEmploye> data;
    
    public PartnerEmplDataModel(){
    }
        
    public PartnerEmplDataModel(List<PartnerEmploye> data ){
        super(data);
        this.data = data;
    }
    
    @Override
    public Object getRowKey(PartnerEmploye object) {
        
//        System.out.println("getRowKey:"+object);
        if(object!=null && data!=null){
         return data.indexOf(object);
        }
      return null;  
    }

    @Override
    public PartnerEmploye getRowData(String rowKey) {
        
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
