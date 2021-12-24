/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.orders.dao;

import io.renren.modules.orders.entity.AlarmsEntity;
import io.renren.modules.orders.entity.OrdersEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlarmsDaoTest {

    //dao层测试
    @Autowired
    public AlarmsDao alarmsDao;

    //查询
    @Test
    public void testMapperSelectAll() {
        System.out.println(("----- selectAll method test ------"));
        List<AlarmsEntity> userList = alarmsDao.selectList(null);
        userList.forEach(System.out::println);
    }
}
