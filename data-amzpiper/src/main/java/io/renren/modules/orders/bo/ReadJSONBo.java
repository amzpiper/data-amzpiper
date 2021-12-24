package io.renren.modules.orders.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 订阅coral的wss时传输数据使用的对象
 * @author guoyh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //生产的setter方法返回this
public class ReadJSONBo {

    {
        /**
         * 初始化默认数据
         */
        classID = "订阅";
    }

    /**
     * 格式：订阅
     * 订阅标识
     */
    private String classID;

    /**
     * 格式：设备.Alarm
     * 多个设备的 “设备名. Alarm”以逗号（,）分隔
     * 订阅报警数据列表
     */
    private List orderAlarmData;

    /**
     * 订阅格式为：“设备名.点名”。例如" stationName.pointName1"其中“stationName”为设备名，“pointName1”为点名
     *
     * 订阅实时数据列表
     */
    private List runtimeData;

}
