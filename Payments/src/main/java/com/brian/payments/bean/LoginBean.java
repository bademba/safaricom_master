/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brian.payments.bean;

/**
 *
 * @author BADEMBA
 */
 
import com.brian.payments.dao.CommonUtils;
import com.brian.payments.dao.UserDAO;
import com.brian.payments.dao.Util;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
 
@ManagedBean(name = "loginBean")
@SessionScoped
 
public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private String uname;
    private String password;
 
     
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String loginProject() {
        boolean result = UserDAO.login(uname, password);
        if (result) {
            HttpSession session =Util.getSession();
            session.setAttribute("username", uname); 
            return "welcomePrimefaces";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Invalid Login!","Please Try Again!"));
            return "login";
        }
    }
    
     public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
         System.out.println(CommonUtils.currDate()+""+CommonUtils.currTime()+" "+uname+" logged out");
      return "login";
   }
}