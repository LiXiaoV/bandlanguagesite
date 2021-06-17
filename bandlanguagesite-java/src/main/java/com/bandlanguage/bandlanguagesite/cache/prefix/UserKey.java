package com.bandlanguage.bandlanguagesite.cache.prefix;

/**
 * @author xiaov
 * @since 2021-05-25 17:37
 */
public class UserKey extends BasePrefix {
    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    public static UserKey token = new UserKey(TOKEN_EXPIRE, "tk");

    public static UserKey getById = new UserKey(0, "id");

    public UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
