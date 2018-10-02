
package com.safaricom.psd.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transactionResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transactionResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hiddenKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionResult", propOrder = {
    "responseCode",
    "responseDesc",
    "hiddenKey"
})
public class TransactionResult {

    protected String responseCode;
    protected String responseDesc;
    protected String hiddenKey;

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the responseDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseDesc() {
        return responseDesc;
    }

    /**
     * Sets the value of the responseDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseDesc(String value) {
        this.responseDesc = value;
    }

    /**
     * Gets the value of the hiddenKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHiddenKey() {
        return hiddenKey;
    }

    /**
     * Sets the value of the hiddenKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHiddenKey(String value) {
        this.hiddenKey = value;
    }

}
