package dummy.restAssured;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DummyApi {
	
	@Test
	public void dummy() {
		int id;
//		DummyApi obj = new DummyApi();
		//http://dummy.restapiexample.com/create
		String jsonPost = "{\r\n" + 
				" \"board\":952, \r\n" + 
				" \"player\":{\r\n" + 
				" 	\"name\": \"Ma1\"\r\n" + 
				" 	\r\n" + 
				" }\r\n" + 
				" }";

		System.out.println("json: "+jsonPost);
		
		Response res = RestAssured.given().contentType("application/json").body(jsonPost).when().post("http://10.0.1.86/snl/rest/v1/player.json");
		
		System.out.println("Response:" +res.asString());
		System.out.println("Status code: "+res.getStatusCode());
	}
}
//To mark changes in GIT
//git practice
