package dateFormatDemo;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**   UTC时间转换
 * Created by Administrator on 2019/1/17.
 */
public class UTCdemo {
    @Test
    public void test(){
        String utcStr = "2019-01-17T15:33:38.409+0800";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        TimeZone utcZone = TimeZone.getTimeZone("UTC");
        sf.setTimeZone(utcZone);
        Date date = null;
        String dataTime = "";
        try {
            date = sf.parse(utcStr);
            dataTime = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dataTime);
    }
}
