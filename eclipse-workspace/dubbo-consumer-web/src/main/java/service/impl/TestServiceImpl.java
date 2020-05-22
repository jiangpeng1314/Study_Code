package service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.service.DemoService;

import service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Reference
	private DemoService demoService ;

	@Override
	public void test() {
		// TODO Auto-generated method stub
		String name=demoService.demo("李四");
		System.out.println(name);
	}
	

}
