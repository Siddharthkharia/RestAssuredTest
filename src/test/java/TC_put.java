import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//import java.util.HashMap;
//import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC_put {


	@Test
	void TC_01() {
//		String url ="https://reqres.in/api/users";
//				Response response = get(url);
//				Map<String, Object> map = new HashMap<String, Object>();
//		
//				map.put("name", "Sid");
//				map.put("job","Engg");
//		
//				JSONObject request = new JSONObject(map);
//				System.out.println(request);


		JSONObject request =new JSONObject();
		request.put("name", "gamma");
		request.put("job", "IT");

		given().
		body(request.toJSONString()).when().
		patch("https://reqres.in/api/users/2").
		then().
		log().status();
	
	}
//	@Test
//	void TC_02() {
//		given().
//	}

}
