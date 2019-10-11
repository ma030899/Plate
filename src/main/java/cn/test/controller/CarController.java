package cn.test.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.test.entity.Car;
import cn.test.service.CarService;

@Controller
public class CarController {
	@Resource
	private CarService carService;
	/**
	 * 
	 * @param currentPage 当前页
	 * @param request 请求
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/index1", method = RequestMethod.GET)
	public ModelAndView showInformation(@RequestParam(defaultValue = "1") Integer currentPage,
			HttpServletRequest request, Map<String, Object> map) {
		PageHelper.startPage(currentPage, 6);//引入分页查询，使用PageHelper分页功能 . 当前页的记录条数
		List<Car> list = carService.selectAll();//startPage必须紧跟分页查询，执行顺序不能变
		PageInfo<Car> pageInfo = new PageInfo<Car>(list, 6);//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以  
		map.put("pageInfo", pageInfo);//pageINfo封装了分页的详细信息，也可以指定连续显示的页数  
		return new ModelAndView("information");
	}

	@RequestMapping("/deleteCar")
	public String deleteCar(Integer id) {
		System.out.println("id" + id);
		try {
			carService.deleteCar(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index1";
	}

	@RequestMapping("/finds")
	public ModelAndView findCarLocation(@RequestParam(defaultValue = "1") Integer currentPage,
			HttpServletRequest request, Map<String, Object> map) {
		String car_location = request.getParameter("car_location");
		PageHelper.startPage(currentPage, 6);
		List<Car> list = carService.findByLocations(car_location);
		PageInfo<Car> pageInfo = new PageInfo<Car>(list, 6);
		map.put("pageInfo", pageInfo);
		return new ModelAndView("information");//装载视图

	}

	@RequestMapping("/findByColor")
	public ModelAndView findByColor(@RequestParam(defaultValue = "1") Integer currentPage, HttpServletRequest request,
			Map<String, Object> map) {
		

		String carColor = request.getParameter("car_cor");
		PageHelper.startPage(currentPage, 6);
		List<Car> list = carService.findByColor(carColor);
		PageInfo<Car> pageInfo = new PageInfo<Car>(list, 6);
		map.put("pageInfo", pageInfo);
		return new ModelAndView("information");
	}
	@RequestMapping("/deletemany")
	public String DeleteMany(int[] chk_value) {
		carService.deleteMany(chk_value);
		return "redirect:/index1";
		
	}
	
}
