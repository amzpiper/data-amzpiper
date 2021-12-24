package io.renren.modules.orders.utils;

import io.renren.common.utils.OkHttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NotifyOtherSystem {

    @Autowired
    private OkHttpUtil okHttpUtil;

    @Value(value = "${header.url}")
    private String url;

    @Value(value = "${header.tokenName}")
    private String tokenName;

    @Value(value = "${header.tokenValue}")
    private String tokenValue;

    Map<String,String> params = new HashMap<>(1);

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 通知第三方平台该id审批完成
     * @param id
     * @param flag true:审批; false:驳回
     * @return
     */
    public boolean sendToOtherSystem(String id, String targetSystem, Boolean flag) {
        // TODO 完成自动审批-回调第三方平台回复审批完成-发起新工单
        logger.info("回调第三方平台回复审批完成");
        params.put(tokenName,tokenValue);
        Map<String,String> cookies = new HashMap<>(1);
        cookies.put(tokenName,tokenValue);
        String responseBody = okHttpUtil.post(url, params, cookies);
        logger.info(responseBody);
        return true;
    }

    /**
     * 通知第三方平台多个id审批完成
     * @param ids
     * @param flag true:审批; false:驳回
     * @return
     */
    public boolean sendToOtherSystem(List<String> ids, List<String> targetSystem, Boolean flag) {
        for (int index = 0; index < ids.size(); index++) {
            this.sendToOtherSystem(ids.get(index), targetSystem.get(index), flag);
        }
        return true;
    }
}
