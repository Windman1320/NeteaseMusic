package com.jmr.nuist.neteasemusic.Utils;

import java.security.MessageDigest;

public class MD5Util {
    /*对密码进行加密
     *参数：密码
     *返回：密文
     */
    public static String digest(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                //负数转换成正数
                int c = b & 0xff;
                //把十进制的数转换成十六进制的数
                String result = Integer.toHexString(c);
                if (result.length() < 2) {
                    //让十六进制全部都是两位数
                    sb.append(0);
                }
                sb.append(result);
            }
            return sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}