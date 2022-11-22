package rest_assured_demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;



public class demo_1 {
	public String url="https://reqres.in/api/users?page=2";
	@Test(enabled=false)
	public void get_tc1() {
		Response rep= RestAssured.get(url);
		int actual=rep.statusCode();
		Assert.assertEquals(actual, 200);
	}
	@Test(enabled=false)
	public void get_tc2() {
		given().
		get(url).
		then().
		statusCode(200).
		statusCode(200).log().all();
		//body("data.firstname", hasItems("Tobias"));
	}
	@Test(enabled=false)
	public void post_tc3() {
		JSONObject js= new JSONObject();
		js.put("name", "sivanesh");
		js.put("job", "tester");
		given().body(js.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}
	@Test(enabled=true)
	public void register() {
		JSONObject js= new JSONObject();
		js.put("email", "sivanesh25@gmail.com");
		js.put("password", "tester123");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
	}

}
