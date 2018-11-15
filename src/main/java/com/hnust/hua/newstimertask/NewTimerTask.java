package com.hnust.hua.newstimertask;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;

/**
 * Created by xhua on 2018-10-30.
 * Describe:
 */

@Service(value = "newTimerTask")
public class NewTimerTask {

    private static ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("newTimerTask").build();

    // 核心线程数，最大线程数，空闲时间，秒，等待策略，
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,2, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),factory,new ThreadPoolExecutor.AbortPolicy());

    //TODO 遍历XML表，启动多线程，将线程放入线程池中获取，数据库配置独立出来

    public void getNews(){

        try {
            URL url = new URL("http://www.people.com.cn/rss/finance.xml");
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = null;
            URLConnection conn;
            conn = url.openConnection();
            String content_encoding = conn.getHeaderField("Content-Encoding");

            if (content_encoding != null && content_encoding.contains("gzip")) {
                System.out.println("conent encoding is gzip");
                GZIPInputStream gzin = new GZIPInputStream(conn
                        .getInputStream());
                feed = input.build(new XmlReader(gzin));
            } else {
                feed = input.build(new XmlReader(conn.getInputStream()));
            }

            List entries = feed.getEntries();

            String tableName = "people";
            StringBuilder stringBuilder = new StringBuilder("INSERT INTO ");
            stringBuilder.append(tableName).append(" VALUES");

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for(int i=0; i < entries.size(); i++) {
                SyndEntry entry = (SyndEntry)entries.get(i);

                stringBuilder.append("(").append("\"").append(entry.getTitle()).append("\"").append(",");
                stringBuilder.append("\"").append(entry.getAuthor()).append("\"").append(",");
                stringBuilder.append("\"").append(sf.format(entry.getPublishedDate())).append("\"").append(",");
                stringBuilder.append("\"").append(entry.getDescription().toString()).append("\"").append(",");
                stringBuilder.append("\"").append(entry.getLink()).append("\"").append(")").append(",");


//                System.out.println(i+" :-------------");
//                System.out.println("标题："+entry.getTitle());
//                System.out.println("作者："+entry.getAuthor());
//                System.out.println("发布时间："+sf.format(entry.getPublishedDate()));
//                System.out.println("详情："+entry.getDescription().getValue());
//                System.out.println("链接："+entry.getLink());
            }
            //去掉最后一个逗号
            stringBuilder.deleteCharAt(stringBuilder.length()-1);

            System.out.println("feed size:" + feed.getEntries().size());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FeedException e) {
            e.printStackTrace();
        }

    }

}
