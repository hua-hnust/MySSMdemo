package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhua on 2018-11-05.
 * Describe:
 */
public class ArrayListWait {
    public void test(){
        List<Integer> list = new ArrayList<Integer>(16);
        list.add(new Integer(1));

        try {
            list.wait();
            list.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
