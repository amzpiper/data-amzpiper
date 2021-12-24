package io.renren.modules.orders.vo;

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
@TableName("order_examine")
public class OrderExamineListVo {

	/**
	 * ID
	 */
	@TableId(type = IdType.UUID)
	private String id;

	/**
	 * 问题描述
	 */
	private String quesDesc;

	/**
	 * 问题类型
	 */
	private String questionType;

	/**
	 * 来源系统
	 */
	private String sourceSystem;

	/**
	 * 目标系统
	 */
	private String targetSystem;

	/**
	 * 本系统创建时间
	 */
	private Date adtecCreateDate;

	/**
	 * 是否审批(0:未审批;1:已审批)
	 */
	private Integer examineStatus;
}
