package agilecrm.apiautomation;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	RequestSpecification rs=	RestAssured.given();
	rs.auth().basic("ashishydv@agilecrm.com", "yadav@12345").accept("application/json");
	Response resp = rs.get("https://ashishydv.agilecrm.com/dev/api/contacts/5928410024706048");
	String responjson =resp.getBody().asPrettyString();
	System.out.println(resp.getStatusCode());
	System.out.println(responjson);
	
		
//	JSONObject rootjson = new JSONObject(responjson);
//	
//	JSONArray jsonPropArray = rootjson.getJSONArray("properties");
//	
//	JSONObject fNamobj = jsonPropArray.getJSONObject(0);
//	String responsfNam = fNamobj.getString("value");
//	
//	JSONObject LNamobj = jsonPropArray.getJSONObject(1);
//	String responsLNam = LNamobj.getString("value");
//	
//	JSONObject emailobj = jsonPropArray.getJSONObject(2);
//	String responsemail = emailobj.getString("value");
	
//	if(fNamobj.eqequals(responsfNam)) {
//		System.out.println("");
//	}
//	
	
	
	
	}

}
