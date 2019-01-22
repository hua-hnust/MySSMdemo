package collection;

import org.junit.Test;

/**   字符串截取测试
 * Created by Administrator on 2018/12/10.
 */
public class CutStringDemo {

    @Test
    public void test(){
        String str = "^[\"^^c:\\intersystems\\trycache\\mgr\\\"]%SYS(\"CSP\",\"Daemon\")";
        String cutStr = str.substring(str.indexOf("[")+4,str.indexOf("]")-1);
        System.out.println(cutStr);

        String taskRate = "SELECT count(*) FROM  %SYSTEM.TaskHistory where Error='Success',SELECT count(*) FROM  %SYSTEM.TaskHistory";
        String[] arr = taskRate.split(",");
        for (String sql:arr){
            System.out.println(sql);
        }


        String memorySQL = "SYSTEM.Config.SharedMemoryHeap,GetMaxConsumerID,GetDescription,GetUsage";
        String[] sqlArr = memorySQL.split(",");
        for (String sql:sqlArr){
            System.out.println(sql);
        }
    }
}
