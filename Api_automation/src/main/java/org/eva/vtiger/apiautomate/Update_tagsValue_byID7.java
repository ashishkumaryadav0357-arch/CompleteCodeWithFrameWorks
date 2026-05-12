package org.eva.vtiger.apiautomate;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update_tagsValue_byID7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String updateTag="{\r\n"
				+ "    \"id\": \"5705392136585216\",\r\n"
				+ "    \"tags\": [\r\n"
				+ "        \"student\",\r\n"
				+ "        \"himanchal\"\r\n"
				+ "    ]\r\n"
				+ "}";
		
RequestSpecification Tagsvalue = RestAssured.given().auth().basic("ashishydv@agilecrm.com", "yadav@12345");
Tagsvalue.accept("application/json").contentType("application/json").body(updateTag);
Response method = Tagsvalue.put("https://ashishydv.agilecrm.com/dev/api/contacts/edit/tags");
String ctreated = method.getBody().asPrettyString();
System.out.println(ctreated);

	}

}
