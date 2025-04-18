package com.petstore.tests;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetDontDoThisTest {

	@Test
	public void getPetTest() {
		// Specify the base URL to the RESTful web service 
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books"; 
		
		// Get the RequestSpecification of the request to be sent to the server. 
		RequestSpecification httpRequest = RestAssured.given(); 
		
		// specify the method type (GET) and the parameters if any. 
		//In this case the request does not take any parameters 
		Response response = httpRequest.request(Method.GET, "");
		
		// Print the status and message body of the response received from the server
		System.out.println("Headers Response =>" + response.getHeaders());
		System.out.println("\n\nStatus received => " + response.getStatusLine());
		System.out.println("\n\nStatus Code received => " + response.getStatusCode());
		System.out.println("\n\nContent Type =>" + response.getContentType());
		System.out.println("\n\nResponse =>" + response.getBody().asString());
		
		//Triple AAA
		// -> Arrange
		// -> Act
		// -> Assert
		
	}
}
