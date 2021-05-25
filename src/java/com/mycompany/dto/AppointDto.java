/*
 * AppointDto.java
 *
 * Created on April 2, 2007, 5:13 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.dto;

/**
 *
 * @author Muhammad Arslan
 */
public class AppointDto  extends AbstractDto {
    private String name, description, date;
    Integer id;
    /** Creates a new instance of AppointDto */
    public AppointDto() {
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id=id;
    }
     public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String a) {
        this.description=a;
    }
    public String getDate() {
        return date;
    }
    
    public void setDate(String a) {
        this.date=a;
    }
}
