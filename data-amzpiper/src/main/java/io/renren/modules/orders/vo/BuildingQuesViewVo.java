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
 * 工单展示详情
 *
 * @author guoyh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //生产的setter方法返回this
public class BuildingQuesViewVo {

    /**
     * 问题任务ID
     */
    private String questaskId;

    /**
     * 问题描述
     */
    private String quesDesc;


    /**
     * 问题类型
     */
    private String questionType;

    /**
     * 问题类型
     */
    private String sourceSystem;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 派单时间
     */
    private Date giveOutDate;

    /**
     * 接单时间
     */
    private Date acceptDate;

    /**
     * 完成时间
     */
    private Date finishDate;

    /**
     * 关闭时间
     */
    private Date closeDate;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 请求来源
     */
    private String taskSource;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系地址
     */
    private String contactAddress;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 区域名称
     */
    private String areaName;

}
