/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.orders.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.orders.entity.BuildingQuesEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildingQuesDaoTest {

    //dao层测试
    @Autowired
    public BuildingQuesDao buildingQuesDao;

    //分页查询
    @Test
    public void testMapperSelectAll() {
        IPage<BuildingQuesEntity> page = new Page<>(1,10);
        IPage<BuildingQuesEntity> buildingQuesEntityIPage = buildingQuesDao.selectPage(page, null);
        List<BuildingQuesEntity> records = buildingQuesEntityIPage.getRecords();
        for (BuildingQuesEntity buildingQuesEntity : records) {
            System.out.println(buildingQuesEntity.getStartDate().toString());
        }
    }

    //查询所有工单类型
    @Test
    public void test() {
        List<String> list = buildingQuesDao.groupByQuestionType();
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testFindDateIn7() {
        Map<String,String> list = buildingQuesDao.findDateIn7();
        for (Map.Entry<String, String> entry : list.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }

    @Test
    public void testFindOrderNumberByName() {
        List<Map<String, Object>> orderNumberByName = buildingQuesDao.findOrderNumberByName(null,null);
        for (Map<String, Object> stringIntegerMap : orderNumberByName) {
            for (Map.Entry<String, Object> entry : stringIntegerMap.entrySet()) {
                System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            }

            for (Map.Entry<String, Object> entry : stringIntegerMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println("key = " + key + ", value = " + value);
            }
        }
    }
}
