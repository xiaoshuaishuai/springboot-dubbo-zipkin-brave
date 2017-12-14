package com.github.xiao.spring.boot.zipkin.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@DubboComponentScan(basePackages = "com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice")
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		new SpringApplicationBuilder()
                .sources(Application.class)
                .web(true) 
                .run(args);
        logger.info("-------应用启动-----");
	}
}
