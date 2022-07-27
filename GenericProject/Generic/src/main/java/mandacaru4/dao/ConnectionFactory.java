package mandacaru4.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    private static String url = null;
    private static String user = null;
    private static String passWord = null;

    public static Connection getConnection(){
        try {
            if(url == null){
                Properties prop = new Properties();
                InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
                prop.load(inputStream);
                url = prop.getProperty("url");
                user = prop.getProperty("user");
                passWord = prop.getProperty("password");
            }
            return DriverManager.getConnection(url, user, passWord);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
