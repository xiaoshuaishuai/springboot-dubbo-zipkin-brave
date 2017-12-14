package com.github.xiao.spring.boot.zipkin.dubbo.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.xiao.spring.boot.zipkin.dubbo.api.entity.DepartmentEntity;
import com.github.xiao.spring.boot.zipkin.dubbo.api.entity.PersonEntity;

@RestController
public class DemoController {
	@Autowired
	private com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IDemoService demoService;

	@Autowired
	private com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IPersonService personService;
	@Autowired
	private com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IDepartmentService departmentService;

	@RequestMapping("/hello") // http://localhost:8086/hello?name=haha
	public String demo(@RequestParam(value = "name") String name) {
		return demoService.sayHello(name);
	}

	@RequestMapping("/personlist")
	public @ResponseBody List<PersonEntity> personlist() {
		return personService.findAll();
	}
	@RequestMapping("/deptlist")
	public @ResponseBody List<DepartmentEntity> deptlist() {
		return departmentService.findAll();
	}

	@RequestMapping("/queryperson")
	public @ResponseBody PersonEntity queryperson(@RequestParam(value = "id") Integer name) {
		return personService.findPersonById(name);
	}
}
