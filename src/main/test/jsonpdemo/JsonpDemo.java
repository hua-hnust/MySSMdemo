package jsonpdemo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by xhua on 2018-10-09.
 * Describe:
 */
public class JsonpDemo {

    @Test
    public void test(){
        try {
            Document document = Jsoup.connect("http://172.19.1.131:4040/environment/").get();
            Elements elements = document.getElementsByTag("td");

            //遍历获取指定的元素
            for(int i=0;i<elements.size();i++){
                if(elements.get(i).toString().contains("Java Home")){
                    System.out.println("Java Home:"+elements.get(i+1).toString());
                }
            }

            for (int j=0;j<elements.size();j++){
//                System.out.println(elements.get(j).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
