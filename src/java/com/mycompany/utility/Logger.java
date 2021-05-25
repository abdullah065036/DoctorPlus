/*
 * Logger.java
 *
 * Created on February 27, 2007, 5:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.utility;

/**
 *
 * @author 05030056
 */
public class Logger {
    
    /** Creates a new instance of Logger */
    public Logger() {
    }
    
    public static void logDebugMessage(String msg)
    {
        System.out.println("DEBUG: "+ msg);
    }
    
    public static void logException(Exception e, String msg)
    {
        System.out.println("EXCEPTION: "+ msg);
        System.out.println("DETAIL: "+ e);
    }
}
