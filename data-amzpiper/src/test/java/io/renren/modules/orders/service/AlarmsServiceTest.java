/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.orders.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.orders.entity.AlarmsEntity;
import io.renren.modules.orders.entity.BuildingQuesEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlarmsServiceTest {

    //service层测试
    @Autowired
    public AlarmsService alarmsService;

    //分页查询
    @Test
    public void test() {
        List<AlarmsEntity> list = alarmsService.list();
        for (AlarmsEntity entity : list) {
            System.out.println(entity.toString());
        }
    }

    //查询一个
    @Test
    public void test2() {
        AlarmsEntity entity = alarmsService.getById("1");
        System.out.println(entity.toString());
        AlarmsEntity entity2 = alarmsService.getById("1");
        System.out.println(entity2.toString());
    }
}
