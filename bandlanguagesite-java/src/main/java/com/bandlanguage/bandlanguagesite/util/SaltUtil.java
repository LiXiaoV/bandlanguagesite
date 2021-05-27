package com.bandlanguage.bandlanguagesite.util;

import java.util.Random;

/**
 * @author xiaov
 * @since 2021-05-25 10:36
 */
public class SaltUtil {

    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()".toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            buffer.append(aChar);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String salt = getSalt(99);
        System.out.println("salt = " + salt);
    }
}
