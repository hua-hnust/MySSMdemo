package itextjfreechartpoi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by hua on 2018-04-04.
 * Describe:
 */
public class POITest {

    @Test
    public void pdfTest(){
        //文件位置
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH时mm分");
        String now= sdf.format(new java.util.Date());
        String fileUrl ="D:\\"+ now +".xls";
        System.out.println(fileUrl);

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("LogExcel");
        HSSFRow firstRow = sheet.createRow(0);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
        HSSFCell titleCell = firstRow.createCell(0);
        titleCell.setCellValue("标题");

        HSSFRow row = sheet.createRow(1);


        HSSFCell cell = row.createCell(0);
        cell.setCellValue("姓名");

        cell = row.createCell(1);
        cell.setCellValue("性别");

        cell= row.createCell(2);
        cell.setCellValue("年龄");

        row = sheet.createRow(2);
        row.createCell(0).setCellValue("小明");
        row.createCell(1).setCellValue("男");
        row.createCell(2).setCellValue(21);

        row = sheet.createRow(3);
        row.createCell(0).setCellValue("小丽");
        row.createCell(1).setCellValue("女");
        row.createCell(2).setCellValue(20);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileUrl);
            wb.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
