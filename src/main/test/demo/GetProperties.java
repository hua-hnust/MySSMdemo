package demo;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * Created by hua on 2018-03-23.
 * Describe: 读取配置文件信息
 */
public class GetProperties {

    private String jbdcDriver;
    private String jdbcurl;
    private String username;
    private String password;

    @Test
    public void getPropertis() {

        Properties prop = new Properties();
        String value = null;
        try {
            // 通过输入缓冲流进行读取配置文件
            InputStream InputStream = new BufferedInputStream(new FileInputStream(new File("src/main/resources/jdbc.properties")));
            // 加载输入流
            prop.load(InputStream);
            // 根据关键字获取value值
            jbdcDriver = prop.getProperty("jdbc.driver");
            jdbcurl = prop.getProperty("jdbc.url");
            username = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            System.out.println(jbdcDriver);
            System.out.println(jdbcurl);
            System.out.println(username);
            System.out.println(password);

            System.out.println("-----------------");

            for (Object key:prop.keySet()){
                System.out.println(key +" = " + prop.getProperty(key.toString()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
