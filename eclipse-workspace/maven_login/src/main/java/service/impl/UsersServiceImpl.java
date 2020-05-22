package service.impl;

import mapper.UsersMapper;
import pojo.Users;
import service.UsersService;

public class UsersServiceImpl implements UsersService {
	private UsersMapper usersMapper;
	public UsersMapper getUsersMapper() {
		return usersMapper;
	}



	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}



	@Override
	public Users login(Users users) {
		// TODO Auto-generated method stub
		return usersMapper.selByUsers(users);
	}
	
}
