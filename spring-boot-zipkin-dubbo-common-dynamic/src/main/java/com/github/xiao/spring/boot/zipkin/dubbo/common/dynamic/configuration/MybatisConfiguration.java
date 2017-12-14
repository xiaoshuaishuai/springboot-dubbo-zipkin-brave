package com.github.xiao.spring.boot.zipkin.dubbo.common.dynamic.configuration;

import java.util.HashMap;
import java.util.Map;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.xiao.spring.boot.zipkin.dubbo.common.dynamic.datasource.MultiDataSources;

@Configuration
//@MapperScan("com.github.xiao.spring.boot.zipkin.dubbo.provider.mapper.xml")
public class MybatisConfiguration {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name.two}")
	private String driverClassName_two;
	@Value("${spring.datasource.url.two}")
	private String url_two;
	@Value("${spring.datasource.username.two}")
	private String username_two;
	@Value("${spring.datasource.password.two}")
	private String password_two;

	@Value("${mybatis.mapper-locations}")
	private String mapperLocations;

	@Value("${mybatis.type-aliases-package}")
	private String typeAliasesPackage;

	@Value("${mybatis.config-location}")
	private String configLocation;

	@Bean(name = "dataSource_one")
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean(name = "dataSource_two")
	public DataSource dataSource_two() {
		DataSource twoDataSource = new DataSource();
		twoDataSource.setDriverClassName(driverClassName_two);
		twoDataSource.setUrl(url_two);
		twoDataSource.setUsername(username_two);
		twoDataSource.setPassword(password_two);
		return twoDataSource;
	}

	@Bean
	public MultiDataSources multiDataSources(@Qualifier("dataSource_one") DataSource dataSource_one
			,@Qualifier("dataSource_two") DataSource dataSource_two
			) {
		MultiDataSources multi = new MultiDataSources();
		multi.setDefaultTargetDataSource(dataSource_one);
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put("dataSource_one", dataSource_one);
		targetDataSources.put("dataSource_two", dataSource_two);
		multi.setTargetDataSources(targetDataSources);
		return multi;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(MultiDataSources mds) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(mds);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
		sessionFactory.setTypeAliasesPackage(typeAliasesPackage);
		sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLocation));
		return sessionFactory.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(MultiDataSources mds) throws Exception {
		return new DataSourceTransactionManager(mds);
	}
}
