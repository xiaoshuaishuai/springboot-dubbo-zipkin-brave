package com.github.xiao.spring.boot.zipkin.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.github.xiao.spring.boot.zipkin.dubbo.customer.servlet.DemoServlet;

import io.zipkin.brave.TraceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@DubboComponentScan(basePackages = "com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice")
@ServletComponentScan
@ImportAutoConfiguration({ TraceAutoConfiguration.class })
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

   @Bean  
    public ServletRegistrationBean testServletRegistration() {  
        ServletRegistrationBean registration = new ServletRegistrationBean(new DemoServlet());  
        registration.addUrlMappings("/demoServlet");  
        return registration;  
    }  

	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(Application.class).web(true).run(args);
		logger.info("-------应用启动-----");
	}
}
