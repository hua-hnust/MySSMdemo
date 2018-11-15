package collection;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xhua on 2018-11-14.
 * Describe: 在while语句中赋值
 */
public class StringDemo {

    @Test
    public void test(){
        String[] arr ={"w","e","r","t"};
        String str = null;
        int i=0;
        //当while读到最后一个再循环回去数组越界
        while ((str=arr[i])!=null){
            str=arr[i];
            i++;
        }
        System.out.println(str);
    }

    @Test
    public void test2(){
        try {
            Process ps = Runtime.getRuntime().exec("ipconfig");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            String line = null;
            String[] arr = null;
//            StringBuilder result = new StringBuilder();
            while ((line=bufferedReader.readLine())!=null){
                arr = line.split("\\s+");
                for (int i =0;i<arr.length;i++){
                    System.out.println(arr[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
