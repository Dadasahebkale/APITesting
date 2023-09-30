package dd.com.book;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;

import dd.com.files.PayLoadBooks;
import io.restassured.path.json.JsonPath;

/**
 * 
 * 1. Print No of courses returned by API
 * 
 * 2.Print Purchase Amount
 * 
 * 3. Print Title of the first course
 * 
 * 4. Print All course titles and their respective Prices
 * 
 * 5. Print no of copies sold by RPA Course
 * 
 * 6. Verify if Sum of all Course prices matches with Purchase Amount
 */
public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(PayLoadBooks.courseprice());
		int count = js.getInt("cources.size()");
		// Print No of courses returned by API
		System.out.println("Print No of courses returned by API :" + count);
		// Print Purchase Amount
		int purchaseamount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Print Purchase Amount :" + purchaseamount);
		// Print Title of the first course
		String firsttitle = js.getString("cources[0].title");

		System.out.println("Print Title of the first course :" + firsttitle);
		// Print All course titles and their respective Prices

		for (int i = 0; i < count; i++) {
			String courseTitle = js.get("cources[" + i + "].title");
			int price = js.getInt("cources[" + i + "].price");
			int copies = js.getInt("cources[" + i + "].copies");
			// System.out.println(js.getInt("cources[0].price"));
			System.out.println(courseTitle + " and price is : " + price + " number of copies are :" + copies);
		}

		System.out.println("Print no of copies sold by Rest API Course");

		for (int i = 0; i < count; i++) {
			String courseTitle = js.get("cources[" + i + "].title");
			if (courseTitle.equalsIgnoreCase("Rest API")) {
				int copies = js.getInt("cources[" + i + "].copies");
				System.out.println(copies);
				break;
			}

		}
		System.out.println("Verify if Sum of all Course prices matches with Purchase Amount");
		int coursesumamount = 0;
		for (int i = 0; i < count; i++) {

			int price = js.get("cources[" + i + "].price");
			int copies = js.getInt("cources[" + i + "].copies");
			int amount = price * copies;
			System.out.println(amount);
			coursesumamount = coursesumamount + amount;
		}
		// Verify if Sum of all Course prices matches with Purchase Amount
		System.out.println(coursesumamount);
		int totalpurchaseamount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Cources prices is " + coursesumamount + " and purchase amount is :" + totalpurchaseamount);
		Assert.assertEquals(coursesumamount, totalpurchaseamount);
	}
}