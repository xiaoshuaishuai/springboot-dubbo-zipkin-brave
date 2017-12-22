package com.github.xiao.spring.boot.zipkin.dubbo.common.configuration;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
public class DubboConfiguration {

	@Bean
	public ApplicationConfig applicationConfig(@Value("${dubbo.application.name}") String appName) {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(appName);
		return applicationConfig;
	}

	@Bean
	public ConsumerConfig consumerConfig() {
		ConsumerConfig consumerConfig = new ConsumerConfig();
		consumerConfig.setTimeout(3000000);
		consumerConfig.setRetries(0);
		consumerConfig.setCheck(false);
		return consumerConfig;
	}

	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress("zookeeper://127.0.0.1:2181");
		// registryConfig.setClient("curator");
		return registryConfig;
	}

	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		Random rand = new Random();
		protocolConfig.setPort(rand.nextInt(22000) + 20000);
		return protocolConfig;
	}
}
