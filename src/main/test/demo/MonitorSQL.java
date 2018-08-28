package demo;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hua on 2018-04-02.
 * Describe:
 */
public class MonitorSQL {

    @Test
    public void test(){
        String jdbcurl="jdbc:mysql://localhost:3306/user";
        String jdbcdriver="com.mysql.jdbc.Driver";
        String username="root";
        String password="xhua";
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName(jdbcdriver);
            conn = DriverManager.getConnection(jdbcurl,username,password);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("show status like '%Threads_connected%'");
//            rs.last();
//            int rowCount = rs.getRow();


            while (rs.next()){
                String num = rs.getString("Value");
                System.out.println("------hangshu:"+num);
            }


//
//            ResultSetMetaData md = rs.getMetaData();   //获取键名
//            int columnCount =md.getColumnCount();
//            System.out.println(columnCount);
//
//            Map map = new HashMap();
//            ArrayList list =new ArrayList();
//            int i=1;
//            while (rs.next()){
//                map.put(md.getColumnName(i),rs.getObject(i));
//                list.add(map);
//                i++;
//            }
//        System.out.print("--------------连接数："+i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}





