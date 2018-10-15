package mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import org.springframework.orm.jpa.vendor.Database;

/**
 * Created by xhua on 2018-09-28.
 * Describe:
 */
public class URLConnectionMongodb {

    @Test
    public void test(){

        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();

        builder.serverSelectionTimeout(2000);
        //连接池与数据库最大连接数  默认为100
        builder.connectionsPerHost(10);
        //连接超时设置
        builder.connectTimeout(5000);
        //空闲时间
        builder.maxConnectionIdleTime(60*1000);
//        MongoClientOptions options = builder.build();

        String url = "mongodb://admin:ceshi123@172.19.1.96:27017/admin?AutoConnectRetry=true";
        MongoClientURI mongoClientURI = new MongoClientURI(url,builder);
        MongoClient mongoClient = new MongoClient(mongoClientURI);

        MongoDatabase db = mongoClient.getDatabase("admin");
        //不能执行
        Document document = db.runCommand(new BasicDBObject("serverStatus",Boolean.TRUE));
        Document connectionInfo = (Document) document.get("connections");
        System.out.println("可用连接："+connectionInfo.get("available"));

//        DB db = mongoClient.getDB("admin");
        //URL连接方式不能执行下面的命令
//        db.command("serverStatus");
        System.out.println("96连接成功");

//        "mongodb://username:password@mongoserver1:34001,mongoserver2:34001,mongoserver3:34001/dbname?AutoConnectRetry=true";

        String url2 = "mongodb://root:Ceshi123@172.19.1.2:27017/admin?AutoConnectRetry=true";
        MongoClientURI mongoClientURI2 = new MongoClientURI(url2,builder);
        MongoClient mongoClient2 = new MongoClient(mongoClientURI2);
        mongoClient2.getDatabase("mydb");
        System.out.println("2连接成功");

    }

}
