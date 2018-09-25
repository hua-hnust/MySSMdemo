package itextjfreechartpoi;

/**
 * Created by xhua on 2018-09-25.
 * Describe: 多个文件打包成zip
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class TestZip {
    public static void main(String[] args) {
        List<String> list =new ArrayList();
        String[] strs = new String[5];
        StringBuffer sb=new StringBuffer();
        try{
            sb.append("F:/1.txt,");
            sb.append("F:/2.txt,");
            sb.append("F:/3.txt,");
            writeZip(sb,"F:/newZipFile");
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
    private static void writeZip(StringBuffer sb,String zipname) throws IOException {
        String[] files = sb.toString().split(",");
        System.out.println(files.toString());
        OutputStream os = new BufferedOutputStream( new FileOutputStream( zipname+".zip" ) );
        ZipOutputStream zos = new ZipOutputStream( os );
        byte[] buf = new byte[8192];
        int len;
        for (int i=0;i<files.length;i++) {
            File file = new File( files[i] );
            if ( !file.isFile() ) continue;
            ZipEntry ze = new ZipEntry( file.getName() );
            zos.putNextEntry( ze );
            BufferedInputStream bis = new BufferedInputStream( new FileInputStream( file ) );
            while ( ( len = bis.read( buf ) ) > 0 ) {
                zos.write( buf, 0, len );
            }
            zos.closeEntry();
        }
//        zos.setEncoding("GBK");
        zos.closeEntry();
        zos.close();

        for(int i=0;i<files.length;i++){
            System.out.println("------------"+files );
            File file= new File(files[i] );
            file.delete();
        }
    }

}
