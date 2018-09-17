package itextjfreechartpoi;

import org.junit.Test;

/**
 * Created by xhua on 2018-09-13.
 * Describe:
 */
public class IllgealArumentExceptionDemo {
    @Test
    public void test(){
        Long start = 0L;
        Long end =0L;
        Long spilt = (end - start)/1000/5;
        System.out.println(spilt);
    }

}
