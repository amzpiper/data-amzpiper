package io.renren.common.postrun;

import io.renren.modules.orders.utils.CoralWebSocketClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;


/**
 * 启动项目后需要执行的任务
 * @author guoyh
 */
@Component
public class PostRunWebSocket{

    //@Autowired
    //CoralWebSocketClientUtil webSocketClientUtil;
    //
    ///**
    // * 启动项目后运行
    // */
    //@PostConstruct
    //public void initMethod(){
    //    System.out.println(">>>>>>>>>启动项目后运行<<<<<<<<<<<");
    //    System.out.println(">>>>>>>>>webSocketClientUtil<<<<<<<<<<<");
    //    // websocket
    //    webSocketClientUtil.start();
    //}

}
