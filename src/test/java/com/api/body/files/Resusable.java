package com.api.body.files;

import io.restassured.path.json.JsonPath;

public class Resusable {

	public static JsonPath rawToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}

}
