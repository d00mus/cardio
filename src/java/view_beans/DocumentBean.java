/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view_beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import mdl.PatientDocument;
import dao.PatientDocumentFacade;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;  
import org.primefaces.model.StreamedContent;  
/**
 * Бин по работе с документами пациента
 * @author d00mus
 */
@SessionScoped
@Named("documentBean")
public class DocumentBean implements Serializable{
    
    @Inject
    private PatientProfileBean profileBean;
    
    private PatientDocument curDoc=new PatientDocument();//загружаемый документ
    
    @EJB
    private PatientDocumentFacade dao;
  
    /**
     * Добавить файл текущему пациенту
     */
    public void addFile(){
      if(curDoc.getFileData()!=null && curDoc.getFileData().length>0){
        curDoc.setPatient(profileBean.getCurrent());
         dao.create(curDoc);
          profileBean.getCurrent().getDocumentList().add(curDoc);
         FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Файл добавлен",curDoc.getFileName());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
       curDoc = new PatientDocument();//создать новый документ 
         
      }
    }
    
    public void delFile(){
        
    }
    
    public void clear(){
      curDoc = new PatientDocument();
        
    }

    
    /**
     * Получить текущий файл как поток, для скачивания
     * @param doc
     * @return 
     */
    public StreamedContent getFile(PatientDocument doc) throws UnsupportedEncodingException{
        InputStream stream =  new ByteArrayInputStream(doc.getFileData());  
         return new DefaultStreamedContent(stream, "application/octet-stream", URLEncoder.encode(doc.getFileName(), "UTF8").replaceAll("\\+", "%20") );  
    }
    
    
    
    public PatientDocument getCurDoc() {
         return curDoc;
    }

    
    public void setCurDoc(PatientDocument curDoc) {
        this.curDoc = curDoc;
    }

  /**
   * Метод для работы с загрузчиком файлов от primeFaces
   * @param event 
   */  
    
   public void handleFileUpload(FileUploadEvent event) { 
         curDoc.setFileName(event.getFile().getFileName());
          curDoc.setFileSize((int)event.getFile().getSize());
          
          byte [] fileContent = new byte[curDoc.getFileSize()];
        try {
            //прочесть содержимое загруженного файла
            event.getFile().getInputstream().read(fileContent);
        } catch (IOException ex) {
            Logger.getLogger(DocumentBean.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка работы с базой", ex.toString());  
           FacesContext.getCurrentInstance().addMessage(null, msg);  
         return; 
        }
          //выставить содержимое в энтети
          curDoc.setFileData(fileContent);
           
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Файл загружен на сервер",event.getFile().getFileName());  
             FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
   
   private List<PatientDocument> filteredDocs;

    public List<PatientDocument> getFilteredDocs() {
        return filteredDocs;
    }

    public void setFilteredDocs(List<PatientDocument> filteredDocs) {
        this.filteredDocs = filteredDocs;
    }
   
   
   
}
