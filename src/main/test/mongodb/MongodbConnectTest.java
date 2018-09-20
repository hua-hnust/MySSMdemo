package mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhua on 2018-07-31.
 * Describe:
 */
public class MongodbConnectTest {

    @Test
    public void connectTest(){

        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.serverSelectionTimeout(2000);
        builder.connectionsPerHost(1);
        builder.threadsAllowedToBlockForConnectionMultiplier(1);
        builder.connectTimeout(2000);
        builder.maxWaitTime(2000);
        builder.socketTimeout(2000);
        builder.maxConnectionIdleTime(60*1000);

        MongoClientOptions options = builder.build();


        //IP  端口
        ServerAddress serverAddress = new ServerAddress("172.19.1.241",27017);
        List<ServerAddress> aList = new ArrayList<ServerAddress>();
        aList.add(serverAddress);

        //用户名 数据库 密码
        MongoCredential credential = MongoCredential.createCredential("root","admin","Ceshi123".toCharArray());
        List<MongoCredential> cList = new ArrayList<MongoCredential>();
        cList.add(credential);

        MongoClient mongoClient = new MongoClient(aList,cList,options);

        try{

            MongoIterable<String> mongoIterable = mongoClient.listDatabaseNames();
            while (mongoIterable.iterator().hasNext()){
                System.out.println(mongoIterable.iterator().next());
            }

            DB db = mongoClient.getDB("admin");
            CommandResult commandResult = db.command("serverStatus");
//            System.out.println(commandResult);
        }catch (Exception e){
            e.printStackTrace();
            mongoClient.close();
            mongoClient = null;
        }finally {
            mongoClient.close();
            mongoClient = null;
        }
    }

}
