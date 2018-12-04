package com.hnust.hua.util;

import org.bson.internal.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Administrator on 2018/11/28.
 */
public class AESUtil {

    /**
     *  AES加密算法
     * @param encryptStr
     * @param sKey
     * @return
     */
    public static String aesEncrypt(String encryptStr,String sKey){
        //判断加密秘钥是否为空
        if (null == sKey){
            System.out.println("AES加密的Key为null");
            return null;
        }
        //判断加密秘钥长度
        if (sKey.length()!= 16){
            System.out.println("AES加密的Key长度不为16");
            return null;
        }
        try{
            byte[] raw = sKey.getBytes("utf-8");
            //定义加密算法
            SecretKeySpec skeySpec = new SecretKeySpec(raw,"AES");
            //得到AES/ECB/PKCS5Padding,算法/模式/补码方式 模式和补码方式可以不写，默认就为ECB和PKCS5Padding
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            //用秘钥初始化Cipher对象为加密模式
            cipher.init(Cipher.ENCRYPT_MODE,skeySpec);
            byte[] encrypted = cipher.doFinal(encryptStr.getBytes("utf-8"));
            //转码 二次加密
            String encode = Base64.encode(encrypted);
            return encode;
        }catch (Exception e){
            System.out.println("AES加密发生异常");
            return null;
        }
    }

    /**
     *
     * @param decryptStr
     * @param sKey
     * @return
     */
    public static String aesDecrypt(String decryptStr,String sKey){
        //判断加密秘钥是否为空
        if (null == sKey){
            System.out.println("AES加密的Key为null");
            return null;
        }
        //判断加密秘钥长度
        if (sKey.length()!= 16){
            System.out.println("AES加密的Key长度不为16");
            return null;
        }
        try{
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw,"AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,skeySpec);
            //先用BASE64解密
            byte[] encrypted = Base64.decode(decryptStr);

            byte[] original = cipher.doFinal(encrypted);
            String key = new String(original,"utf-8");
            return key;
        }catch (Exception e){
            System.out.println("AES解密发生异常");
            return null;
        }
    }
}
