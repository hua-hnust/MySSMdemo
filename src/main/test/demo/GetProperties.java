package demo;

import org.junit.Test;
import sun.tools.jar.Main;

import java.io.*;
import java.util.Properties;

/**
 * Created by hua on 2018-03-23.
 * Describe:
 */
public class GetProperties {

    private String jbdcDriver;
    private String jdbcurl;
    private String username;
    private String password;

    @Test
    public void getPropertis(){
        Properties properties = new Properties();
        try {
            properties.load(Main.class.getResourceAsStream("src/main/resource/jdbc.properties"));
            for (Object key : properties.keySet()) {
                System.out.println(key + "=" + properties.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        InputStream in = Properties.class.getClassLoader().getResourceAsStream("src/jdbc.properties");
//        try {
//            properties.load(in);
//            jbdcDriver=properties.getProperty("jdbc.driver");
//            jdbcurl=properties.getProperty("jdbc.url");
//            username=properties.getProperty("jdbc.username");
//            password=properties.getProperty("jdbc.password");
//            System.out.println(jdbcurl);
//        } catch (IOException e) {
//            System.out.println("没有获取到配置文件");
//            e.printStackTrace();
//        }
//

    }

}
