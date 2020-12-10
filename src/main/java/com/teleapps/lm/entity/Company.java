package com.teleapps.lm.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company 
{
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) add in sequence
	@Column(name="comp_Id",unique=true,nullable=false)
	@Basic(optional=false)
	private Integer comp_id;
	
	@Column(name="comp_name")
	private String comp_name;
	
	

	public Company() {
		super();
	}

	public Company(Integer comp_id, String comp_name) {
		super();
		this.comp_id = comp_id;
		this.comp_name = comp_name;
	}

	public Integer getComp_id() {
		return comp_id;
	}

	public void setComp_id(Integer comp_id) {
		this.comp_id = comp_id;
	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	@Override
	public String toString() {
		return "Company [comp_id=" + comp_id + ", comp_name=" + comp_name + "]";
	}
	
	
}
