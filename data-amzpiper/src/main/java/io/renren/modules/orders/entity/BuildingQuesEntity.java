package io.renren.modules.orders.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoyh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //生产的setter方法返回this
@TableName(value ="dwi_em_tbb_building_ques_info",schema = "dwi_em")
public class BuildingQuesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 问题任务ID
	 */
	@TableId(type = IdType.UUID)
	private String questaskId;

	/**
	 * 任务提交时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
	 * 派单时间
	 */
	private Date giveOutDate;

	/**
	 * 派单时限
	 */
	private Date giveOutDateLine;

	/**
	 * 接单时间
	 */
	private Date acceptDate;

	/**
	 * 接单时限
	 */
	private Date acceptDateLine;

	/**
	 * 完成时间
	 */
	private Date finishDate;

	/**
	 * 处理时限
	 */
	private Date endDate;

	/**
	 * 关闭时间
	 */
	private Date closeDate;

	/**
	 * 关闭时限
	 */
	private Date closeDateLine;

	/**
	 * 任务类型
	 */
	private String biProblemCategory;

	/**
	 * 返工次数
	 */
	private String multimaintainState;

	/**
	 * 操作时间
	 */
	private Long operaDate;

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
	 * 承建商名称
	 */
	private String builderName;

	/**
	 * 承建商ID
	 */
	private String builderId;

	/**
	 * 关联楼栋ID
	 */
	private String buildingId;

	/**
	 * 问题级别
	 */
	private String emergencyDegree;

	/**
	 * 关联房间ID
	 */
	private String infoId;

	/**
	 * 受理人ID
	 */
	private String oriUserid;

	/**
	 * 最后一级任务分类ID
	 */
	private String serverId;

	/**
	 * 房间部位ID
	 */
	private String roomPartId;

	/**
	 * 部位
	 */
	private String roomPart;

	/**
	 * 功能分区ID
	 */
	private String roomTypeId;

	/**
	 * 更新者ID
	 */
	private String updater;

	/**
	 * 作废审批时间
	 */
	private Date closeApprovalDate;

	/**
	 * 作废状态
	 */
	private String closeStatus;

	/**
	 * 作废提交时间
	 */
	private Date closeSubmitDate;

	/**
	 * 中止期限
	 */
	private Date pauseDeadline;

	/**
	 * 中止状态
	 */
	private String pauseStatus;

	/**
	 * 中止审批时间
	 */
	private Date pauseApprovalDate;

	/**
	 * 中止提交时间
	 */
	private Date pauseSubmitDate;

	/**
	 * 类型名称
	 */
	private String typeName;

	/**
	 * 原因
	 */
	private Integer reason;

	/**
	 * 问题编码
	 */
	private String questaskCode;

	/**
	 * 返修次数
	 */
	private String repairNum;

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
	 * 业主ID
	 */
	private String ownerInfoId;

	/**
	 * 各级分类拼接内容
	 */
	private String problemTmpName;

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
	 * 中止作废申请人
	 */
	private String applicant;

	/**
	 * 预约时间
	 */
	private Date appointmentDate;

	/**
	 * 后续处理人ID
	 */
	private String followupProcessor;

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
	 * 回调地址
	 */
	private String revokeUrl;

	/**
	 * 区域主键
	 */
	private String areaId;

	/**
	 * 区域名称
	 */
	private String areaName;

	/**
	 * 非正常关闭状态
	 */
	private String abnormityCloseStatus;

	/**
	 * 非正常关闭申请时间
	 */
	private Date abnormityCloseSubmitDate;

	/**
	 * 非正常关闭审批通过
	 */
	private Date abnormityCloseApprovalDate;

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
	 * 产品类型
	 */
	private String buildingProperty;

	/**
	 * 受理人姓名
	 */
	private String origUserName;

	/**
	 * 处理人姓名
	 */
	private String followupProcessorName;

	/**
	 * 业主姓名
	 */
	private String ownerName;

	/**
	 * 中止作废原因
	 */
	private String reasonName;

	/**
	 * 中止原因
	 */
	private String delayReason;

	/**
	 * 业主会员ID
	 */
	private String memberId;

	/**
	 * 质保开始时间
	 */
	private Date warrantyStartDate;

	/**
	 * 质保结束时间
	 */
	private Date warrantyEndDate;

	/**
	 * 父任务编号
	 */
	private String parentQuestaskCode;

	/**
	 * 父任务ID
	 */
	private String parentId;

	/**
	 * 维修人
	 */
	private String maintenanceMan;

	/**
	 * 派单人ID
	 */
	private String sendUserid;

	/**
	 * 投诉渠道
	 */
	private String complaintChannel;

	/**
	 * 维修人ID
	 */
	private String mtainUserid;

	/**
	 * 评价（回访）方式
	 */
	private String visitType;

	/**
	 * 回访状态
	 */
	private String visitState;

	/**
	 * 是否需要材料
	 */
	private String isNeedMaterial;

	/**
	 * App下单系统
	 */
	private String outOrderTaskSystem;

	/**
	 * 地产任务id
	 */
	private String dcQuestaskId;

	/**
	 * 地产任务编号
	 */
	private String dcQuestaskCode;

	/**
	 * 回访评价满意度
	 */
	private String satisfied;

	/**
	 * 回访任务id
	 */
	private String visitId;

	/**
	 * 对外回复审批通过时间
	 */
	private Date replyApprovalDate;

	/**
	 * 对外回复申请时间
	 */
	private Date replySubmitDate;

	/**
	 * 对外回复内容
	 */
	private String externalReply;

	/**
	 * 对外回复状态
	 */
	private String replyReviewStatus;

	/**
	 * 支付方式
	 */
	private String payType;

	/**
	 * 实际工时
	 */
	private String workHour;

	/**
	 * 额定工时
	 */
	private String ratedWorkHour;

	/**
	 * 费用
	 */
	private String price;

	/**
	 * 参考金额
	 */
	private String ratedAmount;

	/**
	 * 材料费用
	 */
	private String materialPrice;

	/**
	 * 人工费用
	 */
	private String manmadePrice;

	/**
	 * 应收ID
	 */
	private String receivableId;

	/**
	 * 支付状态
	 */
	private String payStatus;

	/**
	 * 是否支付
	 */
	private String isPaid;

	/**
	 * 起单来源
	 */
	private String orignSource;

	/**
	 * 录单系统
	 */
	private String sourceType;

	/**
	 * 维修分类ID
	 */
	private String cateId;

	/**
	 * 关联的维修单ID
	 */
	private String mtainTaskid;

	/**
	 * 问题位置
	 */
	private String roomInfo;

	/**
	 * 是否房修单
	 */
	private String houseFixStatus;

	/**
	 * 房修关闭状态
	 */
	private String housefixCloseStatus;

	private String dwCreationBy;

	private Date dwCreationDate;

	private String dwLastUpdateBy;

	private Date dwLastUpdateDate;

	private Long dwBatchNumber;

}
