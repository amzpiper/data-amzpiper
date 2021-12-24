package io.renren.modules.orders.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.orders.entity.BuildingQuesEntity;
import io.renren.modules.orders.entity.OrdersEntity;

import java.util.List;
import java.util.Map;

/**
 * @author guoyh
 */
public interface BuildingQuesService extends IService<BuildingQuesEntity> {

    /**
     * 根据id获取工单信息
     *
     * @return BuildingQuesEntity
     */
    BuildingQuesEntity findById(String id);

    /**
     * 分页条件查询
     *
     * @return Page<BuildingQuesEntity>
     */
    Page<BuildingQuesEntity> findByPageAndCondtion(Map<String, String> conditions);

    /**
     * 获取工单所有类型列表
     *
     * @return List<String>
     */
    List<String> groupByQuestionType();

    /**
     * 获取工单所有分公司列表
     *
     * @return List<String>
     */
    List<String> groupByAreaName();

    /**
     * 获取工单所有项目列表
     *
     * @return List<String>
     */
    List<String> groupByProjectName(String areaName);

    /**
     * 查询今7天指标数
     *
     * @param areaName
     * @param projectName
     * @return
     */
    List<Map<String,Object>> findOrderNumberByName(String areaName,String projectName);

    /**
     * 当月每日指标数
     *
     * @param areaName
     * @param projectName
     * @return
     */
    List<Map<String, Object>> findOrderMonthByName(String areaName, String projectName);

    /**
     * 当年每月工单数
     *
     * @param areaName
     * @param projectName
     * @return
     */
    List<Map<String, Object>> findOrderYearByName(String areaName, String projectName);

    /**
     * 查询今7天日期

     * @return
     */
    Map<String,String> findDateIn7();

    /**
     * 今日工单个数
    * @return
     */
    Integer findOrderNumberToday(String areaName,String projectName);

    /**
     * 工单个数
     * @return
     */
    Integer findOrderNumber(String areaName,String projectName);
}
