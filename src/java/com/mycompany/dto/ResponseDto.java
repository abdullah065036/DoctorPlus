/*
 * ResponseDto.java
 *
 * Created on February 27, 2007, 5:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mycompany.dto;

import java.util.ArrayList;

/**
 *
 * @author 05030056
 */
public class ResponseDto extends AbstractDto{ 
   
    AbstractDto response;
    private ArrayList data;
    
    /** Creates a new instance of ResponseDto */
    public ResponseDto() {
        data= new ArrayList();        
    }   
    
    public void setResponseDto(AbstractDto d)
    {
        response = d;
    }
    public AbstractDto getResponseDto()
    {
        return response;
    }
    
    public void setData(ArrayList data)
    {
        this.data = data;
    }
    
    
    public ArrayList getData()
    {
        return data;
    }
}
