package cn.test.service;

import java.util.List;

import cn.test.entity.CarState;
public interface CarStateService {

	//添加
		void insertBean(CarState bean);
		
		//删除
		public void deleteBean(int id);
		
		//更新
		public void updateBean(CarState bean);
		

		
		//根据ID查询对象
		public CarState selectBeanById(int id);
		
		
		//按条件查询列表 支持分页
		public List<CarState> selectBeanList(int start,int limit,String chepai,String pinpai,String xinghao,String yanse);
		
		
		//按条件查询列表数量
		public int selectBeanCount(String chepai,String pinpai,String xinghao,String yanse);
		
		
		
		
	}