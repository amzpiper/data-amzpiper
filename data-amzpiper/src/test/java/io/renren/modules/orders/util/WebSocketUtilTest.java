package io.renren.modules.orders.util;

import com.alibaba.fastjson.JSON;
import io.renren.modules.orders.bo.LaoBo;
import io.renren.modules.orders.controller.AlarmsController;
import io.renren.modules.orders.entity.AlarmsEntity;
import io.renren.modules.orders.utils.CoralWebSocketClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSocketUtilTest {

    /**
     * 告警接口对象
     */
    @Autowired
    AlarmsController alarmsController;

    @Autowired
    CoralWebSocketClientUtil webSocketClientUtil;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void test() {
        String message = "{\"lao\":[" +
                "{\n" +
                "        \"begintime\": 1586232665616," +
                "        \"deviceName\": \"ajdlbd\"," +
                "        \"pointName\": \"ajdlbd.Device\"," +
                "        \"value\": 0.0," +
                "        \"description\": \"设备【ajdlbd】断开.\"," +
                "        \"quality\": 0," +
                "        \"alarmType\": \"设备状态\"," +
                "        \"alarmLevel\": 0," +
                "        \"isAlarmRepeat\": false," +
                "        \"Describe\": \"安捷物联\"," +
                "        \"alarmActionDec\": \"通道中断\"," +
                "        \"alarmTableTag\": false," +
                "        \"datatype\": \"DaH\"" +
                "    }," +
                "{\n" +
                "        \"begintime\": 1586232665616," +
                "        \"endtime\": 0,\n" +
                "        \"deviceName\": \"ajdlbd\"," +
                "        \"pointName\": \"ajdlbd.Device\"," +
                "        \"description\": \"设备【ajdlbd】断开.\"," +
                "        \"quality\": 0," +
                "        \"alarmType\": \"设备状态\"," +
                "        \"alarmLevel\": 0," +
                "        \"isAlarmRepeat\": false," +
                "        \"Describe\": \"安捷物联\"," +
                "        \"alarmActionDec\": \"通道中断\"," +
                "        \"alarmTableTag\": false," +
                "        \"datatype\": \"DaH\"" +
                "    }" +
                "],\"lap\":[]}";

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
                    System.out.println(laoBo.toString());

                    AlarmsEntity alarmsEntity = new AlarmsEntity();
                    Timestamp beginTimeTimestamp = new Timestamp(Long.parseLong(laoBo.getBegintime()));
                    Date beginTimeDate = new Date(beginTimeTimestamp.getTime());
                    alarmsEntity.setBegintime(beginTimeDate);
                    Timestamp endTimeTimestamp = new Timestamp(Long.parseLong(laoBo.getBegintime()));
                    Date endTimeDate = new Date(endTimeTimestamp.getTime());
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
}
