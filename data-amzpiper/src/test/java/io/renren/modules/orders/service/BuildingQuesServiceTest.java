/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.orders.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.orders.entity.BuildingQuesEntity;
import io.renren.modules.orders.entity.OrdersEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildingQuesServiceTest {

    //service层测试
    @Autowired
    public BuildingQuesService buildingQuesService;

    //分页查询
    @Test
    public void test() {
        Map<String, String> conditions = new HashMap<>();
        conditions.put("currentPage","2");
        conditions.put("size","10");
        conditions.put("quesDesc","");
        conditions.put("questionType","报事");
        conditions.put("areaName","");
        Page<BuildingQuesEntity> page = buildingQuesService.findByPageAndCondtion(conditions);
        page.getRecords().forEach(System.out::println);
    }

    //查询一个
    @Test
    public void test2() {
        BuildingQuesEntity entity = buildingQuesService.findById("006280cd-ae8f-4f36-b90e-e0757f3e4319");
        System.out.println(entity.toString());
    }

    //查询所有工单类型
    @Test
    public void test3() {
        List<String> list = buildingQuesService.groupByQuestionType();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
