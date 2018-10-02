/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brian.c2b;

import com.brian.db.DBConnector;
import com.brian.stk.Body;
import com.brian.stk.CallbackMetadata;
import com.brian.stk.Item;
import com.brian.stk.STKCallbackUtils;
import com.brian.stk.StkCallback;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.postgresql.util.PSQLException;

/**
 *
 * @author BADEMBA
 */
@WebService
@Path("/c2b")
public class C2B {

    //localhost:8080/C2B/rest/c2b/test
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/test")
    public String test() {

        String resp = "Hello Brian";
        System.out.println(resp);
        return resp;
    }

    //localhost:7140/C2B/rest/c2b/validation
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/validation")
    public Response Validation(C2BUtils c2BUtils) throws PSQLException, SQLException {

        PreparedStatement ps = null;
        Connection conn = null;
        String insertValidationTxn = "INSERT INTO c2b_validation( TransactionType,TransID,TransAmount,BusinessShortCode,BillRefNumber,InvoiceNumber,OrgAccountBalance,ThirdPartyTransID,MSISDN,FirstName,MiddleName,LastName,TransTime,uid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        UUID uuid = UUID.randomUUID();
        try {
            conn = DBConnector.getPostgresSqlDBConnection();
            ps = conn.prepareStatement(insertValidationTxn);
            ps.setString(1, c2BUtils.getTransactionType());
            ps.setString(2, c2BUtils.getTransID());
            ps.setDouble(3, c2BUtils.getTransAmount());
            ps.setString(4, c2BUtils.getBusinessShortCode());
            ps.setString(5, c2BUtils.getBillRefNumber());
            ps.setString(6, c2BUtils.getInvoiceNumber());
            ps.setDouble(7, c2BUtils.getOrgAccountBalance());
            ps.setString(8, c2BUtils.getThirdPartyTransID());
            ps.setString(9, c2BUtils.getMsisdn());
            ps.setString(10, c2BUtils.getFirstName());
            ps.setString(11, c2BUtils.getMiddleName());
            ps.setString(12, c2BUtils.getLastName());
            ps.setString(13, c2BUtils.getTransTime());
            ps.setString(14, uuid.toString());
            int add_detail = ps.executeUpdate();

            if (add_detail == 1) {
                System.out.println("New Validation Txn " + c2BUtils.getTransID() + " added");
            } else {
                System.out.println("no txn added");
            }

            conn.close();
        } catch (Exception e) {
            Logger lgr = Logger.getLogger(C2B.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            System.out.println("Error_Message-->" + e.getMessage());
        }
        //String re = "OK-2000";
        String re = "{\"ResultDesc\":\"Validation Service request accepted succesfully\",\"ResultCode\":\"0\"}";

        return Response.status(200).entity(re).build();
    }

    //localhost:7140/C2B/rest/c2b/confirmation
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/confirmation")
    public Response Confirmation(C2BUtils c2BUtils) throws PSQLException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        PreparedStatement ps = null;
        Connection conn = null;
        String insertValidationTxn = "INSERT INTO c2b_confirmation( TransactionType,TransID,TransAmount,BusinessShortCode,BillRefNumber,InvoiceNumber,OrgAccountBalance,ThirdPartyTransID,MSISDN,FirstName,MiddleName,LastName,TransTime,uid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        UUID uuid = UUID.randomUUID();
        try {
            conn = DBConnector.getPostgresSqlDBConnection();
            ps = conn.prepareStatement(insertValidationTxn);
            ps.setString(1, c2BUtils.getTransactionType());
            ps.setString(2, c2BUtils.getTransID());
            ps.setDouble(3, c2BUtils.getTransAmount());
            ps.setString(4, c2BUtils.getBusinessShortCode());
            ps.setString(5, c2BUtils.getBillRefNumber());
            ps.setString(6, c2BUtils.getInvoiceNumber());
            ps.setDouble(7, c2BUtils.getOrgAccountBalance());
            ps.setString(8, c2BUtils.getThirdPartyTransID());
            ps.setString(9, c2BUtils.getMsisdn());
            ps.setString(10, c2BUtils.getFirstName());
            ps.setString(11, c2BUtils.getMiddleName());
            ps.setString(12, c2BUtils.getLastName());
            ps.setString(13, c2BUtils.getTransTime());
            ps.setString(14, uuid.toString());
            int add_detail = ps.executeUpdate();

            if (add_detail == 1) {
                System.out.println("CONFIRMED: Received " + c2BUtils.getTransID() + " TransTime:" + c2BUtils.getTransTime() + " Amount:" + "KES " + c2BUtils.getTransAmount() + " MSISDN:" + c2BUtils.getMsisdn() + " FirstName:" + c2BUtils.getFirstName() + " MiddleName:" + c2BUtils.getMiddleName() + " LastName:" + c2BUtils.getLastName());
            } else {
                System.out.println("no txn Confirmed");
            }

            conn.close();
        } catch (Exception exception) {
            Logger logger = Logger.getLogger(C2B.class.getName());
            logger.log(Level.SEVERE, exception.getMessage(), exception);
            System.out.println("Error_Message-->" + exception.getMessage());
        }

        String confirmationResponse = "{\"ResultDesc\":\"Confirmation received succesfully\",\"ResultCode\":\"0\"}";

        return Response.status(201).entity(confirmationResponse).build();
    }

    //STK Callback
    //localhost:7140/C2B/rest/c2b/stkcallback
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stkcallback")
    public Response STKCallback(Body body) throws PSQLException, SQLException {
        STKCallbackUtils stkutils = new STKCallbackUtils();
        ObjectMapper mapper = new ObjectMapper();
        StkCallback stkcallback = new StkCallback();
        CallbackMetadata callbackmeta = new CallbackMetadata();
        //Item item = new Item();
        String[][] coupleArray = new String[5][2];
//        coupleArray[0][0] = item.getName();//"Name":"Amount",
//        coupleArray[0][1] = item.getValue();//"Value":5.00
//        // Double d = Double.parseDouble(coupleArray[0][1]);
//        coupleArray[1][0] = item.getName();//"Name":"MpesaReceiptNumber",
//        coupleArray[1][1] = item.getValue();//"Value":"LIR9F1EXBZ"
//        coupleArray[2][0] = item.getName();//"Name":"Balance"
//        //coupleArray[2][1] = item.getValue();
//        coupleArray[3][0] = item.getName();//"Name":"TransactionDate",
//        coupleArray[3][1] = item.getValue();// "Value":20170927161352
//        coupleArray[4][0] = item.getName();//"Name":"PhoneNumber",
//        coupleArray[4][1] = item.getValue();// "Value":254722000000

        PreparedStatement ps = null;
        Connection conn = null;
        String insertStkcallback = "INSERT INTO stkcallback(uid,MerchantRequestID,CheckoutRequestID,ResultCode,ResultDesc,Amount,MpesaReceiptNumber,Balance,TransactionDate,PhoneNumber) VALUES (?,?,?,?,?,?,?,?,?,?)";
        UUID uuid = UUID.randomUUID();
        try {
            conn = DBConnector.getPostgresSqlDBConnection();
            ps = conn.prepareStatement(insertStkcallback);
            ps.setString(1, uuid.toString());
            ps.setString(2, stkcallback.getMerchantRequestID());
            ps.setString(3, stkcallback.getCheckoutRequestID());
            ps.setInt(4, stkcallback.getResultCode());
            ps.setString(5, stkcallback.getResultDesc());
            ps.setString(6, coupleArray[0][1]);
            ps.setString(7, coupleArray[1][1]);
            ps.setString(8, coupleArray[2][1]);
            ps.setString(9, coupleArray[3][1]);
            ps.setString(10, coupleArray[4][1]);
            int add_detail = ps.executeUpdate();

            if (add_detail == 1) {
                System.out.println("CONFIRMED: Received " + coupleArray[1][1] + " UUID:" + uuid.toString() + " MerchantRequestID:" + stkcallback.getMerchantRequestID() + " CheckoutID:" + stkcallback.getCheckoutRequestID() + " ResultCode:" + stkcallback.getResultCode() + " ResultDesc:" + stkcallback.getResultDesc() + " MpesaReference:" + coupleArray[1][1]);
            } else {
                System.out.println("No STK Call back Received");
            }

            conn.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(C2B.class.getName());
            logger.log(Level.SEVERE, e.getMessage(), e);
            System.out.println("Error_Message-->" + e.getMessage());
        }

        String stkcallBackResponse = "{\"ResultDesc\":\"Confirmation received succesfully\",\"ResultCode\":\"0\"}";
        System.out.println(stkcallBackResponse);
        return Response.status(201).entity(stkcallBackResponse).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stk")
    public Response stk(STKCallbackUtils stkutils) throws IOException, ParseException {

        //String stkcallbackString="{\"Body\":{\"stkCallback\":{ \"MerchantRequestID\":\"14590-4517535-1\",\"CheckoutRequestID\":\"ws_CO_27092017161145603\",\"ResultCode\":0,\"ResultDesc\":\"The service request is processed successfully.\",\"CallbackMetadata\":{ \"Item\":[{\"Name\":\"Amount\",\"Value\":5.00},{\"Name\":\"MpesaReceiptNumber\",\"Value\":\"LIR9F1EXBZ\" },{\"Name\":\"Balance\"},{\"Name\":\"TransactionDate\",\"Value\":20170927161352},{\"Name\":\"PhoneNumber\",\"Value\":254722000000}]}}}}                  ";
        String stkcallbackString = "{  \n"
                + "   \"Body\":{  \n"
                + "      \"stkCallback\":{  \n"
                + "         \"MerchantRequestID\":\"" + stkutils.getBody().getStkCallback().getMerchantRequestID() + "\",\n"
                + "         \"CheckoutRequestID\":\"" + stkutils.getBody().getStkCallback().getCheckoutRequestID() + "\",\n"
                + "         \"ResultCode\":" + stkutils.getBody().getStkCallback().getResultCode() + ",\n"
                + "         \"ResultDesc\":\"The service request is processed successfully.\",\n"
                + "         \"CallbackMetadata\":{  \n"
                + "            \"Item\":[  \n"
                + "               {  \n"
                + "                  \"Name\":\"Amount\",\n"
                + "                  \"Value\":5.00\n"
                + "               },\n"
                + "               {  \n"
                + "                  \"Name\":\"MpesaReceiptNumber\",\n"
                + "                  \"Value\":\"LIR9F1EXBZ\"\n"
                + "               },\n"
                + "               {  \n"
                + "                  \"Name\":\"Balance\"\n"
                + "               },\n"
                + "               {  \n"
                + "                  \"Name\":\"TransactionDate\",\n"
                + "                  \"Value\":20170927161352\n"
                + "               },\n"
                + "               {  \n"
                + "                  \"Name\":\"PhoneNumber\",\n"
                + "                  \"Value\":254722000000\n"
                + "               }\n"
                + "            ]\n"
                + "         }\n"
                + "      }\n"
                + "   }\n"
                + "}";

        Reader reader = new StringReader(stkcallbackString);
        ObjectMapper mapper = new ObjectMapper();
        stkutils = mapper.readValue(reader, STKCallbackUtils.class);

        System.out.println("MerchantRequestID: " + stkutils.getBody().getStkCallback().getMerchantRequestID());
        System.out.println("CheckoutRequestID: " + stkutils.getBody().getStkCallback().getCheckoutRequestID());
        System.out.println("ResultCode: " + stkutils.getBody().getStkCallback().getResultCode());
        String stkcallBackResponse = "{\"ResultDesc\":\"Confirmation received succesfully\",\"ResultCode\":\"0\"}";
        System.out.println(stkcallBackResponse);
        return Response.status(201).entity(stkcallBackResponse).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stk2")
    public Response stk2(STKCallbackUtils stkcallbackutils) throws IOException, ParseException {

        StkCallback stkcallback = new StkCallback();

        Body body = new Body();
        body.setStkCallback(stkcallback);
        stkcallbackutils.setBody(body);

        List<Item> items = new ArrayList<Item>();
        CallbackMetadata callbackmetadata = new CallbackMetadata();
        callbackmetadata.setItems(items);

        ObjectMapper mapper = new ObjectMapper();
        String jsonstring = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stkcallbackutils);

        System.out.println(jsonstring);

        String stkcallBackResponse = "{\"ResultDesc\":\"Confirmation received succesfully\",\"ResultCode\":\"0\"}";
        System.out.println(stkcallBackResponse);
        return Response.status(201).entity(stkcallBackResponse).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stk3")
    public Response stk3(InputStream in) throws IOException, ParseException {
        Scanner s = new Scanner(in).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        System.out.println("======STKCallback======");
        System.out.println(result);
        System.out.println("======END=======");
        String stkcallBackResponse = "{\"ResultDesc\":\"Confirmation received succesfully\",\"ResultCode\":\"0\"}";
        System.out.println(stkcallBackResponse);
        return Response.status(201).entity(stkcallBackResponse).build();
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/b2cresult")
    public Response b2c(InputStream in) throws IOException, ParseException {
        Scanner s = new Scanner(in).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        System.out.println("======B2C======");
        System.out.println(result);
        System.out.println("======END=======");
        String stkcallBackResponse = "{\"ResultDesc\":\"Confirmation received succesfully\",\"ResultCode\":\"0\"}";
        System.out.println(stkcallBackResponse);
        return Response.status(201).entity(stkcallBackResponse).build();
    }

     
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/b2bresult")
    public Response b2b(InputStream in) throws IOException, ParseException {
        Scanner s = new Scanner(in).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        System.out.println("======B2B======");
        System.out.println(result);
        System.out.println("======END=======");
        String stkcallBackResponse = "{\"ResultDesc\":\"Confirmation received succesfully\",\"ResultCode\":\"0\"}";
        System.out.println(stkcallBackResponse);
        return Response.status(201).entity(stkcallBackResponse).build();
    }
}
