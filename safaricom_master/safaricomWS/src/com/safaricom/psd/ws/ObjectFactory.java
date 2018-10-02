
package com.safaricom.psd.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.safaricom.psd.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Register_QNAME = new QName("http://ws.psd.safaricom.com/", "register");
    private final static QName _GetKeyResponse_QNAME = new QName("http://ws.psd.safaricom.com/", "getKeyResponse");
    private final static QName _Hello_QNAME = new QName("http://ws.psd.safaricom.com/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://ws.psd.safaricom.com/", "helloResponse");
    private final static QName _RegisterResponse_QNAME = new QName("http://ws.psd.safaricom.com/", "registerResponse");
    private final static QName _GetKey_QNAME = new QName("http://ws.psd.safaricom.com/", "getKey");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.safaricom.psd.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetKey }
     * 
     */
    public GetKey createGetKey() {
        return new GetKey();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link GetKeyResponse }
     * 
     */
    public GetKeyResponse createGetKeyResponse() {
        return new GetKeyResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link TransactionResult }
     * 
     */
    public TransactionResult createTransactionResult() {
        return new TransactionResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.psd.safaricom.com/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKeyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.psd.safaricom.com/", name = "getKeyResponse")
    public JAXBElement<GetKeyResponse> createGetKeyResponse(GetKeyResponse value) {
        return new JAXBElement<GetKeyResponse>(_GetKeyResponse_QNAME, GetKeyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.psd.safaricom.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.psd.safaricom.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.psd.safaricom.com/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKey }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.psd.safaricom.com/", name = "getKey")
    public JAXBElement<GetKey> createGetKey(GetKey value) {
        return new JAXBElement<GetKey>(_GetKey_QNAME, GetKey.class, null, value);
    }

}
