package dateFormatDemo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xhua on 2018-11-09.
 * Describe:  时间戳格式化，用于删除分区
 */
public class DateFormatDemo {

    @Test
    public void test(){
        Long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String formateTime = sf.format(time);
        String dateFormat = sf.format(date);
        System.out.println(formateTime);
        System.out.println(dateFormat);
    }

}
