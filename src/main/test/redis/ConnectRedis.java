package redis;

import org.junit.Test;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2019/1/4.
 */
public class ConnectRedis {

    @Test
    public void test(){

          //普通连接方式
//        Jedis jedis = new Jedis("172.18.1.4",6379);
//        jedis.auth("xhua");
//        System.out.println(jedis.ping());
//        System.out.println(jedis.get("user"));

        //非切片池连接方式
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxIdle(10);
//        poolConfig.setMaxWaitMillis(1000L);
//        poolConfig.setMinIdle(2);
//        poolConfig.setMaxTotal(20);
//        Jedis jedis = null;
//        JedisPool pool = new JedisPool(poolConfig,"172.18.1.4",6379);
//        jedis = pool.getResource();
//        jedis.auth("xhua");
////        jedis.set("user","xhua");
//        jedis.set("age","23");
//        System.out.println(jedis.get("age"));


        //切片连接池
        ShardedJedisPool shardedJedisPool = null;
        //切片额客户端连接
        ShardedJedis shardedJedis = null;

        //切片池连接方式（分布式集群）
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(10);
        poolConfig.setMaxWaitMillis(1000L);
        poolConfig.setMinIdle(2);
        poolConfig.setMaxTotal(20);
        List<JedisShardInfo> infos = new ArrayList<JedisShardInfo>();
        //连接IP 端口
        JedisShardInfo info = new JedisShardInfo("172.18.1.4",6379);
        //密码
        info.setPassword("xhua");
        infos.add(info);
        shardedJedisPool = new ShardedJedisPool(poolConfig,infos);
        shardedJedis = shardedJedisPool.getResource();
        System.out.println(shardedJedis.get("user"));

    }
}
