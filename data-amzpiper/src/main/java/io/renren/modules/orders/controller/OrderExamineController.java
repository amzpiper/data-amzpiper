package io.renren.modules.orders.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.orders.entity.OrderExamineEntity;
import io.renren.modules.orders.entity.OrderExamineViewVo;
import io.renren.modules.orders.service.OrderExamineService;
import io.renren.modules.orders.utils.NotifyOtherSystem;
import io.renren.modules.orders.vo.OrderExamineListVo;
import io.renren.modules.sys.service.SysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@Api("工单审批接口")
public class OrderExamineController {

    @Autowired
    OrderExamineService orderExamineService;

    @Autowired
    private SysConfigService sysConfigService;

    @Autowired
    private NotifyOtherSystem notifyOtherSystem;

    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 接受第三方审核工单
     * @param examineEntity
     * @return
     */
    @PostMapping("/orderexamine/other/add")
    @ApiOperation("第三方系统提报工单")
    public R otherAdd(@RequestBody @Validated OrderExamineEntity examineEntity) {
        logger.info("第三方系统提报工单:"+examineEntity);

        examineEntity.setAdtecCreateDate(new Date());
        examineEntity.setAdtecUpdateDate(new Date());

        String autoConfig = sysConfigService.getValue("自动审批");
        if ("1".equals(autoConfig)) {
            // 直接审批,存储为1，审批
            examineEntity.setExamineStatus(1);
            boolean flag = orderExamineService.save(examineEntity);
            // TODO 调用第三方系统通知审批完成工单
            if (flag) {
                notifyOtherSystem.sendToOtherSystem(examineEntity.getQuestaskId(),
                        examineEntity.getTargetSystem(), true);
            } else {
                return R.error("创建工单失败");
            }
        } else {
            // 存储为0，未审批
            examineEntity.setExamineStatus(0);
            orderExamineService.save(examineEntity);
        }
        return R.ok();
    }

    /**
     * 本平台创建工单自动审核完成
     * @param examineEntity
     * @return
     */
    @SysLog("提报工单")
    @PostMapping("/orderexamine/add")
    @ApiOperation("保存审核工单")
    public R add(@RequestBody @Validated OrderExamineEntity examineEntity) {
        examineEntity.setCreateDate(new Date());
        examineEntity.setUpdateDate(new Date());
        examineEntity.setAdtecCreateDate(new Date());
        examineEntity.setAdtecUpdateDate(new Date());
        examineEntity.setExamineStatus(1);
        examineEntity.setSourceSystem("工单调度平台");

        boolean flag = orderExamineService.save(examineEntity);
        // TODO 调用第三方系统创建工单,通知审批完成工单
        if (flag) {
            notifyOtherSystem.sendToOtherSystem(examineEntity.getQuestaskId(),
                    examineEntity.getTargetSystem(), true);
        } else {
            return R.error("创建工单失败");
        }
        return R.ok();
    }

    /**
     * 审批-通知第三方系统
     * @param id
     * @return
     */
    @SysLog("审批")
    @GetMapping("/orderexamine/approval")
    @ApiOperation("审批")
    public R approval(@RequestParam String id) {
        //处理逻辑
        OrderExamineEntity entity = orderExamineService.findById(id);
        entity.setExamineStatus(1);
        entity.setAdtecUpdateDate(new Date());
        orderExamineService.updateById(entity);
        notifyOtherSystem.sendToOtherSystem(entity.getQuestaskId(),
                entity.getTargetSystem(), true);
        return R.ok();
    }

    /**
     * 驳回--通知第三方系统
     * @param id
     * @return
     */
    @SysLog("驳回")
    @GetMapping("/orderexamine/overrule")
    @ApiOperation("驳回")
    public R overrule(@RequestParam String id) {
        //处理逻辑
        OrderExamineEntity entity = orderExamineService.findById(id);
        entity.setExamineStatus(2);
        entity.setAdtecUpdateDate(new Date());
        orderExamineService.updateById(entity);
        notifyOtherSystem.sendToOtherSystem(entity.getQuestaskId(),
                entity.getTargetSystem(), false);
        return R.ok();
    }

    /**
     * 批量审批-通知第三方系统
     * @param ids
     * @return
     */
    @SysLog("批量审批")
    @PostMapping("/orderexamine/batchapproval")
    @ApiOperation("批量审批")
    public R batchApproval(@RequestBody List<String> ids) {
        //处理逻辑
        List<OrderExamineEntity> entityList = orderExamineService.listByIds(ids);
        List<OrderExamineEntity> newEntityList = entityList.stream().map(dto -> {
            dto.setExamineStatus(1);
            dto.setAdtecUpdateDate(new Date());
            return dto;
        }).collect(Collectors.toList());
        orderExamineService.updateBatchById(newEntityList);

        // 通知第三方
        List<String> questaskIds = entityList.stream().map(OrderExamineEntity::getQuestaskId).collect(Collectors.toList());
        List<String> targetSystemList = entityList.stream().map(OrderExamineEntity::getTargetSystem).collect(Collectors.toList());
        notifyOtherSystem.sendToOtherSystem(questaskIds, targetSystemList, true);
        return R.ok().put("ids", ids);
    }

    /**
     * 批量驳回-通知第三方系统
     * @param ids
     * @return
     */
    @SysLog("批量驳回")
    @PostMapping("/orderexamine/batchoverrule")
    @ApiOperation("批量驳回")
    public R batchOverrule(@RequestBody List<String> ids) {
        List<OrderExamineEntity> entityList = orderExamineService.listByIds(ids);
        List<OrderExamineEntity> newEntityList = entityList.stream().map(dto -> {
            dto.setExamineStatus(2);
            dto.setAdtecUpdateDate(new Date());
            return dto;
        }).collect(Collectors.toList());
        orderExamineService.updateBatchById(newEntityList);

        // 通知第三方
        List<String> questaskIds = entityList.stream().map(OrderExamineEntity::getQuestaskId).collect(Collectors.toList());
        List<String> targetSystemList = entityList.stream().map(OrderExamineEntity::getTargetSystem).collect(Collectors.toList());
        notifyOtherSystem.sendToOtherSystem(questaskIds, targetSystemList, true);
        return R.ok().put("ids", ids);
    }

    /**
     * 分页条件获取工单审批数据列表
     * @param params
     * @return
     */
    @SysLog("分页条件获取工单审批数据列表")
    @GetMapping("/orderexamine/list")
    @ApiOperation("分页条件获取数据列表")
    public R list(@RequestParam Map<String, String> params) {
        Page<OrderExamineEntity> page = orderExamineService.findByPageAndCondition(params);
        List<OrderExamineListVo> voList = page.getRecords().stream().map(dto -> {
            OrderExamineListVo vo = new OrderExamineListVo();
            BeanUtils.copyProperties(dto,vo);
            return vo;
        }).collect(Collectors.toList());
        return R.ok().put("data",voList).put("total",page.getTotal());
    }

    /**
     * 获取工单审批详情数据查询
     * @param id
     * @return
     */
    @SysLog("获取工单审批详情数据查询")
    @GetMapping("/orderexamine/search")
    @ApiOperation("获取详情数据查询")
    public R search(@RequestParam String id) {
        OrderExamineEntity dto = orderExamineService.findById(id);
        OrderExamineViewVo vo = new OrderExamineViewVo();
        BeanUtils.copyProperties(dto,vo);
        return R.ok().put("data",vo);
    }

    /**
     * 获取工单所有类型列表
     * @return
     */
    @SysLog("获取工单所有类型列表")
    @GetMapping("/orderexamine/type")
    @ApiOperation("获取工单所有类型列表")
    public R sourceSystemTypeList() {
        List<String> sourceSystemTypeList = orderExamineService.groupBySourceSystem();
        List<String> targetSystemTypeList = orderExamineService.groupByTargetSystem();
        return R.ok()
                .put("targetSystemTypeList", targetSystemTypeList)
                .put("sourceSystemTypeList", sourceSystemTypeList);
    }

}
