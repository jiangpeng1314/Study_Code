package service;

import java.util.List;

import pojo.Files;
import pojo.Users;

public interface FilesService {
	
	List<Files> show();
	
	int updCount(int id,Users users,String name);

}
