//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.09 at 01:57:07 PM IST 
//


package com.teleapps.lm.soap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.teleapps.lm.soap package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.teleapps.lm.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LaptopIdRequest }
     * 
     */
    public LaptopIdRequest createLaptopIdRequest() {
        return new LaptopIdRequest();
    }

    /**
     * Create an instance of {@link LaptopDetailsResponse }
     * 
     */
    public LaptopDetailsResponse createLaptopDetailsResponse() {
        return new LaptopDetailsResponse();
    }

    /**
     * Create an instance of {@link LaptopType }
     * 
     */
    public LaptopType createLaptopType() {
        return new LaptopType();
    }

}
