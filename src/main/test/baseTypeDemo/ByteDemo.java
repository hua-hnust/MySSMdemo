package baseTypeDemo;

import org.junit.Test;

/**    用于字节加密和解密
 * Created by Administrator on 2019/1/19.
 */
public class ByteDemo {

    @Test
    public void test(){
        byte x = 'A';
        byte y = (byte) (x ^ 0x4A);
        byte z = (byte) (y ^ 0x4A);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

}
