package cn.test.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.test.entity.Yue;
public interface YueDao {
	
	public void insertBean(Yue bean);
	
	public void deleteBean(int id);
	
	public void updateBean(Yue bean);
	
	
	public Yue selectBeanById(
			@Param("id") int id
			);
	
	
	public List<Yue> selectBeanList(
			@Param("start") int start,
			@Param("limit") int limit,
			@Param("month") String month
			);
	
	
	public int selectBeanCount(
			@Param("month") String month
			);
	
}
