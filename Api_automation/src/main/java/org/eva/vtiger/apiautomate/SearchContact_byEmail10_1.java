package org.eva.vtiger.apiautomate;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SearchContact_byEmail10_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	RequestSpecification Searchingcontact = RestAssured.given().auth().basic("ashishydv@agilecrm.com", "yadav@12345");
	Response method = Searchingcontact.accept("application/json").get("https://ashishydv.agilecrm.com/dev/api/contacts/search/email/rajju@walt.ltd");
	String Searchingemail=method.getBody().asPrettyString();
	System.out.println(Searchingemail);
	}

}
