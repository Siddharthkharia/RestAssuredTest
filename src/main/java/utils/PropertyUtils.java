package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    private static String baseResDirectory ="src/main/resources/configs/"+System.getProperty("env","local");
    private static PropertyUtils instance;
    private Properties properties = new Properties();

    private PropertyUtils(){
    }

    public static synchronized PropertyUtils getInstance(){
        if(instance==null){
            instance=new PropertyUtils();
        }
        return instance;
    }

    public Properties loadProperties(String filename){
        filename=baseResDirectory+"/"+filename+".properties";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        try {
            this.properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.properties;
    }
}
