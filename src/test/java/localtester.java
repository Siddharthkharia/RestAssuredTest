import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.filters.TokenFilter.ContainsString;
import org.json.simple.JSONObject;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class localtester {
	
	@BeforeTest
	void bfrtest() {
		baseURI = "http://localhost:3000/";
		
	}
	
	
	@Test
	void TC_01_get() {
		
		Response res = get("/user");
//		res.getBody().jsonPath().getList("/1");
//		System.out.println(res.getBody().jsonPath().getList("/user/1").toString());
//		
//		System.out.println(res.toString());
		
		
		List<String> stl= res.getBody().jsonPath().getList("name");
		
		System.out.println(stl.size());
		
		System.out.println(stl.toString());
		
		//Map<String, String> ma= given().when().get().then().extract().jsonPath().getMap("user[0]");
		
		//System.out.println(ma.keySet());
	}
	
	void TC_002_get() {
		
		Map<String, String> ma= given().when().get().then().extract().jsonPath().getMap("support");
		
		System.out.println(ma.keySet());
		
		
	}
	
	@Test
	void TC_003_post() {
		
		JSONObject reqparam =new JSONObject();
		
		reqparam.put("name", "Alpha");
		reqparam.put("lastname", "Beta");
		reqparam.put("jobid", 2);
		
		
		RequestSpecification req =  RestAssured.given();
 
		//req.header("Content-Type", "appplication/json");
		req.contentType("application json;charset = UTF-8");
		
		req.body(reqparam.toJSONString());
		
		//req.post("/user");
		
//		given().when().get("/user").then().assertThat().body(containsString("Alpha"));
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(reqparam.toJSONString()).when().post("/user").then();
		
		
		given().get("/user").then().assertThat().body(containsString("Alpha"));
	}

}


