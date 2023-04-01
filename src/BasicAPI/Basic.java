package BasicAPI;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Basic {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String jsonPostMapData ="{\r\n"
				+ "\"location\": {\r\n"
				+ "\"lat\": -38.383494,\r\n"
				+ "\"lng\": 33.427362\r\n"
				+ "},\r\n"
				+ "\"accuracy\": 50,\r\n"
				+ "\"name\": \"Frontline house\",\r\n"
				+ "\"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "\"address\": \"29, side layout, cohen 09\",\r\n"
				+ "\"types\": [\r\n"
				+ "\"shoe park\",\r\n"
				+ "\"shop\"\r\n"
				+ "],\r\n"
				+ "\"website\": \"http://google.com\",\r\n"
				+ "\"language\": \"French-IN\"\r\n"
				+ "}";
		
		given().log().all().queryParam("key", "qaclick").header("Content-Type","application/json")
		.body(jsonPostMapData).when().post("/maps/api/place/add/json?key=qaclick123")
		.then().log().all().assertThat().statusCode(200).extract().asString();
		
		String jsonDeleteId = "{\r\n"
				+ "\"place_id\":\"1e8a8c505f3e15273ddcd7c1763b00dc\"\r\n"
				+ "}";
		
	}

}
