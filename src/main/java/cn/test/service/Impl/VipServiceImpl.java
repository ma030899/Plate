package cn.test.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.test.entity.Vip;
import cn.test.mapper.VipDao;
import cn.test.service.VipService;


	@Service("VipService")
	public class VipServiceImpl implements VipService {
		
		@Resource
		private VipDao vipDao;
		
		public void insertBean(Vip bean) {
			vipDao.insertBean(bean);
			
		}
		
		public void deleteBean(int id) {
			vipDao.deleteBean(id);
			
		}
		
		public void updateBean(Vip bean){
			
			vipDao.updateBean(bean);
			
		}
		

		
		
		//根据ID查询对象
		public Vip selectBeanByUsername(String username){
			
			return vipDao.selectBeanByUsername(username);
			
		}
		

		public List<Vip> selectBeanList(int start, int limit, String username, int points, int level, String enddate,
				Double consumed,int kehuid) {
			return vipDao.selectBeanList(start,limit,username,points,level,enddate,consumed,kehuid);
		}

		public int selectBeanCount(String username) {
			return vipDao.selectBeanCount(username);
		}

		public Vip selectBeanByKehuid(int kehuid) {
			return vipDao.selectBeanByKehuid(kehuid);
		}


}
