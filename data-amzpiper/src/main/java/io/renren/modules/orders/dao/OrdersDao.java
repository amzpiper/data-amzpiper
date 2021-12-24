package io.renren.modules.orders.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.orders.entity.OrdersEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author guoyh
 */
@Mapper
public interface OrdersDao extends BaseMapper<OrdersEntity> {
    List<Map<Integer,String>> findOrderNumberByName(String areaName);

    List<Map<Integer,String>> findOrderNumber();

    List findDateIn7();
}
