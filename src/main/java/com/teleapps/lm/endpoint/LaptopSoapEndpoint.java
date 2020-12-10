package com.teleapps.lm.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.teleapps.lm.service.LaptopSoapService;
import com.teleapps.lm.soap.LaptopDetailsResponse;
import com.teleapps.lm.soap.LaptopIdRequest;



@Endpoint
public class LaptopSoapEndpoint {

    private static final String NAMESPACE = "lm.teleapps.com/SOAP";

    @Autowired
    private LaptopSoapService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "LaptopIdRequest")
    @ResponsePayload
    public LaptopDetailsResponse getLoanStatus(@RequestPayload LaptopIdRequest request) {
        return service.checkResult(request);
    }

}