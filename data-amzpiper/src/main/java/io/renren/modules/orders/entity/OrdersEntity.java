package io.renren.modules.orders.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@TableName("orders")
public class OrdersEntity {
    /**
     * 工单id
     */
    @TableId(type= IdType.ASSIGN_UUID)
    private String orderId;

    /**
     * 工单名
     */
    private String orderName;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除[0 - 未删除，1 - 删除]
     */
    @TableLogic
    private String deflag;

    /**
     * 是否审批[0 - 未审批，1 - 审批]
     */
    private String approval;
}
