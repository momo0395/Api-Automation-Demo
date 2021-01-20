package dummy.restAssured;

import org.json.JSONObject;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicAuthenticationUsingJson {
	
	@Test
	public void main1() {
		JSONObject json = new JSONObject();
		json.put("id",1);
		json.put("title","Asto"); 
		json.put("body","Gem");	
		json.put("userId",1);
		System.out.println(json);
		Response res = RestAssured.given().
					auth().
					preemptive().
					basic("user", "password").contentType("application/json").body(json.toString()).
		when().post("https://jsonplaceholder.typicode.com/posts/");
		System.out.println(res.getBody());
		System.out.println(res.asString());
	}
	
}
