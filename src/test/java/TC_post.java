import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;



public class TC_post {

	@Test
	void TC_01() {
		//String url ="https://reqres.in/api/users";
		//		Response response = get(url);
		//		Map<String, Object> map = new HashMap<String, Object>();
		//
		//		map.put("name", "Sid");
		//		map.put("job","Engg");
		//
		//		JSONObject request = new JSONObject(map);
		//		System.out.println(request);


		JSONObject request =new JSONObject();
		request.put("name", "Sid");
		request.put("job", "IT");
		
		System.out.println(request);

		given().
		body(request.toJSONString()).when().
		post("https://reqres.in/api/users").
		then().
		statusCode(201);
		
	}



}
