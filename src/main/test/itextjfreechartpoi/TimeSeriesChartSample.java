package itextjfreechartpoi;

import com.itextpdf.awt.AsianFontMapper;
import com.itextpdf.awt.FontMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.math.stat.descriptive.rank.Min;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.*;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Created by xhua on 2018-09-04.
 * Describe:
 */
public class TimeSeriesChartSample {

    @Test
    public void timeSeriesChartSample() {

        try {
            TimeSeriesCollection dataset = createDataset();
            JFreeChart chart = ChartFactory.createTimeSeriesChart("水果", "时间", "参数（次/S）", dataset, true, true, false);
            XYPlot xyPlot = chart.getXYPlot();
            xyPlot.setBackgroundPaint(Color.WHITE); // 设置绘图区背景色

            // 设置图片中的字体以及字号
            java.awt.Font titleFont = new java.awt.Font(java.awt.Font.SANS_SERIF, com.itextpdf.text.Font.BOLD, 72);
            java.awt.Font xfont = new java.awt.Font(java.awt.Font.SANS_SERIF, com.itextpdf.text.Font.BOLD, 60);
            java.awt.Font labelFont = new java.awt.Font(java.awt.Font.SANS_SERIF, com.itextpdf.text.Font.BOLD, 44);

            // 底部折线名称字体
            chart.getLegend().setItemFont(new java.awt.Font("黑体", com.itextpdf.text.Font.BOLD, 60));
            // 设置标题字体
            chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));
            // x轴
            DateAxis dateAxis = (DateAxis)xyPlot.getDomainAxis();//x轴设置
            // x轴标题
            dateAxis.setLabelFont(xfont);
            // X轴坐标上数值字体
            dateAxis.setTickLabelFont(labelFont);

            //设置X轴显示间隔
            dateAxis.setTickUnit(new DateTickUnit(DateTickUnitType.SECOND,12,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));

            //最左边和右边点距离边线位置
            dateAxis.setUpperMargin(0.0);
            dateAxis.setLowerMargin(0.0);

            // y轴
            ValueAxis rangeAxis = xyPlot.getRangeAxis();
            // y轴标题
            rangeAxis.setLabelFont(xfont);
            // y轴坐标上数值字体
            rangeAxis.setTickLabelFont(labelFont);

            xyPlot.setRangeGridlinePaint(Color.LIGHT_GRAY); // 设置水平方向背景线颜色
            xyPlot.setRangeGridlinesVisible(true);// 设置是否显示水平方向背景线,默认值为true
            xyPlot.setDomainGridlinePaint(Color.LIGHT_GRAY); // 设置垂直方向背景线颜色
            xyPlot.setDomainGridlinesVisible(true); // 设置是否显示垂直方向背景线,默认值为false

            XYItemRenderer renderer =  xyPlot.getRenderer();
            //拐点是否可见
            renderer.setBaseSeriesVisible(true);

            System.out.println("线的条数："+dataset.getSeriesCount());
            for (int i = 0; i < dataset.getSeriesCount(); i++) {
                // 为每一条线设置加粗
                renderer.setSeriesStroke(i, new BasicStroke(6.0F));
            }

            File fileName = new File("E://jfreechartFormat10.pdf");
            //A4大小为 2480 3508   使用itext 的 FontMapper 解决绘图中文不能显示问题
            //显示像素问题   A4像素做了倍增
            saveChartAsPDF(fileName, chart, 2480, 3508, new AsianFontMapper("STSong-Light", "UniGB-UCS2-H"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //将chart 保存为PDF
    private void saveChartAsPDF(File file, JFreeChart chart,
                                int width, int height, FontMapper mapper) throws IOException {
        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        com.itextpdf.text.Rectangle pagesize = new com.itextpdf.text.Rectangle(width, height);
        //后面四个参数为左右上下页边距 2.54 3.18   300dpi
        Document document = new Document(pagesize,216,216,144,144);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, out);
            //设置页眉页脚
            PdfReportHeaderFooter pdfReportHeaderFooter = new PdfReportHeaderFooter();
            writer.setPageEvent(pdfReportHeaderFooter);

            document.addAuthor("JFreeChart");
            document.addSubject("Demonstration");
            document.open();

            // TODO  chart保存为PNG再插入PDF
            BufferedImage bi = chart.createBufferedImage(width-216, height/3);
            ByteArrayOutputStream out1 = new ByteArrayOutputStream();
            ImageIO.write(bi,"png", out1);
            byte[] data = out1.toByteArray();
            com.itextpdf.text.Image image;
            image = com.itextpdf.text.Image.getInstance(data);
            image.scalePercent(90);
            image.setAlignment(com.itextpdf.text.Image.MIDDLE);
            document.add(image);

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
        out.close();
    }


    private static TimeSeriesCollection createDataset() {

        Day day = new Day(21, 9, 2008);
        Hour hour = new Hour(22, day);
        Minute minute = new Minute(46,hour);
        // 创建基本数据
        TimeSeries xyseries = new TimeSeries("JAVA");
        TimeSeries xyseries1 = new TimeSeries("PHP");
        for (int i = 1; i <= 12; i++) {
            // 添加数据
            xyseries.add(new Second(i*5,minute),i+1);
            xyseries1.add(new Second(i*5,minute),i+1.2);
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(xyseries);
        timeSeriesCollection.addSeries(xyseries1);
        return timeSeriesCollection;
    }

}
