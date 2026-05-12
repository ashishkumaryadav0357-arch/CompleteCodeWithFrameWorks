package org.eva.vtiger.apiautomate;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProperties_ofAcontact_byID_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String put_updating="{\r\n"
				+ "    \"id\": \"5783020281462784\",\r\n"
				+ "    \"properties\": [\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"first_name\",\r\n"
				+ "            \"value\": \"ramu\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"last_name\",\r\n"
				+ "            \"value\": \"Gorila\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"email\",\r\n"
				+ "            \"subtype\": \"work\",\r\n"
				+ "            \"value\": \"ramuu@walt.ltd\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"address\",\r\n"
				+ "            \"value\": \"{\\\"address\\\":\\\"225 George Street\\\",\\\"city\\\":\\\"NSW\\\",\\\"state\\\":\\\"Sydney\\\",\\\"zip\\\":\\\"2000\\\",\\\"country\\\":\\\"Australia\\\"}\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
		
		RequestSpecification UpdateProperties = RestAssured.given();
		UpdateProperties.auth().basic("ashishydv@agilecrm.com", "yadav@12345");
		UpdateProperties.accept("application/json").contentType("application/json");
		
		Response xyz = UpdateProperties.body(put_updating).put("https://ashishydv.agilecrm.com/dev/api/contacts/edit-properties");
		String put=xyz.getBody().asPrettyString();
	
	
	System.out.println(put);
	}

}
