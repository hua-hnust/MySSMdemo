package mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import net.sf.json.JSONObject;
import org.bson.Document;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by xhua on 2018-10-17.
 * Describe:
 */
public class TestMongoDb {

    @Test
    /***
     * 没有密码的连接情况
     */
    public void testMongodb() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("172.19.1.22", 27017);
            String info = mongoClient.getConnectPoint();

            if (info ==null)
            {
                System.out.println("连接失败！");
            }else{
                System.out.println("连接成功");
            }

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
            Document document = mongoDatabase.runCommand(new BasicDBObject("serverStatus", Boolean.TRUE));

            Document doc = (Document) document.get("connections");
            System.out.println(doc.get("available"));
            mongoClient.close();
            mongoClient = null;

            boolean b =true;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


}
