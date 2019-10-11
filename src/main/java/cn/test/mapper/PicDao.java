package cn.test.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.test.entity.Pic;



public interface PicDao {
	
	public void insertBean(Pic bean);
	
	public void deleteBean(int id);
	
	public void updateBean(Pic bean);
	
	
	public Pic selectBeanById(
			@Param("id") int id
			);
	
	
	public List<Pic> selectBeanList(
			@Param("start") int start,
			@Param("limit") int limit
			);
	
	
	public int selectBeanCount(
			);
	
}
