/*
 * PersonTranslator.java
 *
 * Created on February 27, 2007, 5:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.translator;

import com.mycompany.dto.PersonDto;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 05030056
 */
public class PersonTranslator {
    
    
    
    /** Creates a new instance of PersonTranslator */
    public PersonTranslator() {
    }
    
    public PersonDto translatePerson(HttpServletRequest request) 
    {
        PersonDto p = new PersonDto();
        if(!((String)request.getParameter("id")).equals("null")){
            p.setId(Integer.parseInt((String)request.getParameter("id")));
        }
        p.setName((String)request.getParameter("name"));
        p.setAddress((String)request.getParameter("address"));
        
        return p;
    }
}
