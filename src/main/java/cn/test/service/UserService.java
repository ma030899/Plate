package cn.test.service;

import java.util.List;
import ccit.mly.page.LimitPageList;
import cn.test.entity.User;

public interface UserService {

	/**
	 * 通过id查询用户
	 */
	User selectById(Integer id);
	/**
	 * 添加用户信息
	 */
	void insertUser(User user);
	
	/**
	 * 修改用户信息
	 */
	void updateUser(User user);
	
	/**
	 * 显示用户信息
	 */
	List<User> selectAll();
	
	/**
	 * 删除用户信息
	 * @return 
	 */
	void deleteUser(Integer id);
}
