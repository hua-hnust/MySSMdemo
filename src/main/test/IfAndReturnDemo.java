import org.junit.Test;

/**
 * Created by xhua on 2018-08-22.
 * Describe:
 */
public class IfAndReturnDemo {

    @Test
    public void ifAndReturnTest(){
        String re = returnString(20);
        System.out.println(re);
    }

    public String returnString(int i){
        if(i<3){
            return "小于3";
        }
        if(i>5){
            return "大于5";
        }
        if(i>10){
            return "大于10";
        }

        return "未知范围";
    }

}
