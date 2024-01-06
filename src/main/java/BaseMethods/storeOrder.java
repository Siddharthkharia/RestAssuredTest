package BaseMethods;

import PoJos.ReqSetters.storeOrderPOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.specBuilder;

public class storeOrder {

    public static Response postStoreOrder(storeOrderPOJO payload){
        Response response = RestAssured.given(specBuilder.setReqSpecs()).when().body(payload).post();
    return response;
    }

}
