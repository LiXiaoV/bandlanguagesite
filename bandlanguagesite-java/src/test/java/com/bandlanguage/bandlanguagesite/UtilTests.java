package com.bandlanguage.bandlanguagesite;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.cache.prefix.EnvironmentKey;
import com.bandlanguage.bandlanguagesite.environment.BandEnvironmentFactory;
import com.bandlanguage.bandlanguagesite.environment.Environment;
import com.bandlanguage.bandlanguagesite.environment.EnvironmentFactory;
import com.bandlanguage.bandlanguagesite.environment.EnvironmentManagement;
import com.bandlanguage.bandlanguagesite.util.FormatUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilTests {

    @Autowired
    private IGlobalCache cache;

    @Test
    public void testFormatUtil() throws Exception {

        String objMap="[{\"key\":\"大大\",\"value\":\"的\"},{\"key\":\"小小\",\"value\":\"的\"}]";

        Map<String, Object> map = FormatUtil.ObjectMap2Map(objMap);

        System.out.println(map);
    }

    @Test
    public void testUseRuntimeEnvironment() throws Exception {

        Long organizationId=4053563L;
        Long bandId=5240552L;
        Long scriptId=0L;

        Map<String, Environment> runtimeEnvironment = EnvironmentManagement.getInstance().getRuntimeEnvironment(organizationId, bandId, scriptId, new HashMap<String, Object>());

        runtimeEnvironment.get("organization").updateEnvironmentInRedis();
    }

    @Test
    public void testGetFromRedis() throws Exception{
        Long bandId=5327463L;

        Environment environment = BandEnvironmentFactory.getInstance().createEnvironment(bandId);

        String s = JSONArray.toJSON(environment).toString();

        System.out.println(s);

    }
}
