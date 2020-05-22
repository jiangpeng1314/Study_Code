package com.consumer.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.consumer.service.impl.TestServiceImpl;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext-dubbo.xml");
		TestServiceImpl t=ac.getBean("testImpl",TestServiceImpl.class);
		t.test();
	}
}
