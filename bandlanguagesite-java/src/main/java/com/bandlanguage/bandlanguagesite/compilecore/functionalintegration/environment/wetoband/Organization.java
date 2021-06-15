package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband;

import java.util.LinkedList;
import java.util.List;

/**
 * 存放机构相关信息的对象
 */
public class Organization {
    public String name; //该机构的名称
    public List<BLObj> things = new LinkedList<>(); //存放该机构的相关信息
    public List<Band> bands = new LinkedList<>(); //存放该机构下的相关帮区
}
