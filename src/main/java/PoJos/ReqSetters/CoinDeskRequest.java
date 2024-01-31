package PoJos.ReqSetters;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import utils.BaseApi;
import utils.constants;

public class CoinDeskRequest extends BaseApi {
    private static String host= constants.coinDesk_host;
    private static String endpoint="v1/bpi/currentprice.json";

    public CoinDeskRequest() {
        this.setBaseUri(host);
        this.setApiEndpoint(endpoint);
        this.setMethod(Method.GET);
        this.setContentType(ContentType.JSON);
    }

    public void setMethodPost(){
        this.setMethod(Method.POST);
    }
}
