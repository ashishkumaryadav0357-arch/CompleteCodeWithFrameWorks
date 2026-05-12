package org.eva.vtiger.testscripts;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class HTTPRequest {


	
	// given()
//	 Headers set karte ho
//
//	 Authorization token dete ho
//
//	 Content type set karte ho
//
//	 Request body bhejte ho
//
//	 Query parameters dete ho
//
//	 👉 Matlab: API call karne se pehle ki preparation
//	 given()
//	 .header("Content-Type", "application/json")
//	 .body("{\"name\":\"Priti\"}")
//	.when()
//	Yahan aap actual API hit karte ho:
//
//		get()
//
//		post()
//
//		put()
//
//		delete()
//
//		Example:
//
//		.when()
//		.post("/users")

//		👉 Matlab: API call karna
//	.then();
//	 3️⃣ then() – Validation
//
//	 Yahan aap:
//
//	 Status code verify karte ho
//
//	 Response body verify karte ho
//
//	 Headers verify karte ho
//
//	 Example:
//
//	 .then()
//	 .statusCode(201);
//
//	 👉 Matlab: Result check karna
//	public void setauthentication() {
//		RestAssured.baseURI="https://evaailab.agilecrm.com/dev/api";
//		RestAssured.preemptive().basic("priti@evaailab.com", "123456");
//	}
//	
	
	
	@Test
	public void getAlluser() {
		given()
		.auth().basic("priti@evaailab.com", "123456")
		.header("Accept","application/json")
		.when()
		.get("https://evaailab.agilecrm.com/dev/api/contacts?page_size=2")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
