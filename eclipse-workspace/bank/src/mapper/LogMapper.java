package mapper;

import java.util.List;
import java.util.Map;

import pojo.Log;
import pojo.PageInfo;

public interface LogMapper {
	long selCount();
	List<Log> selPageInfo(Map map);
	int insLog();
}
