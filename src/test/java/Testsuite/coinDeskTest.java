package Testsuite;

import PoJos.ReqSetters.CoinDeskRequest;
import PoJos.ResponseHandlers.CoinDeskResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"cointDesk"})
public class coinDeskTest {

    @Test
    public static void TC001orderStore(){
        CoinDeskResponse st = utils.utils.JsonToPojo(CoinDeskResponse.class,"CoinDesk");

        System.out.println(st.getTime().getUpdated());

        System.out.println(utils.utils.PojoToJson(st));
    }

    @Test
    public void testGetCall(){
        CoinDeskRequest coinDeskRequest = new CoinDeskRequest();
        coinDeskRequest.executeAndResponse();
        Response response = coinDeskRequest.getResponse();
        CoinDeskResponse coinDeskResponse = coinDeskRequest.ResponseToPojo(CoinDeskResponse.class,response);

        Assert.assertNotNull(coinDeskResponse.getBpi());

        System.out.println(response.asString());
    }


    @Test
    public void testpostCall(){
        CoinDeskRequest coinDeskRequest = new CoinDeskRequest();
        coinDeskRequest.setMethodPost();
        coinDeskRequest.executeAndResponse();
        Response response = coinDeskRequest.getResponse();
        CoinDeskResponse coinDeskResponse = coinDeskRequest.ResponseToPojo(CoinDeskResponse.class,response);
    }
}
