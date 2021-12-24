package io.renren.modules.orders.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.orders.entity.OrdersEntity;

import java.util.List;
import java.util.Map;

/**
 * @author guoyh
 */
public interface OrdersService extends IService<OrdersEntity> {

    /**
     * 根据工单id获取工单信息
     * */
    OrdersEntity findOrdersById(String id);

    /**
     * 获取全部工单
     * */
    List<OrdersEntity> findAllOrders();

    /**
     * 分页查询
     *
     * @return*/
    Page<OrdersEntity> findOrdersByPage(Integer page, Integer size);

    /**
     * 新增工单
     *
     * @return*/
    boolean saveOrders(OrdersEntity orders);

    /**
     * 更新工单
     *
     * @return*/
    boolean updateOrders(OrdersEntity orders);

    /**
     * 删除工单
     *
     * @return*/
    boolean deleteOrdersById(String id);

    /**
     * 批量删除工单
     *
     * @return*/
    boolean deleteAllOrders(List<Long> asList);

      /**
     * 获取近7天分公司工单数量
     * */
    List<Map<Integer,String>> findOrderNumberByName(String areaName);

      /**
     * 获取近7天全国工单数量
     * */
    List<Map<Integer,String>> findOrderNumber();

      /**
     * 获取近7天的日期
     * */
    List<String> findDateIn7();

}
