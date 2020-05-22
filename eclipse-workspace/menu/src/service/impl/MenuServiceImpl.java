package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.MenuMapper;
import pojo.Menu;
import service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private MenuMapper menuMapper;

	@Override
	public List<Menu> show() {
		// TODO Auto-generated method stub
		
		return menuMapper.selByPid(0);
	}
	

}
