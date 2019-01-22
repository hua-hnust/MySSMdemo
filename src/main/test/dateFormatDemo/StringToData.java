package dateFormatDemo;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**  精确到毫秒级的字符串时间戳转换
 * Created by Administrator on 2019/1/15.
 */
public class StringToData {

    @Test
    public void test(){
        try {
            String timeStr = "2019-01-12 10:31:54.853";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date date = simpleDateFormat.parse(timeStr);
            long ts = date.getTime();
            System.out.println(ts);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
