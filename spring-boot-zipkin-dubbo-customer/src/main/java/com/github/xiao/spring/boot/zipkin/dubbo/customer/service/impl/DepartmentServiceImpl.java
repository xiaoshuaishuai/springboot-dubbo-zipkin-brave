package com.github.xiao.spring.boot.zipkin.dubbo.customer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IDepartmentDubboService;
import com.github.xiao.spring.boot.zipkin.dubbo.api.entity.DepartmentEntity;
import com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IDepartmentService;
@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@com.alibaba.dubbo.config.annotation.Reference
	private IDepartmentDubboService departmentDubboService;
	
	@Override
	public List<DepartmentEntity> findAll() {
		return departmentDubboService.findAll();
	}

	@Override
	public DepartmentEntity findDepartmentById(Integer id) {
		return departmentDubboService.findDepartmentById(id);
	}

}
