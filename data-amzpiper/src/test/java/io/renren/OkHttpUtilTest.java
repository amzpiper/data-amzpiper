package io.renren;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.renren.common.utils.OkHttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OkHttpUtilTest {

    @Autowired
    private OkHttpUtil okHttpUtil;

    @Value(value = "${header.tokenName}")
    private String tokenName;

    @Value(value = "${header.tokenValue}")
    private String tokenValue;

    @Test
    public void testPostOrdersList() throws JsonProcessingException {
        Map<String,String> params = new HashMap<>();
        params.put(tokenName,tokenValue);

        Map<String,String> cookies = new HashMap<>();
        cookies.put(tokenName,tokenValue);

        String responseBody = okHttpUtil.post("http://localhost:8999/orders/list", params, cookies);
        System.out.println(responseBody);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        //Map<String, String> map = objectMapper.readValue(data, new TypeReference<Map<String, String>>(){});
        //for (Map.Entry<String, String> entry : map.entrySet()) {
        //    System.out.println(entry.getKey()+":"+entry.getValue());
        //}
    }

    @Test
    public void testCoral() throws JsonProcessingException {
        Map<String,String> params = new HashMap<>();
        params.put(tokenName,tokenValue);

        Map<String,String> cookies = new HashMap<>();
        cookies.put(tokenName,tokenValue);

        String responseBody = okHttpUtil.post("http://localhost:8999/orders/list", params, cookies);
        System.out.println(responseBody);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        //Map<String, String> map = objectMapper.readValue(data, new TypeReference<Map<String, String>>(){});
        //for (Map.Entry<String, String> entry : map.entrySet()) {
        //    System.out.println(entry.getKey()+":"+entry.getValue());
        //}
    }
}
