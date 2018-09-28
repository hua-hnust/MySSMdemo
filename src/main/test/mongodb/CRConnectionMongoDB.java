package mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.junit.Test;

/**
 * Created by xhua on 2018-09-28.
 * Describe:  低版本mongodb  CR认证方式连接
 */
public class CRConnectionMongoDB {

    @Test
    public void test(){

        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();

        builder.serverSelectionTimeout(2000);
        //连接池与数据库最大连接数  默认为100
        builder.connectionsPerHost(10);
        //连接超时设置
        builder.connectTimeout(2000);
        //空闲时间
        builder.maxConnectionIdleTime(60*1000);
        MongoClientOptions options = builder.build();

        //服务器 地址、端口
        ServerAddress serverAddress = new ServerAddress("172.19.1.96",27017);
        //换成CR认证方式
        MongoCredential credential = MongoCredential.createMongoCRCredential("admin","admin","123".toCharArray());
        MongoClient mongoClient = new MongoClient(serverAddress,credential,options);
        DB db = mongoClient.getDB("admin");
        String info = mongoClient.getConnectPoint();
        CommandResult commandResult= db.command("serverStatus");
        System.out.println("96连接成功");
        System.out.println("----------连接成功----------");

    }

}
