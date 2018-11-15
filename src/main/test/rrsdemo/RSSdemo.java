package rrsdemo;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * Created by xhua on 2018-10-26.
 * Describe:
 */
public class RSSdemo {

    /**
     * 根据链接地址得到数据
     *
     * @throws IllegalArgumentException
     * @throws FeedException
     */
    @Test
    public void parseXml() throws IllegalArgumentException, FeedException {

        String driverName = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/news";
        String user = "root";
        String password = "xhua";
        Statement st;
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库链接
            Connection connection = DriverManager.getConnection(dbUrl, user, password);
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
             st = connection.createStatement();

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

            //SQL 拼接，注意标题有空格和双引号，详情页面有样式、样式含有双引号
            for (int i = 0; i < entries.size(); i++) {
                SyndEntry entry = (SyndEntry) entries.get(i);
                String title =entry.getTitle().replace("\"","\\\\");
                SyndContent syndContent = entry.getDescription();
                String value = syndContent.getValue();
                stringBuilder.append("(").append("null").append(",");
                stringBuilder.append("\"").append(title.replaceAll(" ","")).append("\"").append(",");
                stringBuilder.append("\"").append(entry.getAuthor()).append("\"").append(",");
                stringBuilder.append("\"").append(sf.format(entry.getPublishedDate())).append("\"").append(",");
                stringBuilder.append("\"").append(value.replaceAll("\"","\\\\")).append("\"").append(",");
                stringBuilder.append("\"").append(entry.getLink()).append("\"").append(")").append(",");
            }
            //去掉最后一个逗号
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            st.execute(stringBuilder.toString());
            System.out.println("获取新闻成功：" + feed.getEntries().size()+"条");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
