import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.event.LoggingEvent;

public class TC_get {
	
	/*@BeforeTest
	void getRes() {
		Response response = get("https://reqres.in/api/users?page=2");

	}
	*/
	@Test
	void tc_01() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		//System.out.println(response.getHeaders());
		String sttt = response.jsonPath().getJsonObject("id");
		System.out.println(sttt);
	}
	
	@Test
	void tc_02() {
		Response response = get("https://reqres.in/api/users?page=2");
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("TC 2 for get status code is " + response.getStatusCode());
	}
	
	@Test
	void tc_03() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
		
	}
	
	@Test
	void tc_04() {
		given().get("https://reqres.in/api/users?page=2").then().body("data.id", hasItems(7, 9));
		System.out.println("TC 4 for Get passed");

	}
	@Test
	void tc_05() {
	ArrayList<Integer>	arr = given().when().get("https://reqres.in/api/users?page=2").
			then().extract().path("data");
	System.out.println(arr);
	//JSONObject req = new JSONObject();
	

	}
	
	@Test
	void tc_06() {
		//Map<String, String> map = new HashMap<String , String>();
		
		//JSONObject response= 
				given().param("data.id", 7).get("https://reqres.in/api/users?page=2").then();
		System.out.println();
	}
	
	@Test
	void TC_07() {
		String[] st =given().get("https://reqres.in/api/users?page=2").then().extract().path("id");
		System.out.println(st);
	}
	
	@Test
	void TC_009() {
		ArrayList<String> str = new ArrayList<String>();
		
		str= given().get("https://reqres.in/api/users?page=2").then().extract().path("email");
		
		System.out.println(str.size());
	}

}
