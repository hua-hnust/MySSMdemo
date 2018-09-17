package itextjfreechartpoi;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xhua on 2018-09-05.
 * Describe:
 */
public class TimeFormatDemo {

    @Test
    public void timeFormatDemoTest(){
        //将时间戳转换成标准格式字符串
        Date date = new Date(new Long("1536127872000"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = df.format(date);
        System.out.println(dateStr);
        //截取字符串取年月日
        int year = Integer.parseInt(dateStr.substring(0,4));
        int month = Integer.parseInt(dateStr.substring(5,7));
        System.out.println(dateStr.substring(5,7));
        int day = Integer.parseInt(dateStr.substring(8,10));
        System.out.println(dateStr.substring(8,10));
        int hour = Integer.parseInt(dateStr.substring(11,13));
        int minute = Integer.parseInt(dateStr.substring(14,16));
        int second  = Integer.parseInt(dateStr.substring(17,19));
        System.out.println("年:"+year);
        System.out.println("月:"+month);
        System.out.println("日:"+day);
        System.out.println("时:"+hour);
        System.out.println("分:"+minute);
        System.out.println("秒:"+second);

    }

}
