package com.api.body.files;

public class Payload {

	public static String addPlace() {

		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
				+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" + "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n" + "}\r\n" + "";
	}

	public static String updatePlace() {
		return "{\r\n" + "\"place_id\":\"a27d717cb745c9c0efc95f5ae7682606\",\r\n"
				+ "\"address\":\"70 winter walk, USA\",\r\n" + "\"accuracy\": \"100\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n" + "}";
	}

	public static String coursePrice() {

		return "{\r\n" + "\"dashboard\": {\r\n" + "\"purchaseAmount\": 911,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n" + "},\r\n" + "\"courses\": [\r\n" + "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n" + "\"price\": 50,\r\n" + "\"copies\": 6\r\n" + "},\r\n"
				+ "{\r\n" + "\"title\": \"Cypress\",\r\n" + "\"price\": 40,\r\n" + "\"copies\": 4\r\n" + "},\r\n"
				+ "{\r\n" + "\"title\": \"RPA\",\r\n" + "\"price\": 45,\r\n" + "\"copies\": 10\r\n" + "}\r\n" + "]\r\n"
				+ "}";
	}

	public static String addBook() {
		String addBook = "{\"name\":\"Learn Appium Automation with Java\",\"isbn\":\"bcd\",\"aisle\":\"227\",\"author\":\"John foe\"}";
		return addBook;
	}

}
