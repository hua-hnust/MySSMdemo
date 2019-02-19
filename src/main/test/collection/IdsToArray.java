package collection;

import com.hnust.hua.model.Students;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  对象数组转List
 * Created by Administrator on 2019/2/15.
 */
public class IdsToArray {

    @Test
    public void test(){
        Students[] stus = new Students[2];
        Students stu1 = new Students();
        stu1.setName("小红");
        Students stu2 = new Students();
        stu2.setName("小花");

        stus[0] = stu1;
        stus[1] = stu2;

        List<Students> list = Arrays.asList(stus);
        List<Students> list1 = new ArrayList<Students>(Arrays.asList(stus));
        List<Students> list2 = new ArrayList<Students>();
        list2.addAll(Arrays.asList(stus));

        list.forEach(stu ->{

        });

        list1.forEach(stu->{

        });

        list2.forEach(stu->{

        });


        for (int i=0;i<list.size();i++){
            System.out.println("--- --- ---"+list.get(i).getName());
        }
    }
}
