package com.api.test;

import org.testng.Assert;

import com.api.body.files.Payload;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		JsonPath js = new JsonPath(Payload.coursePrice());
		int receivedPrice = 0;

		// Printing number of courses returned by API
		int coursesCount = js.getInt("courses.size()");
		// System.out.println("coursesCount : " + coursesCount);

		// getting the purchase amount from the JSON
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		// System.out.println("The Purchase Amount is : " + purchaseAmount);

		// getting the first index title
		String firsTitle = js.get("courses[0].title");
		// System.out.println("The courses[0].title is : " + firsTitle);

		// Print all course titles and their respective prices
		for (int i = 0; i < coursesCount; i++) {
			String Title = js.get("courses[" + i + "].title");
			int price = js.getInt("courses[" + i + "].price");
			int copies = js.getInt("courses[" + i + "].copies");
			receivedPrice = receivedPrice + (price * copies);

			// Printing the course and python
			System.out.println(Title + " : " + price);
			if (Title.equals("RPA")) {

				System.out.println("The copies of the RPA is :" + copies);
			}
		}
		Assert.assertEquals(receivedPrice, purchaseAmount);
	}
}
