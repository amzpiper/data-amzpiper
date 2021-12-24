package io.renren.modules.orders.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.orders.entity.AlarmsEntity;
import io.renren.modules.orders.entity.BuildingQuesEntity;
import io.renren.modules.orders.entity.OrderExamineEntity;
import io.renren.modules.orders.service.AlarmsService;
import io.renren.modules.orders.service.BuildingQuesService;
import io.renren.modules.orders.service.OrderExamineService;
import io.renren.modules.orders.utils.NotifyOtherSystem;
import io.renren.modules.orders.vo.BuildingQuesListVo;
import io.renren.modules.orders.vo.BuildingQuesViewVo;
import io.renren.modules.orders.vo.OrderExamineListVo;
import io.renren.modules.sys.service.SysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Api("告警展示接口")
public class AlarmsController {

    @Autowired
    AlarmsService alarmsService;

    @Autowired
    private SysConfigService sysConfigService;

    @Autowired
    OrderExamineController orderExamineController;


    /**
     * 保存告警数据
     *
     * @param entity
     *
     * @return
     */
    @SysLog("保存告警数据")
    @PostMapping("/alarms/add")
    @ApiOperation("保存告警数据")
    public R add(@RequestBody AlarmsEntity entity) {
        String autoConfig = sysConfigService.getValue("自动处理");
        if ("1".equals(autoConfig)){
            // 自动处理-设置状态为已处理
            entity.setAdtecStatus(1);
            entity.setAdtecCreateDate(new Date());
            entity.setAdtecUpdateDate(new Date());
            // 储存告警信息后,创建审批工单(自动审批)
            alarmsService.saveOrCreateOrder(entity);
            this.createOrderExamineOrNotify(entity);
        } else {
            // 手动处理
            entity.setAdtecStatus(0);
            entity.setAdtecCreateDate(new Date());
            entity.setAdtecUpdateDate(new Date());
            // 只储存告警信息
            alarmsService.save(entity);
        }
        return R.ok();
    }

    /**
     * 处理
     *
     * @param id
     *
     * @return
     */
    @SysLog("处理")
    @GetMapping("/alarms/approval")
    @ApiOperation("处理")
    public R approval(@RequestParam String id) {
        //处理逻辑
        AlarmsEntity entity = alarmsService.findById(id);
        entity.setAdtecStatus(1);
        entity.setAdtecUpdateDate(new Date());
        alarmsService.updateById(entity);
        return R.ok();
    }

    /**
     * 忽略告警
     *
     * @param id
     *
     * @return
     */
    @SysLog("忽略告警")
    @GetMapping("/alarms/overrule")
    @ApiOperation("忽略告警")
    public R overrule(@RequestParam String id) {
        //处理逻辑
        AlarmsEntity entity = alarmsService.findById(id);
        entity.setAdtecStatus(2);
        entity.setAdtecUpdateDate(new Date());
        alarmsService.updateById(entity);
        return R.ok();
    }

    /**
     * 分页条件获取告警数据列表
     *
     * @param params
     *
     * @return
     */
    @SysLog("分页条件获取告警数据列表")
    @GetMapping("/alarms/list")
    @ApiOperation("分页条件获取告警数据列表")
    public R list(@RequestParam Map<String, String> params) {
        Page<AlarmsEntity> page = alarmsService.findByPageAndCondtion(params);
        return R.ok().put("data",page.getRecords()).put("total",page.getTotal());
    }

    /**
     * 获取告警详情
     *
     * @param id
     *
     * @return
     */
    @SysLog("获取告警详情")
    @GetMapping("/alarms/search")
    @ApiOperation("获取详情数据查询")
    public R search(@RequestParam String id) {
        AlarmsEntity entity = alarmsService.findById(id);
        return R.ok().put("data",entity);
    }

    /**
     * 获取告警类型列表
     *
     * @return
     */
    @SysLog("获取告警类型列表")
    @GetMapping("/alarms/type")
    @ApiOperation("获取告警类型列表")
    public R typeList() {
        List<String> alarmTypeList = alarmsService.groupType();
        return R.ok()
                .put("alarmTypeList", alarmTypeList);
    }

    /**
     * 填写审核工单数据,新建审核工单
     *
     * @return boolean
     */
    private boolean createOrderExamineOrNotify(AlarmsEntity alarmsEntity) {
        OrderExamineEntity examineEntity = new OrderExamineEntity();
        // 设置为审批状态
        examineEntity.setSubmitDate(new Date());
        examineEntity.setCreateDate(new Date());
        examineEntity.setIsPublic("");
        examineEntity.setStartDate(new Date());
        examineEntity.setBiProblemCategory("");
        examineEntity.setUpdateDate(new Date());
        // TODO:字段创建工单时的格式
        examineEntity.setQuesDesc(alarmsEntity.getDescription());
        examineEntity.setQusetaskState("");
        examineEntity.setEmergencyDegree("");
        examineEntity.setContactAddress("");
        examineEntity.setContactName("");
        examineEntity.setContactPhone("");
        examineEntity.setQuestionType("");
        examineEntity.setTaskSource("");
        examineEntity.setTaskType(1);
        examineEntity.setState("");
        examineEntity.setHouseFloor("");
        examineEntity.setProjectId("");
        examineEntity.setProjectName("");
        examineEntity.setAreaId("");
        examineEntity.setAreaName("");
        examineEntity.setRoomType("");
        examineEntity.setRoomPartName("");
        examineEntity.setHouseBuilding("");
        examineEntity.setHouseCell("");
        examineEntity.setHouseRoom("");
        examineEntity.setMaintenanceMan("");
        examineEntity.setSendUserid("");
        examineEntity.setMtainUserid("");
        examineEntity.setOrignSource("");
        examineEntity.setSourceType("");
        examineEntity.setHouseFixStatus("");
        examineEntity.setAdtecCreateDate(new Date());
        examineEntity.setAdtecUpdateDate(new Date());
        examineEntity.setExamineStatus(1);
        examineEntity.setSourceSystem("工单调度平台");
        examineEntity.setTargetSystem("融通");
        // 添加审核工单
        orderExamineController.add(examineEntity);
        return true;
    }
}
