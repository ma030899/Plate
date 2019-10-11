package cn.test.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.easypr.BriefCityUtil;
import org.easypr.ColorUtil;
import org.easypr.FastJsonUtil;
import org.easypr.PlateUtil;
import org.easypr.Result;
import org.springframework.stereotype.Service;
import cn.test.entity.Car;
import cn.test.entity.Record;
import cn.test.mapper.CarMapper;
import cn.test.mapper.RecordMapper;
import cn.test.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Resource
	private CarMapper carMapper;// 注入
	@Resource
	private RecordMapper recordMapper;

	public Car selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result insertCar(Car car) throws Exception {
		Result result = new Result();
		Record record = new Record();
		car.setCarId(null);// 主键自增
		// car.setUserId(user.getId());//关联
		car.setAllCarCor(FastJsonUtil.allCarCor);// 所有识别车牌颜色
		car.setAllCarNum(FastJsonUtil.allCarNum);// 所有识别车牌号码
		BriefCityUtil.TotalPlate(FastJsonUtil.allCarNum);
		car.setCarLocation(BriefCityUtil.allLoaction);// 车牌所属地
		car.setCarTime(PlateUtil.carTime);// 识别所用耗时
		ColorUtil.BlueCount(FastJsonUtil.allCarCor, "blue");
		if (record.getName() == null) {
			record.setName("A0001");
		}
		car.setBlueCount(ColorUtil.blueCount);
		record.setBlue_count(ColorUtil.blueCount);
		ColorUtil.GreenCount(FastJsonUtil.allCarCor, "green");
		car.setGreenCount(ColorUtil.greenCount);
		record.setGreen_count(ColorUtil.greenCount);
		ColorUtil.YellowCount(FastJsonUtil.allCarCor, "yellow");
		car.setYellowCount(ColorUtil.yellowCount);
		record.setYellow_count(ColorUtil.yellowCount);
		ColorUtil.UnknowCount(FastJsonUtil.allCarCor, "unknown");
		car.setUnknowCount(ColorUtil.unknowCount);
		record.setUnknow_count(ColorUtil.unknowCount);

		int returnValue = carMapper.insertCar(car);
		if (returnValue > 0) {
			result.setCode(1);
			result.setMessage("新增数据成功");
			result.setResult(returnValue);
		} else {
			result.setCode(0);

			throw new Exception("新增数据失败了");
		}
		recordMapper.insertRecord(record);
		return result;

	}

	public void updateCar(Car car) {
		carMapper.updateCar(car);

	}

	public List<Car> selectAll() {
		// TODO Auto-generated method stub
		return carMapper.selectAll();
	}

	public Result deleteCar(Integer id) throws Exception {
		Result result = new Result();
		int returnValue = carMapper.deleteCar(id);
		if (returnValue > 0) {
			result.setCode(1);
			result.setMessage("删除成功");
			result.setResult(returnValue);
			System.out.println("删除成功");
		} else {
			result.setCode(0);

			throw new Exception("删除失败或者已经删除");
		}
		return result;
	}

	public List<Car> findByLocations(String car_location) {

		return carMapper.findByCarLocation(car_location);
	}

	public List<Car> findByColor(String carColor) {

		return carMapper.findByColor(carColor);
	}

	public Integer deleteMany(int[] id_arr) {
		// TODO Auto-generated method stub
		return carMapper.deleteMany(id_arr);
	}

}
