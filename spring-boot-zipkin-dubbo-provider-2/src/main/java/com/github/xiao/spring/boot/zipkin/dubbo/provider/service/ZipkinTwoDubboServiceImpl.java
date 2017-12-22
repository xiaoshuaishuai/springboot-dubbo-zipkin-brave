package com.github.xiao.spring.boot.zipkin.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IZipkinTwoDubboService;

@Service//(timeout = 5000)
public class ZipkinTwoDubboServiceImpl implements IZipkinTwoDubboService {

	@Override
	public String h2(String hello) {
		return "服务2";
	}

}
