package io.renren.modules.orders.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.orders.entity.BuildingQuesEntity;
import io.renren.modules.orders.entity.OrdersEntity;
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
public interface BuildingQuesDao extends BaseMapper<BuildingQuesEntity> {

    /**
     * 所有问题类型
     * @return
     */
    public List<String> groupByQuestionType();

    /**
     * 所有分公司分类
     * @return
     */
    public List<String> groupByAreaName();

    /**
     * 所有项目分类
     * @return
     */
    public List<String> groupByProjectName(String areaName);

    /**
     * 7日工单
     * @param areaName
     * @param projectName
     * @return
     */
    public List<Map<String,Object>> findOrderNumberByName(@Param("areaName") String areaName, @Param("projectName")String projectName);

    /**
     * 当月每日工单数
     * @param areaName
     * @param projectName
     * @return
     */
    public List<Map<String,Object>> findOrderMonthByName(@Param("areaName") String areaName, @Param("projectName")String projectName);

    /**
     * 当年每月工单数
     * @param areaName
     * @param projectName
     * @return
     */
    public List<Map<String,Object>> findOrderYearByName(@Param("areaName") String areaName, @Param("projectName")String projectName);

    /**
     * 7日日期
     *
     * @return
     */
    public Map<String,String> findDateIn7();

    /**
     * 今日工单个数
     *
     * @return
     */
    public Integer findOrderNumberToday(@Param("areaName") String areaName, @Param("projectName")String projectName);

    /**
     * 工单个数
     *
     * @return
     */
    public Integer findOrderNumber(@Param("areaName") String areaName, @Param("projectName")String projectName);

}
