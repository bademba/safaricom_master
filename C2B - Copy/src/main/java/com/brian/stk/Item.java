/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brian.stk;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

/**
 *
 * @author BADEMBA
 */
public class Item
{
    public String Name[];
    public String Value[];

    public String[] getName() {
        return Name;
    }

    public void setName(String[] Name) {
        this.Name = Name;
    }

    public String[] getValue() {
        return Value;
    }

    public void setValue(String[] Value) {
        this.Value = Value;
    }
 
    
 
    
    
  
}
	
