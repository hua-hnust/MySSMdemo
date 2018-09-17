package itextjfreechartpoi;

import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by xhua on 2018-09-12.
 * Describe:  通过字体文件创建字体
 */
public class CreateFont {

    @Test
    public void testCreateFont(){
        try {
            String fontUrl = "C:/Windows/Fonts/simsunb.ttf";
            FileInputStream fis = new FileInputStream(new File(fontUrl));
            Font font = Font.createFont(Font.TRUETYPE_FONT,fis);
            font.deriveFont(1,64F);
            System.out.println(font.getName());
            System.out.println(font.getStyle());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
