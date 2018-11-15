package dateFormatDemo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xhua on 2018-11-12.
 * Describe: 获取时间戳第二天的开始时间
 */
public class GetSecendDay {

    @Test
    public void test(){
        Long time = System.currentTimeMillis();
        SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd");
        String s = sf.format(time);
        Date data = new Date(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        data = calendar.getTime();
        String time1 = sf.format(data);
//        Timestamp timestamp = Timestamp.valueOf(time1);
        System.out.println(time);
        System.out.println(data.getTime());

    }

    @Test
    public void test2(){
        Long time = System.currentTimeMillis();
        Calendar calendar =Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Date date = calendar.getTime();
        Long time2 = date.getTime();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(time2));
        System.out.println(time2);
    }
}
