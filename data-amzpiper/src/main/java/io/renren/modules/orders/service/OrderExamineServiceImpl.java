package io.renren.modules.orders.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.orders.dao.OrderExamineDao;
import io.renren.modules.orders.entity.OrderExamineEntity;
import io.renren.modules.orders.utils.NotifyOtherSystem;
import io.renren.modules.sys.service.SysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guoyh
 */
@Service
public class OrderExamineServiceImpl extends ServiceImpl<OrderExamineDao, OrderExamineEntity> implements OrderExamineService {

    private ReentrantLock lock = new ReentrantLock(true);

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 查询一个通过id
     * @param id
     * @return OrderExamineEntity
     */
    @Override
    public OrderExamineEntity findById(String id) {
        OrderExamineEntity orderExamineEntity = this.getById(id);
        return orderExamineEntity;
    }

    /**
     * 分页条件查询查询
     *
     * @param conditions
     * @return Page<OrderExamineEntity>
     */
    @Override
    public Page<OrderExamineEntity> findByPageAndCondition(Map<String, String> conditions) {
        logger.info(conditions.toString());

        int currentPage = 1;
        int size = 10;
        if (conditions.get("currentPage") != null) {
            currentPage = Integer.valueOf(conditions.get("currentPage"));
        }
        if (conditions.get("size") != null) {
            size = Integer.valueOf(conditions.get("size"));
        }
        Page<OrderExamineEntity> page = new Page<>(currentPage, size);

        QueryWrapper<OrderExamineEntity> queryWrapper = new QueryWrapper<>();
        // 筛选工单详情
        if (conditions.get("quesDesc") != null) {
            if (!conditions.get("quesDesc").equals("")){
                queryWrapper.like("ques_desc", conditions.get("quesDesc"));
            }
        }
        // 筛选审批状态
        if (conditions.get("isApproval") != null) {
            if (!conditions.get("isApproval").equals("")) {
                queryWrapper.eq("examine_status", conditions.get("isApproval"));
            }
        }
        // 筛选来源系统
        if (conditions.get("sourceSystem") != null) {
            if (!conditions.get("sourceSystem").equals("")) {
                queryWrapper.eq("source_system", conditions.get("sourceSystem"));
            }
        }
        // 筛选目标系统
        if (conditions.get("targetSystem") != null) {
            if (!conditions.get("targetSystem").equals("")) {
                queryWrapper.eq("target_system", conditions.get("targetSystem"));
            }
        }
        // 排序-未审批(0)靠前-时间倒叙-最新靠前
        queryWrapper.orderByAsc("examine_status");
        queryWrapper.orderByDesc("adtec_create_date");
        queryWrapper.orderByDesc("adtec_update_date");
        return this.page(page, queryWrapper);
    }

    /**
     * 来源系统类型
     * @return
     */
    @Override
    public List<String> groupBySourceSystem() {
        List<String> sourceSystemTypeList = baseMapper.groupBySourceSystem();
        if (sourceSystemTypeList == null || sourceSystemTypeList.size() == 0) {
            logger.warn("sourceSystemTypeList is NULL");
            sourceSystemTypeList = new ArrayList<>();
            sourceSystemTypeList.add("无");
        }
        return sourceSystemTypeList;
    }

    /**
     * 目标系统类型
     * @return
     */
    @Override
    public List<String> groupByTargetSystem() {
        List<String> targetSystemTypeList = baseMapper.groupByTargetSystem();
        if (targetSystemTypeList == null || targetSystemTypeList.size() == 0) {
            logger.warn("sourceSystemTypeList is NULL");
            targetSystemTypeList = new ArrayList<>();
            targetSystemTypeList.add("无");
        }
        return targetSystemTypeList;
    }

     /**
     * 近7日审批数据
     *
     * @param areaName
     * @return List<Map<String, Integer>>
     */
    @Override
    public List<Map<String, Object>> findExamineApprovalNumberByName(String areaName, String projectName){
         if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        List<Map<String,Object>> orderList =  baseMapper.findExamineApprovalNumberByName(areaName, projectName);
        logger.info(orderList.toString());
        return orderList;
    }

    /**
     * 近7日驳回数据
     *
     * @param areaName
     * @return List<Map<String, Integer>>
     */
    @Override
    public List<Map<String, Object>> findExamineOverruleNumberByName(String areaName, String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        List<Map<String,Object>> orderList =  baseMapper.findExamineOverruleNumberByName(areaName, projectName);
        logger.info(orderList.toString());
        return orderList;
    }

    /**
     * 当月每日审批数据
     *
     * @param areaName
     * @return List<Map<String, Integer>>
     */
    @Override
    public List<Map<String, Object>> findExamineApprovalMonthByName(String areaName, String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        List<Map<String,Object>> orderList =  baseMapper.findExamineApprovalMonthByName(areaName, projectName);
        logger.info("当月每日审批数据:"+orderList.toString());
        return orderList;
    }

    /**
     * 当月每日驳回数据
     *
     * @param areaName
     * @return List<Map<String, Integer>>
     */
    @Override
    public List<Map<String, Object>> findExamineOverruleMonthByName(String areaName, String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        List<Map<String,Object>> orderList =  baseMapper.findExamineOverruleMonthByName(areaName, projectName);
        logger.info("当月每日驳回数据:"+orderList.toString());
        return orderList;
    }

    /**
     * 当年每月审批数据
     *
     * @param areaName
     * @return List<Map<String, Integer>>
     */
    @Override
    public List<Map<String, Object>> findExamineApprovalYearByName(String areaName, String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        List<Map<String,Object>> orderList =  baseMapper.findExamineApprovalYearByName(areaName, projectName);
        logger.info("当年每月审批数据:"+orderList.toString());
        return orderList;
    }

    /**
     * 当年每月驳回数据
     *
     * @param areaName
     * @return List<Map<String, Integer>>
     */
    @Override
    public List<Map<String, Object>> findExamineOverruleYearByName(String areaName, String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        List<Map<String,Object>> orderList =  baseMapper.findExamineOverruleYearByName(areaName, projectName);
        logger.info("当年每月驳回数据:"+orderList.toString());
        return orderList;
    }

     /**
     * 今日审批工单个数
     *
     * @param areaName
     * @return Integer
     */
    @Override
    public Integer findExamineApprovalNumberToday(String areaName, String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        Integer order =  baseMapper.findExamineApprovalNumberToday(areaName, projectName);
         if(order == null){
            order = 0;
        }
        logger.info(order+"");
        return order;
    }

    /**
     * 今日审批工单个数
     *
     * @param areaName
     * @return Integer
     */
    @Override
    public Integer findExamineOverruleNumberToday(String areaName, String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        Integer order =  baseMapper.findExamineOverruleNumberToday(areaName, projectName);
        if(order == null){
            order = 0;
        }
        logger.info(order+"");
        return order;
    }

    /**
     * 审批工单总数
     *
     * @param areaName
     * @return Integer
     */
    @Override
    public Integer findExamineApprovalNumber(String areaName, String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        Integer order =  baseMapper.findExamineApprovalNumber(areaName, projectName);
        if(order == null){
            order = 0;
        }
        logger.info(order+"");
        return order;
    }

    /**
     * 驳回工单总数
     *
     * @param areaName
     * @return Integer
     */
    @Override
    public Integer findExamineOverruleNumber(String areaName, String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        Integer order =  baseMapper.findExamineOverruleNumber(areaName, projectName);
        if(order == null){
            order = 0;
        }
        logger.info(order+"");
        return order;
    }
}
