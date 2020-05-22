package com.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.consumer.service.TestService;
import com.dubbo.service.DemoService;

public class TestServiceImpl implements TestService{
	@Reference
	private DemoService demoService;
	@Override
	public void test() {
		// TODO Auto-generated method stub
		String name=demoService.demo("张三");
		System.out.println(name);
	}

}
