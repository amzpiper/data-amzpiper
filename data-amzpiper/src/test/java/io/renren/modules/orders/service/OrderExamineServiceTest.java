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
import io.renren.modules.orders.entity.OrderExamineEntity;
import io.renren.modules.orders.vo.OrderExamineListVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderExamineServiceTest {

    //service层测试
    @Autowired
    public OrderExamineService orderExamineService;

    //分页查询
    @Test
    public void test() {
        Map<String, String> conditions = new HashMap<>();
        conditions.put("currentPage","1");
        conditions.put("size","10");
        //conditions.put("quesDesc","123");
        //conditions.put("isApproval","1");
        Page<OrderExamineEntity> page = orderExamineService.findByPageAndCondition(conditions);
        //for (OrderExamineEntity entity : page.getRecords()) {
        //    System.out.println(entity.toString());
        //}
        List<OrderExamineListVo> voList = page.getRecords().stream().map(dto -> {
            OrderExamineListVo vo = new OrderExamineListVo();
            BeanUtils.copyProperties(dto,vo);
            return vo;
        }).collect(Collectors.toList());
        for (OrderExamineListVo entity : voList) {
            System.out.println(entity.toString());
        }
    }

    //查询一个
    @Test
    public void test2() {
        OrderExamineEntity entity = orderExamineService.getById("1");
        System.out.println(entity.toString());
    }
}
