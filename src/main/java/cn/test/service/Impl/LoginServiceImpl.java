package cn.test.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.test.entity.Login;
import cn.test.mapper.LoginMapper;
import cn.test.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Resource
	private LoginMapper loginMapper;

	public Login checkUser(String username) {
		// TODO Auto-generated method stub
		return this.loginMapper.checkByUserName(username);
	}

	public int insertNewUser(Login user) {
		// TODO Auto-generated method stub
		return this.loginMapper.insert(user);
	}
	
}
