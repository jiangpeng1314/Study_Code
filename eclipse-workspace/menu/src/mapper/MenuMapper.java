package mapper;

import java.util.List;

import pojo.Menu;

public interface MenuMapper {
	List<Menu> selByPid(int pid);
}
