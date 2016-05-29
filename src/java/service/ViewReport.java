package service;

import dao.PatientFacade;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import mdl.PatientPhoto;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * REST-веб сервис, отвечающий за печать отчётов
 * @author d00mus
 */
@Stateless
//@RequestScoped
@Path("report") 
public class ViewReport {
    
 @EJB
 //@Inject
 PatientFacade dao;  

 @GET
 @Path("psg/{id}")
 @Produces("application/pdf")
 /**
  * Печать ПСГ, точка входа
  */
  public byte[] printPsg(@PathParam("id") Long id) {
    //TODO:проверки безопасности, на основании данных текущего юзера!  
        return printPsgRep(id);
  }
  
  
  /**
   * Печать ПСГ
   * @param psgId
   * @return 
   */
  private byte[] printPsgRep(Long psgId){
      Connection conn=null;
try {
      InputStream is = getClass().getResourceAsStream("/rep/psg/psg_view.jasper");
      JasperReport jasperReport =  (JasperReport)JRLoader.loadObject(is);
      
       DataSource ds = (DataSource)InitialContext.doLookup("jdbc/cardio");
       conn = ds.getConnection();
       
      HashMap params = new HashMap();
      params.put("psg_id", psgId);
      JasperPrint jasperPrint  = JasperFillManager.fillReport(jasperReport, params,conn);

      return JasperExportManager.exportReportToPdf(jasperPrint);
    } catch (Exception e) {
        //TODO:нужна нормальная обработка ошибок!
      e.printStackTrace();
    }
     finally{
      try{
          conn.close();
      }catch(Exception e){}
    }
   return null;   
  }

  
 @GET
 @Path("patient/{id}")
 @Produces("application/pdf")
 /**
  * Печать пациента, точка входа
  */
  
  public byte[]printPatientRep(@PathParam("id") Long patientId){
    return  printPatient(patientId);
  }
  
  /**
   * Печать анкеты пациента
   * @param patientId
   * @return 
   */
  private byte[] printPatient(Long patientId){
      Connection conn=null;
try {
      InputStream is = getClass().getResourceAsStream("/rep/pat_profile/pat_profile.jasper");
      JasperReport jasperReport =  (JasperReport)JRLoader.loadObject(is);
      
       DataSource ds = (DataSource)InitialContext.doLookup("jdbc/cardio");
       conn = ds.getConnection();
       
      HashMap params = new HashMap();
      params.put("p_id", patientId);
      
//передать как параметр файл c картинков
      PatientPhoto avatar = dao.find(patientId).getAvatarId();
      if(avatar!=null){
       byte[] fileData = avatar.getFileData();
       
        }
              
      JasperPrint jasperPrint  = JasperFillManager.fillReport(jasperReport, params,conn);

      return JasperExportManager.exportReportToPdf(jasperPrint);
    } catch (Exception e) {
        //TODO:нужна нормальная обработка ошибок!
      e.printStackTrace();
    }
     finally{
      try{
          conn.close();
      }catch(Exception e){}
    }
   return null;   
  }

  
  
}
