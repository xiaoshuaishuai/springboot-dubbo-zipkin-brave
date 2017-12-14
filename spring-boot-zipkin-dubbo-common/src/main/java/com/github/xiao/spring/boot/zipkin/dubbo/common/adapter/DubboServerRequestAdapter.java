package com.github.xiao.spring.boot.zipkin.dubbo.common.adapter;

import brave.SpanCustomizer;

public class DubboServerRequestAdapter implements SpanCustomizer {

	private String name ,key, value ,event;

	public DubboServerRequestAdapter(String name, String key, String value, String event) {
		super();
		this.name = name;
		this.key = key;
		this.value = value;
		this.event = event;
	}
	public SpanCustomizer name(String name) {
		return new DubboServerRequestAdapter(name,null,null,null);
	}

	public SpanCustomizer tag(String key, String value) {
		return new DubboServerRequestAdapter(null,key,value,null);
	}

	public SpanCustomizer annotate(String value) {
		return new DubboServerRequestAdapter(null,null,value,null);
	}

	public SpanCustomizer annotate(long timestamp, String value) {
		return new DubboServerRequestAdapter(null,null,value+":"+System.currentTimeMillis(),null);
	}


}
