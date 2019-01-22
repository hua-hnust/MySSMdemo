package baseTypeDemo;

import org.junit.Test;

import java.text.DecimalFormat;

/**  保留两位小数测试
 * Created by Administrator on 2018/12/12.
 */
public class KeepTwoPoint {

    @Test
    public void test(){
        Double i = 123456.0;
        Double k = 321.0;
        Double point = i/k;
        System.out.println(point);

        DecimalFormat df = new DecimalFormat("#0.00");
        String value = df.format(point);
        System.out.println(value);

        String dk ="0";
        Double dkf = Double.parseDouble(dk);

        if (dkf==0){
            System.out.println("double == 0");
        }else {
            System.out.println("please format");
        }
    }
}
