package com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice;

import java.util.List;

import com.github.xiao.spring.boot.zipkin.dubbo.api.entity.DepartmentEntity;

public interface IDepartmentDubboService {
	
	List<DepartmentEntity> findAll();

	DepartmentEntity findDepartmentById(Integer id);
}
