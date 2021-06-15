package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband;

import java.util.LinkedList;
import java.util.List;

/**
 * 存放帮区相关信息的对象
 */
public class Band {
    public String name; //该帮区的名称
    public List<BLObj> things = new LinkedList<>(); //存放该帮区的相关信息
}
