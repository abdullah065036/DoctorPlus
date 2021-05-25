/*
 * PesronBl.java
 *
 * Created on February 27, 2007, 5:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.bl;

import com.mycompany.dao.PersonDao;
import com.mycompany.dto.PersonDto;
import com.mycompany.dto.ResponseDto;

/**
 *
 * @author 05030056
 */
public class PersonBl {
    
    /** Creates a new instance of PesronBl */
    public PersonBl() {
    }
    
    public ResponseDto searchPerson(PersonDto p) throws Exception
    {
        ResponseDto r ;
        try
        {
        PersonDao dao = new PersonDao();
        r= dao.searchPerson(p);
    }
        catch(Exception e)
        {
            throw e;
        }
    
        return r;
        
    }
    
    public void addPerson(PersonDto p) throws Exception 
    {
        try{
            PersonDao dao = new PersonDao();
            dao.addPerson(p);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
    public void editPerson(PersonDto p) throws Exception 
    {
        try{
            PersonDao dao = new PersonDao();
            dao.editPerson(p);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    public void deletePerson(PersonDto p) throws Exception 
    {
        try{
            PersonDao dao = new PersonDao();
            dao.deletePerson(p);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}
