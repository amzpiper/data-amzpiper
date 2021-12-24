package io.renren.modules.orders.util;

import com.alibaba.fastjson.JSON;
import io.renren.modules.orders.bo.LaoBo;
import io.renren.modules.orders.entity.AlarmsEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestJson {

    public static void main(String[] args) {
        String json = "{\"lao\":[" +
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
        Map<String, Object> jsonObject = JSON.parseObject(json,Map.class);
        for (Object key : jsonObject.keySet()){
            System.out.println("key为："+key+"值为："+jsonObject.get(key));
            if ("lao".equals(key)){
                String value = jsonObject.get(key).toString();

                List<LaoBo> laoBos = JSON.parseArray(jsonObject.get(key).toString(),LaoBo.class);
                List<AlarmsEntity> alarmsEntities = laoBos.stream().map(laoBo -> {
                    System.out.println(laoBo.toString());

                    AlarmsEntity alarmsEntity = new AlarmsEntity();
                    Timestamp beginTimeTimestamp = new Timestamp(Long.parseLong(laoBo.getBegintime()));
                    Date beginTimeDate = new Date(beginTimeTimestamp.getTime());
                    alarmsEntity.setBegintime(beginTimeDate);
                    Timestamp endTimeTimestamp = new Timestamp(Long.parseLong(laoBo.getBegintime()));
                    Date endTimeDate = new Date(endTimeTimestamp.getTime());
                    alarmsEntity.setEndtime(endTimeDate);
                    alarmsEntity.setDeviceName(laoBo.getDeviceName());
                    alarmsEntity.setPointName(laoBo.getPointName());
                    alarmsEntity.setValue(laoBo.getValue());
                    alarmsEntity.setDescription(laoBo.getDescription());
                    alarmsEntity.setQuality(laoBo.getQuality());
                    alarmsEntity.setAlarmType(laoBo.getAlarmType());
                    alarmsEntity.setAlarmLevel(laoBo.getAlarmLevel());
                    alarmsEntity.setIsAlarmRepeat(laoBo.getIsAlarmRepeat());
                    alarmsEntity.setAlarmActionDec(laoBo.getAlarmActionDec());
                    alarmsEntity.setAlarmTableTag(laoBo.getAlarmTableTag());
                    alarmsEntity.setAlarmType(laoBo.getAlarmType());
                    alarmsEntity.setDataType(laoBo.getDatatype());

                    System.out.println(alarmsEntity.toString());
                    return alarmsEntity;
                }).collect(Collectors.toList());
            }
        }
    }
}
