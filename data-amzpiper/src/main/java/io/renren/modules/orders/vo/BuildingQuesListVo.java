package io.renren.modules.orders.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 工单展示列表
 *
 * @author guoyh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //生产的setter方法返回this
public class BuildingQuesListVo {

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
     * 任务状态
     */
    private String qusetaskState;

    /**
     * 来源系统
     */
    private String sourceSystem;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 项目名称
     */
    private String projectName;
}
