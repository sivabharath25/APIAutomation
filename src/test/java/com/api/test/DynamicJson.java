package com.api.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.body.files.Payload;
import com.api.body.files.Resusable;

public class DynamicJson {

	@Test
	public void addBook() {

		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().header("Content-type", "application/json").body(Payload.addBook()).when()
				.post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = Resusable.rawToJson(response);
		String id = js.get("ID");
		System.out.println("The id of the book is : " + id);
		;
	}

}
