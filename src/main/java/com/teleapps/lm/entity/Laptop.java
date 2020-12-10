package com.teleapps.lm.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {
	@Id
	@Column(name = "p_id", unique = true, nullable = false)
	@Basic(optional = false)
	private Integer p_id;

	@Column(name = "p_name")
	private String p_name;
	
	
	
	public Laptop() {
		super();
	}

	public Laptop(Integer p_id, String p_name, int comp_id, String ram, String processor, double price, Integer count) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.comp_id = comp_id;
		this.ram = ram;
		this.processor = processor;
		this.price = price;
		Count = count;
	}

	/*
	 * @Id
	 * 
	 * @Column(name="comp_id",unique=true,nullable=false)
	 * 
	 * @GeneratedValue(generator="gen")
	 * 
	 * @GenericGenerator(name="gen",strategy = "foreign",parameters = {
	 * 
	 * @Parameter(name="property",value="Company")})
	 */
	 
    @Column(name = "comp_id") 
	private int comp_id;

	
	/*
	 * @OneToMany
	 * 
	 * @PrimaryKeyJoinColumn private Company company;
	 */
	  
	 
	@Column(name = "ram")
	private String ram;

	@Column(name = "processor")
	private String processor;

	@Column(name = "price")
	private double price;
	
	@Column(name="count")
	private Integer Count;

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getComp_id() {
		return comp_id;
	}

	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}

	/*
	 * public Company getCompany() { return company; }
	 * 
	 * public void setCompany(Company company) { this.company = company; }
	 */

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	public Integer getCount() {
		return Count;
	}

	public void setCount(Integer count) {
		Count = count;
	}

	@Override
	public String toString() {
		return "Laptop [p_id=" + p_id + ", p_name=" + p_name + ", comp_id=" + comp_id + ", ram=" + ram + ", processor="
				+ processor + ", price=" + price + ", Count=" + Count + "]";
	}
	
}
