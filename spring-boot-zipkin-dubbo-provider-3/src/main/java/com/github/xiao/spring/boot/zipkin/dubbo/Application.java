package com.github.xiao.spring.boot.zipkin.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

import io.zipkin.brave.TraceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
		// HibernateJpaAutoConfiguration.class, （如果使用Hibernate时，需要加）
		DataSourceTransactionManagerAutoConfiguration.class, })
@DubboComponentScan(basePackages = "com.github.xiao.spring.boot.zipkin.dubbo.provider.service")
@ServletComponentScan
@ImportAutoConfiguration({ TraceAutoConfiguration.class })
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(Application.class).web(true).run(args);
		logger.info("-------应用启动-----");
	}

}
