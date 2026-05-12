package org.eva.vtiger.apiautomate;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Search_contacts_companies11 {//Search_contacts_companies11

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String Addtagbyemail="email=rajju@walt.ltd.tags=[\"testingtesto,suriyava,kalikabara\"]";

		RequestSpecification addingtag = RestAssured.given();
		addingtag.auth().basic("ashishydv@agilecrm.com", "yadav@12345").accept("application/json")
		.queryParam("q", "kallu").queryParam("page_size", "10").queryParam("type", "PERSON");
		
		Response method = addingtag.get("https://ashishydv.agilecrm.com/dev/api/search");
		String tagadd=	method.getBody().asPrettyString();
		System.out.println(tagadd);

	}

}
