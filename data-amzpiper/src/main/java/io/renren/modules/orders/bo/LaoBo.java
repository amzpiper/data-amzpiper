package io.renren.modules.orders.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import net.bytebuddy.implementation.bind.annotation.Default;

import java.io.Serializable;

/**
 * 接收coral报警数据对象
 *
 * @author guoyh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //生产的setter方法返回this
public class LaoBo implements Serializable {

    /**
     * 数据:
     * 1586232665616
     */
    private String begintime;

    /**
     * 数据:
     * 0
     */
    private String endtime;

    /**
     * 数据:
     * ajdlbd
     */
    private String deviceName;

    /**
     * 数据:
     * ajdlbd.Device
     */
    String pointName;

    /**
     * 数据:
     * 0.0
     */
    String value;

    /**
     * 数据:
     * 设备【ajdlbd】断开
     */
    String description;

    /**
     * 数据:
     * 0
     */
    String quality;

    /**
     * 数据:
     * 设备状态
     */
    String alarmType;

    /**
     * 数据:
     * 0
     */
    String alarmLevel;

    /**
     * 数据:
     * false
     */
    String isAlarmRepeat;

    /**
     * 数据:
     * 安捷物联
     */
    String Describe;

    /**
     * 数据:
     * 通道中断
     */
    String alarmActionDec;

    /**
     * 数据:
     * false
     */
    String alarmTableTag;

    /**
     * 数据:
     * DaH
     */
    String datatype;
}
