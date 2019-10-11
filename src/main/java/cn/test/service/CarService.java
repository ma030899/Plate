package cn.test.service;

import java.util.List;
import org.easypr.Result;

import ccit.mly.page.LimitPageList;
import cn.test.entity.Car;
public interface CarService {

	/**
	 * 通过id查询用户
	 */
	Car selectById(Integer id);
	/**
	 * 添加用户信息
	 * @return 
	 * @throws Exception 
	 */
	Result insertCar(Car car) throws Exception;
	
	/**
	 * 修改用户信息
	 */
	void updateCar(Car car);
	
	/**
	 * 显示车牌信息
	 */
	List<Car> selectAll();
	
	/**
	 * 删除车牌信息
	 * @return 
	 * @throws Exception 
	 */
	
	Result deleteCar(Integer id) throws Exception;
	List<Car> findByLocations(String car_location);
	List<Car> findByColor(String carColor);
	public Integer deleteMany(int[] id_arr);
}
