package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import java.io.File;
import java.io.FileInputStream;

public class BaseApi extends specBuilder{

    private static String baseResDirectory ="src/main/resources/configs/"+System.getProperty("env","local");

    private Response response;

    public void createRequestFromPojo(){
        utils.PojoToJson(this.getClass());
        this.getClass();
    }

    public Response getResponse(){
        return this.response;
    }


    public Response executeAndResponse(){

        switch (this.getMethod()){
            case GET:
                this.response= RestAssured
                        .given()
                        .spec(this.getRequestSpecBuilder().build())
                        .when().get();
                response.then().spec(responseValidation()).log().ifValidationFails();
                return response;
            case POST:
                this.response= RestAssured.given().spec(this.getRequestSpecBuilder().build()).when().post();
                System.out.println(response.then().spec(responseValidation()).log().ifValidationFails().toString());
                return response;
            default:
                response =null;
                break;
        }
        return null;
    }


    public <T> T defaultJsonReqToPojo(Class<T> clazz, String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/defaultRequests/"+fileName+".json");
            FileInputStream fileInputStream = new FileInputStream(file);
            return objectMapper.readValue(fileInputStream,clazz);
        } catch (Exception e) {
            throw new RuntimeException("Error converting JSON to POJO", e);
        }
    }

    public String PojoToJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T ResponseToPojo(Class<T> clazz, Response response){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response.asString(),clazz);
        } catch (Exception e) {
            throw new RuntimeException("Error converting JSON to POJO", e);
        }
    }

    public static ResponseSpecification responseValidation(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON) //checks for the content type is application/json
                .expectBody(Matchers.is(Matchers.notNullValue()))
                //checks for the body as not null
                .build();
    }
}
