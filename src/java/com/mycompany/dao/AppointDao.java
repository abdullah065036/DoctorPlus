/*
 * AppointDao.java
 *
 * Created on April 2, 2007, 5:13 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.dao;

import com.mycompany.dto.AppointDto;
import com.mycompany.dto.PersonDto;
import com.mycompany.dto.ResponseDto;
import com.mycompany.utility.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Muhammad Arslan
 */
public class AppointDao  extends AbstractDao {
    public AppointDao() throws Exception {
    con = getConnection();
    }
    
    public ResponseDto viewAppoint(AppointDto t) throws Exception {
        
        try {
            
            ResponseDto r  = new ResponseDto();
            // search query based on name only, 
            // to do ... search based on name and address
            String sql ="SELECT * FROM Appointment where name like ?";
            
            PreparedStatement pStmt = con.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                    );
            String n="%"+t.getName()+"%";
            pStmt.setString(1, n);
            
            
           // pStmt.setString(1, n);
            
            ResultSet rs = pStmt.executeQuery( );
            
            ArrayList contacts = new ArrayList();
            
            while(rs.next()) {
                
                AppointDto p1 = new AppointDto();
                p1.setId(rs.getInt("id"));
                p1.setName(rs.getString("name"));
                p1.setDescription(rs.getString("description"));
                p1.setDate(rs.getString("date1")); 
                               
                contacts.add(p1); 
            }
            r.setData(contacts);
            return r;
        }catch(Exception e) {
            Logger.logException(e, "exception while searching");
            throw e;
        }

    }
    public void addAppoint(AppointDto p) throws Exception {
        try{
            //do your sql and return response dto
            String query="INSERT INTO Appointment(name,description,date1) VALUES('" +
                    p.getName() + "','" +
                    p.getDescription() + "','" +
                    p.getDate() + "') ";
            System.out.println(query);
            Statement  stmt  = con.createStatement(); 
            int num 	     = stmt.executeUpdate(query);            
            
            
        }catch(Exception e) {
            Logger.logException(e, "exception while adding new contact");
            throw e;
        }
    }
     public void editAppoint(AppointDto p) throws Exception {
        try{
            //do your sql and return response dto
            String query="UPDATE Appointment set date1 = '"+p.getDate()+"' , name = '"+p.getName()+"',description='"+p.getDescription()+"' WHERE id =" + p.getId();
            Statement  stmt  = con.createStatement(); 
            int num 	     = stmt.executeUpdate(query);            
            
            
        }catch(Exception e) {
            Logger.logException(e, "exception while adding new contact");
            throw e;
        }
    }
     public void deleteAppoint(AppointDto p) throws Exception {
        try{
            //do your sql and return response dto
            String query="DELETE FROM Appointment WHERE id = "+ p.getId();
            Statement  stmt  = con.createStatement(); 
            int num 	     = stmt.executeUpdate(query);
            
            
            
        }catch(Exception e) {
            Logger.logException(e, "exception while adding new contact");
            throw e;
        }
    }  
}