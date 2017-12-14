package com.github.xiao.spring.boot.zipkin.dubbo.common.dynamic.filter.rpc;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.github.xiao.spring.boot.zipkin.dubbo.common.dynamic.constants.Constants_;
import com.github.xiao.spring.boot.zipkin.dubbo.common.dynamic.datasource.MultiDataSources;

@Activate(group = { Constants.PROVIDER })
public class MybatisMultiDataSourceDubboFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(MybatisMultiDataSourceDubboFilter.class);

	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		// String source =
		// RpcContext.getContext().getAttachment(Constants_.DATASOURCE);

		Random r = new Random();
		if (r.nextInt(2) == 0) {
			logger.info("选择默认数据源key:{}", Constants_.DATASOURCE_ONE);
			MultiDataSources.set(Constants_.DATASOURCE_ONE);
		} else {
			logger.info("选择数据源key:{}", Constants_.DATASOURCE_TWO);
			MultiDataSources.set(Constants_.DATASOURCE_TWO);
		}
		Result result = invoker.invoke(invocation);
		MultiDataSources.SOURCE.remove();
		return result;
	}

}
