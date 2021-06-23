package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;

import java.util.LinkedList;
import java.util.List;

/**
 * 吾托帮的环境，存放所有机构、帮区的相关信息
 */
public class WTBConst {
    public static List<Organization> organizations = new LinkedList<>();

    //演示
    static {
        Organization organization = new Organization();
        Band band = new Band();
        band.name = "测试帮区";
        band.things.add(new BLObj("测试工具","1231231", BLObjType.TOOLID));
        band.things.add(new BLObj("通讯录工具","1231231", BLObjType.TOOLID));
        organization.name = "测试机构";
        organization.bands.add(band);
        organization.things.add(new BLObj("张三","1112111",BLObjType.USERID));

        organizations.add(organization);
    }
}
