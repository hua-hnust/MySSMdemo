package rrsdemo;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * Created by xhua on 2018-10-26.
 * Describe:
 */
public class RSSdemo {

    /**
     * 根据链接地址得到数据
     * @throws IllegalArgumentException
     * @throws FeedException
     */
    @Test
    public void parseXml() throws IllegalArgumentException, FeedException {

        try {
            URL url = new URL("http://www.people.com.cn/rss/world.xml");
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

            List entries = feed.getEntries();//得到所有的标题<title></title>

            for(int i=0; i < entries.size(); i++) {
                SyndEntry entry = (SyndEntry)entries.get(i);
                System.out.println(i+" :-------------");
                System.out.println("标题："+entry.getTitle());
                System.out.println("作者："+entry.getAuthor());
                System.out.println("发布时间："+entry.getPublishedDate());
                System.out.println("详情："+entry.getDescription());
            }
            System.out.println("feed size:" + feed.getEntries().size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
