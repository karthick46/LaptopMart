package com.teleapps.lm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.teleapps.lm.entity.Laptop;

public interface LaptopRepository extends CrudRepository<Laptop, Integer> {
	@Query("from Laptop WHERE price = :price")
	Iterable<Laptop> findbyprice(@Param("price") double price);
	
	@Query("select price from Laptop WHERE p_id= :pid")
	Double findprice(@Param("pid") Integer pid);
	
	@Query("select p_name from Laptop WHERE p_id= :pid")
	String pname(@Param("pid") Integer pid);
	
	@Query("from Laptop WHERE price > :startprice and price < :endprice")
	Iterable<Laptop> findLapByRange(double startprice,double endprice);
	
	@Query("from Laptop WHERE  price > :price")
	Iterable<Laptop> findLapUnderPrice(double price);
}
