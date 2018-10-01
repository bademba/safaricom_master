/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brian.payments.tx;

import com.brian.db.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author BADEMBA
 */
@ManagedBean(name="C2BTransactions")
@SessionScoped
public class C2BTransactions {

//    //resource injection
//    @Resource(name = "jdbc/primefaces")
    
    public List<C2BTransactionsUtils> getC2BTransactionList() throws SQLException, ClassNotFoundException {
        Connection con = null;
        con = DBConnector.getPostgresSqlDBConnection();
        Statement stmt = con.createStatement();
        String sql = "SELECT uid,transactiontype,transid,transamount,businessshortcode,billrefnumber,invoicenumber,orgaccountbalance,thirdpartytransid,msisdn,firstname,middlename,lastname,transtime FROM c2b_confirmation";
        ResultSet rs = stmt.executeQuery(sql);

        List<C2BTransactionsUtils> list = new ArrayList<C2BTransactionsUtils>();

        while (rs.next()) {
            C2BTransactionsUtils c2bTransactionsUtils = new C2BTransactionsUtils();
            c2bTransactionsUtils.setUid(rs.getString("uid"));
            c2bTransactionsUtils.setTransactiontype(rs.getString("transactiontype"));
            c2bTransactionsUtils.setTransid(rs.getString("transid"));
            c2bTransactionsUtils.setTransamount(rs.getDouble("transamount"));
            c2bTransactionsUtils.setBusinessshortcode(rs.getString("businessshortcode"));
            c2bTransactionsUtils.setBillrefnumber(rs.getString("billrefnumber"));
            c2bTransactionsUtils.setInvoicenumber(rs.getString("invoicenumber"));
            c2bTransactionsUtils.setOrgaccountbalance(rs.getDouble("orgaccountbalance"));
            c2bTransactionsUtils.setThirdpartytransid(rs.getString("thirdpartytransid"));
            c2bTransactionsUtils.setMsisdn(rs.getString("msisdn"));
            c2bTransactionsUtils.setFirstname(rs.getString("firstname"));
            c2bTransactionsUtils.setMiddlename(rs.getString("middlename"));
            c2bTransactionsUtils.setLastname(rs.getString("lastname"));
            c2bTransactionsUtils.setTranstime(rs.getString("transtime"));

            //store all data into a List
            list.add(c2bTransactionsUtils);
        }

        return list;
   
    }
}
