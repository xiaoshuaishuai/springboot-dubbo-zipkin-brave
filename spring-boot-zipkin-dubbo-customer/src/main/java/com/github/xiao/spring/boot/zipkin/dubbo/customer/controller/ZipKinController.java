package com.github.xiao.spring.boot.zipkin.dubbo.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IZipkinOneService;
import com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IZipkinThreeService;
import com.github.xiao.spring.boot.zipkin.dubbo.customer.service.IZipkinTwoService;

@RestController
public class ZipKinController {
	@Autowired
	private IZipkinOneService zipkinOneService;
	@Autowired
	private IZipkinTwoService zipkinTwoService;
	@Autowired
	private IZipkinThreeService zipkinThreeService;

	@RequestMapping("/hiZipKin")
	public @ResponseBody String hiZipKin() {
		return zipkinOneService.h1("") + zipkinTwoService.h2("") + zipkinThreeService.h3("");
	}
}
