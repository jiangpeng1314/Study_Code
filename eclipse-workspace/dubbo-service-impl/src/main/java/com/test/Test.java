package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;

public class Test {
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext-dubbo.xml");
//		ac.start();
		//官方推荐
		Main.main(args);
	}

}
