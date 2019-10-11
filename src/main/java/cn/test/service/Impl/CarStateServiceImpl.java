package cn.test.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.test.entity.CarState;
import cn.test.mapper.CarStateMapper;
import cn.test.service.CarStateService;


@Service("carstateService")
public class CarStateServiceImpl implements CarStateService {
	
	@Resource
	private CarStateMapper carDao;
	
	public void insertBean(CarState bean) {
		carDao.insertBean(bean);
		
	}
	
	public void deleteBean(int id) {
		carDao.deleteBean(id);
		
	}
	
	public void updateBean(CarState bean){
		
		carDao.updateBean(bean);
		
	}
	

	
	
	//根据ID查询对象
	public CarState selectBeanById(int id){
		
		return carDao.selectBeanById(id);
		
	}
	
	
	public List<CarState> selectBeanList(int start,int limit,String chepai,String pinpai,String xinghao,String yanse ){

		return carDao.selectBeanList(start,limit,chepai,pinpai,xinghao,yanse);
		
		
	}
	
	public int selectBeanCount(String chepai,String pinpai,String xinghao,String yanse){
		
		return carDao.selectBeanCount(chepai,pinpai,xinghao,yanse);
		
	}



	
	
	
}
