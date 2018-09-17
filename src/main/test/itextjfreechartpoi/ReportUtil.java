package itextjfreechartpoi;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
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
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtil extends PdfPageEventHelper {

    //PDF属性 长宽 文件 填充内容 字体
    private final int width = 2480;
    private final int height = 3508;
    //页边距
    private final float xMargin = 216;
    private final float yMargin = 144;
    //文件名
    private String filename;
    //文件流 前端下载
    private HttpServletResponse response;
    private Rectangle pageSize = new Rectangle(width, height);
    private Document document = new Document(this.pageSize, xMargin, xMargin, yMargin, yMargin);
    private Paragraph paragraph;
    private Font font;
    private BaseFont baseFont;

//    //构造函数
//    public ReportUtil(String filename,HttpServletResponse response){
//        this.filename = filename + ".pdf";
//        this.response = response;
//        // pdf 大小 像素
//        this.pageSize = new Rectangle(this.width,this.height);
//        //设置底色
//        this.pageSize.setBackgroundColor(new BaseColor(255,255,255));
//        // 设置 文件大小 边距
//        this.document = new Document(pageSize,this.xMargin,this.xMargin,this.yMargin,this.yMargin);
//        //填充内容
//        this.paragraph = new Paragraph();
//        try {
//            this.baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void creatPDF() {
        File fileName = new File("E://jfreechartFormat5.pdf");
        //Rectangle pagesize = new Rectangle(width, height);
        //后面四个参数为左右上下页边距 2.54 3.18   300dpi
//        Document document = new Document(pagesize,xMargin,xMargin,yMargin,yMargin);
        try {
            OutputStream out = new BufferedOutputStream(new FileOutputStream(fileName));
            PdfWriter writer = PdfWriter.getInstance(this.document, out);
            //设置页眉页脚  在打开文件和结束文件的时候发生
            PdfReportHeaderFooter pdfReportHeaderFooter = new PdfReportHeaderFooter();
            writer.setPageEvent(pdfReportHeaderFooter);

            this.document.addAuthor("JFreeChart");
            this.document.addSubject("Demonstration");
            this.document.open();

            //首页
            homePage();
            //新建一页
            this.document.newPage();

            drawText("数 据 库 状 态 监 控 报 告", 128, BaseColor.BLACK, 1, 344, 0, 160, 48);
            //基本信息标题
            drawText("数据库基本信息", 88, BaseColor.BLACK, 1, 0, 0, 110, 0);
            //基本信息表
            drawBaseInfoTable();

            emptyLine(3, this.document);
            //生命周期标题
            drawText("可用性（生命周期）", 88, BaseColor.BLACK, 1, 0, 0, 110, 0);
            drawBaseInfoTable();

            //换行
            emptyLine(3, this.document);
            drawText("Mysql活动状态", 88, BaseColor.BLACK, 1, 0, 0, 110, 0);

            JFreeChart chart = createJfreeChart();
            //A4大小为 2480 3508
            //显示像素问题   A4像素做了倍增
            saveChartAsPDF(chart);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //生成线图
    private JFreeChart createJfreeChart() {
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
            DateAxis dateAxis = (DateAxis) xyPlot.getDomainAxis();//x轴设置
            // x轴标题
            dateAxis.setLabelFont(xfont);
            // X轴坐标上数值字体
            dateAxis.setTickLabelFont(labelFont);

            //设置X轴显示间隔  间隔时间不能为0
            Long spiltTime = 4000L/1000/5;
            dateAxis.setTickUnit(new DateTickUnit(DateTickUnitType.SECOND, 12, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));

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

            XYItemRenderer renderer = xyPlot.getRenderer();
            //拐点是否可见
            renderer.setBaseSeriesVisible(true);

            for (int i = 0; i < dataset.getSeriesCount(); i++) {
                // 为每一条线设置加粗
                renderer.setSeriesStroke(i, new BasicStroke(6.0F));
            }
            return chart;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //构造数据
    private static TimeSeriesCollection createDataset() {

        Day day = new Day(21, 9, 2008);
        Hour hour = new Hour(22, day);
        Minute minute = new Minute(46, hour);
        // 创建基本数据
        TimeSeries xyseries = new TimeSeries("JAVA");
        TimeSeries xyseries1 = new TimeSeries("PHP");
        for (int i = 1; i <= 12; i++) {
            // 添加数据
            xyseries.add(new Second(i * 5, minute), i + 1);
            xyseries1.add(new Second(i * 5, minute), i + 1.2);
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(xyseries);
        timeSeriesCollection.addSeries(xyseries1);
        return timeSeriesCollection;
    }

    /**
     * 生成首页
     * log 用户名 导出时间 左下公司信息
     */
    private void homePage() {
        String imgurl = "E:\\ankki_logo.jpg";
        try {
            Image img = Image.getInstance(imgurl);
            if (img == null) {
                return;
            }
            img.scaleToFit(912.0f, 168.0f);
            img.setAlignment(1);
            Phrase phrase = new Phrase(new Chunk(img, 1168.0f, -600));
            this.document.add(phrase);
            drawText("________________________", 72, BaseColor.LIGHT_GRAY, 1, 1168, 0, 0, 500);
            drawText("come from : " + "admin", 72, BaseColor.BLACK, 1, 1168, 0, 0, 36);
            drawText("数据库状态监控报告", 72, BaseColor.BLACK, 1, 1168, 0, 0, 36);
            //导出时间
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy- MM- dd HH: mm: ss");
            String dateStr = dateFormat.format(date);
            drawText(dateStr, 72, BaseColor.BLACK, 0, 1168, 0, 0, 36);

            //左下角公司信息
            drawText("Shenzhen Ankki Technology Co.,ltd", 64, BaseColor.BLACK, 0, 272, 0, 0, 952);
            drawText("Website:www.ankki.com", 64, BaseColor.BLACK, 0, 320, 0, 0, 0);
            drawText("FAX:(86755)2698 0060", 64, BaseColor.BLACK, 0, 320, 0, 0, 0);
            drawText("TEL:(86755)2698 0059", 64, BaseColor.BLACK, 0, 320, 0, 0, 0);
            drawText("support@ankki.com", 64, BaseColor.BLACK, 0, 320, 0, 0, 0);

        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 换行
     * @param i        行数
     * @param document
     */
    private void emptyLine(int i, Document document) {
        if (i == 1) {
            try {
                document.add(new Paragraph("\n"));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        } else {
            for (int j = 0; j < i; j++) {
                try {
                    document.add(new Paragraph("\n"));
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 添加文字函数
     * @param contextStr 内容
     * @param size       字体大小
     * @param isBold     是否加粗
     * @param color      颜色
     * @param left       左缩进
     * @param right      右缩进
     * @param under      字体下方间距
     * @param down       下移
     */
    private void drawText(String contextStr, int size, BaseColor color, int isBold, int left, int right, int under, int down) throws Exception {
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont, size, isBold, color);
        Paragraph paragraph = new Paragraph(contextStr, font);
        paragraph.setIndentationLeft(left);
        paragraph.setIndentationRight(right);
        paragraph.setSpacingAfter(under);
        paragraph.setSpacingBefore(down);
        try {
            this.document.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**  绘制单元格
     * @param cellStr 单元格内容
     * @param display 是否显示边框
     * @param colspan 单元格列跨度
     * @param rowspan 单元格行跨度
     * @param table
     */
    private void drawTableCell(String cellStr, boolean display, int colspan, int rowspan, PdfPTable table) throws Exception {
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont, 56);
        //定义单元格
        PdfPCell cell = new PdfPCell(new Paragraph(cellStr, font));
        cell.setBorderWidth(1);
        //边框颜色
        cell.setBorderColor(new BaseColor(26, 26, 26));
        //是否显示边框
        if (!display) {
            cell.setBorderWidth(0);
        }
        //单元格跨度
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
        //设置单元格垂直居中
        cell.setVerticalAlignment(cell.ALIGN_MIDDLE);
        //设置单元格高度
        cell.setMinimumHeight(72);
        cell.setUseAscender(true);

        table.addCell(cell);
    }

    /**
     * 数据库基本信息表
     */
    private void drawBaseInfoTable() {
        PdfPTable table = new PdfPTable(7);
        //设置表格总宽度 宽度-页边距X2
        table.setTotalWidth(2048F);
        table.setLockedWidth(true);

        try {
            //TODO 数据库信息
            drawTableCell("IP", true, 1, 1, table);
            drawTableCell("172.19.1.12", true, 2, 1, table);
            drawTableCell("", false, 1, 1, table);
            drawTableCell("总空间", true, 1, 1, table);
            drawTableCell("1.3G", true, 2, 1, table);

            drawTableCell("端口", true, 1, 1, table);
            drawTableCell("3306", true, 2, 1, table);
            drawTableCell("", false, 1, 1, table);
            drawTableCell("版本", true, 1, 1, table);
            drawTableCell("5.7", true, 2, 1, table);

            drawTableCell("数据库类型", true, 1, 1, table);
            drawTableCell("mysql", true, 2, 1, table);
            drawTableCell("", false, 1, 2, table);
            drawTableCell("平台", true, 1, 2, table);
            drawTableCell("windows", true, 2, 2, table);

            drawTableCell("名称", true, 1, 1, table);
            drawTableCell("mysql5.7", true, 2, 1, table);
            this.document.add(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //将chart 保存为PDF
    private void saveChartAsPDF(JFreeChart chart) throws IOException {
        try {
            // TODO  chart保存为PNG再插入PDF
            BufferedImage bi = chart.createBufferedImage(this.width,this.height / 3);
            ByteArrayOutputStream out1 = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", out1);
            byte[] data = out1.toByteArray();
            Image image;
            image = Image.getInstance(data);
            image.scalePercent(90);
            image.setAlignment(Image.MIDDLE);
            this.document.add(image);
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.document.close();
    }
}