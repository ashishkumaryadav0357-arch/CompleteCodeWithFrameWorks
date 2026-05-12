package org.eva.vtiger.apiautomate;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Search_contact_byEmail10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String emails="email_ids=[\"rajju@walt.ltd\"]";
		
		RequestSpecification SearchContactEmail = RestAssured.given().auth().basic("ashishydv@agilecrm.com", "yadav@12345");
		SearchContactEmail.accept("application/json").contentType("application/x-www-form-urlencoded").body(emails);
		Response method = SearchContactEmail.post("https://ashishydv.agilecrm.com/dev/api/contacts/search/email");
		String SearchEmails = method.getBody().asPrettyString();
		System.out.println(SearchEmails);
	}

}
