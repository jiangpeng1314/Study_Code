package com.ego.manage.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ego.manage.service.PicService;
import com.ego.manage.service.impl.PicServiceImpl;

@Controller
public class PicController {
	@Resource
	private PicService PicServiceImpl;
	
	/**
	 * 文件上传
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping("pic/upload")
	@ResponseBody
	public Map<String,Object> upload(MultipartFile uploadFile){		
		return PicServiceImpl.upload(uploadFile);
		
	}

}
