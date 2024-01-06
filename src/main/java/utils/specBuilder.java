package utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utils.constants.*;

public class specBuilder {

    public static RequestSpecification setReqSpecs(){
        return new RequestSpecBuilder().setBaseUri(base_uri).setBasePath(base_path).setAccept(ContentType.JSON).setContentType(ContentType.JSON).build();

    }

}
