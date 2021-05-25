/*
 * AppointTranslator.java
 *
 * Created on April 2, 2007, 5:14 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.translator;

import com.mycompany.dto.AppointDto;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author Muhammad Arslan
 */
public class AppointTranslator {
    
    /** Creates a new instance of AppointTranslator */
    public AppointTranslator() {
    }
    public AppointDto translateAppoint(HttpServletRequest request) 
    {
        AppointDto p = new AppointDto(); 
        if(!((String)request.getParameter("id")).equals("null")){
            p.setId(Integer.parseInt((String)request.getParameter("id")));
        }
        p.setName((String)request.getParameter("name"));
        p.setDescription((String)request.getParameter("description"));
        p.setDate((String)request.getParameter("date"));
        return p;
    }
    
}
