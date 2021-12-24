/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.orders.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public class OrdersDaoTest {

    //dao层测试
    @Autowired
    public OrdersDao ordersDao;

    //查询
    @Test
    public void testMapperSelectAll() {
        System.out.println(("----- selectAll method test ------"));
        List<OrdersEntity> userList = ordersDao.selectList(null);
        userList.forEach(System.out::println);
    }
}
