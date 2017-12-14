package com.github.xiao.spring.boot.zipkin.dubbo.common.dynamic.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiDataSources extends AbstractRoutingDataSource{

	public static final ThreadLocal<String> SOURCE = new ThreadLocal<String>();
	
	public static void set(String value) {
		SOURCE.set(value);
	}
	
	@Override
	protected Object determineCurrentLookupKey() {
		return SOURCE.get();
	}

}
