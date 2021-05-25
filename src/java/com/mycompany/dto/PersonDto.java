/*
 * PersonDto.java
 *
 * Created on February 27, 2007, 5:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.dto;

/**
 *
 * @author 05030056
 */
public class PersonDto extends AbstractDto {
    
    private String name, address;
    private Integer id;
    /** Creates a new instance of PersonDto */
    public PersonDto() {
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
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String a) {
        this.address=a;
    }
}
