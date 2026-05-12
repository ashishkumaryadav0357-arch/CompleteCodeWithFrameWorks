package org.eva.vtiger.apiautomate;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateStar_valuebyID_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String updatingstar="{\r\n"
				+ "    \"id\": \"5705392136585216\",\r\n"
				+ "    \"star_value\": 5\r\n"
				+ "}";
		
		RequestSpecification Starvalue = RestAssured.given();
		Starvalue.auth().basic("ashishydv@agilecrm.com", "yadav@12345");
		Starvalue.accept("application/json").contentType("application/json").body(updatingstar);
		Response method = Starvalue.put("https://ashishydv.agilecrm.com/dev/api/contacts/edit/add-star");
		String changed = method.getBody().asPrettyString();
		System.out.println(changed);
		
	}

}
