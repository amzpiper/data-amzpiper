package io.renren.modules.orders.utils;

import com.alibaba.fastjson.JSON;
import io.renren.common.utils.OkHttpUtil;
import io.renren.modules.orders.bo.ReadJSONBo;
import io.renren.modules.sys.service.SysConfigService;
import io.renren.modules.sys.service.impl.SysConfigServiceImpl;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 适配coral物联网平台的WebSocketClientUtil
 * @author guoyh
 */
@Component
public class CoralWebSocketClientUtil {

    @Autowired
    private OkHttpUtil okHttpUtil;

    @Autowired
    private SysConfigService sysConfigService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * token
     */
    String token;

    /**
     * wss的host地址
     */
    String uri = "coral.anjieservice.com";

    /**
     * 创建WebSocketClient
     */
    WebSocketClient client;

    /**
     * 启动websocket
     */
    public void start() {
        this.configToken();
    }

    /**
     * 关闭websocket
     */
    public void stop() {
        if (this.client != null && this.client.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
            this.client.close();
        }
    }

    /**
     * 获取token
     */
    public void configToken(){
        // 获取登录账号和密码
        String username = sysConfigService.getValue("coral-username");
        String password = sysConfigService.getValue("coral-password");
        String url = sysConfigService.getValue("coral-url");

        //String username = "rtcs";
        //String password = "Aa58221086!";
        //String url = "https://coral.anjieservice.com";

        Map<String,String> cookies = new HashMap<>();
        Map<String,String> params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);

        String responseBody = okHttpUtil.post(url+"/sys/login/restful",
                params, cookies);
        logger.info("responseBody: "+responseBody);

        Map jsonObject = JSON.parseObject(responseBody,Map.class);
        //用JSON类,指定解析类型，来解析JSON字符串
        for (Object key : jsonObject.keySet()){
            if (key.equals("token")) {
                this.token = (String) jsonObject.get(key);
                logger.info("token: "+this.token);
            }
        }

        this.configClient();
    }

    /**
     * 初始化WebSocket客户端
     */
    public void configClient() {
        uri = sysConfigService.getValue("coral-host");
        if ("".equals(uri) || uri == null) {
            logger.info("coral-host is null ");
            uri = "coral.anjieservice.com";
        }
        // wss地址
        String url = "wss://"+uri+"/aj?logintoken=" + token;
        logger.info("url: "+url);

        // 请求与服务端建立连接
        try {
            client = new CoralWebSocketClient(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        client.connect();
        // 请求与服务端建立连接-判断是否建立连接
        while (!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
        }
        logger.info("与wss服务端建立连接!");

        this.sendMessageToClient();
    }

    /**
     * 发生数据到WebSocket
     */
    public void sendMessageToClient() {
        // 获取系统参数-告警设备列表
        String orderAlarmDataString = sysConfigService.getValue("orderAlarmData");
        String[] orderAlarmDataSplits = orderAlarmDataString.split(",");

        // 需要监听的设备列表
        ReadJSONBo readJSONBo = new ReadJSONBo();
        readJSONBo.setClassID("订阅");
        // 报警数据订阅
        //orderAlarmData.add("rtdcbd.Alarm");
        List orderAlarmData = new ArrayList();
        for (String orderAlarmDataSplit : orderAlarmDataSplits) {
            orderAlarmData.add(orderAlarmDataSplit.trim() + ".Alarm");
        }
        readJSONBo.setOrderAlarmData(orderAlarmData);
        // 实时数据订阅
        //List runtimeData = new ArrayList();
        //runtimeData.add("rtdcbd.YC0001");
        //runtimeData.add("rtdcbd.YC0002");
        //readJSONBo.setRuntimeData(runtimeData);

        // 发送监听列表数据
        String jsonString = JSON.toJSONString(readJSONBo);
        logger.info("监听列表数据:" + jsonString);
        client.send(jsonString);
    }
}
