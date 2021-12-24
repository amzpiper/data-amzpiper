package io.renren.modules.orders.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * @author guoyh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //生产的setter方法返回this
@TableName("alarms")
public class AlarmsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(type = IdType.UUID)
	private String id;

	/**
	 * 告警名称
	 */
	private String alarmName;

	/**
	 * 开始时间
	 */
	private Date begintime;

	/**
	 * 结束时间
	 */
	private Date endtime;

	/**
	 * 设备名
	 */
	private String deviceName;

	/**
	 * 设备名.点名
	 */
	private String pointName;

	/**
	 * 值
	 */
	private String value;

	/**
	 * 点描述
	 */
	private String description;

	private String quality;

	/**
	 * 报警类型
	 */
	private String alarmType;

	/**
	 * 报警级别
	 */
	private String alarmLevel;

	private String isAlarmRepeat;

	/**
	 * 设备描述
	 */
	private String deviceDescribe;

	/**
	 * 动作描述
	 */
	private String alarmActionDec;

	private String alarmTableTag;

	/**
	 * 数据类型
	 */
	private String dataType;

	/**
	 * 本系统创建时间
	 */
	private Date adtecCreateDate;

	/**
	 * 告警状态(0:未处理,1:已处理,2:已忽略)
	 */
	private Integer adtecStatus;

	/**
	 * 本系统更新时间
	 */
	private Date adtecUpdateDate;
}
