package mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import pojo.Users;

public interface UsersMapper {
	@Results(value = {
			@Result(id=true,property = "id",column = "id"),
			@Result(property = "menus",many = @Many(select="mapper.MenuMapper.selByPid"),column = "{uid=id,pid=pid}")
			
			
	})
	@Select("select *,0 pid from users where username=#{username} and password=#{password} ")
	Users selByUsers(Users users);
}
