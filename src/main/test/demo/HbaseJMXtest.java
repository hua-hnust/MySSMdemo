package demo;

import net.sf.json.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * Created by xhua on 2018-08-18.
 * Describe:
 */
public class HbaseJMXtest {
    @Test
    public void hbaseJmxTest(){
        int code=0;
        String url = "http://172.19.1.20:16010/jmx";
        HttpGet httpGet = new HttpGet(url);
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpGet);
            code = response.getStatusLine().getStatusCode();
            String info = JSONObject.fromObject(EntityUtils.toString(response.getEntity())).getString("beans");
            System.out.println("连接成功:"+ code);
        }catch (Exception e){
            System.out.println("数据库连接失败:"+code);
        }

    }

}
