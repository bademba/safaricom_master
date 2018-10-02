
package com.safaricom.psd.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getKeyResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getKeyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getKey" type="{http://ws.psd.safaricom.com/}transactionResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getKeyResponse", propOrder = {
    "getKey"
})
public class GetKeyResponse {

    protected TransactionResult getKey;

    /**
     * Gets the value of the getKey property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionResult }
     *     
     */
    public TransactionResult getGetKey() {
        return getKey;
    }

    /**
     * Sets the value of the getKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionResult }
     *     
     */
    public void setGetKey(TransactionResult value) {
        this.getKey = value;
    }

}
