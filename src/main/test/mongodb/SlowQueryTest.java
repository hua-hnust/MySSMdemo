package mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * mongodb 慢查询
 * Created by Administrator on 2019/1/15.
 */
public class SlowQueryTest {

    @Test
    public void test() {
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();

        builder.serverSelectionTimeout(2000);
        //连接池与数据库最大连接数  默认为100
        builder.connectionsPerHost(10);
        //连接超时设置
        builder.connectTimeout(2000);
        //空闲时间
        builder.maxConnectionIdleTime(60 * 1000);
        MongoClientOptions options = builder.build();

        //服务器 地址、端口
        ServerAddress serverAddress = new ServerAddress("172.18.1.4", 27017);

        //sha认证
        MongoCredential sha1Credential = MongoCredential.createScramSha1Credential("root", "admin", "xhua".toCharArray());

        Document document = null;

        MongoClient shaclient = new MongoClient(serverAddress, sha1Credential, options);


        MongoDatabase db = shaclient.getDatabase("admin");
        DB getDB = shaclient.getDB("admin");
        try {
            CommandResult result = getDB.command("currentOp");
            Map<String,Object> status = result.toMap();
            List<Map<String,Object>> map1 = (List<Map<String,Object>>)status.get("inprog");

            for(Map<String,Object> map:map1){
                for (Map.Entry<String,Object> entry:map.entrySet()){
                    System.out.println(entry.getKey()+"---"+entry.getValue());
                }
            }

            DBObject cmdObj = new BasicDBObject("currentOp", Boolean.TRUE).append("op",new BasicDBObject(QueryOperators.NE,"command"));

            CommandResult ObjResult = getDB.command(cmdObj);
            Map<String,Object> ObjStatus = ObjResult.toMap();

            document = db.runCommand(new BasicDBObject("currentOp", Boolean.TRUE));
           List<Map<String,Object>> list = (List<Map<String,Object>>)document.get("inprog");

           for (Map<String,Object> map:list){
               Document document1 = (Document)map.get("clientMetadata");
               Long time = (Long)map.get("secs_running");
               System.out.println(document1.get("application"));
           }

//           int i =1;
//           for (Map<String,Object> map:list){
//               System.out.println("第几条语句："+i);
//               int k=1;
//             for(String key:map.keySet()){
//                 System.out.println("第几个属性："+k);
//                 System.out.println("key:"+key);
//                 System.out.println("value:"+map.get(key));
//                 k++;
//             }
//             i++;
//           }
        } catch (Exception e2) {
            shaclient.close();
            shaclient = null;
        }
    }
}
