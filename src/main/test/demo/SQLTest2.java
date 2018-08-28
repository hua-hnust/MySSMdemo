package demo;

import org.junit.Test;

import java.sql.*;

/**
 * Created by hua on 2018-04-18.
 * Describe:
 */
public class SQLTest2 {
    @Test
    public void sqlTest(){
        int[] ids ={1,4,3,2,5};
        String sqlStr = "update sqltest set num = case id ";
        for (int i=0;i<ids.length;i++){
            sqlStr += "when " + ids[i] + " then '" + (i+1) + "' ";
        }
        sqlStr +="end";

        System.out.println(sqlStr);

        String jdbcurl="jdbc:mysql://localhost:3306/user?useSSL=false";
        String jdbcdriver="com.mysql.jdbc.Driver";
        String username="root";
        String password="xhua";
        try {
            Class.forName(jdbcdriver);
            Connection conn = DriverManager.getConnection(jdbcurl,username,password);
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(sqlStr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
