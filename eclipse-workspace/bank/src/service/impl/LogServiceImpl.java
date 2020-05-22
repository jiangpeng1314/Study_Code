package service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.LogMapper;
import pojo.Log;
import pojo.PageInfo;
import service.LogService;
import util.MyBatisUtil;

public class LogServiceImpl implements LogService {

	@Override
	public PageInfo show(int pageNumber, int pageSize) throws IOException {
//		InputStream is = Resources.getResourceAsStream("mybatis.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = factory.openSession();
		SqlSession session=MyBatisUtil.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pageStart", (pageNumber-1)*pageSize);
		map.put("pageSize", pageSize);
		LogMapper mapper=session.getMapper(LogMapper.class);
		List<Log> list=mapper.selPageInfo(map);
		long count=mapper.selCount();
		PageInfo pi=new PageInfo();
		pi.setPageSize(pageSize);
		pi.setPageNumber(pageNumber);
		pi.setList(list);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		System.out.println("pi value:"+pi.toString());
		return pi;
	}

}
