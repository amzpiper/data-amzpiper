package io.renren.modules.orders.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.orders.dao.BuildingQuesDao;
import io.renren.modules.orders.entity.BuildingQuesEntity;
import io.renren.modules.orders.entity.OrdersEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guoyh
 */
@Service
public class BuildingQuesServiceImpl extends ServiceImpl<BuildingQuesDao, BuildingQuesEntity> implements BuildingQuesService {

    private ReentrantLock lock = new ReentrantLock(true);
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 查询一个工单通过id
     * @param id
     * @return BuildingQuesEntity
     */
    @Override
    public BuildingQuesEntity findById(String id) {
        BuildingQuesEntity buildingQues = this.getById(id);
        return buildingQues;
    }

    /**
     * 分页条件查询
     *
     * @param conditions currentPage: int,
     *                   size: int,
     *                   quesDesc: String,
     *                   questionType: String,
     *                   areaName: String
     * @return Page<BuildingQuesEntity>
     */
    @Override
    public Page<BuildingQuesEntity> findByPageAndCondtion(Map<String, String> conditions) {
        logger.info(conditions.toString());

        int currentPage = 1;
        int size = 10;
        if (conditions.get("currentPage") != null) {
            currentPage = Integer.valueOf(conditions.get("currentPage"));
        }
        if (conditions.get("size") != null) {
            size = Integer.valueOf(conditions.get("size"));
        }
        Page<BuildingQuesEntity> page = new Page<BuildingQuesEntity>(currentPage, size);

        QueryWrapper<BuildingQuesEntity> queryWrapper = new QueryWrapper<>();
        if (conditions.get("quesDesc") != null) {
            if (!conditions.get("quesDesc").equals("")){
                queryWrapper.like("ques_desc", conditions.get("quesDesc"));
            }
        }
        if (conditions.get("questionType") != null) {
            if (!conditions.get("questionType").equals("")) {
                queryWrapper.eq("question_type", conditions.get("questionType"));
            }
        }
        if (conditions.get("areaName") != null) {
            if (!conditions.get("areaName").equals("") && !conditions.get("areaName").equals("全国")) {
                queryWrapper.eq("area_name", conditions.get("areaName"));
            }
        }
        if (conditions.get("projectName") != null) {
            if (!conditions.get("projectName").equals("") && !conditions.get("projectName").equals("所有项目")) {
                queryWrapper.eq("project_name", conditions.get("projectName"));
            }
        }
        queryWrapper.orderByDesc("create_date");
        return this.page(page, queryWrapper);
    }

    /**
     * 获取工单所有类型列表
     *
     * @return List<String>
     */
    @Override
    public List<String> groupByQuestionType() {
        List<String> list = baseMapper.groupByQuestionType();
        logger.info(list.toString());
        return list;
    }

    /**
     * 获取工单所有分公司列表
     *
     * @return List<String>
     */
    @Override
    public List<String> groupByAreaName(){
        List<String> list = baseMapper.groupByAreaName();
        logger.info(list.toString());
        return list;
    }

    /**
     * 获取工单所有分公司列表
     *
     * @return List<String>
     */
    @Override
    public List<String> groupByProjectName(String areaName){
         if (areaName.equals("全国")) {
            areaName = null;
        }
        List<String> list = baseMapper.groupByProjectName(areaName);
        logger.info(list.toString());
        return list;
    }

    /**
     * 查询今7天指标数
     *
     * @param areaName
     * @param projectName
     * @return List<Integer>
     */
    @Override
    public List<Map<String,Object>> findOrderNumberByName(String areaName,String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        List<Map<String,Object>> orderList =  baseMapper.findOrderNumberByName(areaName,projectName);
        logger.info(orderList.toString());
        return orderList;
    }

    /**
     * 当月每日指标数
     *
     * @param areaName
     * @param projectName
     * @return List<Integer>
     */
    @Override
    public List<Map<String,Object>> findOrderMonthByName(String areaName,String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        List<Map<String,Object>> orderList =  baseMapper.findOrderMonthByName(areaName,projectName);
        logger.info("当月每日指标数:"+orderList.toString());
        return orderList;
    }

    /**
     * 当年每月工单数
     *
     * @param areaName
     * @param projectName
     * @return List<Integer>
     */
    @Override
    public List<Map<String,Object>> findOrderYearByName(String areaName,String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        List<Map<String,Object>> orderList =  baseMapper.findOrderYearByName(areaName,projectName);
        logger.info("当年每月工单数:"+orderList.toString());
        return orderList;
    }

    /**
     * 今日工单个数
     * @param areaName
     * @param projectName
     * @return
     */
    @Override
    public Integer findOrderNumberToday(String areaName,String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        Integer data = baseMapper.findOrderNumberToday(areaName, projectName);
        
        logger.info(data+"");
        if(data == null){
            data = 0;
        }
        return data;
    }

    /**
     * 工单总数
     * @param areaName
     * @param projectName
     * @return
     */
    @Override
    public Integer findOrderNumber(String areaName,String projectName){
        if (areaName.equals("全国")||!projectName.equals("所有项目")) {
            areaName = null;
        }
        if (projectName.equals("所有项目")) {
            projectName = null;
        }
        Integer data = baseMapper.findOrderNumber(areaName,projectName);
        logger.info(data+"");
        if(data == null){
            data = 0;
        }
        return data;
    }

    @Override
    public Map<String,String> findDateIn7(){
        Map<String,String> dateList = baseMapper.findDateIn7();
        logger.info(dateList.toString());
        return dateList;
    }
}
