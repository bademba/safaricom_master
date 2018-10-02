
package com.safaricom.psd.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for helloResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="helloResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="G2Result" type="{http://ws.psd.safaricom.com/}transactionResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "helloResponse", propOrder = {
    "g2Result"
})
public class HelloResponse {

    @XmlElement(name = "G2Result")
    protected TransactionResult g2Result;

    /**
     * Gets the value of the g2Result property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionResult }
     *     
     */
    public TransactionResult getG2Result() {
        return g2Result;
    }

    /**
     * Sets the value of the g2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionResult }
     *     
     */
    public void setG2Result(TransactionResult value) {
        this.g2Result = value;
    }

}
