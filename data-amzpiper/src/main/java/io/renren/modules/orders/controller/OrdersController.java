package io.renren.modules.orders.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.orders.entity.OrdersEntity;
import io.renren.modules.orders.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author guoyh
 */
@RestController
//@Api("新建工单接口")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @SysLog("通过id获取工单")
    @PostMapping("/orders/{id}")
    @ApiOperation("通过id获取工单")
    public R searchOrdersById(@PathVariable("id") String id) {
        OrdersEntity orders = ordersService.findOrdersById(id);
        return R.ok().put("data",orders);
    }

    @PostMapping("/orders/{page}/{size}")
    @ApiOperation("分页获取工单")
    public R listOrders(@PathVariable("page") Integer page,@PathVariable("size") Integer size) {
        Page<OrdersEntity> ordersEntityPage = ordersService.findOrdersByPage(page,size);
        return R.ok().put("data",ordersEntityPage.getRecords());
    }

    @PostMapping("/orders/list")
    @ApiOperation("获取所有工单")
    public R listOrders() {
        List<OrdersEntity> ordersList = ordersService.findAllOrders();
        return R.ok().put("data",ordersList);
    }

    @PostMapping("/orders/num")
    @ApiOperation("获取首页指标")
    public R num(@RequestBody Map<String, Object> body) {
        for (Map.Entry<String, Object> entry : body.entrySet()) {
            System.out.println(entry.getKey() + ":"+entry.getKey().indexOf("t")+":");
            //移除t时间戳字段
            body.remove("t");
            Map<String, String> value = (Map<String, String>) entry.getValue();
            for (Map.Entry<String, String> stringEntry : value.entrySet()) {
                System.out.println(stringEntry.getKey() + ":"+stringEntry.getValue());
            }
        }
        return R.ok().put("body",body);
    }

    @PostMapping("/orders/array")
    @ApiOperation("批量处理")
    public R test(@RequestBody Map<String, String> ids) {
        for (Map.Entry<String, String> entry : ids.entrySet()) {
            System.out.println(entry.getKey() + ":"+entry.getValue());
        }
        //移除t时间戳字段
        ids.remove("t");
        return R.ok().put("ids", ids);
    }

    @PostMapping("/orders/add")
    @ApiOperation("新增工单")
    public R saveOrders(@RequestBody OrdersEntity orders) {
        Boolean flag = ordersService.saveOrders(orders);
        return R.ok();
    }

    @PostMapping("/orders/update")
    @ApiOperation("更新工单")
    public R updateOrders(@RequestBody OrdersEntity orders) {
        boolean flag = ordersService.updateOrders(orders);
        if (flag) {
            return R.ok();
        }else {
            return R.error("更新失败");
        }
    }

    @PostMapping("/orders/delete/{id}")
    @ApiOperation("通过id删除工单")
    public R deleteOrdersById(@PathVariable("id") String id) {
        boolean flag = ordersService.deleteOrdersById(id);
        if (flag) {
            return R.ok();
        }else {
            return R.error("删除失败");
        }
    }

    @PostMapping("/orders/delete")
    @ApiOperation("批量删除工单")
    public R deleteAllOrders(@RequestBody Long[] OrdersIds) {
        boolean flag = ordersService.deleteAllOrders(Arrays.asList(OrdersIds));
        if (flag) {
            return R.ok();
        }else {
            return R.error("删除失败");
        }
    }
}
