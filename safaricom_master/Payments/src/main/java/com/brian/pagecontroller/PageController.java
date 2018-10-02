/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brian.pagecontroller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author BADEMBA
 */
@ManagedBean(name="PageController")
@SessionScoped
public class PageController implements Serializable{
    //String var="c2BValidationPageContoller";
    public String C2BValidationPageContoller(){
    
         
        return "/C2BValidation.xhtml";
    }
    
}
