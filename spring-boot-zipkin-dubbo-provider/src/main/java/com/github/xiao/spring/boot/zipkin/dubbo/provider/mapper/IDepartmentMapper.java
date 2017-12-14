package com.github.xiao.spring.boot.zipkin.dubbo.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.xiao.spring.boot.zipkin.dubbo.api.entity.DepartmentEntity;
@Mapper
public interface IDepartmentMapper {
	
	List<DepartmentEntity> selectAll();
	
	DepartmentEntity selectOneById(Integer id);
}
