package cn.test.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.test.entity.Yue;
import cn.test.mapper.YueDao;
import cn.test.service.YueService;



@Service("yueService")
public class YueServiceImpl implements YueService {
	
	@Resource
	private YueDao yueDao;
	
	public void insertBean(Yue bean) {
		yueDao.insertBean(bean);
		
	}
	
	public void deleteBean(int id) {
		yueDao.deleteBean(id);
		
	}
	
	public void updateBean(Yue bean){
		
		yueDao.updateBean(bean);
		
	}
	

	
	
	//根据ID查询对象
	public Yue selectBeanById(int id){
		
		return yueDao.selectBeanById(id);
		
	}
	
	
	public List<Yue> selectBeanList(int start,int limit,String month){

		return yueDao.selectBeanList(start,limit,month);
		
		
	}
	
	public int selectBeanCount(String month){
		
		return yueDao.selectBeanCount(month);
		
	}



	
	
	
}











