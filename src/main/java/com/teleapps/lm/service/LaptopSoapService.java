package com.teleapps.lm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleapps.lm.entity.Laptop;
import com.teleapps.lm.repository.LaptopRepository;
import com.teleapps.lm.soap.LaptopDetailsResponse;
import com.teleapps.lm.soap.LaptopIdRequest;

@Service
public class LaptopSoapService {

    @Autowired 
    LaptopRepository laptoprespository;

    public LaptopDetailsResponse checkResult(LaptopIdRequest res) {
       LaptopDetailsResponse responce=new LaptopDetailsResponse();

        Laptop laptop;
        laptop=laptoprespository.findById(res.getPId()).get();
        responce.setLaptopType(laptop);
        return responce;

    }

} 