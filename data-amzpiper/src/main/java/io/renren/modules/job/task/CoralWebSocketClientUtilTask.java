/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.job.task;

import io.renren.modules.orders.utils.CoralWebSocketClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * coralWebSocketClientUtilTask定时任务,因为wss连接每30min过期
 * <p>
 * coralWebSocketClientUtilTask为spring bean的名称
 *
 * @author guoyha
 */
@Component("coralWebSocketClientUtilTask")
public class CoralWebSocketClientUtilTask implements ITask {

	@Autowired
	CoralWebSocketClientUtil webSocketClientUtil;

	private Logger logger = LoggerFactory.getLogger(getClass());


	/**
	 * 启动项目后运行
	 */
	@PostConstruct
	public void initMethod(){
		//logger.info(">>>>>>>>>启动项目后需要运行的代码<<<<<<<<<<<");
	}

	/**
	 * 项目启动后开启,之后,每30分钟重启websocket连接
	 * @param params 参数,多参数使用JSON数据
	 */
	@Override
	public void run(String params) {
		logger.debug("CoralWebSocketClientUtilTask定时任务正在执行, 参数为:", params);
		webSocketClientUtil.stop();
		webSocketClientUtil.start();
	}
}
