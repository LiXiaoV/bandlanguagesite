package com.bandlanguage.bandlanguagesite.util;

import java.util.UUID;

/**
 * @author xiaov
 * @since 2021-05-25 09:44
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
