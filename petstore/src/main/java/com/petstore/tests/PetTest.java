package com.petstore.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.petstore.core.BaseTest;
import com.petstore.dto.Tag;

public class PetTest extends BaseTest {

	@Test
	public void getAvailablePets() {
		
		
		
		
		
		
		
		
		
		
		
		
		
		//https://petstore.swagger.io/v2/pet/findByStatus?status=available		
		
		
		String name = "Dory"; //"Frettchen"
		String category = "Fish"; //"ferret"

		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("status", "available");

		//BDD: O que, como fazer e o teste.... 
		// Gherkin Language: Given (dado) - When (Quando) - Then (Então)
		
		given()
			//.queryParams("status", "available")
		    .queryParams(queryParams)
		.when()
			.get("/v2/pet/findByStatus")
		.then()
			.statusCode(200)			
			
		    .body("name", hasItem(name))
			.body("category.name", hasItem(category))
			.body("status", hasItem("available"))
			
			.body("find{it.name == \"" + name + "\"}.status", is("available"))			
			.body("find{it.name == \"" + name + "\"}.category.name", is(category))

			.log().all()
		;		
	}
	
	
	@Test
	public void postPets() {
		
		/*
		 * 
		 * {
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}
		 * 
		 * */
		
		List<String> photoUrls = new ArrayList<>();
		photoUrls.add("https://blog-static.petlove.com.br/wp-content/uploads/2023/09/25143323/como-cuidar-de-um-vira-lata-caramelo-petlove.jpg");
		photoUrls.add("https://blog-static.petlove.com.br/wp-content/uploads/2023/09/25143323/como-cuidar-de-um-vira-lata-caramelo-petlove2.jpg");
		
		//DTO/POJO
		List<Tag> tags = new ArrayList<>();
		tags.add(new Tag(0, "cutie"));
		tags.add(new Tag(1, "blabla"));
		
		

		Map<String, Object> bodyParams = new HashMap<String, Object>();
		bodyParams.put("category.name", "dog");
		bodyParams.put("name", "Caramelo");
		bodyParams.put("photoUrls",photoUrls);
		bodyParams.put("tags", tags);
		bodyParams.put("status", "pending");
		
		
		given()		    
			.body(bodyParams) //Obrigatorio para POST (insert) e PUT (update)			
		.when()		
			.post("/v2/pet")  //https://petstore.swagger.io/v2/pet
			
		.then()
			.statusCode(200)
			.body("id", is(greaterThan(0l)))
			
		.log().all()
			
		;		
	}
	
}
