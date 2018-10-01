/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brian.payments.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author BADEMBA
 */
@ManagedBean(name = "commonbean")
@SessionScoped
public class CommonUtils {
       public static String currDate(){
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       Date date=new Date();
       String requestDate=sdf.format(date);
        return requestDate;
   }
    
      public static String currTime(){
       
       SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
       Calendar cal=Calendar.getInstance();
       String requestTime=sdf.format(cal.getTime());       
        return requestTime;
   }
     
}
