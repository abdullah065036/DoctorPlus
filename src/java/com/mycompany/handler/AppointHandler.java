/*
 * AppointHandler.java
 *
 * Created on April 2, 2007, 4:30 AM
 */

package com.mycompany.handler;

import com.mycompany.dto.AppointDto;
import com.mycompany.dto.PersonDto;
import com.mycompany.translator.AppointTranslator;
import com.mycompany.translator.PersonTranslator;
import com.mycompany.bl.AppointBl;
import com.mycompany.dto.ResponseDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Muhammad Arslan
 * @version
 */
public class AppointHandler extends AbstractHandler {
    
    /** Creates a new instance of AppointHandler */
    public AppointHandler() {
    }
    public void processRequest(HttpServletRequest request, HttpServletResponse response )throws Exception {
        String actionId = (String)request.getParameter("actionid");
        if(actionId.equals("view")) {
            viewAppoint(request, response);
        } 
        else if(actionId.equals("add")) {
            addAppoint(request, response);
        }
        else if(actionId.equals("edit")) {
            editAppoint(request, response);
        }
        else if(actionId.equals("del")) {
            deleteAppoint(request, response);
        }
        
    }
    private void viewAppoint(HttpServletRequest request, HttpServletResponse response ) throws Exception {
        try{
            System.out.println("In view appointment");
            AppointBl bl = new AppointBl();
            AppointTranslator p= new AppointTranslator();
            AppointDto t= p.translateAppoint(request);
            ResponseDto r = bl.viewAppoint(t);
            
            HttpSession session = request.getSession();
            
            // store the dto in session for retrieval on jsp page
            // session is a HashMap
            session.setAttribute("appoints",r);
            response.sendRedirect("view.jsp");
   
            
        } catch(Exception e) {
            //in case of exception redirect to error page
            com.mycompany.utility.Logger.logDebugMessage(""+ e);
            throw e;
        }
    }
    private void addAppoint(HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            AppointTranslator t = new AppointTranslator();
            AppointDto p = t.translateAppoint(request);
            AppointBl bl = new AppointBl();
            bl.addAppoint(p);
            // no exception till this point so redirect to success page
            response.sendRedirect("success.jsp");
        } catch(Exception e) {
            com.mycompany.utility.Logger.logDebugMessage(""+ e);
            throw e;
        }        
    }
     private void editAppoint(HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            AppointTranslator t = new AppointTranslator();
            AppointDto p = t.translateAppoint(request);
            AppointBl bl = new AppointBl();
            
            bl.editAppoint(p);
            // no exception till this point so redirect to success page
            response.sendRedirect("success.jsp");
        } catch(Exception e) {
            com.mycompany.utility.Logger.logDebugMessage(""+ e);
            throw e;
        }        
     }
     private void deleteAppoint(HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
             
            AppointTranslator t = new AppointTranslator();
            AppointDto p = t.translateAppoint(request);
            
            AppointBl bl = new AppointBl();
           
            bl.deleteAppoint(p);
            
            
            // no exception till this point so redirect to success page
            response.sendRedirect("success.jsp");
        } catch(Exception e) {
            com.mycompany.utility.Logger.logDebugMessage(""+ e);
            throw e;
        }        
    } 

}
