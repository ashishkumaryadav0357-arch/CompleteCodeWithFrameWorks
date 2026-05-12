package org.eva.vtiger.apiautomate;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddingTags_toAcontactBased_onEmail_12 {//

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    
		
String urluncoded="email=rajju@walt.ltd&tags=[\"mondh\",\"bhadohi\"]";


		RequestSpecification AddingTag = RestAssured.given();
		AddingTag.auth().basic("ashishydv@agilecrm.com", "yadav@12345").accept("application/json").contentType("application/x-www-form-urlencoded").body(urluncoded);
		Response method = AddingTag.post("https://ashishydv.agilecrm.com/dev/api/contacts/email/tags/add");
		String respons=method.getBody().asPrettyString();
		System.out.println(method.getStatusCode());
		System.out.println(respons);
	}

}
