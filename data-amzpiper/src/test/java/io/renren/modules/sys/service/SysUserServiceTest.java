/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.sys.service;

import io.renren.modules.orders.entity.AlarmsEntity;
import io.renren.modules.orders.service.AlarmsService;
import io.renren.modules.sys.entity.SysUserEntity;
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
public class SysUserServiceTest {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;


    @Test
    public void test() {
        //Long userId = 1453604054853021700L;
        //System.out.println("userId:" + userId);
        //
        //SysUserEntity user = sysUserService.getById(userId);
        //System.out.println("info/user:"+user);
        //
        ////获取用户所属的角色列表
        //List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        //user.setRoleIdList(roleIdList);
    }

}
