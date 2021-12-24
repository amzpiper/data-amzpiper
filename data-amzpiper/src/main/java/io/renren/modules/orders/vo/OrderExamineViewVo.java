package io.renren.modules.orders.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Date;


/**
 * @author guoyh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //生产的setter方法返回this
public class OrderExamineViewVo {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 问题任务ID
	 */
	private String questaskId;

	/**
	 * 任务提交时间
	 */
	private Date submitDate;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 是否公共区域
	 */
	private String isPublic;

	/**
	 * 开始时间
	 */
	private Date startDate;

	/**
	 * 任务类型
	 */
	private String biProblemCategory;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	/**
	 * 问题描述
	 */
	private String quesDesc;

	/**
	 * 任务状态
	 */
	private String qusetaskState;

	/**
	 * 问题级别
	 */
	private String emergencyDegree;

	/**
	 * 联系地址
	 */
	private String contactAddress;

	/**
	 * 联系人
	 */
	private String contactName;

	/**
	 * 联系电话
	 */
	private String contactPhone;

	/**
	 * 问题类型
	 */
	private String questionType;

	/**
	 * 请求来源
	 */
	private String taskSource;

	/**
	 * 任务类型
	 */
	private Integer taskType;

	/**
	 * 状态
	 */
	private String state;

	/**
	 * 楼层
	 */
	private String houseFloor;

	/**
	 * 项目Id
	 */
	private String projectId;

	/**
	 * 项目名称
	 */
	private String projectName;

	/**
	 * 区域主键
	 */
	private String areaId;

	/**
	 * 区域名称
	 */
	private String areaName;

	/**
	 * 功能分区名称
	 */
	private String roomType;

	/**
	 * 部位名称
	 */
	private String roomPartName;

	/**
	 * 楼栋名称
	 */
	private String houseBuilding;

	/**
	 * 单元
	 */
	private String houseCell;

	/**
	 * 房号
	 */
	private String houseRoom;

	/**
	 * 维修人
	 */
	private String maintenanceMan;

	/**
	 * 派单人ID
	 */
	private String sendUserid;

	/**
	 * 维修人ID
	 */
	private String mtainUserid;

	/**
	 * 起单来源
	 */
	private String orignSource;

	/**
	 * 录单系统
	 */
	private String sourceType;

	/**
	 * 是否房修单
	 */
	private String houseFixStatus;

	/**
	 * 本系统创建时间
	 */
	private Date adtecCreateDate;

	/**
	 * adtec_update_date
	 * 更新时间
	 */
	private Date adtecUpdateDate;

	/**
	 * 是否审批(0:未审批;1:已审批)
	 */
	private Integer examineStatus;

	/**
	 * 来源系统
	 */
	private String sourceSystem;

	/**
	 * 目标系统
	 */
	private String targetSystem;
}
