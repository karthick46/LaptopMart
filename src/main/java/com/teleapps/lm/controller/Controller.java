package com.teleapps.lm.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teleapps.lm.entity.BillingDetails;
import com.teleapps.lm.entity.Company;
import com.teleapps.lm.entity.Laptop;
import com.teleapps.lm.repository.BillingDetailsRepository;
import com.teleapps.lm.repository.CompanyRepositoy;
import com.teleapps.lm.repository.LaptopRepository;
import com.teleapps.lm.repository.RamRepository;
import com.teleapps.lm.service.BillingService;
import com.teleapps.lm.service.IReportService;

/**
 * @author AnanthaKarthick
 *
 */
@RestController
@RequestMapping("/laptop")
public class Controller {
	static Logger logger = LogManager.getLogger(Controller.class);
	private KafkaTemplate<String, String> template;
	@Autowired
	CompanyRepositoy companyRepository;

	@Autowired
	LaptopRepository laptoprepository;

	@Autowired
	RamRepository ramRepository;

	@Autowired
	private IReportService ireportservice;

	@Autowired
	private BillingService billingServiceRepository;

	@Autowired
	private BillingDetailsRepository billingDetailsrepository;

	List<Laptop> list = new ArrayList<>();

	public Controller(KafkaTemplate<String, String> template) {
		super();
		this.template = template;
	}

	// Get all company brand name eg.apple,acer and its unique id
	/**
	 * @return 
	 */
	@GetMapping("/allcompanies")
	public Iterable<Company> allCompany() {
		logger.info("@GetMapping(/all) api called SUCCESS");
		template.send("laptopmart", companyRepository.findAll().toString());
		logger.info(companyRepository.findAll());
		return (List) companyRepository.findAll();

	}

	// Get the list of laptop availiable
	/**
	 * @return
	 */
	@GetMapping("/alllaptops")
	public Iterable<Laptop> allLaptop() {
		logger.info("@GetMapping(/alllaptops) api called SUCCESS");
		template.send("laptopmart", laptoprepository.findAll().toString());
		return laptoprepository.findAll();
	}

	// Get a particular laptop by using unique product id (p_id) eg.4001 for apple
	// mac book pro
	/**
	 * @param pid
	 * @return
	 */
	@GetMapping("/byid/{p_id}")
	public String getLaptopByPidd(@PathVariable("p_id") Integer pid) {
		if (laptoprepository.findById(pid).isPresent()) {
			logger.info("@GetMapping(/all) api called SUCCESS");
			// template.send("laptopmart",laptoprepository.findById(pid).toString());

			return laptoprepository.findById(pid).toString();
		} else
			return "Invalid Product id";
	}

	// Adding a new brand
	/**
	 * @param company
	 * @return
	 */
	@PostMapping("/addcompany")
	public Company addCompany(@RequestBody Company company) {
		logger.info("@PostMApping(/addcompany) api called SUCCESS");
		template.send("laptopmart",
				" Total no of Brands Availiable now " + laptoprepository.count() + new Date().toString());
		template.send("laptopmart", companyRepository.findAll().toString());

		return companyRepository.save(company);
	}

	// Adding a single laptop entity and sending the count as msg in kafka
	/**
	 * @param laptop
	 * @return
	 */
	@PostMapping("/addlaptop")
	public Laptop addLaptop(@RequestBody Laptop laptop) {
		logger.info("@PostMapping(/all/laptops) api called SUCCESS");
		template.send("laptopmart",
				" Total no of Laptop Availiable now " + laptoprepository.count() + new Date().toString());
		logger.info("addLaptop() method Executed Successfully");
		return laptoprepository.save(laptop);
	}

	// Adding a list of company into company table
	/**
	 * @param complist
	 * @return ""
	 */
	@PutMapping("/addcompanylist")
	public Iterable<Company> addlistcomp(@RequestBody List<Company> complist) {
		logger.info("@PutMApping(/addlistlaptop) api called SUCCESS");
		// logger.info(companyRepository.saveAll(complist));
		logger.info("OutputResult " + companyRepository.saveAll(complist));
		return companyRepository.saveAll(complist);
	}

	// Adding a list of laptops using PUT
	/**
	 * @param laptoplist
	 * @return "List of all Laptops"
	 */
	@PutMapping("/addlaptoplist")
	public Iterable<Laptop> addlist(@RequestBody List<Laptop> laptoplist) {
		logger.info("@PutMApping(/addlistlaptop) api called SUCCESS");
		logger.info("OutputResult " + laptoprepository.saveAll(laptoplist));
		return laptoprepository.saveAll(laptoplist);
	}

	// Update the price or other config using prodduct_id
	@PatchMapping("/updatelaptop{p_id}")
	public Laptop update(@RequestBody Laptop laptop, @PathVariable("p_id") Integer pid) {
		logger.info("PatchMapping(/updatelaptop{p_id} api called SUCCESS");
		Optional<Laptop> lapopt = laptoprepository.findById(pid);
		if (!lapopt.isPresent())
			return null;
		laptop.setP_id(pid);
		logger.info("OutputResult " + laptoprepository.save(laptop));
		return laptoprepository.save(laptop);
	}

	// Getting a list of laptops by using ram
	@GetMapping("/byram/{ram}")
	public Iterable<Laptop> getbyram(@PathVariable("ram") String ram) {
		logger.info("GetMapping(/byram/{ram}) api called SUCCESS");
		logger.info("OutputResult " + ramRepository.findByRam(ram));
		return ramRepository.findByRam(ram);
	}

	// Getting a laptop by using its price
	@GetMapping("/byprice/{price}")
	public Iterable<Laptop> getbyprice(@PathVariable("price") double price) {
		logger.info("@GetMapping(/byprice/{price}) api called SUCCESS");
		logger.info("OutputResult : " + laptoprepository.findbyprice(price));
		return laptoprepository.findbyprice(price);
	}

	// Delete a laptop entity by using its productid (p_id)
	@DeleteMapping("/deletelaptop/{p_id}")
	public String deleteByNum(@PathVariable("p_id") Integer pid) {
		logger.info("@DeleteMapping(/deletebylaptop/{p_id}) api called SUCCESS");
		if (laptoprepository.findById(pid).isPresent()) {
			laptoprepository.deleteById(pid);
			logger.info("Product id" + pid + "Deleted Success");
			return "Laptop Entity Deleted Successfully";
		} else {
			logger.info("Product id" + pid + "Deleted Success");
			return "Invalid Product id" + pid + "..Plz try again";
		}
	}
	
	//Generate ireport for 
	@GetMapping("/report/laptop/{format}")
	public String reportForLaptop(@PathVariable("format") String format) throws FileNotFoundException, Exception {
		logger.debug("Iam in Debug");
		System.out.println(format);
		return ireportservice.reportforLaptopEntity(format);
	}
	
	//Generate ireport for company
		@GetMapping("/report/company/{format}")
		public String reportForCompany(@PathVariable("format") String format) throws FileNotFoundException, Exception {
			logger.debug("Iam in Debug");
			System.out.println(format);
			return ireportservice.reportforCompanyEntity(format);
		}
		
    //Generate ireport based on ram
	@GetMapping("/report/{ram}/{format}")
	public String reportForLaptopByRam(@PathVariable("ram") String ram, @PathVariable("format") String format)
			throws FileNotFoundException, Exception {
		// logger.debug("Iam in Debug");
		System.out.println(format);
		return ireportservice.reportForLaptopByRam(ram, format);
	}
	
	//Generate ireport for billing
	@GetMapping("/report/bill/{format}")
	public String reportForBilling(@PathVariable("format") String format) throws FileNotFoundException, Exception {
		logger.debug("Iam in Debug");
		System.out.println(format);
		return ireportservice.reportForBilling(format);
	}

	//filter laptop using price range
	@GetMapping("/range/{startprice}/{endprice}")
	public Iterable<Laptop> byPriceRange(@PathVariable("startprice") double startprice,@PathVariable("endprice") double endprice) {
		return laptoprepository.findLapByRange(startprice,endprice);
	}
	
	//filter laptop based on price
	@GetMapping("/range/below/{price}")
	public Iterable<Laptop> laptopUnderPrice(@PathVariable("price") double price) {
		return laptoprepository.findLapUnderPrice(price);
	}
	
	//To add/but a laptop 
		@GetMapping("/buy/{p_id}/{count}")
		public Optional<BillingDetails> addToCart(@PathVariable("p_id") Integer pid, @PathVariable("count") Integer count) {
			String billno = billingServiceRepository.BillGenereator(pid, count);
			return billingDetailsrepository.findById(billno);
		}
}
