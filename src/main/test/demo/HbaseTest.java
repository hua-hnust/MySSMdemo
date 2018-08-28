package demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by xhua on 2018-08-18.
 * Describe:
 */
public class HbaseTest {

    @Test
    public void hbaseConectionTest(){
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        configuration.set("hbase.zookeeper.quorum", "172.19.1.20");
        configuration.set("hbase.master", "172.19.1.20:16010");

        try {
            System.out.println("start create table----");
            HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration);
            //如果表存在则删除
            if(hBaseAdmin.tableExists("user")){
                hBaseAdmin.disableTable("user");
                hBaseAdmin.deleteTable("user");
                System.out.println("table is exist,delete table----");
            }
            //创建表的字段
            HTableDescriptor tableDescriptor = new HTableDescriptor("user");
            tableDescriptor.addFamily(new HColumnDescriptor("id"));
            tableDescriptor.addFamily(new HColumnDescriptor("name"));
            tableDescriptor.addFamily(new HColumnDescriptor("age"));
            hBaseAdmin.createTable(tableDescriptor);
            System.out.println("create table sussess-----");
        } catch (IOException e) {
            System.out.println("create table fail-----");
        }

    }


    @Test
    public void testTableScan(){

        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        configuration.set("hbase.zookeeper.quorum", "172.19.1.20");
        configuration.set("hbase.master", "172.19.1.20:16010");

        try {
            HBaseAdmin hBaseAdmin = new HBaseAdmin(configuration);
            HTable table = new HTable(configuration,"user");
            Get get = new Get(Bytes.toBytes("test"));
            Result result = table.get(get);
            System.out.println("result:"+result);

            for(KeyValue keyValue : result.raw()){
                System.out.println("key:"+ new String(keyValue.getFamily()));
                System.out.println("value:"+new String(keyValue.getValue()));
            }

            System.out.println("--------------------------------");

            Scan scan = new Scan();
            ResultScanner scanner = table.getScanner(scan);
            for (Result resultScanner:scanner){
                for (KeyValue keyValue : resultScanner.raw()){
                    byte[] family = keyValue.getFamily();
                    System.out.println("key:"+new String(family));
                    System.out.println("value:"+new String(keyValue.getValue()));

                    System.out.println("key:"+family.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
