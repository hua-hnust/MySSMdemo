package util;

import com.hnust.hua.util.AESUtil;
import com.hnust.hua.util.PropertyUtils;
import org.junit.Test;

/**  获取配置文件属性，AES 加密解密算法
 * Created by Administrator on 2018/11/28.
 */
public class PropertyUtilTest {

    @Test
    public void test(){
        // 获取配置文件属性
        String password = PropertyUtils.getProperty("jdbc.password");
        // AES 算法加密 解密  秘钥长度必须为 16位
        System.out.println("原密码："+password);
        String aesPassword = AESUtil.aesEncrypt(password,"ANKKIAESDBCONFIG");
        System.out.println("加密后："+aesPassword);
        String dePassword = AESUtil.aesDecrypt(aesPassword,"ANKKIAESDBCONFIG");
        System.out.println("解密后："+dePassword);
    }
}
