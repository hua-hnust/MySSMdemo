package mongodb;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.BSON;
import org.bson.BasicBSONObject;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhua on 2018-09-19.
 * Describe:
 */
public class MongodbDemo {
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
        ServerAddress serverAddress = new ServerAddress("172.19.1.2",27017);
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);
        //三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential("root","admin","Ceshi123".toCharArray());
        List<MongoCredential> mcList = new ArrayList<MongoCredential>();
        mcList.add(credential);

        MongoClient mongoClient = new MongoClient(addrs,mcList,options);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("mydb");
        System.out.println("----------连接成功----------");

        //获取所有数据库
        MongoIterable<String> databases = mongoClient.listDatabaseNames();
        System.out.println("数据库列表：");
        for (String dbname:databases){
            System.out.println(dbname);
        }

        //删库
//        mongoClient.getDatabase("").drop();

        //获取所有集合名称
        MongoIterable<String> cols = mongoDatabase.listCollectionNames();
        System.out.println("集合列表：");
        for(String colname:cols){
            System.out.println(colname);
        }

        //创建集合
        //mongoDatabase.createCollection("test2");
        MongoCollection<Document> collection = mongoDatabase.getCollection("test");
        System.out.println("选择集合test成功");
        //插入文档
//        Document document = new Document("name","小明").append("sex","男").append("age",23);
//        Document document1 = new Document("name","小红").append("sex","女").append("age",19);
//        Document document2 = new Document("name","小丽").append("sex","女").append("age",20).append("city","深圳");
//        List<Document> documents = new ArrayList<Document>();
//        documents.add(document);
//        documents.add(document1);
//        collection.insertMany(documents);
//        collection.insertOne(document2);

        //删除符合条件的第一个文档
//        collection.deleteOne(Filters.eq("name","小明"));
        //将集合中name=小明的集合的age set为22
//        collection.updateMany(Filters.eq("name","小明"),new Document("$set",new Document("age","22")));

        //遍历文档
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }


        //排序  1为升序  -1为降序
        BasicDBObject sortBosn = new BasicDBObject("age",1);
        FindIterable<Document> sort = collection.find().sort(sortBosn);
        MongoCursor<Document> mongoCursor1 = sort.iterator();
        System.out.println("排序后的集合：");
        while (mongoCursor1.hasNext()){
            System.out.println(mongoCursor1.next());
        }

        BasicDBObject searchBSON = new BasicDBObject("name","小明");
        FindIterable<Document> findIterable1 = collection.find(searchBSON);
        MongoCursor<Document> mongoCursor3 = findIterable1.iterator();
        System.out.println("匹配集合某个值：");
        while (mongoCursor3.hasNext()){
            System.out.println(mongoCursor3.next());
        }

        //条件查询  $gte/$lte/$gt/$lt
        BasicDBObject filter = new BasicDBObject();
        filter.append("age",new BasicDBObject("$gte",20));
        FindIterable<Document> sortAndFilter = collection.find(filter).sort(sortBosn);
        MongoCursor<Document> mongoCursor2 = sortAndFilter.iterator();
        System.out.println("条件查询后的集合：");
        while (mongoCursor2.hasNext()){
            System.out.println(mongoCursor2.next());
        }

        //多条件查询
        BasicDBObject searchObject = new BasicDBObject().append(QueryOperators.AND,new BasicDBObject[]{
                new BasicDBObject("age",new BasicDBObject(QueryOperators.GT,19)),
                new BasicDBObject("age",new BasicDBObject(QueryOperators.LTE,23))
        });
        FindIterable<Document> sortAndFilter1 = collection.find(searchObject).sort(sortBosn);
        MongoCursor<Document> mongoCursor4 = sortAndFilter1.iterator();
        System.out.println("多条件查询后的集合：");
        while (mongoCursor4.hasNext()){
            System.out.println(mongoCursor4.next());
        }

        // in
        BasicDBObject basicDBObject = new BasicDBObject().append("age",new BasicDBObject(
                QueryOperators.IN,new int[]{19,23}
        ));
        FindIterable<Document> sortAndFilter2 = collection.find(basicDBObject);
        MongoCursor<Document> mongoCursor5 = sortAndFilter2.iterator();
        System.out.println("in查询：");
        while (mongoCursor5.hasNext()){
            System.out.println(mongoCursor5.next());
        }

        //分页查询  start  limit
        FindIterable<Document> sortAndFilter3 = collection.find().skip(0).limit(2);
        MongoCursor<Document> mongoCursor6 = sortAndFilter3.iterator();
        System.out.println("分页查询：");
        while (mongoCursor6.hasNext()){
            System.out.println(mongoCursor6.next());
        }


        mongoClient.close();

    }

}
