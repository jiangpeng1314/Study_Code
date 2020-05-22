package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo demo=ac.getBean("demo",Demo.class);
		demo.demo1();
		demo.demo2();
		demo.demo3();
	}
}
