package io.renren.modules.orders.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.orders.entity.BuildingQuesEntity;
import io.renren.modules.orders.service.BuildingQuesService;
import io.renren.modules.orders.vo.BuildingQuesListVo;
import io.renren.modules.orders.vo.BuildingQuesViewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Api("问题主表展示接口")
public class BuildingQuesController {

    @Autowired
    BuildingQuesService buildingQuesService;

    @SysLog("分页条件获取问题主表数据列表")
    @GetMapping("/buildingques/list")
    @ApiOperation("分页条件获取工单数据列表")
    public R list(@RequestParam Map<String, String> params) {
        Page<BuildingQuesEntity> page = buildingQuesService.findByPageAndCondtion(params);
        List<BuildingQuesListVo> voList = page.getRecords().stream().map(dto -> {
            BuildingQuesListVo vo = new BuildingQuesListVo();
            vo.setQuestaskId(dto.getQuestaskId());
            vo.setQuesDesc(dto.getQuesDesc());
            vo.setQuestionType(dto.getQuestionType());
            vo.setSourceSystem("一碑");
            vo.setAreaName(dto.getAreaName());
            vo.setProjectName(dto.getProjectName());
            vo.setCreateDate(dto.getCreateDate());
            // 0:待派单、1:待接单  2:处理中、3:待确认、4:已关闭  5：已暂停
            String qusetaskStateString = "";
            switch (dto.getQusetaskState()) {
                case "0":
                    qusetaskStateString = "待派单";
                    break;
                case "1":
                    qusetaskStateString = "待接单";
                    break;
                case "2":
                    qusetaskStateString = "处理中";
                    break;
                case "3":
                    qusetaskStateString = "待确认";
                    break;
                case "4":
                    qusetaskStateString = "已关闭";
                    break;
                case "5":
                    qusetaskStateString = "已暂停";
                    break;
            }
            vo.setQusetaskState(qusetaskStateString);
            return vo;
        }).collect(Collectors.toList());
        return R.ok()
                .put("data",voList)
                .put("total",page.getTotal());
    }

    @SysLog("获取问题主表详情数据")
    @GetMapping("/buildingques/search")
    @ApiOperation("获取详情数据查询")
    public R search(@RequestParam String id) {
        BuildingQuesEntity buildingQuesEntity = buildingQuesService.findById(id);
        BuildingQuesViewVo buildingQuesViewVo = new BuildingQuesViewVo();
        BeanUtils.copyProperties(buildingQuesEntity, buildingQuesViewVo);
        buildingQuesViewVo.setSourceSystem("一碑");
        return R.ok().put("data",buildingQuesViewVo);
    }

    @SysLog("获取问题主表所有类型列表")
    @GetMapping("/buildingques/type")
    @ApiOperation("获取工单所有类型列表")
    public R typeList(@RequestParam String areaName) {
        List<String> questionTypeList = buildingQuesService.groupByQuestionType();
        List<String> areaNameList = buildingQuesService.groupByAreaName();
        List<String> projectList = buildingQuesService.groupByProjectName(areaName);
        R r = R.ok();
        r.put("types", questionTypeList);
        r.put("areaNames", areaNameList);
        r.put("projectNames", projectList);
        return r;
    }

    @SysLog("获取问题主表所有类型列表")
    @GetMapping("/buildingques/project")
    @ApiOperation("获取工单项目")
    public R projectList(@RequestParam String areaName) {
        List<String> projectList = buildingQuesService.groupByProjectName(areaName);
        R r = R.ok();
        r.put("projectNames", projectList);
        return r;
    }
}
