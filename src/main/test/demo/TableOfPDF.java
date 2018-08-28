package demo;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;
import javafx.scene.paint.Color;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.itextpdf.text.Document;

/**
 * 使用iText生成PDF文件
 * 在PDF文件中创建表格
 */
public class TableOfPDF {

    @Test
    public void createPDF() {

        //文件位置
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH时mm分");
        String now= sdf.format(new java.util.Date());
        String fileUrl ="D:\\"+ now +".pdf";
        System.out.println(fileUrl);

        //创建文件
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileUrl));
            document.open();

            PdfPTable table = new PdfPTable(7);
            table.setTotalWidth(595);



            String font_cn = "src/main/resources/font/simsun.ttc";
            BaseFont bf = BaseFont.createFont(font_cn+",1", //注意这里有一个,1
                    BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font font = new Font(bf,10);

            PdfPCell cell;
            //第一行标题
            cell = new PdfPCell(new Phrase("系统日志",font));
            cell.setColspan(7);
            cell.setUseAscender(true);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            String hellow = new String("你好");
            cell = new PdfPCell(new Paragraph(hellow, font));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("222"));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("333"));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("444"));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("555"));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("666"));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("777"));
            table.addCell(cell);

            ArrayList list =new ArrayList();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);
            System.out.println(list.size());
            for(int i=0;i<list.size();i++){
                cell = new PdfPCell(new Paragraph(list.get(0).toString()));
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(list.get(1).toString()));
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(list.get(2).toString()));
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(list.get(3).toString()));
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(list.get(4).toString()));
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(list.get(5).toString()));
                table.addCell(cell);
            }
            document.add(table);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
