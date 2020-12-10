package com.teleapps.lm;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.teleapps.lm.service.IReportService;

@SpringBootApplication
public class LaptopMartApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(LaptopMartApplication.class, args);
		
	}
	

}
