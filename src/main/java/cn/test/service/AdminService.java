package cn.test.service;

import java.util.List;

import cn.test.entity.Admin;
import cn.test.entity.Vip;


public interface AdminService {
	//添加
		void insertBean(Admin bean);
		
		//删除
		public void deleteBean(int id);
		
		//更新
		public void updateBean(Admin bean);
		
		//用户登录
		public Admin userlogin(String username,String password,int role);
		
		
		//验证该用户名是否存在
		public Admin useryz(String username);
		
		
		//验证身份证是否存在
		public Admin sfzyz(String sfz);
		
		
		//根据ID查询对象
		public Admin selectBeanById(int id);
		
		//根据username查询对象
		public Admin selectBeanByUsername(String username);
		
		
		
		
		//按条件查询列表 支持分页
		public List<Admin> selectBeanList(int start,int limit,String username);
		
		
		//按条件查询列表数量
		public int selectBeanCount(String username);
		
		
		//按条件查询列表 支持分页
		public List<Admin> selectBeanList2(int start,int limit,String username);
		

		
		
		//按条件查询列表数量
		public int selectBeanCount2(String username);
		
		//按条件查询列表 支持分页
		public List<Vip> selectBeanList3(int start,int limit,String username);
		
		//按条件查询列表数量
		public int selectBeanCount3(String username);
		
		//按条件查询列表 支持分页
		public List<Admin> selectBeanList4(int start,int limit,String username);
		
		//按条件查询列表数量
		public int selectBeanCount4(String username);
		
	}






