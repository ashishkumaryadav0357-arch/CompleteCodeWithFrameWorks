package org.eva.vtiger.apiautomate;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_tagsValue_byID8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String delettagvalu="{\r\n"
				+ "    \"id\": \"5705392136585216\",\r\n"
				+ "    \"tags\": [\r\n"
				+ "        \"Lead\",\r\n"
				+ "        \"student\"\r\n"
				+ "    ]\r\n"
				+ "}";
RequestSpecification Delettag = RestAssured.given().auth().basic("ashishydv@agilecrm.com", "yadav@12345");
Delettag.accept("application/json").contentType("application/json").body(delettagvalu);
Response method = Delettag.put("https://ashishydv.agilecrm.com/dev/api/contacts/delete/tags");
String deleted = method.getBody().asPrettyString();
System.out.println(deleted);



	}

}
