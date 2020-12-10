package com.teleapps;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LaptopMartApplicationTests {
	static Logger logger = LogManager.getLogger(LaptopMartApplicationTests.class);
  
  @SuppressWarnings("unchecked")
  @Test(priority = 1)
  void testGet_1()
  {
	  Response response=RestAssured.get("http://localhost:9090/laptop/alllaptops");
	  
	  System.out.println("_________________________________");
	  System.out.println(response.asString());
	  System.out.println(response.getStatusCode());
	  System.out.println(response.getStatusLine());
	  System.out.println(response.getBody().asString());
	  System.out.println(response.getHeader("content-type"));
	  System.out.println(response.getTime());
  }
  @Test(priority=2)
  public void allCompany()
  {
	  given().get("http://localhost:9090/laptop/allcompanies").then().statusCode(200).log().all();
  }
  
  @Test(priority=3)
  public void allLaptop()
  {
	  given().get("http://localhost:9090/laptop/alllaptops").then().statusCode(200).log().all();
  }
  
  @Test(priority=4)
  public void getLaptopbyId()
  {
	  given().get("http://localhost:9090/laptop/byid100").then().statusCode(200).log().all();
  }
  
  @Test(priority=5)
  @SuppressWarnings("unchecked")
  public void addCompany()
  {
	  JSONObject request=new JSONObject();
	  
	  request.put("comp_id", 10);
	  request.put("comp_name","LG" );
	  
	  System.out.println(request);
	  System.out.println(request.toJSONString());
	  
	  
	  given().header("Content-Type","application/json").
	  contentType(ContentType.JSON).
	  accept(ContentType.JSON).
	  body(request.toJSONString()).
	  when().post("http://localhost:9090/laptop/addcompany").
	  then().
	  statusCode(200);
  }
  
  @Test(priority=6)
  @SuppressWarnings("unchecked")
  public void addLaptop()
  {
	  JSONObject request=new JSONObject();
	  
	  request.put("p_id", 9001);
	  request.put("p_name","APPLE 2020 BOOKLET PRO");
	  request.put("comp_id", 1);
	  request.put("processor", "i7");
	  request.put("price", 80000);
	  request.put("count", 32);
	  
	  
	  
	  System.out.println(request);
	  System.out.println(request.toJSONString());
	  
	  
	  given().header("Content-Type","application/json").
	  contentType(ContentType.JSON).
	  accept(ContentType.JSON).
	  body(request.toJSONString()).
	  when().post("http://localhost:9090/laptop/addlaptop").
	  then().
	  statusCode(200);
  }

	/*
	 * @Test(priority = 7) public void test_Update() {
	 * logger.info("Test_Update my log 4j"); JSONObject request=new JSONObject();
	 * 
	 * request.put("empid", 56); request.put("empdep",10 ); request.put("empname",
	 * "Karthickkeyan"); request.put("empsal", 396555);
	 * 
	 * 
	 * System.out.println(request); System.out.println(request.toJSONString());
	 * 
	 * 
	 * given().header("Content-Type","application/json").
	 * contentType(ContentType.JSON). accept(ContentType.JSON).
	 * body(request.toJSONString()).
	 * when().put("http://172.16.11.13:8080/employee/update56"). then().
	 * statusCode(200); }
	 * 
	 * @Test(priority = 6) public void test_Updatewrong() { JSONObject request=new
	 * JSONObject();
	 * 
	 * request.put("empid", 56); request.put("empdep",10 ); request.put("empname",
	 * "Karthickkeyan"); request.put("empsal", 396555);
	 * 
	 * 
	 * System.out.println(request); System.out.println(request.toJSONString());
	 * 
	 * 
	 * given().header("Content-Type","application/json").
	 * contentType(ContentType.JSON). accept(ContentType.JSON).
	 * body(request.toJSONString()).
	 * when().put("http://172.16.11.13:8080/employee/update4569"). then().
	 * statusCode(200); } // @Test(priority=7) public void delete() { given().
	 * when(). delete("http://172.16.11.13:8080/employee/delete1164").then().
	 * statusCode(200); }
	 */
}