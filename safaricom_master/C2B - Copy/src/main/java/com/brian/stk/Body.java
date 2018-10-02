/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brian.stk;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author BADEMBA
 */
public class Body
{
    private StkCallback stkCallback;
    
  

    public StkCallback getStkCallback ()
    {
        return stkCallback;
    }

     @JsonProperty("stkCallback")
    public void setStkCallback (StkCallback stkCallback)
    {
        this.stkCallback = stkCallback;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [stkCallback = "+stkCallback+"]";
    }
}
	
