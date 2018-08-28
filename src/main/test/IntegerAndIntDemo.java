import org.junit.Test;

/**
 * Created by xhua on 2018-08-18.
 * Describe:
 */
public class IntegerAndIntDemo {
    @Test
    public void testIntegerAndInt(){
        int i = 200;
        Integer k = new Integer(200);
        if (i==k){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }

}
