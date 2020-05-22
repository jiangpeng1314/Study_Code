package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TestService;

@Controller
public class TestController {
	@Resource
	private TestService testServiceImpl;

	@RequestMapping("")
	public String test() {
		testServiceImpl.test();
		return null;
		
	}
}
