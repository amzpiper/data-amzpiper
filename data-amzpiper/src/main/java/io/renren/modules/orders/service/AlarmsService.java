package io.renren.modules.orders.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.orders.entity.AlarmsEntity;
import io.renren.modules.orders.entity.BuildingQuesEntity;
import io.renren.modules.orders.entity.OrderExamineEntity;

import java.util.List;
import java.util.Map;

/**
 * @author guoyh
 */
public interface AlarmsService extends IService<AlarmsEntity> {

    /**
     * 存储AlarmsEntity,并创建审批工单
     * @param entity
     * @return boolean
     */
    boolean saveOrCreateOrder(AlarmsEntity entity);

    /**
     * 查询单个详情
     * @return AlarmsEntity
     * */
    AlarmsEntity findById(String id);

    /**
     * 条件分页查询
     * @return Page<AlarmsEntity>
     * */
    Page<AlarmsEntity> findByPageAndCondtion(Map<String, String> conditions);

    /**
     * 类型列表
     * @return List<String>
     */
    List<String> groupType();

    /**
     * 查询今7天指标数
     *
     * @return
     */
    List<Map<String,Object>> findAlarmsNumberByName();

    /**
     * 当月每日告警
     *
     * @return
     */
    List<Map<String,Object>> findAlarmsMonthByName();

    /**
     * 当月每日告警
     *
     * @return
     */
    List<Map<String,Object>> findAlarmsYearByName();

    /**
     * 查询今日指标数
     *
     * @return
     */
    Integer findAlarmsNumberToday();

    /**
     * 查询今日指标数
     *
     * @return
     */
    Integer findAlarmsNumber();
}
