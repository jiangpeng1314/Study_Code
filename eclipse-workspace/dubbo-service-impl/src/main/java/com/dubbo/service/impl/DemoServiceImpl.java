package com.dubbo.service.impl;

import com.dubbo.service.DemoService;

public class DemoServiceImpl implements DemoService {

	@Override
	public String demo(String name) {
		// TODO Auto-generated method stub
		return "传递过来的name:"+name;
	}
}
