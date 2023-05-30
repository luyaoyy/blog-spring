package com.blue.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
//    private static final String salt = "1a2b3c4d";
//
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }
//
//    public static String firstMd5(String inputPass) {
//        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
//        return md5(str);
//    }

    public static String secondMd5(String fromPass, String salt) {
        String str = fromPass +salt;
        return md5(str);
    }

//    public static String finallyPass(String inputPass, String salt) {
//        String fromPass = firstMd5(inputPass);
//        String dbPass = secondMd5(fromPass, salt);
//        return dbPass;
//    }

//    //加密测试
//    public static void main(String[] args) {
//        String password = "123456";
//        String first = firstMd5(password);
//        String second = secondMd5(first, salt);
//        String result = finallyPass(password, salt);
//        System.out.println(first);//输出第一次加密结果
//        System.out.println(second);//输出第二次加密结果
//        System.out.println(result);//直接输出加密两次后的结果
//    }
}
