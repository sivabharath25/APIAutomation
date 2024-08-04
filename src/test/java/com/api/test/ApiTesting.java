package com.api.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import com.api.body.files.Payload;
import com.api.body.files.Resusable;

public class ApiTesting {

	public static void main(String[] args) {
		String newAddress = "70 winter walk, Africa";
		// baseURI is the URL
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		// Given-all input details
		// When - Submit the API
		// Then - Validate the response

		String response = given().queryParam("key", "qaclick123").header("Content-type", "application/json")
				.body(Payload.addPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract().response()
				.asString();

		// System.out.println(response);
		JsonPath js = Resusable.rawToJson(response); // for Parsing Json
		String placeId = js.getString("place_id");

		System.out.println("The Place Id is :" + placeId);

		// updating the place
		String updateApiResponse = given().queryParam("key", "qaclick123").header("Content-type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"" + newAddress + "\",\r\n"
						+ "\"accuracy\": \"100\",\r\n" + "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated")).extract().response().asString();

		JsonPath js1 = Resusable.rawToJson(updateApiResponse);
		System.out.println(js1.getString("msg"));

		// Getting the place information
		String getResponse = given().queryParam("key", "qaclick123").queryParam("place_id", placeId).when()
				.get("maps/api/place/get/json").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(getResponse);

		JsonPath js2 = Resusable.rawToJson(getResponse);
		String actualAddress = js2.getString("address");
		System.out.println(actualAddress.equals(newAddress));
		Assert.assertEquals(newAddress, actualAddress);

	}

	// Add place --> update place with new Address--> Get place to validate if new
	// address is present in response

}
