package Java_Practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class json_practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		byte[] jsonarr = Files.readAllBytes(Paths.get("C:\\Users\\Ashish\\Desktop\\ashish.json"));
	String json=new String(jsonarr);
	System.out.println(json);
	
	JSONObject rootjson=new JSONObject(json);
	String typevalue = rootjson.getString("type");
	int arr=rootjson.getInt("id");
	
	System.out.println("Type value is >."+typevalue);
	System.out.println(arr);
	
	JSONArray arryjson = rootjson.getJSONArray("tagsWithTime");
	JSONObject objjson = arryjson.getJSONObject(0);
	String tagvalue = objjson.getString("tag");
	
	JSONArray properti_json = rootjson.getJSONArray("properties");
	
	
	
	for(int i=0;i<properti_json.length();i++) {
		JSONObject jsonobject = properti_json.getJSONObject(i);
		JSONArray allkeys = jsonobject.names();
		for(int j=0;j<jsonobject.length();j++) {
			System.out.println(allkeys.getString(j)); 
		}
//	String	objvalue1=jsonobject.getString("type");
	//System.out.println(objvalue1);
	}
	System.out.println(tagvalue);
	
	
	}

}
