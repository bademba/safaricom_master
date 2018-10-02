
package com.safaricom.psd.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="registration" type="{http://ws.psd.safaricom.com/}transactionResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerResponse", propOrder = {
    "registration"
})
public class RegisterResponse {

    protected TransactionResult registration;

    /**
     * Gets the value of the registration property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionResult }
     *     
     */
    public TransactionResult getRegistration() {
        return registration;
    }

    /**
     * Sets the value of the registration property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionResult }
     *     
     */
    public void setRegistration(TransactionResult value) {
        this.registration = value;
    }

}
