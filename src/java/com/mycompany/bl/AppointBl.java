/*
 * AppointBl.java
 *
 * Created on April 2, 2007, 5:12 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.bl;

import com.mycompany.dao.AppointDao;
import com.mycompany.dao.PersonDao;
import com.mycompany.dto.AppointDto;
import com.mycompany.dto.PersonDto;
import com.mycompany.dto.ResponseDto;

/**
 *
 * @author Muhammad Arslan
 */
public class AppointBl {
    
    /** Creates a new instance of AppointBl */
    public AppointBl() {
    }
    
    public ResponseDto viewAppoint(AppointDto t) throws Exception
    {
        ResponseDto r ;
        try
        {
        AppointDao dao = new AppointDao();
        r= dao.viewAppoint(t);
    }
        catch(Exception e)
        {
            throw e;
        }
    
        return r;
        
    }
    public void addAppoint(AppointDto p) throws Exception 
    {
        try{
            AppointDao dao = new AppointDao();
            dao.addAppoint(p);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
     public void editAppoint(AppointDto p) throws Exception 
    {
        try{
            AppointDao dao = new AppointDao();
            dao.editAppoint(p);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
     public void deleteAppoint(AppointDto p) throws Exception 
    {
        try{
            AppointDao dao = new AppointDao();
            dao.deleteAppoint(p);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
    
}
