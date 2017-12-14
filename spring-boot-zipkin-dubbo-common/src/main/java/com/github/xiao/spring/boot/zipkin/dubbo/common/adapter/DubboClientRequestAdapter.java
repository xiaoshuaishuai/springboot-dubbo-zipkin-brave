package com.github.xiao.spring.boot.zipkin.dubbo.common.adapter;

import brave.SpanCustomizer;

public class DubboClientRequestAdapter implements SpanCustomizer{

	private String name ,key, value ,event;
	

	public DubboClientRequestAdapter(String name, String key, String value, String event) {
		super();
		this.name = name;
		this.key = key;
		this.value = value;
		this.event = event;
	}

	public SpanCustomizer name(String name) {
		return new DubboClientRequestAdapter(name,null,null,null);
	}

	public SpanCustomizer tag(String key, String value) {
		return new DubboClientRequestAdapter(null,key,value,null);
	}

	public SpanCustomizer annotate(String value) {
		return new DubboClientRequestAdapter(null,null,value,null);
	}

	public SpanCustomizer annotate(long timestamp, String value) {
		return new DubboClientRequestAdapter(null,null,value+":"+System.currentTimeMillis(),null);
	}

}
