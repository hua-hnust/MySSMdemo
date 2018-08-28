import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hua on 2018-04-11.
 * Describe:字符串截取
 */
public class StringToArray {

    @Test
    public void stringToArrayTest(){
        String str = "1,2,3";
        String[] ids = str.split(",");
        List<Integer> list = new ArrayList<Integer>();
        for(String id:ids){
            list.add(Integer.valueOf(id));
        }
        System.out.println(list.toString());
    }

}
