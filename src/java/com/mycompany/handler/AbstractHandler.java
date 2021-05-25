/*
 * AbstractHandler.java
 *
 * Created on February 27, 2007, 5:19 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 05030056
 */
public abstract class AbstractHandler {
    
    /** Creates a new instance of AbstractHandler */
    public AbstractHandler() {
    }
    public abstract void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception; 
    
}
