package service;

import java.io.IOException;

import pojo.PageInfo;

public interface LogService {
	PageInfo show(int pageNumber,int pageSize) throws IOException;
}
