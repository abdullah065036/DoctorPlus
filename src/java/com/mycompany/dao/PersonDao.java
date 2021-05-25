/*
 * PersonDao.java
 *
 * Created on February 27, 2007, 5:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.dao;

import com.mycompany.dto.PersonDto;
import com.mycompany.dto.ResponseDto;
import com.mycompany.utility.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 05030056
 */
public class PersonDao extends AbstractDao {
    public PersonDao() throws Exception{
        con = getConnection();
    }
    
    
    
    public ResponseDto searchPerson(PersonDto p) throws Exception {
        
        try {
            
            ResponseDto r  = new ResponseDto();
            // search query based on name only, 
            // to do ... search based on name and address
            String sql ="SELECT * FROM Person where name like ?";
            
            PreparedStatement pStmt = con.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                    );
            
            String n    = "%" + p.getName() + "%";
            
            pStmt.setString(1, n);
            
            ResultSet rs = pStmt.executeQuery( );
            
            ArrayList contacts = new ArrayList();
            
            while(rs.next()) {
                
                PersonDto p1 = new PersonDto();
                p1.setId(rs.getInt("id"));    
                p1.setName(rs.getString("name"));
                p1.setAddress(rs.getString("address"));
                
                contacts.add(p1); 
            }
            r.setData(contacts);
            return r;
        }catch(Exception e) {
            Logger.logException(e, "exception while searching");
            throw e;
        }

    }
    
    public void addPerson(PersonDto p) throws Exception {
        try{
            //do your sql and return response dto
            String query="INSERT INTO Person(name, address) VALUES(' " +
                    p.getName() + "' , '" + p.getAddress() + "') ";
            Statement  stmt  = con.createStatement(); 
            int num 	     = stmt.executeUpdate(query);            
            
            
        }catch(Exception e) {
            Logger.logException(e, "exception while adding new contact");
            throw e;
        }
    }
    public void editPerson(PersonDto p) throws Exception {
        try{
            //do your sql and return response dto
            System.out.println(p.getId());
            String query="UPDATE Person set address = '"+p.getAddress()+"' , name = '"+p.getName()+"' WHERE id =" + p.getId();
            Statement  stmt  = con.createStatement(); 
            int num 	     = stmt.executeUpdate(query);            
            
            
        }catch(Exception e) {
            Logger.logException(e, "exception while adding new contact");
            throw e;
        }
    }
    
    public void deletePerson(PersonDto p) throws Exception {
        try{
            //do your sql and return response dto
            String query="DELETE FROM person WHERE id = " + p.getId();
            Statement  stmt  = con.createStatement(); 
            int num 	     = stmt.executeUpdate(query);
            
            
            
        }catch(Exception e) {
            Logger.logException(e, "exception while adding new contact");
            throw e;
        }
    }
}
