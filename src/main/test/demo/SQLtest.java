package demo;

import org.junit.Test;

/**
 * Created by hua on 2018-04-18.
 * Describe:
 */
public class SQLtest {
    @Test
    public void sqlTest(){
        int[] ids ={3,4,2,1,5};
        String sqlStr = "update db_sort set sort = case db_config_id ";
        for (int i=0;i<ids.length;i++){
           sqlStr += "when " + ids[i] + " then '" + (i+1) + "' ";
        }
        sqlStr +="end";
        System.out.println(sqlStr);
    }

}
