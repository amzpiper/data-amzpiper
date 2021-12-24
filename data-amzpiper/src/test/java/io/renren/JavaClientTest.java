package io.renren;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.renren.common.utils.OkHttpUtil;
import io.renren.modules.orders.utils.CoralWebSocketClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaClientTest {

    @Autowired
    private OkHttpUtil okHttpUtil;

    @Test
    public void testGetToken() {
        Map<String,String> cookies = new HashMap<>();
        Map<String,String> params = new HashMap<>();
        params.put("username","rtcs");
        params.put("password","Aa58221086!");

        String responseBody = okHttpUtil.post("https://coral.anjieservice.com/sys/login/restful",
                params, cookies);
        System.out.println(responseBody);

        Map jsonObject = JSON.parseObject(responseBody,Map.class);
        System.out.println("这个是用JSON类,指定解析类型，来解析JSON字符串!!!");
        for (Object key : jsonObject.keySet()){
            if (key.equals("token")) {
                System.out.println("key为："+key+"值为："+jsonObject.get(key));
            }
        }
    }


    @Autowired
    CoralWebSocketClientUtil webSocketClientUtil;

    @Test
    public void testWS() {
        webSocketClientUtil.start();
        while (true) {
        }
    }
}
