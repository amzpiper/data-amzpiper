package io.renren.modules.orders.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.orders.entity.AlarmsEntity;
import io.renren.modules.orders.entity.OrdersEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;

import java.util.List;
import java.util.Map;


/**
 * @author guoyh
 */
@CacheNamespace(flushInterval = 2000,eviction = FifoCache.class,readWrite = false,size = 1024)
@Mapper
public interface AlarmsDao extends BaseMapper<AlarmsEntity> {

    /**
     * 警告类型
     * @return
     */
    public List<String> groupByAlarmsType();

    /**
     * 7日告警
     * @return
     */
    public List<Map<String,Object>> findAlarmsNumberByName();

    /**
     * 当月每日告警
     * @return
     */
    public List<Map<String,Object>> findAlarmsMonthByName();

    /**
     * 当年每月告警
     * @return
     */
    public List<Map<String,Object>> findAlarmsYearByName();

    /**
     * 今日告警
     * @return
     */
    Integer findAlarmsNumberToday();

    /**
     * 告警个数
     * @return
     */
    Integer findAlarmsNumber();

}
