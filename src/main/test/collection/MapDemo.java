package collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**  map 有key无key的get测试，返回值处理
 * Created by Administrator on 2018/12/5.
 */
public class MapDemo {

    @Test
    public void test(){
        HashMap<String,String> map = new HashMap<String, String>();
        //有key无值
        map.put("cat",null);
        map.put("dog","xyz");

        System.out.println(map.get("cat"));
        System.out.println(map.get("dog"));
        System.out.println(map.get("bird"));

        System.out.println("---------");

        String cat = mapHasValue(map,"cat");
        String dog = mapHasValue(map,"dog");
        String bird = mapHasValue(map,"dird");

        System.out.println(cat);
        System.out.println(dog);
        System.out.println(bird);

    }

    // 用于 map 返回值的处理，如果map有key无value 则返回 -
    // 用于区分 有key为null 和 无 key 的情况
    public String mapHasValue(HashMap<String,String> map,String key){
        if (map.containsKey(key)&&map.get(key)==null){
            return "-";
        }else if (!map.containsKey(key)){
            return null;
        }else if (map.get(key)!=null){
            return map.get(key);
        }
        return null;
    }
}
