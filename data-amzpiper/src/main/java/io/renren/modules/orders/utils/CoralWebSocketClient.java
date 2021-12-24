package io.renren.modules.orders.utils;

import com.alibaba.fastjson.JSON;
import io.renren.modules.orders.bo.LaoBo;
import io.renren.modules.orders.controller.AlarmsController;
import io.renren.modules.orders.entity.AlarmsEntity;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 适配coral的webSocketClient
 * @author guoyh
 */
public class CoralWebSocketClient extends WebSocketClient {

    /**
     * 告警接口对象
     */
    @Autowired
    AlarmsController alarmsController;

    private Logger logger = LoggerFactory.getLogger(getClass());


    public CoralWebSocketClient(String uri) throws URISyntaxException {
        super(new URI(uri));
    }

    /**
     * 建立连接调用
     *
     * @param serverHandshake
     */
    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        logger.info("建立websocket连接");
        for(Iterator<String> it = serverHandshake.iterateHttpFields(); it.hasNext();) {
            String key = it.next();
            logger.info(key+":"+serverHandshake.getFieldValue(key));
        }
        logger.info("建立websocket完成");
    }

    /**
     * 收到服务端消息调用
     *
     * @param message
     */
    @Override
    public void onMessage(String message) {
        logger.info("收到来自服务端的消息:" + message);
        Map messageMap = JSON.parseObject(message,Map.class);
        for (Object key : messageMap.keySet()) {
            // 获取告警信息
            if ("lao".equals(key)) {
                logger.info("告警数据:" + messageMap.get(key));
                // 告警信息json
                String value = messageMap.get(key).toString();
                // 告警信息json转list
                List<LaoBo> laoBos = JSON.parseArray(value.toString(),LaoBo.class);
                laoBos.stream().map(laoBo -> {
                    //System.out.println(laoBo.toString());
                    AlarmsEntity alarmsEntity = new AlarmsEntity();
                    Timestamp beginTimeTimestamp = new Timestamp(Long.parseLong(laoBo.getBegintime()));
                    Date beginTimeDate = new Date(beginTimeTimestamp.getTime());
                    alarmsEntity.setBegintime(beginTimeDate);
                    Timestamp endTimeTimestamp = new Timestamp(Long.parseLong(laoBo.getBegintime()));
                    Date endTimeDate = new Date(endTimeTimestamp.getTime());
                    // TODO: 告警名称格式
                    alarmsEntity.setAlarmName(laoBo.getDescription());
                    alarmsEntity.setEndtime(endTimeDate);
                    alarmsEntity.setDeviceName(laoBo.getDeviceName());
                    alarmsEntity.setPointName(laoBo.getPointName());
                    alarmsEntity.setValue(laoBo.getValue());
                    alarmsEntity.setDescription(laoBo.getDescription());
                    alarmsEntity.setQuality(laoBo.getQuality());
                    alarmsEntity.setAlarmType(laoBo.getAlarmType());
                    alarmsEntity.setAlarmLevel(laoBo.getAlarmLevel());
                    alarmsEntity.setIsAlarmRepeat(laoBo.getIsAlarmRepeat());
                    alarmsEntity.setDeviceDescribe(laoBo.getDescribe());
                    alarmsEntity.setAlarmActionDec(laoBo.getAlarmActionDec());
                    alarmsEntity.setAlarmTableTag(laoBo.getAlarmTableTag());
                    alarmsEntity.setAlarmType(laoBo.getAlarmType());
                    alarmsEntity.setDataType(laoBo.getDatatype());

                    //调用告警信息接口创建告警信息
                    logger.info("调用告警信息接口创建告警信息:"+alarmsEntity.toString());
                    alarmsController.add(alarmsEntity);
                    return alarmsEntity;
                }).collect(Collectors.toList());
            }
        }
    }

    /**
     * 断开连接调用
     *
     * @param code
     * @param reason
     * @param remote
     */
    @Override
    public void onClose(int code, String reason, boolean remote) {
        logger.info("连接关闭, 重新连接");
    }

    /**
     * 连接报错调用
     *
     * @param e
     */
    @Override
    public void onError(Exception e) {
        logger.info("报错了,尝试重新连接: " + e.getMessage());
    }
}

