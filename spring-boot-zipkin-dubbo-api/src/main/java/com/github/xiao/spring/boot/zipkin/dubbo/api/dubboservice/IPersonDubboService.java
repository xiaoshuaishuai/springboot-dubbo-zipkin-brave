package com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice;

import java.util.List;

import com.github.xiao.spring.boot.zipkin.dubbo.api.entity.PersonEntity;

public interface IPersonDubboService {
	
	List<PersonEntity> findAll();

	PersonEntity findPersonById(Integer id);
}
