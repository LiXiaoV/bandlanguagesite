package com.bandlanguage.bandlanguagesite.util;


import cn.hutool.crypto.digest.DigestUtil;

/**
 * @author xiaov
 * @since 2021-05-25 09:46
 */
public class MD5Util {

    public static String md5(String src) {
        return DigestUtil.md5Hex(src);
    }

    private static final String SALT = "wtb_language";  //12

    public static String inputPassToFormPass(String inputPass) {
        String str = "" + SALT.charAt(2) + SALT.charAt(0) + inputPass + SALT.charAt(1) + SALT.charAt(9);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass,String saltDB){
        String str = "" + saltDB.charAt(2)+saltDB.charAt(0)+ formPass +saltDB.charAt(1)+saltDB.charAt(9);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass,String saltDB){
        String formPass = inputPassToFormPass(inputPass);
        return formPassToDBPass(formPass,saltDB);
    }

    public static void main(String[] args) {

        System.out.println(inputPassToFormPass("123456"));
        System.out.println(formPassToDBPass(inputPassToFormPass("123456"),"1234567890"));
        System.out.println(inputPassToDBPass("liwei666","201921043844"));
    }
}
