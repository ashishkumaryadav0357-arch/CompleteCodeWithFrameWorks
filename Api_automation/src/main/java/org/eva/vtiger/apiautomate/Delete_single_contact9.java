package org.eva.vtiger.apiautomate;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_single_contact9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RequestSpecification deletecontact = RestAssured.given().auth().basic("ashishydv@agilecrm.com", "yadav@12345");
		deletecontact.accept("application/json");
		Response method = deletecontact.delete("https://ashishydv.agilecrm.com/dev/api/contacts/5544735244222464");
		String Deletedsingle = method.getBody().asPrettyString();
		System.out.println(Deletedsingle);
	}

}
