package com.api.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.api.body.files.Payload;

public class ApiTesting {

	public static void main(String[] args) {
		// baseURI is the URL
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		// Given-all input details
		// When - Submit the API
		// Then - Validate the response
		String response = given().queryParam("key", "qaclick123").header("Content-type", "application/json")
				.body(Payload.addPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract().response()
				.asString();
		//System.out.println(response);
		JsonPath js = new JsonPath(response); // for Parsing Json
		String placeId = js.getString("place_id");

		System.out.println("The Place Id is :" + placeId);

	}

	// Add place --> update place with new Address--> Get place to validate if new
	// address is present in response

}
