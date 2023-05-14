import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_trial {
	
	
	@Test
	void TC_01 (){
		Response response = get("");
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		RestAssured.authentication = auth;
	}

}
