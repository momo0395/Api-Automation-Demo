package openWeather;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;

public class GetResponse {

	@Test
	public void testOfResponseData() {
		Response res = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=90fdcef626f9f7c75d8a83de4ef3baba");
//		Response res1 = RestAssured.post("http://api.openweathermap.org/data/2.5/weather?q=London&appid=90fdcef626f9f7c75d8a83de4ef3baba");
		
		int statusCode = res.getStatusCode();
		System.out.println("statusCode: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		ResponseBody body = res.getBody();
		System.out.println("Response body:" + body.asString());
		System.out.println("Response:" + res.asString());
		
//		To check for sub string presence get the Response body
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("Clouds"), true );
		System.out.println("Response body contains Clouds");
	}
}
