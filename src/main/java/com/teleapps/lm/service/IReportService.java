package com.teleapps.lm.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import com.teleapps.lm.entity.BillingDetails;
import com.teleapps.lm.entity.Company;
import com.teleapps.lm.entity.Laptop;
import com.teleapps.lm.repository.BillingDetailsRepository;
import com.teleapps.lm.repository.CompanyRepositoy;
import com.teleapps.lm.repository.LaptopRepository;
import com.teleapps.lm.repository.RamRepository;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class IReportService {
	@Autowired
	private LaptopRepository laptopRepository;
	
	@Autowired
	private CompanyRepositoy companyRepository;
	
	@Autowired
	RamRepository ramRepository;
	
	@Autowired
	BillingDetailsRepository billingDetailsReport;

	//ireport for laptop Repository
	public String reportforLaptopEntity(String reportFormat) throws FileNotFoundException, Exception {
		System.out.println("Iam in exportReport");
		String path = "E:\\IREPORT\\LaptopReport";
		List<Laptop> laptop = (List<Laptop>) laptopRepository.findAll();
		System.out.println(reportFormat);

		File file = ResourceUtils.getFile("classpath:Laptop.jrxml");

		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(laptop);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("CreatedBy", "Karthick");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\laptopiReport.html");
		}
		if (reportFormat.equals("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\laptopiReport.pdf");
		}
		if (reportFormat.equalsIgnoreCase("xml")) {
			JasperExportManager.exportReportToXmlFile(jasperPrint, path + "\\laptopiReport.xml", false);
		}
		return "report Generated in path " + path + " for the " + reportFormat + " format";
	}
	
	    //ireport for company Repository
		public String reportforCompanyEntity(String reportFormat) throws FileNotFoundException, Exception {
			System.out.println("Iam in exportReport");
			String path = "E:\\IREPORT\\CompanyReport";
			List<Company> company = (List<Company>) companyRepository.findAll();
			System.out.println(reportFormat);

			File file = ResourceUtils.getFile("classpath:company.jrxml");

			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(company);

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("CreatedBy", "Karthick");

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
			if (reportFormat.equalsIgnoreCase("html")) {
				JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\companyiReport.html");
			}
			if (reportFormat.equals("pdf")) {
				JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\companyiReport.pdf");
			}
			if (reportFormat.equalsIgnoreCase("xml")) {
				JasperExportManager.exportReportToXmlFile(jasperPrint, path + "\\company.xml", false);
			}
			return "report Generated in path " + path + " for the " + reportFormat + " format";
		}
	//ireport for laptop based on ram which is given by the user
	public String reportForLaptopByRam(String ram, String reportFormat) throws FileNotFoundException, Exception {
		System.out.println("Iam in exportReport");
		String path = "E:\\IREPORT\\LaptopByRamReport";
		List<Laptop> laptopbyram = (List<Laptop>) ramRepository.findByRam(ram);
		System.out.println(reportFormat);

		File file = ResourceUtils.getFile("classpath:Laptop.jrxml");

		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(laptopbyram);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("CreatedBy", "Karthick");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\laptopbyram.html");
		}
		if (reportFormat.equals("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\laptopbyram.pdf");
		}
		if (reportFormat.equalsIgnoreCase("xml")) {
			JasperExportManager.exportReportToXmlFile(jasperPrint, path + "\\laptopbyram.xml", false);
		}
		return "report Generated in path " + path + " for the " + reportFormat + " format";
	}
	
	//ireport for billingReport
	public String reportForBilling(String reportFormat) throws FileNotFoundException, Exception {
		System.out.println("Iam in exportReport");
		String path = "E:\\IREPORT\\BillingReport";
		List<BillingDetails> billingDetails = (List<BillingDetails>) billingDetailsReport.findAll();
		System.out.println(reportFormat);

		File file = ResourceUtils.getFile("classpath:billreport.jrxml");

		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(billingDetails);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("CreatedBy", "Karthick");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\billingReport.html");
		}
		if (reportFormat.equals("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\billingReport.pdf");
		}
		if (reportFormat.equalsIgnoreCase("xml")) {
			JasperExportManager.exportReportToXmlFile(jasperPrint, path + "\\billingReport.xml", false);
		}
		return "report Generated in path " + path + " for the " + reportFormat + " format";
	}

}
