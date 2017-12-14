package com.github.xiao.spring.boot.zipkin.dubbo.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.xiao.spring.boot.zipkin.dubbo.api.entity.PersonEntity;
@Mapper
public interface IPersonMapper {
	
	List<PersonEntity> selectAll();
	
	PersonEntity selectOneById(Integer id);
}
