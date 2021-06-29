package com.bandlanguage.bandlanguagesite;

import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.util.HttpUtil;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaov
 * @since 2021-06-22 17:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientTests {

    @Test
    public void testPost() throws IOException {

        Map<String, String> map = new HashMap<>();

        map.put("name", "li_xiaov");
        map.put("password", "liwei666");
        map.put("aid", "21419389378723787447");
        map.put("format", "json");

        HttpResponse response = HttpUtil.doPost("https://www.wetoband.com", "/core/core/v4/authc/user", new HashMap<>(), map, (Map<String, String>) null);

        Header[] headers = response.getAllHeaders();
        for (Header header : headers) {
            System.out.println(header.getName()+":" + header.getValue());
        }
        String accessToken = HttpUtil.getValueFromHeaders(response,"Set-Cookie","access_token");
//        String strRes = HttpUtil.parseString(response);
        JSONObject resObj = HttpUtil.parseJson(response);
        Object user = null;
        if(resObj.containsKey("rows")){
            user = resObj.getJSONArray("rows").get(0);
        }
        System.out.println("resObj = " + resObj);
        System.out.println("user = " + user);
//        System.out.println("strRes = " + strRes);
        System.out.println("accessToken = " + accessToken);
    }
}
