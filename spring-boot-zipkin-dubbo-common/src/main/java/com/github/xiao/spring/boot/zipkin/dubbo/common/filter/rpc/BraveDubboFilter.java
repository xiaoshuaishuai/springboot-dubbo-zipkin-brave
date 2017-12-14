package com.github.xiao.spring.boot.zipkin.dubbo.common.filter.rpc;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

@Activate(group = { Constants.PROVIDER, Constants.CONSUMER })
public class BraveDubboFilter implements Filter {

	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		// TODO Auto-generated method stub
		System.out.println("brave filter before ");
		Result result = invoker.invoke(invocation);
		System.out.println("brave filter after  ");
		return result;
	}

}
