package com.github.xiao.spring.boot.zipkin.dubbo.provider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IDepartmentDubboService;
import com.github.xiao.spring.boot.zipkin.dubbo.api.entity.DepartmentEntity;
import com.github.xiao.spring.boot.zipkin.dubbo.provider.mapper.IDepartmentMapper;

@Service(timeout = 5000)
public class DepartmentDubboServiceImpl implements IDepartmentDubboService {
	@Autowired
	private IDepartmentMapper departmentMapper;

	@Override
	public List<DepartmentEntity> findAll() {
		return departmentMapper.selectAll();
	}

	@Override
	public DepartmentEntity findDepartmentById(Integer id) {
		return departmentMapper.selectOneById(id);
	}

}
