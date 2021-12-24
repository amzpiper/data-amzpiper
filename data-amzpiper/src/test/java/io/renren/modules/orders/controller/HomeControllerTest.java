package io.renren.modules.orders.controller;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.orders.service.AlarmsService;
import io.renren.modules.orders.service.BuildingQuesService;
import io.renren.modules.orders.service.OrderExamineService;
import io.renren.modules.orders.utils.DateListUtil;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTest {


    /**
     * 审批工单
     */
    @Autowired
    OrderExamineService orderExamineService;

    /**
     * 告警数据
     */
    @Autowired
    AlarmsService alarmsService;

    /**
     * 今日工单
     */
    @Autowired
    BuildingQuesService buildingQuesService;

    /**
     * 查询近7天指标数
     */
    @Test
    public R number(@RequestParam String areaName, String projectName) {
        // 7日工单数
        List<Map<String, Object>> orderList = buildingQuesService.findOrderNumberByName(areaName,projectName);
        // 7日告警数
        List<Map<String, Object>> alarmsList = alarmsService.findAlarmsNumberByName();
        // 7日审核数
        List<Map<String, Object>> examineApprovalList = orderExamineService.findExamineApprovalNumberByName(areaName,projectName);
        // 7日驳回数
        List<Map<String, Object>> examineOverruleList = orderExamineService.findExamineOverruleNumberByName(areaName, projectName);

        return R.ok()
                .put("dateList", DateListUtil.getDaysOf7())
                .put("orderList", DateListUtil.compareDaysOf7(orderList))
                .put("alarmsList", DateListUtil.compareDaysOf7(alarmsList))
                .put("examineApprovalList", DateListUtil.compareDaysOf7(examineApprovalList))
                .put("examineOverruleList", DateListUtil.compareDaysOf7(examineOverruleList));
    }

    /**
     * 查询当月每日指标数
     */
    @Test
    public R month(@RequestParam String areaName, String projectName) {
        // 当月工单数
        List<Map<String, Object>> orderList = buildingQuesService.findOrderMonthByName(areaName,projectName);
        // 当月告警数
        List<Map<String, Object>> alarmsList = alarmsService.findAlarmsMonthByName();
        // 当月审核数
        List<Map<String, Object>> examineApprovalList = orderExamineService.findExamineApprovalMonthByName(areaName,projectName);
        // 当月驳回数
        List<Map<String, Object>> examineOverruleList = orderExamineService.findExamineOverruleMonthByName(areaName,projectName);

        return R.ok()
                .put("dateList", DateListUtil.getDays())
                .put("orderList", DateListUtil.compareMonths(orderList))
                .put("alarmsList", DateListUtil.compareMonths(alarmsList))
                .put("examineApprovalList", DateListUtil.compareMonths(examineApprovalList))
                .put("examineOverruleList", DateListUtil.compareMonths(examineOverruleList));
    }

    /**
     * 查询当年每月指标数
     */
    @Test
    public R year(@RequestParam String areaName, String projectName) {
        // 当年工单数
        List<Map<String, Object>> orderList = buildingQuesService.findOrderYearByName(areaName,projectName);
        // 当年告警数
        List<Map<String, Object>> alarmsList = alarmsService.findAlarmsYearByName();
        // 当年审核数
        List<Map<String, Object>> examineApprovalList = orderExamineService.findExamineApprovalYearByName(areaName,projectName);
        // 当年驳回数
        List<Map<String, Object>> examineOverruleList = orderExamineService.findExamineOverruleYearByName(areaName,projectName);

        return R.ok()
                .put("dateList", DateListUtil.getMonths())
                .put("orderList", DateListUtil.compareYears(orderList))
                .put("alarmsList", DateListUtil.compareYears(alarmsList))
                .put("examineApprovalList", DateListUtil.compareYears(examineApprovalList))
                .put("examineOverruleList", DateListUtil.compareYears(examineOverruleList));
    }

}
