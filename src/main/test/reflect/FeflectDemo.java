package reflect;

import com.hnust.hua.model.Students;
import com.hnust.hua.util.ReflectUtil;
import org.junit.Test;

/**  反射工具类测试
 * Created by Administrator on 2019/2/13.
 */
public class FeflectDemo {

    @Test
    public void test(){
        Students students = new Students();
        ReflectUtil.setValueByFieldName(students,"name","小明");
        ReflectUtil.setValueByFieldName(students,"sex","男");
        ReflectUtil.setValueByFieldName(students,"age",23);
        System.out.println(ReflectUtil.getValueByFieldName(students,"name"));
        System.out.println(ReflectUtil.getValueByFieldName(students,"sex"));
        System.out.println(ReflectUtil.getValueByFieldName(students,"age"));
    }
}
