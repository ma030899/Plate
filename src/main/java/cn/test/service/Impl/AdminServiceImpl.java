package cn.test.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.test.entity.Admin;
import cn.test.entity.Vip;
import cn.test.mapper.AdminMapper;
import cn.test.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminMapper userDao;
	
	public void insertBean(Admin bean) {
		userDao.insertBean(bean);
		
	}
	
	public void deleteBean(int id) {
		userDao.deleteBean(id);
		
	}
	
	public void updateBean(Admin bean){
		
		userDao.updateBean(bean);
		
	}
	

	//用户登录
	public Admin userlogin(String username,String password,int role){
		
		return userDao.userlogin(username, password,role);
		
	}
	
	
	
	//验证该用户名是否存在
	public Admin useryz(String username){
		
		
		return userDao.useryz(username);
	}
	
	
	//验证身份证是否存在
	public Admin sfzyz(String sfz){
		
		
		return userDao.sfzyz(sfz);
	}
	
	
	//根据ID查询对象
	public Admin selectBeanById(int id){
		
		return userDao.selectBeanById(id);
		
	}
	
	
	public List<Admin> selectBeanList(int start,int limit,String username ){

		return userDao.selectBeanList(start,limit,username);
		
		
	}
	
	public int selectBeanCount(String username){

		return userDao.selectBeanCount(username);
		
	}


	public List<Admin> selectBeanList2(int start,int limit,String username ){

		return userDao.selectBeanList2(start,limit,username);
		
		
	}
	
	
	public int selectBeanCount2(String username){

		return userDao.selectBeanCount2(username);
		
	}
	
	
	public List<Vip> selectBeanList3(int start,int limit,String username ){
		
		return userDao.selectBeanList3(start,limit,username);
		
		
	}
	
	public int selectBeanCount3(String username){

		return userDao.selectBeanCount3(username);
		
	}
	
	
	public List<Admin> selectBeanList4(int start,int limit,String username ){
		
		return userDao.selectBeanList4(start,limit,username);
		
		
	}
	
	public int selectBeanCount4(String username){

		return userDao.selectBeanCount4(username);
		
	}

	public Admin selectBeanByUsername(String username) {
		return userDao.selectBeanByUsername(username);
	}

	
	
	
}