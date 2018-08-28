import org.junit.Test;

import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;

/**
 * Created by hua on 2018-03-20.
 * Describe:
 */
public class MysqlStatusTest {
    @Test
   public void test(){
        String jdbcurl="jdbc:mysql://localhost:3306/user?connectTimeout=1000&socketTimeout=1000";
        String jdbcdriver="com.mysql.jdbc.Driver";
        String username="root";
        String password="xhua";
       try {
           Class.forName(jdbcdriver);
           Connection conn = DriverManager.getConnection(jdbcurl,username,password);
           Statement st = conn.createStatement();

           //innodb
           ResultSet rs = st.executeQuery("SELECT @@innodb_buffer_pool_size");
           double size=0.0;
           String str=null;
           while (rs.next()){
               str =rs.getString(1);
               size = Double.parseDouble(str)/1024/1024;
           }
           System.out.println("size："+size);

           //连接数
           ResultSet process =st.executeQuery("show PROCESSLIST");
           process.last();
           int num = process.getRow();
           System.out.println("连接数："+num);

           //命中率
           ResultSet rs1 = st.executeQuery("show GLOBAL status like '%innodb_buffer_pool_read_requests%'");
           String p1=null;
           while (rs1.next()){
               p1 = rs1.getString(2);
           }
           ResultSet rs2 = st.executeQuery("show GLOBAL status like '%innodb_buffer_pool_reads%'");
           String p2 = null;
           while (rs2.next()){
               p2 = rs2.getString(2);
           }
           Double rate = (double)(Integer.parseInt(p1)-Integer.parseInt(p2))/Integer.parseInt(p1)*100;
           DecimalFormat df = new DecimalFormat("#0.00");
           System.out.println("命中率："+df.format(rate));

           //表空间
           ResultSet tableSpaceSizeRs = st.executeQuery("SELECT TABLE_SCHEMA,concat(TRUNCATE (sum(data_length) / 1024 / 1024,2)) AS data_size FROM information_schema.TABLES GROUP BY TABLE_SCHEMA ORDER BY data_length DESC");
           Double tableSize = 0.0;
           while (tableSpaceSizeRs.next()){
               tableSize += tableSpaceSizeRs.getDouble(2);
           }
           DecimalFormat df2 = new DecimalFormat("#0.00");
           System.out.println("表空间："+df2.format(tableSize));

           //binlog 日志大小，需要开启
           ResultSet logbinRs = st.executeQuery("show VARIABLES like 'log_bin'");
           while (logbinRs.next()){
               String logbinstatus = logbinRs.getString(2);
               if("OFF".equals(logbinstatus)){
                   System.out.println("日志未开启");
               }
           }

       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

}
