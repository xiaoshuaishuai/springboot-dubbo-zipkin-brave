package com.github.xiao.spring.boot.zipkin.dubbo.customer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.xiao.spring.boot.zipkin.dubbo.api.dubboservice.IPersonDubboService;
import com.github.xiao.spring.boot.zipkin.dubbo.api.entity.PersonEntity;
import com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IPersonService;
@Service
public class PersonServiceImpl implements IPersonService {
	@com.alibaba.dubbo.config.annotation.Reference(check=false)
	private IPersonDubboService personDubboService;
	
	@Override
	public List<PersonEntity> findAll() {
		return personDubboService.findAll();
	}

	@Override
	public PersonEntity findPersonById(Integer id) {
		return personDubboService.findPersonById(id);
	}

}
