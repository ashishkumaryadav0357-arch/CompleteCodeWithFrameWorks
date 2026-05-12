package org.eva.vtiger.apiautomate;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Creating_new {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fname=RandomStringUtils.randomAlphabetic(5);
		String lname=RandomStringUtils.randomAlphabetic(5);
		String Email=RandomStringUtils.randomAlphabetic(5)+"@gmail.com";


		String creating="{\r\n"
				+ "    \"star_value\": \"4\",\r\n"
				+ "    \"lead_score\": \"92\",\r\n"
				+ "    \"tags\": [\r\n"
				+ "        \"Lead\",\r\n"
				+ "        \"Likely Buyer\"\r\n"
				+ "    ],\r\n"
				+ "    \"properties\": [\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"first_name\",\r\n"
				+ "            \"value\": \""+fname+"\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"last_name\",\r\n"
				+ "            \"value\": \""+lname+"\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"email\",\r\n"
				+ "            \"subtype\": \"work\",\r\n"
				+ "            \"value\": \""+Email+"\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"type\": \"SYSTEM\",\r\n"
				+ "            \"name\": \"address\",\r\n"
				+ "            \"value\": \"{\\\"address\\\":\\\"225 George Street\\\",\\\"city\\\":\\\"NSW\\\",\\\"state\\\":\\\"Sydney\\\",\\\"zip\\\":\\\"2000\\\",\\\"country\\\":\\\"Australia\\\"}\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"phone\",\r\n"
				+ "            \"value\": \"8888888889\",\r\n"
				+ "            \"subtype\": \"work\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"phone\",\r\n"
				+ "            \"value\": \"8888888889\",\r\n"
				+ "            \"subtype\": \"home\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"website\",\r\n"
				+ "            \"value\": \"www.youtube.com\",\r\n"
				+ "            \"subtype\": \"YOUTUBE\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"website\",\r\n"
				+ "            \"value\": \"www.linkedin.com\",\r\n"
				+ "            \"subtype\": \"LINKEDIN\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"website\",\r\n"
				+ "            \"value\": \"www.mywebsite.com\",\r\n"
				+ "            \"subtype\": \"URL\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"My custom field of type text\",\r\n"
				+ "            \"type\": \"CUSTOM\",\r\n"
				+ "            \"value\": \"My name is ghanshyam\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"My custom field of type date\",\r\n"
				+ "            \"type\": \"CUSTOM\",\r\n"
				+ "            \"value\": 1479580200\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"My custom field of type checkbox\",\r\n"
				+ "            \"type\": \"CUSTOM\",\r\n"
				+ "            \"value\": \"on\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"My custom field of type list\",\r\n"
				+ "            \"type\": \"CUSTOM\",\r\n"
				+ "            \"value\": \"lemon\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"name\": \"My custom field of type companies\",\r\n"
				+ "            \"type\": \"CUSTOM\",\r\n"
				+ "            \"value\": \"[\\\"5767466600890368\\\",\\\"5114076984246272\\\",\\\"5746725247516672\\\"]\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";

		RequestSpecification Creating = RestAssured.given();
		Creating.auth().basic("ashishydv@agilecrm.com", "yadav@12345").accept("application/json").contentType("application/json").body(creating);
		Response method = Creating.post("https://ashishydv.agilecrm.com/dev/api/contacts");
		String respons = method.getBody().asPrettyString();
		System.out.println(method.getStatusCode());
		System.out.println(respons);


		JSONObject jsonroot = new JSONObject(respons);
		JSONArray properarray = jsonroot.getJSONArray("properties");

		JSONObject jsonobj = properarray.getJSONObject(0);
		String firstname=jsonobj.getString("value");

		if(firstname.equalsIgnoreCase(fname)) {
			System.out.println("FirstNam is matching actual - "+firstname+" , and expected - "+fname+" >>> passed");
		}else {
			System.out.println("FirstNam is not matching actual"+firstname+" , and expected-"+fname+" >>> Failed");
		}

		JSONObject lastnamobj = properarray.getJSONObject(1);
		String lastname=lastnamobj.getString("value");

		if(lastname.equalsIgnoreCase(lname)) {

			System.out.println("lastNam is matching actual"+lastname+" , and expected-"+lname+" >>> passed");
		}else {
			System.out.println("lastNam is not matching actual"+lastname+" , and expected-"+lname+" >>> Failed");
		}

		JSONObject Emailobj = properarray.getJSONObject(2);
		String Emailvalue=Emailobj.getString("value");

		if(Emailvalue.equalsIgnoreCase(Email)) {

			System.out.println("Email Id is matching actual"+Emailvalue+" , and expected-"+Email+" >>> passed");
		}else {
			System.out.println("Email Id is not matching actual"+Emailvalue+" , and expected-"+Email+" >>> Failed");
		}
	}

}
