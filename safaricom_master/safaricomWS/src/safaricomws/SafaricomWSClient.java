/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safaricomws;

import com.safaricom.psd.ws.TestWS_Service;
import com.safaricom.psd.ws.TransactionResult;

/**
 *
 * @author Brian Ademba <brian.ademba@gmail.com>
 */
public class SafaricomWSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String name ="red";
        TestWS_Service tws=new TestWS_Service();
        TransactionResult x=tws.getTestWSPort().getKey(name);
        System.out.println(x.getResponseCode());
        System.out.println(x.getResponseDesc());
        System.out.println(x.getHiddenKey());
        
        
        TransactionResult tr =tws.getTestWSPort().register("Brian Ademba", "28494194", "25471574661", x.getHiddenKey());
        System.out.println(tr.getResponseCode());
        System.out.println(tr.getResponseDesc());
        
    }
    
}
