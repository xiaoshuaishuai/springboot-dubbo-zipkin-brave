package com.github.xiao.spring.boot.zipkin.dubbo.provider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IPersonDubboService;
import com.github.xiao.spring.boot.zipkin.dubbo.api.entity.PersonEntity;
import com.github.xiao.spring.boot.zipkin.dubbo.provider.mapper.IPersonMapper;

@Service(timeout = 5000)
public class PersonDubboServiceImpl implements IPersonDubboService {
	@Autowired
	private IPersonMapper personMapper;

	@Override
	public List<PersonEntity> findAll() {
		return personMapper.selectAll();
	}

	@Override
	public PersonEntity findPersonById(Integer id) {
		return personMapper.selectOneById(id);
	}

}
