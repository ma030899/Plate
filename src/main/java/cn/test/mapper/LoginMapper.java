package cn.test.mapper;
import cn.test.entity.Login;

public interface LoginMapper {
	int insert(Login record);

	Login selectByPrimaryKey(Integer id);
  
	Login checkByUserName(String username);
}
