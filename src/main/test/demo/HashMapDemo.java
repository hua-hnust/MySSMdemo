package demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhua on 2018-09-21.
 * Describe:
 */
public class HashMapDemo {

    @Test
    public void test(){
        try {
            Map<String,Object> map = new HashMap<String, Object>(16);
            map.put("hello","hello");
            map.put("nihao","nihao");
            System.out.println(map.get("test").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
