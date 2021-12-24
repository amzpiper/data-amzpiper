/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.orders.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.orders.dao.OrdersDao;
import io.renren.modules.orders.entity.OrdersEntity;
import io.renren.modules.orders.service.OrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersServiceTest {

    //service层测试
    @Autowired
    public OrdersService ordersService;

    //查询全部
    @Test
    public void testOrdersServiceFindAllOrders() {
        List<OrdersEntity> ordersEntityList = ordersService.findAllOrders();
        ordersEntityList.forEach(System.out::println);
    }

    //分页查询
    @Test
    public void testOrdersServiceFindOrdersByPage() {
        Page<OrdersEntity> orders = ordersService.findOrdersByPage(1,2);
        orders.getRecords().forEach(System.out::println);
    }

    //查询一个
    @Test
    public void testOrdersServiceFindOrdersById() {
        OrdersEntity orders = ordersService.findOrdersById("1");
        System.out.println(orders);
    }

    //插入一个未审批工单
    @Test
    public void testOrdersServiceSaveOrders() {
        OrdersEntity orders = new OrdersEntity();
        orders.setOrderName("测试工单new")
                .setDescription("测试工单new")
                .setCreateTime(new Date())
                .setUpdateTime(new Date())
                .setDeflag("0")
                .setApproval("0");
        boolean flag = ordersService.saveOrders(orders);
        System.out.println(flag);
    }

    //修改一个工单
    @Test
    public void testOrdersServiceUpdateOrders() {
        OrdersEntity orders = ordersService.findOrdersById("1");
        orders.setOrderName("修改后的测试工单2")
                .setDescription("修改后的测试工单2")
                .setCreateTime(new Date())
                .setUpdateTime(new Date())
                .setDeflag("0")
                .setApproval("1");

        boolean flag = ordersService.updateOrders(orders);
        System.out.println(flag);

        //异常后是否回滚测试
        //throw new NullPointerException();
    }

    //删除一个工单
    @Test
    public void testOrdersServiceDeleteOrdersById() {
        OrdersEntity orders = ordersService.findOrdersById("4");
        boolean flag = ordersService.deleteOrdersById(orders.getOrderId());
        System.out.println(flag);
    }

    //删除多个工单
    @Test
    public void testOrdersServiceUp() {
        List list = new ArrayList();
        list.add(3);
        list.add(4);
        boolean flag = ordersService.deleteAllOrders(list);
        System.out.println(flag);
    }

}
