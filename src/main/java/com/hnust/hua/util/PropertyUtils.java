package com.hnust.hua.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2018/11/28.
 */
public class PropertyUtils {
    private static Properties jdbcProps;

    static {
        loadProps();
    }

    synchronized static private void loadProps(){
        jdbcProps = new Properties();
        InputStream in = null;
        in = PropertyUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try{
            jdbcProps.load(in);
        }catch (IOException e){
            System.out.println("加载配置文件失败");
        }
    }

    public static String getProperty(String key){
        if(null ==jdbcProps){
            loadProps();
        }
        return jdbcProps.getProperty(key);
    }

}
