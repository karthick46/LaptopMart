package com.teleapps.lm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teleapps.lm.entity.Laptop;

@Repository
public interface RamRepository extends CrudRepository<Laptop, String>
{
	   List<Laptop> findByRam(String ram);
}
