package cn.test.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.easypr.BriefCityUtil;
import org.easypr.FastJsonUtil;
import org.easypr.GetFileUtil;
import org.easypr.PlateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.test.entity.Car;
import cn.test.entity.Provice;
import cn.test.entity.Record;
import cn.test.entity.User;
import cn.test.mapper.CarMapper;
import cn.test.service.CarService;
import cn.test.service.ProviceService;
import cn.test.service.UserService;
@Controller
public class UserController {

	@Resource
	private UserService userService;
	@Resource
	private CarMapper carMapper;
	@Resource
	private CarService carService;
	@Resource
	private ProviceService proviceService;
//	@Resource
//	private RecordService recordService;
	@RequestMapping(value = "/index",method=RequestMethod.GET)
	public ModelAndView showInformation(@RequestParam(defaultValue = "1") Integer currentPage,
			HttpServletRequest request, Map<String, Object> map) {
		PageHelper.startPage(currentPage, 4);//引入分页查询，使用PageHelper分页功能 . 当前页的记录条数
		List<User> list = userService.selectAll();//startPage必须紧跟分页查询，执行顺序不能变
		PageInfo<User> pageInfo = new PageInfo<User>(list, 4);//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以  
		map.put("pageInfo", pageInfo);//pageINfo封装了分页的详细信息，也可以指定连续显示的页数  
		return new ModelAndView("showAll1");
	}

	/**
	 * 新增
	 * 
	 * @param user
	 * @param file
	 * @param request
	 * @param car
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addUser")
	public String addUser(User user, MultipartFile file, HttpServletRequest request,Car car,Record coloRecord,Provice provice) throws Exception {
		System.out.println("提交的用户：" + user);
		String filePath = request.getSession().getServletContext().getRealPath("/upload"); // 定义图片上传后的路径
		String newFileName = GetFileUtil.fileOperate(file, filePath);
		System.out.println("图片路径" + filePath);
		user.setUserImg(newFileName);
		System.out.println("最后的user:" + user);
		String Detailpath = filePath + "/" + newFileName;
		/**
		 * replaceAll()方法 采用正则表达式的规则去匹配，java解析将其交给交给正则表达式 拼接图片路径
		 */
		Detailpath = Detailpath.replaceAll("/", "\\\\");// 字符串中的斜杠/替换成反斜杠\,图片路径问题
		System.out.println("图片详细路径" + Detailpath);// 本地Tomact/upload文件夹下
		user.setImgUrl(Detailpath);// 将图片详细地址传入数据库中

		// System.out.println("sssssssssssssssss"+FastJsonUtil.car_cor);
		PlateUtil.GetResult(Detailpath);// 将图片路径（二进制）传给百度api工具类进行识别
		user.setCarNum(FastJsonUtil.allCarNum);
		user.setCarCor(FastJsonUtil.allCarCor);
		userService.insertUser(user);
		carService.insertCar(car);//将车牌信息（车辆所在地、车牌颜色、各个颜色得车牌数量插入数据库）
		proviceService.insertRecord(provice);
		//recordService.insert(coloRecord);
		FastJsonUtil.allCarNum="";
		FastJsonUtil.allCarCor="";
		FastJsonUtil.briefprovice="";
		BriefCityUtil.allLoaction="";
		return "redirect:/index";//重定向
	}

	/**
	 * 跳转到修改用户信息页面
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/toUpdateUser")
	public String toUpdateUserPage(Integer id, ModelMap map) {
		System.out.println("id:" + id);
		User user = userService.selectById(id);
		
		System.out.println("修改后获取的user：" + user);
		map.addAttribute("user", user);
		return "update";
	}

	/**
	 * 修改车牌图片/车主姓名等
	 * 
	 * @param user 整个user
	 * @param file 车辆图片
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateUser") // 暂时不用
	public String updateUser(User user,MultipartFile file,HttpServletRequest request) throws Exception{
			System.out.println("修改提交的用户：" + user);
			String filePath = request.getSession().getServletContext().getRealPath("/upload");
			; // 定义图片上传后的路径
			String newFileName = GetFileUtil.fileOperate(file, filePath);
			user.setUserImg(newFileName);
			System.out.println("修改最后的user:" + user);
			String Detailpath = filePath + "/" + newFileName;
			/**
			 * replaceAll()方法 采用正则表达式的规则去匹配，java解析将其交给交给正则表达式
			 */
			Detailpath = Detailpath.replaceAll("/", "\\\\");// 字符串中的斜杠/替换成反斜杠\,图片路径问题
			System.out.println("修改后的图片路径" + Detailpath);
			user.setImgUrl(Detailpath);// 修改数据库图片地址
			PlateUtil.GetResult(Detailpath);// 将图片路径（二进制）传给百度api工具类进行识别 替换车牌图片后对车牌进行识别
			user.setCarNum(FastJsonUtil.allCarNum);
			user.setCarCor(FastJsonUtil.allCarCor);
			
			userService.updateUser(user);
			Car car=new Car();
			car.setCarId(null);//主键自增
			car.setUserId(user.getId());//关联
			car.setAllCarCor(FastJsonUtil.allCarCor);//所有识别车牌号码
			car.setAllCarNum(FastJsonUtil.allCarNum);//所有识别车牌颜色
			BriefCityUtil.TotalPlate(FastJsonUtil.allCarNum);
			car.setCarLocation(BriefCityUtil.allLoaction);//车牌所属地
			car.setCarTime(PlateUtil.carTime);//识别所用耗时
			carService.updateCar(car);
			System.out.println("修改成功");
			FastJsonUtil.allCarNum="";
			FastJsonUtil.allCarCor="";
			FastJsonUtil.briefprovice="";
			BriefCityUtil.allLoaction="";
			//PlateUtil.GetResult(Detailpath);// 替换车牌图片后对车牌进行识别
			return "redirect:/index";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id) {
		System.out.println("id" + id);
		userService.deleteUser(id);
		return "redirect:/index";
	}
	@RequestMapping("/findById")
	public String Find(Integer id, ModelMap map) {
		System.out.println("id:" + id);
		User user = userService.selectById(id);
		
		System.out.println("修改后获取的user：" + user);
		map.addAttribute("user", user);
		return "detail";
	}

	
}
