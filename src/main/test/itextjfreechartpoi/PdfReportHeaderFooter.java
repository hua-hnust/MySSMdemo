package itextjfreechartpoi;

/**
 * Created by xhua on 2018-09-03.
 * Describe:  设置PDF页眉页脚
 */
import java.io.IOException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfReportHeaderFooter extends PdfPageEventHelper {

    /**
     * 页眉
     */
    public String header = "『 Shenzhen Ankki Technology Co.,ltd 』";

    /**
     * 文档字体大小，页脚页眉最好和文本大小一致
     */
    public int presentFontSize = 56;

    /**
     * 文档页面大小，最好前面传入，否则默认为A4纸张
     */
    public Rectangle pageSize = PageSize.A4;

    // 模板
    public PdfTemplate pdfTemplate;

    // 基础字体对象
    public BaseFont baseFont = null;

    // 利用基础字体生成的字体对象，一般用于生成中文文字
    public Font font = null;

    /**
     * Creates a new instance of PdfReportM1HeaderFooter 无参构造方法.
     */
    public PdfReportHeaderFooter() {

    }

    /**
     *
     * Creates a new instance of PdfReportM1HeaderFooter 构造方法.
     *
     * @param yeMei
     *            页眉字符串
     * @param presentFontSize
     *            数据体字体大小
     * @param pageSize
     *            页面文档大小，A4，A5，A6横转翻转等Rectangle对象
     */
    public PdfReportHeaderFooter(String yeMei, int presentFontSize, Rectangle pageSize) {
        this.header = yeMei;
        this.presentFontSize = presentFontSize;
        this.pageSize = pageSize;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setPresentFontSize(int presentFontSize) {
        this.presentFontSize = presentFontSize;
    }

    /**
     * TODO 文档打开时创建模板
     */
    @Override
    public void onOpenDocument(PdfWriter writer, Document document) {
        // 共 页 的矩形的长宽高
        pdfTemplate = writer.getDirectContent().createTemplate(128, 64);
    }

    /**
     * TODO 关闭每页的时候，写入页眉，写入'第几页共'这几个字。
     */
    @Override
    public void onEndPage(PdfWriter writer, Document document) {

        try {
            if (baseFont == null) {
                baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
            }
            if (font == null) {
                font = new Font(baseFont, presentFontSize, Font.NORMAL, BaseColor.BLACK);// 字体
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2.写入前半部分的 第 X页/共
        int pageS = writer.getPageNumber();
        String foot1 = "第 " + pageS + " 页 /共";
        Phrase footer = new Phrase(foot1, font);

        //首页不需要设置页眉
        if (pageS>=2){
            // 1.写入页眉
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase(header, font),document.left() + 552 , document.top(), 0);
        }

        // 3.计算前半部分的foot1的长度，后面好定位最后一部分的'Y页'这俩字的x轴坐标，字体长度也要计算进去 = len
        float len = baseFont.getWidthPoint(foot1, presentFontSize);

        // 4.拿到当前的PdfContentByte
        PdfContentByte cb = writer.getDirectContent();

        //自己增加的
        if(pageS==1){
            Phrase footerLeft = new Phrase("978-1-4799-0530-031.00 ©2013 IEEE", font);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, footerLeft, document.left(), document.bottom() - 80F, 0);
        }

        // 5.写入页脚1，x轴就是(右margin+左margin + right() -left()- len)/2.0F 再给偏移20F适合人类视觉感受，否则肉眼看上去就太偏左了 ,y轴就是底边界-20,否则就贴边重叠到数据体里了就不是页脚了；注意Y轴是从下往上累加的，最上方的Top值是大于Bottom好几百开外的。
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer, (document.rightMargin() + document.right() + document.leftMargin() - document.left() - len) / 2.0F + 80F, document.bottom() - 80F, 0);

        // 6.写入页脚2的模板（就是页脚的Y页这俩字）添加到文档中，计算模板的和Y轴,X=(右边界-左边界 - 前半部分的len值)/2.0F + len ， y 轴和之前的保持一致，底边界-20
        cb.addTemplate(pdfTemplate, (document.rightMargin() + document.right() + document.leftMargin() - document.left()) / 2.0F + 80F, document.bottom() - 80F); // 调节模版显示的位置

    }

    /**
     * TODO 关闭文档时，计算文档总页数，替换模板，完成整个页眉页脚组件
     */
    @Override
    public void onCloseDocument(PdfWriter writer, Document document) {
        // 7.最后一步了，就是关闭文档的时候，将模板替换成实际的 Y 值,至此，page x of y 制作完毕，完美兼容各种文档size。
        pdfTemplate.beginText();
        // 生成的模版的字体、颜色
        pdfTemplate.setFontAndSize(baseFont, presentFontSize);
        String foot2 = " " + (writer.getPageNumber()) + " 页";
        // 模版显示的内容
        pdfTemplate.showText(foot2);
        pdfTemplate.endText();
        pdfTemplate.closePath();
    }
}
