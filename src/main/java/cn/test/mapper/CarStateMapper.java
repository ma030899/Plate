package cn.test.mapper;





import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.test.entity.CarState;



public interface CarStateMapper {
	
	public void insertBean(CarState bean);
	
	public void deleteBean(int id);
	
	public void updateBean(CarState bean);
	
	
	public CarState selectBeanById(
			@Param("id") int id
			);
	
	
	public List<CarState> selectBeanList(
			@Param("start") int start,
			@Param("limit") int limit,
			@Param("chepai") String chepai,
			@Param("pinpai") String pinpai,
			@Param("xinghao") String xinghao,
			@Param("yanse") String yanse
			);
	
	
	public int selectBeanCount(
			@Param("chepai") String chepai,
			@Param("pinpai") String pinpai,
			@Param("xinghao") String xinghao,
			@Param("yanse") String yanse
			);
	
}
