package endPointVerification;


import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class EndPointVerification {

	@Test
	public void testOfResponseData() {
		Response res = RestAssured.get("http://10.0.135.222:83/status");

		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode,200 );
		System.out.println("Response body:" + res.asString());

		JSONObject jsonObject = new JSONObject(res.asString());
		JSONObject getJsonData = jsonObject.getJSONObject("Summary");
		Object level = getJsonData.get("version");
		System.out.println(level);
	}
}
