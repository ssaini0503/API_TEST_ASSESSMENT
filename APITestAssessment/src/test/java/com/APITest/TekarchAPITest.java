package com.APITest;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojo.TC1_Response_GetEMP;
import com.pojo.TC2_Request_CreateEMP;
import com.pojo.TC2_Response_CreateEMP;
import com.pojo.TC3_Response_DeleteEMP;
import com.pojo.TC4_Response_DeleteEMP;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TekarchAPITest {
	
	@BeforeMethod
	public static void setup()
	{
		RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
	}
	
	@Test
	public static void TestCase1()
	{
		Response res = RestAssured
				.given()
				.when()
				.get("employees");
		res.then().statusCode(200);
		res.then().body("status",Matchers.equalTo("success"));
	
		
		TC1_Response_GetEMP resp = new TC1_Response_GetEMP();
		resp.setStatus(res.jsonPath().getString("status"));
		System.out.println("status is:" + resp.getStatus());	
				
		System.out.println("number of records in data " +res.jsonPath().get("data.size()"));
		System.out.println(res.jsonPath().getList("data"));
		res.prettyPrint();
	}		
	
	
	@Test
	public static void TestCase2()
	{
		TC2_Request_CreateEMP createRequest = new TC2_Request_CreateEMP();
		createRequest.setName("test");
		createRequest.setSalary("123");
		createRequest.setAge("23");
		
		Response res = RestAssured
				.given()
				.body(createRequest)
				.contentType(ContentType.JSON)
				.when()
				.post("create");
		
		res.then().statusCode(200);
		res.then().body("status", Matchers.equalTo("success"));

		TC2_Response_CreateEMP TC2_Response = new TC2_Response_CreateEMP();
		
		TC2_Response.setStatus(res.jsonPath().getString("status"));
		TC2_Response.setMessage(res.jsonPath().getString("message"));
		
		res.then().body("status",Matchers.equalTo("success"));
		res.then().body("data.name",Matchers.equalTo("test"));
		res.then().body("data.salary",Matchers.equalTo("123"));
		res.then().body("data.age",Matchers.equalTo("23"));
		res.then().body("message",Matchers.equalTo("Successfully! Record has been added."));
		
	   System.out.println("Id is: "+ res.jsonPath().getString("data.id"));
      
		res.prettyPrint();
	}	
	
	
	@Test
	public static void TestCase3()
	{
		Response res = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.when()
				.delete("delete/8309");
		res.then().statusCode(200);
		res.then().body("status",Matchers.equalTo("success"));
		
		res.prettyPrint();
		
		TC3_Response_DeleteEMP TC3_Response = new TC3_Response_DeleteEMP();
		
		TC3_Response.setStatus(res.jsonPath().getString("status"));
		TC3_Response.setData(res.jsonPath().getString("data"));
		TC3_Response.setMessage(res.jsonPath().getString("message"));
		
		res.then().body("status",Matchers.equalTo("success"));
		res.then().body("data",Matchers.equalTo("8309"));
		res.then().body("message",Matchers.equalTo("Successfully! Record has been deleted"));
		
	   System.out.println("Message is: " +TC3_Response.getMessage());
			
	}	
	
	@Test
	public static void TestCase4()
	{
		Response res = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.when()
				.delete("delete/0");
		res.then().statusCode(400);
			
		TC4_Response_DeleteEMP TC4_Response = new TC4_Response_DeleteEMP();
		
		TC4_Response.setStatus(res.jsonPath().getString("status"));
		TC4_Response.setMessage(res.jsonPath().getString("message"));
		TC4_Response.setCode(res.jsonPath().getInt("code"));
		TC4_Response.setErrors(res.jsonPath().getString("errors"));
	
		
		res.then().body("status",Matchers.equalTo("error"));
		res.then().body("message",Matchers.equalTo("Not found record"));
		res.then().body("code",Matchers.equalTo(400));
		res.then().body("errors",Matchers.equalTo("id is empty"));
		
	   System.out.println("Message is: " + TC4_Response.getMessage());
	   
	   res.prettyPrint();
		
	}
	
	@Test
	public static void TestCase5()
	{
		Response res = RestAssured
				.given()
				.when()
				.get("employee/2");
		res.then().statusCode(200);
		res.then().body("status",Matchers.equalTo("success"));
		res.then().body("data.employee_name",Matchers.equalTo("Garrett Winters"));
		res.then().body("data.employee_salary",Matchers.equalTo(170750));
		res.then().body("data.employee_age",Matchers.equalTo(63));
		res.then().contentType(ContentType.JSON);
	
	}
	
}
