package io.renren.modules.orders.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.orders.controller.OrderExamineController;
import io.renren.modules.orders.dao.AlarmsDao;
import io.renren.modules.orders.entity.AlarmsEntity;
import io.renren.modules.orders.entity.AlarmsEntity;
import io.renren.modules.orders.entity.OrderExamineEntity;
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
public class AlarmsServiceImpl extends ServiceImpl<AlarmsDao, AlarmsEntity> implements AlarmsService {

    private ReentrantLock lock = new ReentrantLock(true);
    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 存储AlarmsEntity,并创建审批工单
     *
     * @param entity
     * @return boolean
     */
    @Override
    public boolean saveOrCreateOrder(AlarmsEntity entity) {
        boolean flag = this.save(entity);
        return flag;
    }

    /**
     * 查询一个通过id
     *
     * @param id
     * @return AlarmsEntity
     */
    @Override
    public AlarmsEntity findById(String id) {
        AlarmsEntity alarmsEntity = this.getById(id);
        return alarmsEntity;
    }

    /**
     * 条件分页查询
     *
     * @param conditions
     * @return Page<AlarmsEntity>
     */
    @Override
    public Page<AlarmsEntity> findByPageAndCondtion(Map<String, String> conditions) {
        logger.info(conditions.toString());

        int currentPage = 1;
        int size = 10;
        if (conditions.get("currentPage") != null) {
            currentPage = Integer.valueOf(conditions.get("currentPage"));
        }
        if (conditions.get("size") != null) {
            size = Integer.valueOf(conditions.get("size"));
        }
        Page<AlarmsEntity> page = new Page<AlarmsEntity>(currentPage, size);

        QueryWrapper<AlarmsEntity> queryWrapper = new QueryWrapper<>();
        if (conditions.get("alarmName") != null) {
            if (!conditions.get("alarmName").equals("")){
                queryWrapper.like("alarm_name", conditions.get("alarmName"));
            }
        }
        if (conditions.get("alarmType") != null) {
            if (!conditions.get("alarmType").equals("")) {
                queryWrapper.eq("alarm_type", conditions.get("alarmType"));
            }
        }
        // 排序-未处理(0)靠前-时间倒叙-最新靠前
        queryWrapper.orderByAsc("adtec_status");
        queryWrapper.orderByDesc("adtec_create_date");
        queryWrapper.orderByDesc("adtec_update_date");
        return this.page(page, queryWrapper);
    }

    /**
     * 获取分类
     *
     * @return
     */
    @Override
    public List<String> groupType() {
        List<String> AlarmsTypeList = baseMapper.groupByAlarmsType();
        logger.info(AlarmsTypeList.toString());
        if (AlarmsTypeList == null || AlarmsTypeList.size() == 0) {
            logger.warn("list is NULL");
            AlarmsTypeList = new ArrayList<>();
            AlarmsTypeList.add("无");
        }
        return AlarmsTypeList;
    }

    /**
     * 查询今7天指标数
     *
     * @return
     */
    @Override
    public List<Map<String,Object>> findAlarmsNumberByName() {
        List<Map<String,Object>> alarmsList =  baseMapper.findAlarmsNumberByName();
        logger.info(alarmsList.toString());
        return alarmsList;
    }

    /**
     * 当月每日告警
     *
     * @return
     */
    @Override
    public List<Map<String,Object>> findAlarmsMonthByName() {
        List<Map<String,Object>> alarmsList =  baseMapper.findAlarmsMonthByName();
        logger.info("当月每日告警:"+alarmsList.toString());
        return alarmsList;
    }

    /**
     * 当年每月告警
     *
     * @return
     */
    @Override
    public List<Map<String,Object>> findAlarmsYearByName() {
        List<Map<String,Object>> alarmsList =  baseMapper.findAlarmsYearByName();
        logger.info("当年每月告警:"+alarmsList.toString());
        return alarmsList;
    }

    /**
     * 查询今天指标数
     *
     * @return
     */
    @Override
    public Integer findAlarmsNumberToday() {
        Integer alarm =  baseMapper.findAlarmsNumberToday();
        if(alarm == null){
            alarm = 0;
        }
        logger.info(alarm+"");
        return alarm;
    }

    /**
     * 查询指标数
     *
     * @return
     */
    @Override
    public Integer findAlarmsNumber() {
        Integer alarm =  baseMapper.findAlarmsNumber();
        if(alarm == null){
            alarm = 0;
        }
        logger.info(alarm+"");
        return alarm;
    }

}
