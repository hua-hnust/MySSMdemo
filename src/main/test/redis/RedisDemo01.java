package redis;

import org.junit.Test;

/**
 * Created by Administrator on 2018/12/28.
 */
public class RedisDemo01 {

    @Test
    public void test(){
        RedisClient redisClient = new RedisClient();
        redisClient.show();
    }
}
