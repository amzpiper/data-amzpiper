package io.renren.modules.orders.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.orders.entity.AlarmsEntity;
import io.renren.modules.orders.entity.OrderExamineEntity;

import java.util.List;
import java.util.Map;

/**
 * @author guoyh
 */
public interface OrderExamineService extends IService<OrderExamineEntity> {

    /**
     * 根据id获取信息
     *
     * @return OrderExamineEntity
     * */
    OrderExamineEntity findById(String id);


    /**
     * 分页和条件查询
     *
     * @return Page<OrderExamineEntity>
     * */
    Page<OrderExamineEntity> findByPageAndCondition(Map<String, String> conditions);

    /**
     * 来源系统类型
     * @return
     */
    List<String> groupBySourceSystem();

    /**
     * 来源系统类型
     * @return
     */
    List<String> groupByTargetSystem();

    /**
     * 查询近7日审批数
     *
     * @return List<Map<String, Integer>>
     * */
    List<Map<String, Object>> findExamineApprovalNumberByName(String areaName, String projectName);

    /**
     * 查询近7日驳回数
     *
     * @return List<Map<String, Integer>>
     * */
    List<Map<String, Object>> findExamineOverruleNumberByName(String areaName, String projectName);

    /**
     * 当月每日审批数
     *
     * @return List<Map<String, Integer>>
     * */
    List<Map<String, Object>> findExamineApprovalMonthByName(String areaName, String projectName);

    /**
     * 当月每日驳回数
     *
     * @return List<Map<String, Integer>>
     * */
    List<Map<String, Object>> findExamineOverruleMonthByName(String areaName, String projectName);

    /**
     * 当年每月审批数据
     *
     * @return List<Map<String, Integer>>
     * */
    List<Map<String, Object>> findExamineApprovalYearByName(String areaName, String projectName);

    /**
     * 当年每月驳回数据
     *
     * @return List<Map<String, Integer>>
     * */
    List<Map<String, Object>> findExamineOverruleYearByName(String areaName, String projectName);

    /**
     * 今日审核工单
     * @return
     */
    Integer findExamineApprovalNumberToday(String areaName, String projectName);

    /**
     * 今日驳回工单
     * @return
     */
    Integer findExamineOverruleNumberToday(String areaName, String projectName);

    /**
     * 审核工单总数
     * @return
     */
    Integer findExamineApprovalNumber(String areaName, String projectName);

    /**
     * 今日驳回工单总数
     * @return
     */
    Integer findExamineOverruleNumber(String areaName, String projectName);
}
