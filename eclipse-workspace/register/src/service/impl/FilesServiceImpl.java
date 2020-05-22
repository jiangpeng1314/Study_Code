package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import mapper.FilesMapper;
import pojo.Files;
import pojo.Users;
import service.FilesService;

@Service
public class FilesServiceImpl implements FilesService{
	
	@Resource
	private FilesMapper filesMapper;

	@Override
	public List<Files> show() {
		// TODO Auto-generated method stub
		return filesMapper.selAll();
	}

	@Override
	public int updCount(int id, Users users, String name) {
		Logger log=Logger.getLogger(FilesServiceImpl.class);
		log.info(users.getUsername()+"download:"+name);
		// TODO Auto-generated method stub
		return filesMapper.updCountById(id);
	}

}
