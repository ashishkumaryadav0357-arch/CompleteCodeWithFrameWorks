package org.eva.vtiger.apiautomate;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update_leadscore_byID_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String put_body="{\r\n"
				+ "    \"id\": \"5544735244222464\",\r\n"
				+ "    \"lead_score\": 99\r\n"
				+ "}";
		RequestSpecification put_leadscore = RestAssured.given();
		
		put_leadscore.auth().basic("ashishydv@agilecrm.com", "yadav@12345").accept("application/json").contentType("application/json").body(put_body);
		
	Response putMethod = put_leadscore.put("{{baseURL}}/dev/api/contacts/edit/lead-score");
	
		String leadscore=  putMethod.getBody().asPrettyString();
	System.out.println(leadscore);
	}

}
