/*
 * ControllerServlet.java
 *
 * Created on February 27, 2007, 5:03 PM
 */

package com.mycompany.controller;

import com.mycompany.handler.AbstractHandler;
import com.mycompany.handler.PersonHandler;
import com.mycompany.handler.AppointHandler;

import java.io.*;
import java.util.HashMap;


import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author 05030056
 * @version
 */
public class ControllerServlet extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    HashMap handlerMap;
    
    public void init() {
        handlerMap = new HashMap();
        handlerMap.put("personinfo", new PersonHandler());
        handlerMap.put("appointinfo", new AppointHandler());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String page = request.getParameter("pageid");
        
        AbstractHandler ah =  null;
        
        if(page.equals("personinfo")) {
            
            ah=(AbstractHandler)handlerMap.get("personinfo");
          
        }
        if(page.equals("appointinfo")) {
            System.out.println("appointment");
            ah=(AbstractHandler)handlerMap.get("appointinfo");
        }
        
        try{
            ah.processRequest(request, response);
        } catch(Exception e) {
            com.mycompany.utility.Logger.logDebugMessage("" + e);
            response.sendRedirect("failure.jsp");
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
