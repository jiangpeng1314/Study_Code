package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.UsersMapper;
import pojo.Users;
import service.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersMapper usersMaper;
	@Override
	public Users login(Users users) {
		// TODO Auto-generated method stub
		return usersMaper.selByUsers(users);
	}

}
