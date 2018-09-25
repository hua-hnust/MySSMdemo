package itextjfreechartpoi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xhua on 2018-09-13.
 * Describe: 初始化list大小
 */
public class ListSizeDemo {
    @Test
    public void test(){
        List<Date> dataList = new ArrayList<Date>();
        System.out.println(dataList.size());
        dataList.add(new Date());
        System.out.println(dataList.size());
    }

}
