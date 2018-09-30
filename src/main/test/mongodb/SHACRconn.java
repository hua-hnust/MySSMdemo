package mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

/**
 * Created by xhua on 2018-09-29.
 * Describe:
 */
public class SHACRconn {

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
        ServerAddress serverAddress = new ServerAddress("172.19.1.2", 27017);
        //换成CR认证方式
        MongoCredential credential = MongoCredential.createMongoCRCredential("authtest", "admin", "123".toCharArray());
        //sha认证
        MongoCredential sha1Credential = MongoCredential.createScramSha1Credential("authtest", "admin", "123".toCharArray());

        Document document = null;

        MongoClient crclient = new MongoClient(serverAddress, credential, options);
        MongoClient shaclient = new MongoClient(serverAddress, sha1Credential, options);

        try {
            MongoDatabase db = crclient.getDatabase("admin");
            document = db.runCommand(new BasicDBObject("serverStatus", Boolean.TRUE));
            Document connInfo = (Document) document.get("connections");
            System.out.println(connInfo.get("available"));
        } catch (Exception e1) {
            System.out.println("连接异常！");
            crclient.close();
            crclient = null;
            shaclient.getConnectPoint();
            MongoDatabase db = shaclient.getDatabase("admin");
            DB getDB = shaclient.getDB("admin");
            try {
                //旧的可执行serverStatus方法，返回没有权限错误信息
                CommandResult result = getDB.command("serverStatus");
                System.out.println(result.toMap());
                //新的方法直接不能执行次命令，抛出异常
                document = db.runCommand(new BasicDBObject("serverStatus", Boolean.TRUE));
                Document connInfo = (Document) document.get("connections");
                System.out.println(connInfo.get("available"));
            } catch (Exception e2) {
                shaclient.close();
                shaclient = null;
            }
        }
    }

}
