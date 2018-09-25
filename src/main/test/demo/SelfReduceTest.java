package demo;

/**
 * Created by xhua on 2018-09-01.
 * Describe:  先加后加运算
 */
public class SelfReduceTest {
    @org.junit.Test
    public void testSelfReduce(){
        int y=2;
        System.out.println(y--);
        System.out.println(--y);
    }

}
