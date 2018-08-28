package demo;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * Created by hua on 2018-04-16.
 * Describe:
 */
public class PDFUtil {

    public static PdfPCell getPDFCell(String string,Font font){
        PdfPCell cell = new PdfPCell(new Paragraph(string,font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //设置最小单元格高度
        cell.setMinimumHeight(25);
        return cell;
    }

}
