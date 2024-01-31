package utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DbUtils {
    private static JdbcTemplate jdbc=null;


    public DbUtils(){

        Properties prop = PropertyUtils.getInstance().loadProperties("db");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(prop.getProperty("driverClassName"));
        dataSource.setUsername(prop.getProperty("username"));
        dataSource.setUrl(prop.getProperty("dburl"));
        dataSource.setPassword(prop.getProperty("password"));
        jdbc = new JdbcTemplate(dataSource);
    }

    public Object readValue(String query){
        return jdbc.queryForObject(query,Object.class);
    }

    public Map<String, Object> readRow(String query){
        return jdbc.queryForMap(query);
    }

    public List<Map<String,Object>> readMultipleRows(String query){
        return jdbc.queryForList(query);
    }

    public void updateRow(String query){
        jdbc.update(query);
    }

}
