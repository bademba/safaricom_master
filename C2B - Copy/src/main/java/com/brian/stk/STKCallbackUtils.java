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
public class STKCallbackUtils {

    public Body Body;

    public Body getBody() {
        return Body;
    }

    @JsonProperty("Body")
    public void setBody(Body Body) {
        this.Body = Body;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Body = "+Body+"]";
    }
}
