package utils;

import PoJos.ReqSetters.storeOrderPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.formula.functions.T;
import org.json.simple.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class utils {
    private static String baseResDirectory ="src/main/resources/configs/"+System.getProperty("env","local");

    public static <T> T JsonToPojo(Class<T> clazz, String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/defaultRequests/"+fileName+".json");
            FileInputStream fileInputStream = new FileInputStream(file);
            String reqJson = file.toString();
            T reqPojo = objectMapper.readValue(fileInputStream,clazz);
            return reqPojo;
        } catch (Exception e) {
            throw new RuntimeException("Error converting JSON to POJO", e);
        }
    }

    public static String PojoToJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
