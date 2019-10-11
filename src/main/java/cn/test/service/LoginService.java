package cn.test.service;

import cn.test.entity.Login;

public interface LoginService {
	public Login checkUser(String username);

	public int insertNewUser(Login user);
}
