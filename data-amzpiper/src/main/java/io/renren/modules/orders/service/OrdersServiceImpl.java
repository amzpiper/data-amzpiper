package io.renren.modules.orders.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.orders.dao.OrdersDao;
import io.renren.modules.orders.entity.OrdersEntity;
import org.apache.ibatis.annotations.Param;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersEntity> implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;
    private ReentrantLock lock = new ReentrantLock(true);
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 查询一个工单通过id
     * @param id
     * @return OrdersEntity
     */
    @Override
    public OrdersEntity findOrdersById(String id) {
        OrdersEntity orders = this.getById(id);
        return orders;
    }

    /**
     * 查询所有工单
     * @return List<OrdersEntity>
     */
    @Override
    public List<OrdersEntity> findAllOrders() {
        List<OrdersEntity> ordersList = this.list();
        return ordersList;
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return Page<OrdersEntity>
     */
    @Override
    public Page<OrdersEntity> findOrdersByPage(Integer page,Integer size) {
        Page<OrdersEntity> IPage=new Page<>(page,size);
        return this.page(IPage);
    }

    /**
     * 保存工单
     * @return boolean
     */
    @Override
    public boolean saveOrders(OrdersEntity orders) {
        boolean flag = this.save(orders);
        return flag;
    }

    /**
     * 更新工单信息-审批
     * @param orders
     * @return
     */
    @Override
    public boolean updateOrders(OrdersEntity orders) {
        boolean flag = this.updateById(orders);
        return flag;
    }

    @Override
    public boolean deleteOrdersById(String id) {
        boolean flag = this.removeById(id);
        return flag;
    }

    @Override
    public boolean deleteAllOrders(List<Long> asList) {
        boolean flag = this.removeByIds(asList);
        return flag;
    }

    @Override
    public List<Map<Integer,String>> findOrderNumberByName(String areaName){
        List<Map<Integer,String>> orderList =  baseMapper.findOrderNumberByName(areaName);
        logger.info(orderList.toString());
        return orderList;
    }

    @Override
    public List<Map<Integer,String>> findOrderNumber(){
        List<Map<Integer,String>> orderList =  baseMapper.findOrderNumber();
        logger.info(orderList.toString());
        return orderList;
    }

    @Override
    public List<String> findDateIn7(){
        List<String> dateList =  baseMapper.findDateIn7();
        logger.info(dateList.toString());
        return dateList;
    }
}
