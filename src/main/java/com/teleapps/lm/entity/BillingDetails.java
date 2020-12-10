package com.teleapps.lm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BillingDetails")
public class BillingDetails 
{
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bill_no",unique=true,nullable=false)
	private String bill_no;
	
	@Column(name="date_time")
	private String date_time;
	
	@Column(name="laptop_name")
	private String laptop_name;
	
	@Column(name="count")
	private Integer count;
	
	@Column(name="price")
	private double price;
	
	@Column(name="total_cost")
	private double total_cost;

	public BillingDetails() {
		super();
	}

	public BillingDetails(String bill_no, String date_time, String laptop_name, Integer count, double price,
			double total_cost) {
		super();
		this.bill_no = bill_no;
		this.date_time = date_time;
		this.laptop_name = laptop_name;
		this.count = count;
		this.price = price;
		this.total_cost = total_cost;
	}

	

	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getLaptop_name() {
		return laptop_name;
	}

	public void setLaptop_name(String laptop_name) {
		this.laptop_name = laptop_name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	@Override
	public String toString() {
		return "BillingDetails [bill_no=" + bill_no + ", date_time=" + date_time + ", laptop_name=" + laptop_name
				+ ", count=" + count + ", price=" + price + ", total_cost=" + total_cost + "]";
	}
	
}
