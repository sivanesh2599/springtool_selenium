package rest_assured_demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;


public class trello_board {
	public String url="https://api.trello.com";
	public String key="c56337e8a5cd53dc0776e23d13cd8eb5";
	public String token="d41568a7e85c941c21884160bf0e108ca0298a2eb83f58d3b250e81903813189";
	public String id;
	@Test
	public void createboard() {
		JSONObject js = new JSONObject();
		//JsonPath jp = new JsonPath(js.toJSONString());
		RestAssured.baseURI=url;
		//create a board
//		given().queryParam("name","vamsi").queryParam("key",key)
//		.queryParam("token",token)
//		.when().contentType(ContentType.JSON)
//		.accept(ContentType.JSON).post("/1/boards/").then().log().all();
		//delete a board
//		given().queryParam("name","sivanesh").queryParam("key",key)
//		.queryParam("token",token)
//		.when().contentType(ContentType.JSON)
//		.accept(ContentType.JSON).delete("/1/boards/CNc3Ruus").then().log().all();
		//update a board
//		given().queryParam("name","vamsi").queryParam("key",key)
//		.queryParam("token",token)
//		.when().contentType(ContentType.JSON)
//		.accept(ContentType.JSON).body("kumar").put("/1/boards/RAXhS0iZ").then().log().all();
//		
		Response response=given().queryParam("name", "siva")
				.queryParam("key", key)
				.queryParam("token", token)
				.header("Content-Type", "application/json")
				.when()
				.post("/1/boards/")
				.then()
				.assertThat().statusCode(200).contentType(ContentType.JSON)
				.extract().response();
				String jsonresponse = response.asString();
				JsonPath js1= new JsonPath(jsonresponse);
				
				id = js1.get("id");
				System.out.println(id);		
			}
	}


