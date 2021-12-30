package serviceRequest;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postData {
	ArrayList<Integer> responses = new ArrayList<Integer>();
	
	@Test
	public void validUUIDv4_valid()
	{
		RestAssured.baseURI = "http://localhost:8088/operations/";
		RequestSpecification httprequest = RestAssured.given()
				.pathParam("id", "d1e90d8f-11f7-41e0-92ff-235e2a85ab4b");
	
		Response response = httprequest.request(Method.POST,("{id}/refund"));
		
		int code = response.getStatusCode();
		

		Reporter.log("validUUIDv4_valid - Given a valid uuid v4 id When a refund transaction is initiated the expected status code is 201 and the respose from the server is = " + code );
		
		Assert.assertEquals(code, 201);

	}
	
	

	@Test (threadPoolSize = 2, invocationCount = 2, timeOut = 6080)
	public void concurrentTransactions()
	{
		RestAssured.baseURI = "http://localhost:8088/operations/";
		RequestSpecification httprequest = RestAssured.given()
				.pathParam("id", "d1e90d8f-11f7-41e0-92ff-235e2a85ab3b");
	
		Response response = httprequest.request(Method.POST,("{id}/refund"));
		  
		int code = response.getStatusCode();
		
		if(Thread.currentThread().isAlive()) {
			responses.add(code);
		}
		if ( responses.size() == 2 ) {
			
			int code1 = responses.get(0);
			Assert.assertEquals(code1, 423);
			
			//System.out.println("Blocked Concurrent Transactions\nGiven a valid uuid v4 id\nWhen I do a refund\nI expect a 423 status code got = " + code1 + "\n");
			Reporter.log("Blocked Concurrent Transactions - Given a valid uuid v4 id When a refund transaction is initiated the expected status code is 423 and the respose from the server is = " + code1 );
			
			int code2 = responses.get(1);
			Assert.assertEquals(code2, 201);
			
			//System.out.println("Concurrent Transactions\nGiven a valid uuid v4 id\nWhen I do a refund\nI expect a 201 status code got = " + code2 + "\n");
			Reporter.log("Concurrent Transactions - Given a valid uuid v4 id When a refund transaction is initiated the expected status code is 201 and the respose from the server is = " + code1 );
			
		}
	}
	
	
	
	@Test 
	public void longString()
	{
		RestAssured.baseURI = "http://localhost:8088/operations/";
		RequestSpecification httprequest = RestAssured.given()
				.pathParam("id", "d1e90d8f-11f7-41e0-92ff-235e2a85ab3b0");
	
		Response response = httprequest.request(Method.POST,("{id}/refund"));
		
		int code = response.getStatusCode();
		Reporter.log("Long String - Given an invalid uuid v4 id with additional length When a refund transaction is initiated the expected status code is 400 and the response fron the server is = " + code);
		
		Assert.assertEquals(code, 400);
	}
	
	
	
	@Test 
	public void shortString()
	{
		RestAssured.baseURI = "http://localhost:8088/operations/";
		RequestSpecification httprequest = RestAssured.given()
				.pathParam("id", "d1e90d8f--41e0-92ff-235e2a85ab3b0");
		
		Response response = httprequest.request(Method.POST,("{id}/refund"));
		
		int code = response.getStatusCode();
		//System.out.println("Short String\nGiven an invalid uuid v4 id with reduced length\nWhen I do a refund\nI expect a 400 status code got = " + code + "\n");
		Reporter.log("Short String - Given an invalid uuid v4 id with reduced length When a refund transaction is initiated the expected status code is 400 and the response fron the server is = " + code);	
		
		Assert.assertEquals(code, 400);
	}
	
	
	
	
	@Test
	public void emptyString()
	{
		RestAssured.baseURI = "http://localhost:8088/operations/";
		RequestSpecification httprequest = RestAssured.given()
				.pathParam("id", " ");
	
		Response response = httprequest.request(Method.POST,("{id}/refund"));
		
		int code = response.getStatusCode();
		//System.out.println("Empty String\nGiven an invalid uuid v4 id with NULL/Empty String\nWhen I do a refund\nI expect a 400 status code got = " + code + "\n");
		Reporter.log("Empty String - Given an invalid uuid v4 id with NULL/Empty String When a refund transaction is initiated the expected status code is 400 and the response fron the server is = " + code);
			
		Assert.assertEquals(code, 400);
	}
	
	
	@Test 
	public void nonHexagonal()
	{
		RestAssured.baseURI = "http://localhost:8088/operations/";
		RequestSpecification httprequest = RestAssured.given()
				.pathParam("id", "dfeabdaz-fefd-abec-eaff-cfbeeabaabcb");
	
		Response response = httprequest.request(Method.POST,("{id}/refund"));
		
		int code = response.getStatusCode();
		//System.out.println("Non Hexagonal\nGiven an invalid uuid v4 id with 'z'\nWhen I do a refund\nI expect a 400 status code got = " + code + "\n");
		Reporter.log("Non Hexagonal - Given an invalid uuid v4 id with 'z' When a refund transaction is initiated the expected status code is 400 and the response fron the server is = " + code);
			
		Assert.assertEquals(code, 400);
	}
	
	
	
	@Test 
	public void nills()
	{
		RestAssured.baseURI = "http://localhost:8088/operations/";
		RequestSpecification httprequest = RestAssured.given()
				.pathParam("id", "00000000-0000-0000-0000-000000000000");
	
		Response response = httprequest.request(Method.POST,("{id}/refund"));
		
		int code = response.getStatusCode();
		//System.out.println("Nills\nGiven a valid uuid v4 id with only nills\nWhen I do a refund\nI expect a 201 status code got = " + code + "\n");
		Reporter.log("Long String - Given a valid uuid v4 id with only nills When a refund transaction is initiated the expected status code is 201 and the response fron the server is = " + code);
			
		Assert.assertEquals(code, 201);
	}
	
	
	
	
	@Test 
	public void alphabetsOnly()
	{
		RestAssured.baseURI = "http://localhost:8088/operations/";
		RequestSpecification httprequest = RestAssured.given()
				.pathParam("id", "dfeabdaf-fefd-abec-eaff-cfbeeabaabcb");
	
		Response response = httprequest.request(Method.POST,("{id}/refund"));
		
		int code = response.getStatusCode();
		// System.out.println("Alphabets Only\nGiven a valid uuid v4 id with aplphabets only\nWhen I do a refund\nI expect a 201 status code = " + code + "\n");
		Reporter.log("Long String - Given a valid uuid v4 id with alphabetes only When a refund transaction is initiated the expected status code is 201 and the response fron the server is = " + code);
			
		Assert.assertEquals(code, 201);
	}
	
	
	
	@Test 
	public void undefinedID()
	{
		RestAssured.baseURI = "http://localhost:8088/operations/";
		RequestSpecification httprequest = RestAssured.given();
	
		Response response = httprequest.request(Method.POST,("/refund"));
		
		int code = response.getStatusCode();
		//System.out.println("Undefined UUID\nGiven an invalid uuid v4 id\nWhen I do a refund\nI expect a 404 status code got = " + code + "\n");
		Reporter.log("Undefined UUD - Given an invalid uuid v4 id id When a refund transaction is initiated the expected status code is 404 and the response fron the server is = " + code);
			
		Assert.assertEquals(code, 404);
	}
	
	
	
	
	@Test 
	public void uuidWithoutDashes()
	{
		RestAssured.baseURI = "http://localhost:8088/operations/";
		RequestSpecification httprequest = RestAssured.given()
				.pathParam("id", "d1e90d8f411f7441e0392ff2235e2a85ab3b0");
	
		Response response = httprequest.request(Method.POST,("{id}/refund"));
		
		int code = response.getStatusCode();
		//System.out.println("uuid Without Dashes\nGiven an invalid uuid v4 id without dashes\nWhen I do a refund\nI expect a 400 status code = " + code + "\n");
		Reporter.log("UUID Without Dashes - Given an invalid uuid v4 id without Dashes When a refund transaction is initiated the expected status code is 400 and the response fron the server is = " + code);
			
		Assert.assertEquals(code, 400);
	}	
}
