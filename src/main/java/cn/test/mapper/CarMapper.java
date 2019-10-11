package cn.test.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.test.entity.Car;
public interface CarMapper {

	/**
	 * 通过id查询用户
	 */
	Car selectById(Integer id);
	/**
	 * 添加用户信息
	 * @return 
	 */
	int insertCar(Car car);
	
	/**
	 * 修改用户信息
	 */
	void updateCar(Car car);
	
	/**
	 * 显示用户信息
	 */
	List<Car> selectAll();
	
	/**
	 * 删除用户信息
	 */
	int deleteCar(Integer id);//删除
	List<Car> findByCarLocation(@Param("car_location") String carLocation);//根据车辆所在地查询。
	List<Car> findByColor(@Param("car_cor") String carColor);
	 public Integer deleteMany(int[] id_arr);

	
}
