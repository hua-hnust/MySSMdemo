import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hua on 2018-04-16.
 * Describe:
 */
public class ListGetClassTest {

    @Test
    public void testGetClassTets(){
        PersonDemo p1 =new PersonDemo();
        p1.setName("张三");
        p1.setAge(20);
        p1.setSex("男");

        List<PersonDemo> list = new ArrayList<PersonDemo>();
        list.add(p1);
        list.add(p1);
        list.add(p1);
        for(int i=0;i<list.size();i++){
            Class listClass = list.get(i).getClass();
            Object obj = list.get(i);
            Method[] methods = listClass.getMethods();
            for(Method method:methods){
                String name =method.getName();
                System.out.println(name);
            }
        }

    }

}
