package view_beans;

import java.io.Serializable;
import java.util.List;  
import javax.faces.model.ListDataModel;  
import mdl.ProjectEvent;
import org.primefaces.model.SelectableDataModel;  

/**
 *
 * @author d00mus
 */
public class ProjectEventDataModel extends ListDataModel<ProjectEvent> implements SelectableDataModel<ProjectEvent>, Serializable{

    private List<ProjectEvent> data;
    
    public ProjectEventDataModel(){
    }
        
    public ProjectEventDataModel(List<ProjectEvent> data ){
        super(data);
        this.data = data;
    }
    
    @Override
    public Object getRowKey(ProjectEvent object) {
        
//        System.out.println("ProjectEventDataModel.getRowKey:" + object);//debug
        
        if (object != null && data != null) {
            
//        System.out.println("ProjectEventDataModel.getRowKey: returned: " + data.indexOf(object));//debug
        
         return data.indexOf(object);
        }
      return null;  
    }

    
      
   
    @Override
    public ProjectEvent getRowData(String rowKey) {
        Integer index=null;
        if (rowKey!=null && !rowKey.trim().isEmpty()) {
         index = Integer.valueOf(rowKey);
        }
        
        if( index != null && index >= 0){
          return data.get(index);
        }
       return null; 
    }
   
}
