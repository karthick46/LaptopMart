package com.teleapps.lm.repository;

import org.springframework.data.repository.CrudRepository;

import com.teleapps.lm.entity.Company;

public interface CompanyRepositoy extends CrudRepository<Company, Integer> 
{
	
}

