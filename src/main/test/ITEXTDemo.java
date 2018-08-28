import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by hua on 2018-04-16.
 * Describe:
 */
public class ITEXTDemo {
    public static void createPDF(OutputStream os,List<Object> list){
        Document document = new Document(PageSize.A4,36,36,126,36);
        try {
            //添加中文字体
            BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            //设置字体样式
            Font textFont = new Font(bfChinese,12,Font.NORMAL);//正常
            Font boldFont = new Font(bfChinese,11,Font.BOLD); //加粗
            Font firsetTitleFont = new Font(bfChinese,22,Font.BOLD); //一级标题
            Font secondTitleFont = new Font(bfChinese,15,Font.BOLD); //二级标题
            Font underlineFont = new Font(bfChinese,11,Font.UNDERLINE); //下划线斜体

            PdfWriter pdfWriter = PdfWriter.getInstance(document,os);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
