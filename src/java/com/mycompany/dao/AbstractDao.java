/*
 * AbstractDao.java
 *
 * Created on February 27, 2007, 5:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 05030056
 */
public class AbstractDao {
    
    Connection  	con;
    
    String	 	dbUrl;
    String		username;
    String		password;
    
    /** Creates a new instance of AbstractDao */
    public AbstractDao() {
    }
    
    public Connection getConnection() throws Exception
    {
        System.out.println("Here in Conn");
        try {     
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book","root","root");
        } catch(Exception cnfEx) {
            // Exception for Class
            System.out.println(cnfEx);
            System.out.println("Connectivity Error");
            throw cnfEx;
        }
        System.out.println("Connected");
 
        return con;
    }
    
    public void releaseResources()throws Exception{
        try {
            con.close();
        } catch(SQLException sqlEx) {
            System.out.println("SQL Exception: " + sqlEx);
            throw sqlEx;
        }
    }
}
