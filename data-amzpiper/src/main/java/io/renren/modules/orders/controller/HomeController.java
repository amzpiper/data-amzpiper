package io.renren.modules.orders.controller;

import java.util.*;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.orders.service.AlarmsService;
import io.renren.modules.orders.service.BuildingQuesService;
import io.renren.modules.orders.service.OrderExamineService;
import io.renren.modules.orders.service.OrdersService;
import io.renren.modules.orders.utils.DateListUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("主界面展示接口")
public class HomeController {

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
     *
     * @param areaName
     * @param projectName
     *
     * @return R
     */
    @SysLog("查询近7天指标数")
    @GetMapping("/home/number")
    @ApiOperation("查询近7天指标数")
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
     *
     * @param areaName
     * @param projectName
     *
     * @return R
     */
    @SysLog("查询当月每日指标数")
    @GetMapping("/home/month")
    @ApiOperation("查询当月每日指标数")
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
     *
     * @param areaName
     * @param projectName
     *
     * @return R
     */
    @SysLog("查询当年每月指标数")
    @GetMapping("/home/year")
    @ApiOperation("查询当年每月指标数")
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

    /**
     * 查询今日指标数
     *
     * @param areaName
     * @param projectName
     *
     * @return R
     */
    @SysLog("获取今日指标数据")
    @GetMapping("/home/today")
    @ApiOperation("获取今日指标数据")
    public R searchToday(@RequestParam String areaName, String projectName) {
        // 今日统计
        int orderNum = buildingQuesService.findOrderNumberToday(areaName,projectName);
        int examineApprovalNum = orderExamineService.findExamineApprovalNumberToday(areaName, projectName);
        int examineOverruleNum = orderExamineService.findExamineOverruleNumberToday(areaName, projectName);
        int alarmsNum = alarmsService.findAlarmsNumberToday();

        R r = R.ok();
        r.put("orderNum",orderNum);
        r.put("alarmsNum",alarmsNum);
        r.put("examineApprovalNum",examineApprovalNum);
        r.put("examineOverruleNum",examineOverruleNum);
        return r;
    }

    /**
     * 查询今日指标数
     *
     * @param areaName
     * @param projectName
     *
     * @return R
     */
    @SysLog("获取今日指标数据")
    @GetMapping("/home/all")
    @ApiOperation("获取总数指标数据")
    public R searchAll(@RequestParam String areaName, String projectName) {
        int orderNumAll = buildingQuesService.findOrderNumber(areaName,projectName);
        int examineApprovalNumAll = orderExamineService.findExamineApprovalNumber(areaName, projectName);
        int examineOverruleNumAll = orderExamineService.findExamineOverruleNumber(areaName, projectName);
        int alarmsNumAll = alarmsService.findAlarmsNumber();

        R r = R.ok();
        r.put("orderNumAll",orderNumAll);
        r.put("alarmsNumAll",alarmsNumAll);
        r.put("examineApprovalNumAll",examineApprovalNumAll);
        r.put("examineOverruleNumAll",examineOverruleNumAll);
        return r;
    }
}
