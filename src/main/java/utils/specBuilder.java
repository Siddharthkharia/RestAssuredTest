package utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.*;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.CoreConnectionPNames;
import org.hamcrest.Matchers;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.config.LogConfig.logConfig;

public class specBuilder {
    private Map<String,String> headers =new HashMap<>();
    private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    private ContentType contentType;
    private Method method;
    private String cookie;
    private String apiEndpoint;
    private String BaseUri;
    private Map<String, Object> queryParams = new HashMap<>();
    private Object requestBody;
    private boolean enableLogConfig=false;
    private RestAssuredConfig config = new RestAssuredConfig();



    public boolean isEnableLogConfig() {
        return this.enableLogConfig;
    }

    public void setEnableLogConfig(boolean enableRestAssuredLogging) {
        this.enableLogConfig = enableRestAssuredLogging;
    }


    public void setLogConfig() {
        this.config.logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails().enablePrettyPrinting(true));
    }

    public void setHttpConConfig(){
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000)
                .build();

        HttpClientConfig httpClientFactory = HttpClientConfig.httpClientConfig()
                .httpClientFactory(() -> HttpClientBuilder.create()
                        .setDefaultRequestConfig(requestConfig)
                        .build());

//        Deprecated
//                this.config.httpClient(HttpClientConfig.httpClientConfig()
//                        .setParam("http.socket.timeout",1000)
//                        .setParam("http.connection.timeout", 1000));

        this.config.httpClient(httpClientFactory);

    }


    public void setContentType(ContentType content){
        this.contentType = content;
        this.requestSpecBuilder.setAccept(this.contentType);
        this.requestSpecBuilder.setContentType(this.contentType);
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, String> headerMap) {
        this.headers.putAll(headerMap);
        this.requestSpecBuilder.addHeaders(headers);
    }

    public void setHeader(String headerKey, String headerValue){
        this.headers.put(headerKey,headerValue);
        this.requestSpecBuilder.addHeaders(headers);
    }


    public RequestSpecBuilder getRequestSpecBuilder() {
        if(isEnableLogConfig()){
            setLogConfig();
        }
        setHttpConConfig();

         this.requestSpecBuilder.setConfig(this.config);
        return this.requestSpecBuilder;
    }

    protected void setRequestSpecBuilder(RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
    }

    public String getContentType() {
        return this.contentType.toString();
    }

    public Method getMethod() {
        return this.method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }


    public String getCookie() {
        return this.cookie;
    }

    public void setCookie(String cookies) {
        this.cookie = cookies;
        this.requestSpecBuilder.addCookie(cookie);
    }

    public String getApiEndpoint() {
        return this.apiEndpoint;
    }

    public void setApiEndpoint(String base_path) {
        this.apiEndpoint = base_path;
        this.requestSpecBuilder.setBasePath(apiEndpoint);
    }

    public String getBaseUri() {
        return this.BaseUri;
    }

    public void setBaseUri(String uri) {
        this.BaseUri = uri;
        this.requestSpecBuilder.setBaseUri(BaseUri);
    }

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, Object> params) {
        this.queryParams = params;
        this.requestSpecBuilder.addParams(queryParams);
    }

    public Object getRequestBody() {
        return this.requestBody;
    }

    public void setRequestBody(Object request) {
        this.requestBody = request;
        this.requestSpecBuilder.setBody(requestBody);
    }



}
