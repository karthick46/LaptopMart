package com.teleapps.lm.service;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.teleapps.lm.entity.BillingDetails;
import com.teleapps.lm.repository.BillingDetailsRepository;
import com.teleapps.lm.repository.CompanyRepositoy;
import com.teleapps.lm.repository.LaptopRepository;
import com.teleapps.lm.repository.RamRepository;

@Service
public class BillingService 
{
	@Autowired
	CompanyRepositoy companyRepository;
	
	@Autowired
	LaptopRepository laptoprepository;
	
	@Autowired
	RamRepository ramRepository;

	@Autowired
	private IReportService service;
	
	@Autowired
	private BillingDetailsRepository billingDetailsrepository;
	

	public String BillGenereator(Integer pid,Integer count)
	{
		
		String pname=laptoprepository.pname(pid);
		double price1=laptoprepository.findprice(pid);
		double price2=laptoprepository.findprice(pid)*count;
		String date=new Date().toString();
			Date d1=new Date();
			String ts=d1.getDate()+""+d1.getHours()+""+d1.getMinutes()+""+d1.getSeconds();
		    Random rand = new Random();
			String billno=rand.nextInt(1000)+ts;
			System.out.println(billno);

		BillingDetails bd=new BillingDetails(billno, date, pname, count, price1, price2);
		billingDetailsrepository.save(bd);
		return billno;
	}
}
