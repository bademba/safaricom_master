
package com.safaricom.psd.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for register complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="register">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="your_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="national_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobile_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "register", propOrder = {
    "yourName",
    "nationalId",
    "mobileNo",
    "hiddenKey"
})
public class Register {

    @XmlElement(name = "your_name")
    protected String yourName;
    @XmlElement(name = "national_id")
    protected String nationalId;
    @XmlElement(name = "mobile_no")
    protected String mobileNo;
    protected String hiddenKey;

    /**
     * Gets the value of the yourName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYourName() {
        return yourName;
    }

    /**
     * Sets the value of the yourName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYourName(String value) {
        this.yourName = value;
    }

    /**
     * Gets the value of the nationalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalId() {
        return nationalId;
    }

    /**
     * Sets the value of the nationalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalId(String value) {
        this.nationalId = value;
    }

    /**
     * Gets the value of the mobileNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets the value of the mobileNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileNo(String value) {
        this.mobileNo = value;
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
