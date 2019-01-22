package cache;

import com.intersys.classes.SYS.ProcessQuery;
import com.intersys.objects.*;
import com.intersys.xep.samples.Sample;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/5.
 */
public class CacheDemo02 {

    @Test
    public void test() {

        try {
            String url = "jdbc:Cache://172.23.1.31:1972/%SYS";
            String username = "_system";
            String password = "123";
            Database dbconnection = CacheDatabase.getDatabase(url, username,password);


//            //用于测试连接
//            dbconnection.close();
//            boolean open =  dbconnection.isOpen();

            //版本信息
            ObjectServerInfo serverInfo = dbconnection.getServerInfo();
            int version = serverInfo.getMajorObjectVersion();

            PreparedStatement statement = dbconnection.prepareStatement("call %CSP.Session_SessionInfo");

            ResultSet resultSet = statement.executeQuery();

            ResultSetMetaData rsmd =resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            List<Map<String, String>> result = new ArrayList<Map<String, String>>();

            while (resultSet.next()) {
                Map<String, String> record = new HashMap<String,String>();
                for (int j = 1; j <= columnCount; j++) {
                    String key = rsmd.getColumnName(j);
                    String value = resultSet.getString(key);
                    record.put(key, value);
                }
                result.add(record);
            }
            System.out.println("结果行数："+result.size());
        } catch (CacheException ex) {
            System.out.println("Caught exception: " + ex.getClass().getName() + ": " + ex.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
