package io.renren.modules.orders.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.orders.entity.OrderExamineEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;
import java.util.Map;

/**
 * @author guoyh
 */
@CacheNamespace(flushInterval = 2000,eviction = FifoCache.class,readWrite = false,size = 1024)
@Mapper
public interface OrderExamineDao extends BaseMapper<OrderExamineEntity> {

    /**
     * 7日审核工单
     * @param areaName
     * @return
     */
    public List<Map<String,Object>> findExamineApprovalNumberByName(@Param("areaName") String areaName, @Param("projectName") String projectName);

    /**
     * 7日驳回工单
     * @param areaName
     * @return
     */
    public List<Map<String,Object>> findExamineOverruleNumberByName(@Param("areaName") String areaName, @Param("projectName") String projectName);

    /**
     * 当月审核工单
     * @param areaName
     * @return
     */
    public List<Map<String,Object>> findExamineApprovalMonthByName(@Param("areaName") String areaName, @Param("projectName") String projectName);

    /**
     * 当年驳回工单
     * @param areaName
     * @return
     */
    public List<Map<String,Object>> findExamineOverruleMonthByName(@Param("areaName") String areaName, @Param("projectName") String projectName);

    /**
     * 当年审核工单
     * @param areaName
     * @return
     */
    public List<Map<String,Object>> findExamineApprovalYearByName(@Param("areaName") String areaName, @Param("projectName") String projectName);

    /**
     * 当月驳回工单
     * @param areaName
     * @return
     */
    public List<Map<String,Object>> findExamineOverruleYearByName(@Param("areaName") String areaName, @Param("projectName") String projectName);

    /**
     * 今日审核工单
     * @param areaName
     * @return
     */
    public Integer findExamineApprovalNumberToday(@Param("areaName") String areaName, @Param("projectName") String projectName);

    /**
     * 今日驳回工单
     * @param areaName
     * @return
     */
    public Integer findExamineOverruleNumberToday(@Param("areaName") String areaName, @Param("projectName") String projectName);


    /**
     * 审核工单总数
     * @param areaName
     * @return
     */
    public Integer findExamineApprovalNumber(@Param("areaName") String areaName, @Param("projectName") String projectName);

    /**
     * 驳回工单总数
     * @param areaName
     * @return
     */
    public Integer findExamineOverruleNumber(@Param("areaName") String areaName, @Param("projectName") String projectName);

    /**
     * 来源系统类型
     * @return
     */
    public List<String> groupBySourceSystem();

    /**
     * 目标系统类型
     * @return
     */
    public List<String> groupByTargetSystem();
}
