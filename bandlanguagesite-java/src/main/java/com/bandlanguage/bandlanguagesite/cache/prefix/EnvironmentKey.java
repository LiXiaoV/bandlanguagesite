package com.bandlanguage.bandlanguagesite.cache.prefix;

/**
 *
 **/
public class EnvironmentKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    public static EnvironmentKey instance=new EnvironmentKey(TOKEN_EXPIRE,"");

    public EnvironmentKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
