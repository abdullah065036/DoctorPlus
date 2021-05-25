/*
 * PersonHandler.java
 *
 * Created on February 27, 2007, 5:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.handler;


import com.mycompany.dto.PersonDto;
import com.mycompany.translator.PersonTranslator;
import com.mycompany.bl.PersonBl;
import com.mycompany.dto.ResponseDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 05030056
 */
public class PersonHandler extends AbstractHandler {
    
    /** Creates a new instance of PersonHandler */
    public PersonHandler() {
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response )throws Exception {
        String actionId = (String)request.getParameter("actionid");
        if(actionId.equals("search")) {
            searchPerson(request, response);
        } else if(actionId.equals("add")) {
            addPerson(request, response);
        }else if(actionId.equals("edit")) {
            editPerson(request, response);
        }
        else if(actionId.equals("del")) {
            deletePerson(request, response);
        }
         else if(actionId.equals("show")) {
            showPerson(request, response);
        }
            
    }
    
    private void searchPerson(HttpServletRequest request, HttpServletResponse response ) throws Exception {
        try{
            PersonTranslator t = new PersonTranslator();
            PersonDto p = t.translatePerson(request);
            PersonBl bl = new PersonBl();
            ResponseDto r = bl.searchPerson(p);
            
            HttpSession session = request.getSession();
            
            // store the dto in session for retrieval on jsp page
            // session is a HashMap
            session.setAttribute("contacts",r);
            response.sendRedirect("searchresults.jsp");
   
            
        } catch(Exception e) {
            //in case of exception redirect to error page
            com.mycompany.utility.Logger.logDebugMessage(""+ e);
            throw e;
        }
    }
    
    
    private void addPerson(HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            PersonTranslator t = new PersonTranslator();
            PersonDto p = t.translatePerson(request);
            PersonBl bl = new PersonBl();
            bl.addPerson(p);
            // no exception till this point so redirect to success page
            response.sendRedirect("success.jsp");
        } catch(Exception e) {
            com.mycompany.utility.Logger.logDebugMessage(""+ e);
            throw e;
        }        
    }
     private void editPerson(HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
            PersonTranslator t = new PersonTranslator();
            PersonDto p = t.translatePerson(request);
            PersonBl bl = new PersonBl();
            //HttpSession session = request.getSession();
            // store the dto in session for retrieval on jsp page
            // session is a HashMap
            //PersonDto person = (PersonDto)session.getAttribute("update");
            bl.editPerson(p);
            // no exception till this point so redirect to success page
            response.sendRedirect("success.jsp");
        } catch(Exception e) {
            com.mycompany.utility.Logger.logDebugMessage(""+ e);
            throw e;
        }        
    }
     
    private void deletePerson(HttpServletRequest request, HttpServletResponse response)throws Exception {
        try{
             
            PersonTranslator t = new PersonTranslator();
            PersonDto p = t.translatePerson(request);
            
            PersonBl bl = new PersonBl();
           
            bl.deletePerson(p);
            
            
            // no exception till this point so redirect to success page
            response.sendRedirect("success.jsp");
        } catch(Exception e) {
            com.mycompany.utility.Logger.logDebugMessage(""+ e);
            throw e;
        }        
    } 
    private void showPerson(HttpServletRequest request, HttpServletResponse response ) throws Exception {
        try{
            //PersonTranslator t = new PersonTranslator();
            //PersonDto p = t.translatePerson(request);
            //PersonBl bl = new PersonBl();
            //ResponseDto r = bl.searchPerson(p);
            
            //HttpSession session = request.getSession();
            
            // store the dto in session for retrieval on jsp page
            // session is a HashMap
            //session.setAttribute("contacts",r);
            response.sendRedirect("appoint.jsp");
   
            
        } catch(Exception e) {
            //in case of exception redirect to error page
            com.mycompany.utility.Logger.logDebugMessage(""+ e);
            throw e;
        }
    }
}
