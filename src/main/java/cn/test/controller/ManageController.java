package cn.test.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ccit.mly.util.Pager;
import ccit.mly.util.Util;
import cn.test.entity.Admin;
import cn.test.entity.Car;
import cn.test.entity.CarState;
import cn.test.entity.Gonggao;
import cn.test.entity.Jilu;
import cn.test.entity.Liuyan;
import cn.test.entity.Pic;
import cn.test.entity.Provice;
import cn.test.entity.Record;
import cn.test.entity.Ri;
import cn.test.entity.Vip;
import cn.test.entity.Yuding;
import cn.test.entity.Yue;
import cn.test.service.AdminService;
import cn.test.service.CarService;
import cn.test.service.CarStateService;
import cn.test.service.GonggaoService;
import cn.test.service.JiluService;
import cn.test.service.LiuyanService;
import cn.test.service.PicService;
import cn.test.service.ProviceService;
import cn.test.service.RecordService;
import cn.test.service.RiService;
import cn.test.service.VipService;
import cn.test.service.YudingService;
import cn.test.service.YueService;


@Controller
@RequestMapping("/manage")
public class ManageController {

	@Resource
	private AdminService userService;
	@Resource
	private CarService carService2;//车牌信息
	@Resource
	private ProviceService  proviceService;
	@Resource
	private RecordService recordService;
	@Resource
	private CarStateService carService;
	
	@Resource
	private GonggaoService gonggaoService; 
	
	@Resource
	private PicService picService;
	
	@Resource
	private JiluService jiluService;
	
	@Resource
	private YudingService yudingService;
	
	@Resource
	private LiuyanService liuyanService;
	
	@Resource
	private RiService riService;
	
	@Resource
	private YueService yueService;
	
	@Resource
	private VipService vipService;
	

	@Value("#{dbConf.pageSize}")
	private int pageSize;
	//历史纪录
	@RequestMapping(value = "/index1", method = RequestMethod.GET)
	public ModelAndView showInformation(@RequestParam(defaultValue = "1") Integer currentPage,
			HttpServletRequest request, Map<String, Object> map) {
		PageHelper.startPage(currentPage, 6);//引入分页查询，使用PageHelper分页功能 . 当前页的记录条数
		List<Car> list = carService2.selectAll();//startPage必须紧跟分页查询，执行顺序不能变
		PageInfo<Car> pageInfo = new PageInfo<Car>(list, 6);//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以  
		map.put("pageInfo", pageInfo);//pageINfo封装了分页的详细信息，也可以指定连续显示的页数  
		return new ModelAndView("information/information");
	}
	@RequestMapping("/deleteCar")
	public String deleteCar(Integer id) {
		System.out.println("id" + id);
		try {
			carService2.deleteCar(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index1";
	}
	@RequestMapping(value = "/proviceRecord")
    public @ResponseBody  Object getRecord(){
        List<Provice> list=proviceService.showProvices();
            return list;
    }
    @RequestMapping(value ="/provice")
    public String into(){
        return "showProvice";
    }
    @RequestMapping(value = "/record")
    public @ResponseBody  Object getColor(){
        List<Record> list=recordService.showcolor();
            return list;
    }
    @RequestMapping(value ="/color")
    public String ColorInto(){
        return "showColor";
        //showColor
    }
    @RequestMapping("/finds")
	public ModelAndView findCarLocation(@RequestParam(defaultValue = "1") Integer currentPage,
			HttpServletRequest request, Map<String, Object> map) {
		String car_location = request.getParameter("car_location");
		PageHelper.startPage(currentPage, 6);
		List<Car> list = carService2.findByLocations(car_location);
		PageInfo<Car> pageInfo = new PageInfo<Car>(list, 6);
		map.put("pageInfo", pageInfo);
		return new ModelAndView("information");//装载视图

	}

	@RequestMapping("/findByColor")
	public ModelAndView findByColor(@RequestParam(defaultValue = "1") Integer currentPage, HttpServletRequest request,
			Map<String, Object> map) {
		String carColor = request.getParameter("car_cor");
		PageHelper.startPage(currentPage, 6);
		List<Car> list = carService2.findByColor(carColor);
		PageInfo<Car> pageInfo = new PageInfo<Car>(list, 6);
		map.put("pageInfo", pageInfo);
		return new ModelAndView("information");
	}
	// 获取输出对象
	public PrintWriter getPrintWriter(HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return writer;
	}



	//管理员登录
	@RequestMapping("/login.do")
	public void login(HttpServletRequest request,HttpServletResponse response,String username,String password,String role){

		PrintWriter writer = this.getPrintWriter(response);

		Admin user = userService.userlogin(username, password,Integer.parseInt(role));

		if(user==null){

			writer.print("<script language=javascript>alert('用户名或者密码错误');window.location.href='login.jsp';</script>");

		}else{
			HttpSession session = request.getSession();
			session.setAttribute("manage", user);

			writer.print("<script language=javascript>alert('登录成功');window.location.href='index.jsp';</script>");

		}

	}


	//安全退出
	@RequestMapping("/loginout.do")
	public void loginout(HttpServletRequest request,HttpServletResponse response,String username,String password){

		
		PrintWriter writer = this.getPrintWriter(response);

		HttpSession session = request.getSession();
		session.removeAttribute("manage");
		writer.print("<script language=javascript>alert('退出成功');window.location.href='login.jsp';</script>");

	}


	//跳转到修改密码页面
	@RequestMapping("/password.do")
	public String password(HttpServletRequest request){

		request.setAttribute("url", "password2.do");

		request.setAttribute("title", "修改密码");

		return "password";

	}

	//修改密码操作
	@RequestMapping("/password2.do")
	public void password2(HttpServletRequest request,HttpServletResponse response,String password1,String password2){

		PrintWriter writer = this.getPrintWriter(response);

		HttpSession session = request.getSession();

		Admin user = (Admin)session.getAttribute("manage");

		Admin bean = userService.userlogin(user.getUsername(), password1, user.getRole());

		if(bean!=null){
			bean.setPassword(password2);
			userService.updateBean(bean);

			writer.print("<script language=javascript>alert('修改成功');window.location.href='password.do';</script>");


		}else{

			writer.print("<script language=javascript>alert('用户名或者密码错误');window.location.href='password.do';</script>");

		}
	}

	
	//人员列表
	@RequestMapping("/userlist.do")
	public String userlist(HttpServletRequest request,String pagenum,String username){

		//查询条件返回页面
		if (username != null && !"".equals(username)) {

			request.setAttribute("username", username);
		}


		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Admin> list = userService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, username);

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = userService.selectBeanCount(username);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "userlist.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "userlist.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "user");

		request.setAttribute("title", "人员管理");

		return "user/userlist";

	}


	//跳转到添加人员页面
	@RequestMapping("/useradd.do")
	public String useradd(HttpServletRequest request){

		request.setAttribute("url", "useradd2.do");

		request.setAttribute("title", "添加人员");

		return "user/useradd";

	}


	//添加人员操作
	@RequestMapping("/useradd2.do")
	public void useradd2(HttpServletResponse response,Admin bean){

		Admin user = userService.useryz(bean.getUsername());
		
		if(user!=null){
			this.getPrintWriter(response).print("<script language=javascript>alert('操作失败，该用户名已经存在');window.location.href='userlist.do';</script>");
			return;
		}

		bean.setPassword("111111");
		bean.setCreatetime(Util.getTime());
		userService.insertBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='userlist.do';</script>");
	}


	//跳转到修改人员页面
	@RequestMapping("/userupdate.do")
	public String userupdate(HttpServletRequest request,int id){

		Admin bean = userService.selectBeanById(id);

		request.setAttribute("bean", bean);

		request.setAttribute("url", "userupdate2.do?id="+id);

		request.setAttribute("title", "修改人员");

		return "user/userupdate";

	}

	//修改人员操作
	@RequestMapping("/userupdate2.do")
	public void userupdate2(HttpServletResponse response,Admin bean){

		userService.updateBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='userlist.do';</script>");
	}


	//删除操作
	@RequestMapping("/userdelete.do")
	public void userdelete(HttpServletResponse response,int id){

		userService.deleteBean(id);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='userlist.do';</script>");
	}



	//跳转到查看详情页面
	@RequestMapping("/userupdate3.do")
	public String userupdate3(HttpServletRequest request,int id){

		Admin bean = userService.selectBeanById(id);

		request.setAttribute("bean", bean);

		request.setAttribute("title", "查看详情");

		return "user/userupdate3";

	}
	
	
	
	//车辆列表
	@RequestMapping("/carlist.do")
	public String carlist(HttpServletRequest request,String pagenum,String chepai){

		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<CarState> list = carService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,null,null,null);

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = carService.selectBeanCount(chepai,null,null,null);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "carlist.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "carlist.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "car");

		request.setAttribute("title", "车辆管理");

		return "car/carlist";

	}


	//跳转到添加车辆页面
	@RequestMapping("/caradd.do")
	public String caradd(HttpServletRequest request){

		request.setAttribute("url", "caradd2.do");

		request.setAttribute("title", "添加车辆");

		return "car/caradd";

	}




	//添加车辆操作
	@RequestMapping("/caradd2.do")
	public void caradd2(HttpServletResponse response,HttpServletRequest request,CarState bean,MultipartFile prodFile){

		
		if(prodFile==null || prodFile.getSize()<=0 ){
			this.getPrintWriter(response).print("<script language=javascript>alert('车辆图片不能为空');" +
			"window.location.href='caradd.do';</script>");
			return;
		}

		String pic =  Util.uploadFile(request, prodFile);

		bean.setPic(pic);
		
		bean.setStatus("车位空闲");
		bean.setCtime(Util.getTime());
		carService.insertBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');" +
		"window.location.href='carlist.do';</script>");
	}


	//跳转到修改车辆页面
	@RequestMapping("/carupdate.do")
	public String carupdate(HttpServletRequest request,int id){

		CarState bean = carService.selectBeanById(id);

		request.setAttribute("bean", bean);

		request.setAttribute("url", "carupdate2.do?id="+id);

		request.setAttribute("title", "修改车辆");

		return "car/carupdate";

	}

	//修改车辆操作
	@RequestMapping("/carupdate2.do")
	public void carupdate2(HttpServletResponse response,HttpServletRequest request,CarState bean,MultipartFile prodFile){

		if(prodFile!=null && prodFile.getSize()>0){
			String pic =  Util.uploadFile(request, prodFile);

			bean.setPic(pic);
		}

		
		carService.updateBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='carlist.do';</script>");
	}


	//删除操作
	@RequestMapping("/cardelete.do")
	public void cardelete(HttpServletResponse response,int id){

		carService.deleteBean(id);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='carlist.do';</script>");
	}
	
	
	
	//跳转到查看详情页面
	@RequestMapping("/carupdate3.do")
	public String carupdate3(HttpServletRequest request,int id){

		CarState bean = carService.selectBeanById(id);

		request.setAttribute("bean", bean);

		request.setAttribute("title", "查看车辆详情");

		return "car/carupdate3";

	}
	
	
	
	//车辆维修列表
	@RequestMapping("/carlist2.do")
	public String carlist2(HttpServletRequest request,String pagenum,String chepai){

		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<CarState> list = carService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,null,null,null);

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = carService.selectBeanCount(chepai,null,null,null);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "carlist2.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "carlist2.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "car");

		request.setAttribute("title", "车辆维修管理");

		return "car/carlist2";

	}
	
	
	
	//设置为维修状态操作
	@RequestMapping("/cardelete2.do")
	public void cardelete2(HttpServletResponse response,int id){
		
		CarState bean = carService.selectBeanById(id);

		bean.setStatus("维修中");
		
		carService.updateBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='carlist2.do';</script>");
	}
	
	
	//维修完成操作
	@RequestMapping("/cardelete3.do")
	public void cardelete3(HttpServletResponse response,int id){
		
		CarState bean = carService.selectBeanById(id);

		bean.setStatus("车位空闲");
		
		carService.updateBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='carlist2.do';</script>");
	}
	

	
	
	//网站公告列表
	@RequestMapping("/gonggaolist.do")
	public String gonggaolist(HttpServletRequest request,String pagenum,String gbiaoti){

		//查询条件返回页面
		if (gbiaoti != null && !"".equals(gbiaoti)) {

			request.setAttribute("gbiaoti", gbiaoti);
		}


		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Gonggao> list = gonggaoService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, gbiaoti);

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = gonggaoService.selectBeanCount(gbiaoti);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "gonggaolist.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "gonggaolist.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "gonggao");

		request.setAttribute("title", "网站公告管理");

		return "gonggao/gonggaolist";

	}


	//跳转到添加网站公告页面
	@RequestMapping("/gonggaoadd.do")
	public String gonggaoadd(HttpServletRequest request){

		request.setAttribute("url", "gonggaoadd2.do");

		request.setAttribute("title", "添加网站公告");

		return "gonggao/gonggaoadd";

	}


	//添加网站公告操作
	@RequestMapping("/gonggaoadd2.do")
	public void gonggaoadd2(HttpServletResponse response,Gonggao bean){

		
		bean.setCtime(Util.getTime());
		
		gonggaoService.insertBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='gonggaolist.do';</script>");
	}


	//跳转到修改网站公告页面
	@RequestMapping("/gonggaoupdate.do")
	public String gonggaoupdate(HttpServletRequest request,int id){

		Gonggao bean = gonggaoService.selectBeanById(id);

		request.setAttribute("bean", bean);

		request.setAttribute("url", "gonggaoupdate2.do?id="+id);

		request.setAttribute("title", "修改网站公告");

		return "gonggao/gonggaoupdate";

	}

	//修改网站公告操作
	@RequestMapping("/gonggaoupdate2.do")
	public void gonggaoupdate2(HttpServletResponse response,Gonggao bean){

		gonggaoService.updateBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='gonggaolist.do';</script>");
	}


	//删除操作
	@RequestMapping("/gonggaodelete.do")
	public void gonggaodelete(HttpServletResponse response,int id){

		gonggaoService.deleteBean(id);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='gonggaolist.do';</script>");
	}



	//跳转到查看详情页面
	@RequestMapping("/gonggaoupdate3.do")
	public String gonggaoupdate3(HttpServletRequest request,int id){

		Gonggao bean = gonggaoService.selectBeanById(id);

		request.setAttribute("bean", bean);

		request.setAttribute("title", "查看详情");

		return "gonggao/gonggaoupdate3";

	}
	
	
	
	//展示图片列表
	@RequestMapping("/piclist.do")
	public String piclist(HttpServletRequest request,String pagenum){

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Pic> list = picService.selectBeanList((currentpage - 1)
				* pageSize, pageSize);

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = picService.selectBeanCount();

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "piclist.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "piclist.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "pic");

		request.setAttribute("title", "展示图片管理");

		return "pic/piclist";

	}




	//跳转到修改展示图片页面
	@RequestMapping("/picupdate.do")
	public String picupdate(HttpServletRequest request,int id){

		Pic bean = picService.selectBeanById(id);

		request.setAttribute("bean", bean);

		request.setAttribute("url", "picupdate2.do?id="+id);

		request.setAttribute("title", "修改展示图片");

		return "pic/picupdate";

	}

	//修改展示图片操作
	@RequestMapping("/picupdate2.do")
	public void picupdate2(HttpServletResponse response,HttpServletRequest request,Pic bean,MultipartFile prodFile){

		if(prodFile!=null && prodFile.getSize()>0){
			String pic =  Util.uploadFile(request, prodFile);

			bean.setPath(pic);
		}

		
		picService.updateBean(bean);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='piclist.do';</script>");
	}
	
	//车辆租赁列表
	@RequestMapping("/carlist3.do")
	public String carlist3(HttpServletRequest request,String pagenum,String chepai,String pinpai,String xinghao,String yanse){

		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}
		if (pinpai != null && !"".equals(pinpai)) {

			request.setAttribute("pinpai", pinpai);
		}
		if (xinghao != null && !"".equals(xinghao)) {

			request.setAttribute("xinghao", xinghao);
		}
		if (yanse != null && !"".equals(yanse)) {

			request.setAttribute("yanse", yanse);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<CarState> list = carService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,pinpai,xinghao,yanse);

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = carService.selectBeanCount(chepai,pinpai,xinghao,yanse);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "carlist3.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "carlist3.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "car");

		request.setAttribute("title", "车辆租赁管理");

		return "car/carlist3";

	}
	
	
	//跳转到租车页面
	@RequestMapping("/jiluadd.do")
	public String jiluadd(HttpServletRequest request,int carid){
		
		CarState car = carService.selectBeanById(carid);
		
		request.setAttribute("car", car);
		
		request.setAttribute("url", "jiluadd2.do?carid="+carid);

		request.setAttribute("title", "租车");

		return "jilu/jiluadd";

	}



	//租车操作
	@RequestMapping("/jiluadd2.do")
	public void jiluadd2(HttpServletResponse response,HttpServletRequest request,Jilu bean,MultipartFile prodFile1,MultipartFile prodFile2){

		
		if(prodFile1==null || prodFile1.getSize()<=0 ){
			this.getPrintWriter(response).print("<script language=javascript>alert('身份证复印件不能为空');" +
			"window.location.href='jiluadd.do';</script>");
			return;
		}
		
		if(prodFile2==null || prodFile2.getSize()<=0 ){
			this.getPrintWriter(response).print("<script language=javascript>alert('驾驶证复印件不能为空');" +
			"window.location.href='jiluadd.do';</script>");
			return;
		}
		int carid = bean.getCarid();
		
		CarState car = carService.selectBeanById(carid);
		
		bean.setChepai(car.getChepai());
		bean.setCarid(car.getId());
		
		
		String sfz  = bean.getSfz();
		
		Admin kehu = userService.sfzyz(sfz);
		
		if(kehu==null){
			kehu = new Admin();
			kehu.setCreatetime(Util.getTime());
			kehu.setName(bean.getXingming());
			kehu.setPassword("111111");
			kehu.setRole(4);
			kehu.setSfz(sfz);
			kehu.setTej(bean.getDianhua());
			kehu.setUsername(sfz);
			
			userService.insertBean(kehu);
		}
		
		bean.setKehuid(kehu.getId());
		
		HttpSession session = request.getSession();
		
		Admin user = (Admin)session.getAttribute("manage");
		
		bean.setWorkid(user.getId());
		

		String sfz2 =  Util.uploadFile(request, prodFile1);
		String jsz =  Util.uploadFile(request, prodFile2);

		bean.setSfz2(sfz2);
		bean.setJsz(jsz);
		
		bean.setShijian1(Util.getTime());
		bean.setZhuangtai("已在车位中");

		jiluService.insertBean(bean);
		
		car.setStatus("车位被占");
		
		carService.updateBean(car);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');" +
		"window.location.href='jilulist.do';</script>");
	}
	
	
	//租车记录列表
	@RequestMapping("/jilulist.do")
	public String jilulist(HttpServletRequest request,String pagenum,String chepai,String xingming,String sfz){
		
		HttpSession session = request.getSession();
		
		Admin user = (Admin)session.getAttribute("manage");

		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}
		if (xingming != null && !"".equals(xingming)) {

			request.setAttribute("xingming", xingming);
		}
		if (sfz != null && !"".equals(sfz)) {

			request.setAttribute("sfz", sfz);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Jilu> list = jiluService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,sfz,xingming,null,user.getId(),0,0);
		
		for(Jilu jilu:list){
			jilu.setCar(carService.selectBeanById(jilu.getCarid()));
		}

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = jiluService.selectBeanCount(chepai,sfz,xingming,null,user.getId(),0,0);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "jilulist.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "jilulist.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "jilu");

		request.setAttribute("title", "出库管理");

		return "jilu/jilulist";

	}
	
	
	//跳转到客户还车页面
	@RequestMapping("/jiluupdate.do")
	public String jiluupdate(HttpServletRequest request,int id) throws ParseException{

		Jilu bean = jiluService.selectBeanById(id);
		
		CarState car = carService.selectBeanById(bean.getCarid());
		bean.setCar(car);


		request.setAttribute("bean", bean);

		request.setAttribute("url", "jiluupdate2.do?id="+id);

		request.setAttribute("title", "用户出库");
		
		long t1 = new Date().getTime();//当前时间毫秒数
		
		long t2 = Util.parseTime(bean.getShijian1()).getTime();//出租时间毫秒数
		
		long t3 = 24*60*60*1000;//一天的毫秒数
		
		long tianshu = ((t1-t2)/t3 )+1;//已租天数
		

		long tzujin = tianshu*car.getZujin();  //总租金
		
		
		Vip vip = vipService.selectBeanByKehuid(bean.getKehuid());
		double tzujin2 =0.0d;
		if(vip!=null) {
			tzujin2 = tianshu*car.getZujin()*vip.getDiscount() ;  //会员折后总租金	
		}else {
			tzujin2=tzujin;
		}

		request.setAttribute("tzujinbefore", tzujin);//未折扣前
		
		request.setAttribute("tianshu", tianshu);
		
		request.setAttribute("tzujin", tzujin2);
		
		
		request.setAttribute("shijian2", Util.getTime());
		
		

		return "jilu/jiluupdate";

	}

	//客户还车操作
	@RequestMapping("/jiluupdate2.do")
	public void jiluupdate2(HttpServletResponse response,HttpServletRequest request){

		String id = request.getParameter("id");
		String shijian2 = request.getParameter("shijian2");
		String tianshu = request.getParameter("tianshu");
		String tzujin = request.getParameter("tzujin");
		
		Jilu jilu = jiluService.selectBeanById(Integer.parseInt(id));
		
		
		jilu.setShijian2(shijian2);
		jilu.setTianshu(Integer.parseInt(tianshu));
		jilu.setTzujin(Double.parseDouble(tzujin));
		jilu.setZhuangtai("出库中,等待技术人员确认");
		
		jiluService.updateBean(jilu);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='jilulist.do';</script>");
	}
	
	//跳转到查看详情页面
	@RequestMapping("/jiluupdate3.do")
	public String jiluupdate3(HttpServletRequest request,int id){

		Jilu bean = jiluService.selectBeanById(id);
		
		bean.setCar(carService.selectBeanById(bean.getCarid()));
		bean.setWork(userService.selectBeanById(bean.getWorkid()));
		bean.setJishu(userService.selectBeanById(bean.getJishuid()));

		request.setAttribute("bean", bean);

		request.setAttribute("title", "查看车位记录详情");

		return "jilu/jiluupdate3";

	}
	
	
	//技术确认查询
	@RequestMapping("/jilulist2.do")
	public String jilulist2(HttpServletRequest request,String pagenum,String chepai,String xingming,String sfz){
		
		HttpSession session = request.getSession();
		
		Admin user = (Admin)session.getAttribute("manage");

		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}
		if (xingming != null && !"".equals(xingming)) {

			request.setAttribute("xingming", xingming);
		}
		if (sfz != null && !"".equals(sfz)) {

			request.setAttribute("sfz", sfz);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Jilu> list = jiluService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,sfz,xingming,"出库中,等待技术人员确认",user.getId(),0,0);
		
		for(Jilu jilu:list){
			jilu.setCar(carService.selectBeanById(jilu.getCarid()));
		}

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = jiluService.selectBeanCount(chepai,sfz,xingming,"出库中,等待技术人员确认",user.getId(),0,0);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "jilulist2.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "jilulist2.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "jilu");

		request.setAttribute("title", "技术确认查询");

		return "jilu/jilulist2";

	}
	
	
	
	
	//待确认车辆
	@RequestMapping("/jilulist3.do")
	public String jilulist3(HttpServletRequest request,String pagenum,String chepai,String xingming,String sfz){
		
		
		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}
		if (xingming != null && !"".equals(xingming)) {

			request.setAttribute("xingming", xingming);
		}
		if (sfz != null && !"".equals(sfz)) {

			request.setAttribute("sfz", sfz);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Jilu> list = jiluService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,sfz,xingming,"出库中,等待技术人员确认",0,0,0);
		
		for(Jilu jilu:list){
			jilu.setCar(carService.selectBeanById(jilu.getCarid()));
		}

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = jiluService.selectBeanCount(chepai,sfz,xingming,"出库中,等待技术人员确认",0,0,0);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "jilulist3.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "jilulist3.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "jilu");

		request.setAttribute("title", "待确认车辆");

		return "jilu/jilulist3";

	}
	
	
	
	//跳转到输入确认信息页面
	@RequestMapping("/jiluupdate5.do")
	public String jiluupdate5(HttpServletRequest request,int id) throws ParseException{

		Jilu bean = jiluService.selectBeanById(id);
		
		CarState car = carService.selectBeanById(bean.getCarid());
		bean.setCar(car);

		request.setAttribute("bean", bean);

		request.setAttribute("url", "jiluupdate6.do?id="+id);

		request.setAttribute("title", "输入确认信息");


		return "jilu/jiluupdate5";

	}

	//输入确认信息操作
	@RequestMapping("/jiluupdate6.do")
	public void jiluupdate6(HttpServletResponse response,HttpServletRequest request,Jilu bean){

		Jilu jilu = jiluService.selectBeanById(bean.getId());
		
		HttpSession session = request.getSession();
		
		Admin user = (Admin)session.getAttribute("manage");
		
		jilu.setWeixiu(bean.getWeixiu());
		
		jilu.setJishuid(user.getId());
		
		jilu.setZhuangtai("技术人员已确认");
		
		
		jiluService.updateBean(jilu);


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='jilulist3.do';</script>");
	}
	
	
	//我的确认车辆
	@RequestMapping("/jilulist4.do")
	public String jilulist4(HttpServletRequest request,String pagenum,String chepai,String xingming,String sfz){
		
		
		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}
		if (xingming != null && !"".equals(xingming)) {

			request.setAttribute("xingming", xingming);
		}
		if (sfz != null && !"".equals(sfz)) {

			request.setAttribute("sfz", sfz);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		HttpSession session = request.getSession();
		
		Admin user = (Admin)session.getAttribute("manage");
		
		//查询列表
		List<Jilu> list = jiluService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,sfz,xingming,null,0,user.getId(),0);
		
		for(Jilu jilu:list){
			jilu.setCar(carService.selectBeanById(jilu.getCarid()));
		}

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = jiluService.selectBeanCount(chepai,sfz,xingming,null,0,user.getId(),0);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "jilulist4.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "jilulist4.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "jilu");

		request.setAttribute("title", "我的确认车辆");

		return "jilu/jilulist4";

	}
	
	
	
	//确认管理
	@RequestMapping("/jilulist5.do")
	public String jilulist5(HttpServletRequest request,String pagenum,String chepai,String xingming,String sfz){
		
		
		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}
		if (xingming != null && !"".equals(xingming)) {

			request.setAttribute("xingming", xingming);
		}
		if (sfz != null && !"".equals(sfz)) {

			request.setAttribute("sfz", sfz);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		HttpSession session = request.getSession();
		
		Admin user = (Admin)session.getAttribute("manage");
		
		//查询列表
		List<Jilu> list = jiluService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,sfz,xingming,"技术人员已确认",user.getId(),0,0);
		
		for(Jilu jilu:list){
			jilu.setCar(carService.selectBeanById(jilu.getCarid()));
		}

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = jiluService.selectBeanCount(chepai,sfz,xingming,"技术人员已确认",user.getId(),0,0);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "jilulist5.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "jilulist5.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "jilu");

		request.setAttribute("title", "确认管理");

		return "jilu/jilulist5";

	}
	
	
	//确认还车操作
	@RequestMapping("/jiluupdate7.do")
	public void jiluupdate7(HttpServletResponse response,HttpServletRequest request){

		String id = request.getParameter("id");
		
		Jilu jilu = jiluService.selectBeanById(Integer.parseInt(id));

		jilu.setZhuangtai("完成结算");
		
		jiluService.updateBean(jilu);
		
		CarState car =  carService.selectBeanById(jilu.getCarid());
		
		car.setStatus("车位空闲");

		car.setWeihu(car.getWeihu()+jilu.getWeixiu());
		car.setTzujin(car.getTzujin()+jilu.getTzujin());
		
		carService.updateBean(car);
		
		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='jilulist5.do';</script>");
	}
	
	
	
	
	//待处理预定列表
	@RequestMapping("/yudinglist.do")
	public String yudinglist(HttpServletRequest request,String pagenum,String chepai,String sfz){
		
		

		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}

		if (sfz != null && !"".equals(sfz)) {

			request.setAttribute("sfz", sfz);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Yuding> list = yudingService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,sfz,0,0,"处理中");
		

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = yudingService.selectBeanCount(chepai,sfz,0,0,"处理中");

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "yudinglist.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "yudinglist.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "yuding");

		request.setAttribute("title", "待处理预定");

		return "yuding/yudinglist";

	}
	
	
	
	//跳转到处理预定页面
	@RequestMapping("/yudingupdate.do")
	public String yudingupdate(HttpServletRequest request,int id) throws ParseException{

		Yuding bean = yudingService.selectBeanById(id);


		request.setAttribute("bean", bean);

		request.setAttribute("url", "yudingupdate2.do?id="+id);

		request.setAttribute("title", "处理用户预定");
		

		return "yuding/yudingupdate";

	}

	//处理预定操作
	@RequestMapping("/yudingupdate2.do")
	public void yudingupdate2(HttpServletResponse response,HttpServletRequest request ){

		String id = request.getParameter("id");
		String zhuangtai = request.getParameter("zhuangtai");
		
		HttpSession session = request.getSession();
		
		Admin user = (Admin)session.getAttribute("manage");
		
		Yuding bean = yudingService.selectBeanById(Integer.parseInt(id));
		
		if("预定成功".equals(zhuangtai)){
			bean.setZhuangtai("预定成功");
			bean.setShijian2(Util.getTime());
			bean.setWorkid(user.getId());
			
			yudingService.updateBean(bean);
			
			CarState car = carService.selectBeanById(bean.getCarid());
			
			car.setStatus("车位被占");
			
			carService.updateBean(car);
			
			Jilu jilu = new Jilu();
			jilu.setBeizhu(bean.getBeizhu());
			jilu.setCarid(bean.getCarid());
			jilu.setChepai(bean.getChepai());
			jilu.setDianhua(bean.getDianhua());
			jilu.setJsz(bean.getJsz());
			jilu.setKehuid(bean.getKehuid());
			jilu.setSfz(bean.getSfz());
			jilu.setSfz2(bean.getSfz2());
			jilu.setShijian1(Util.getTime());
			jilu.setWorkid(user.getId());
			jilu.setXingming(bean.getXingming());
			jilu.setZhuangtai("已在车位中");
			
			jiluService.insertBean(jilu);
			
		}else{
			bean.setZhuangtai("预定失败");
			bean.setShijian2(Util.getTime());
			bean.setWorkid(user.getId());
			
			yudingService.updateBean(bean);
			
			CarState car = carService.selectBeanById(bean.getCarid());
			
			car.setStatus("车位空闲");
			
			carService.updateBean(car);
		}
		
		


		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='yudinglist.do';</script>");
	}
	
	
	
	//我处理的预定
	@RequestMapping("/yudinglist2.do")
	public String yudinglist2(HttpServletRequest request,String pagenum,String chepai,String sfz){
		
		HttpSession session = request.getSession();
		
		Admin user = (Admin)session.getAttribute("manage");

		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}

		if (sfz != null && !"".equals(sfz)) {

			request.setAttribute("sfz", sfz);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Yuding> list = yudingService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,sfz,0,user.getId(),null);
		

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = yudingService.selectBeanCount(chepai,sfz,0,user.getId(),null);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "yudinglist2.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "yudinglist2.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "yuding");

		request.setAttribute("title", "我处理的预定");

		return "yuding/yudinglist2";

	}
	
	
	//跳转到查看预定详情页面
	@RequestMapping("/yudingupdate3.do")
	public String yudingupdate3(HttpServletRequest request,int id) throws ParseException{

		Yuding bean = yudingService.selectBeanById(id);


		request.setAttribute("bean", bean);
		request.setAttribute("title", "查看预定详情");
		

		return "yuding/yudingupdate3";

	}
	
	
	
	
	//待回复留言列表
	@RequestMapping("/liuyanlist.do")
	public String liuyanlist(HttpServletRequest request,String pagenum,String ltitle){
		

		//查询条件返回页面
		if (ltitle != null && !"".equals(ltitle)) {

			request.setAttribute("ltitle", ltitle);
		}


		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Liuyan> list = liuyanService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, ltitle,"未回复",0,0);
		

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = liuyanService.selectBeanCount(ltitle,"未回复",0,0);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "liuyanlist.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "liuyanlist.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "liuyan");

		request.setAttribute("title", "待回复留言");

		return "liuyan/liuyanlist";

	}
	
	
	
	//跳转到回复留言页面
	@RequestMapping("/liuyanupdate.do")
	public String liuyanupdate(HttpServletRequest request,int id) throws ParseException{

		Liuyan bean = liuyanService.selectBeanById(id);


		request.setAttribute("bean", bean);

		request.setAttribute("url", "liuyanupdate2.do?id="+id);

		request.setAttribute("title", "回复留言");
		

		return "liuyan/liuyanupdate";

	}

	//回复留言操作
	@RequestMapping("/liuyanupdate2.do")
	public void liuyanupdate2(HttpServletResponse response,HttpServletRequest request ){

		String id = request.getParameter("id");
		String huifu = request.getParameter("huifu");
		
		HttpSession session = request.getSession();
		
		Admin user = (Admin)session.getAttribute("manage");
		
		Liuyan bean = liuyanService.selectBeanById(Integer.parseInt(id));
		
		bean.setHuifu(huifu);
		bean.setShijian2(Util.getTime());
		bean.setZhuangtai("已回复");
		bean.setWorkid(user.getId());
		
		liuyanService.updateBean(bean);

		this.getPrintWriter(response).print("<script language=javascript>alert('操作成功');window.location.href='liuyanlist.do';</script>");
	}
	
	
	
	//我处理的留言
	@RequestMapping("/liuyanlist2.do")
	public String liuyanlist2(HttpServletRequest request,String pagenum,String ltitle ){
		
		HttpSession session = request.getSession();
		
		Admin user = (Admin)session.getAttribute("manage");

		//查询条件返回页面
		if (ltitle != null && !"".equals(ltitle)) {

			request.setAttribute("ltitle", ltitle);
		}


		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Liuyan> list = liuyanService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, ltitle,null,0,user.getId());
		

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = liuyanService.selectBeanCount(ltitle,null,0,user.getId());

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "liuyanlist2.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "liuyanlist2.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "liuyan");

		request.setAttribute("title", "我处理的留言");

		return "liuyan/liuyanlist2";

	}
	
	
	//跳转到查看留言详情页面
	@RequestMapping("/liuyanupdate3.do")
	public String liuyanupdate3(HttpServletRequest request,int id) throws ParseException{

		Liuyan bean = liuyanService.selectBeanById(id);


		request.setAttribute("bean", bean);
		request.setAttribute("title", "查看留言详情");
		

		return "liuyan/liuyanupdate3";

	}
	
	
	//客户信息查询
	@RequestMapping("/userlist2.do")
	public String userlist2(HttpServletRequest request,String pagenum,String username){
		

		//查询条件返回页面
		if (username != null && !"".equals(username)) {

			request.setAttribute("username", username);
		}


		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Admin> list = userService.selectBeanList2((currentpage - 1)
				* pageSize, pageSize, username);
		

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = userService.selectBeanCount2(username);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "userlist2.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "userlist2.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "user");

		request.setAttribute("title", "客户信息查询");

		return "user/userlist2";

	}
	
	
	//VIP客户信息查询
		@RequestMapping("/userlist3.do")
		public String userlist3(HttpServletRequest request,String pagenum,String username,String vipstatus){
			

			//查询条件返回页面
			if (username != null && !"".equals(username)) {

				request.setAttribute("username", username);
			}


			//分页功能默认第一页
			int currentpage = 1;
			//获取当前页
			if (pagenum != null) {
				currentpage = Integer.parseInt(pagenum);
			}

			//查询列表
			List<Vip> list = userService.selectBeanList3((currentpage - 1)
					* pageSize, pageSize, username);
			

			//列表返回页面
			request.setAttribute("list", list);

			//获取总数量
			int total = userService.selectBeanCount3(username);

			//分页信息返回页面
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
					currentpage, "userlist3.do", "共有" + total + "条记录"));

			//查询按钮
			request.setAttribute("url", "userlist3.do");

			//添加，更新，删除等按钮
			request.setAttribute("url3", "user");

			request.setAttribute("title", "VIP客户信息查询");

			return "user/userlist3";

		}
		//VIP客户信息查询
		@RequestMapping("/userlist4.do")
		public String userlist4(HttpServletRequest request,String pagenum,String username){
			

			//查询条件返回页面
			if (username != null && !"".equals(username)) {

				request.setAttribute("username", username);
			}


			//分页功能默认第一页
			int currentpage = 1;
			//获取当前页
			if (pagenum != null) {
				currentpage = Integer.parseInt(pagenum);
			}

			//查询列表
			List<Admin> list = userService.selectBeanList4((currentpage - 1)
					* pageSize, pageSize, username);
			

			//列表返回页面
			request.setAttribute("list", list);

			//获取总数量
			int total = userService.selectBeanCount4(username);

			//分页信息返回页面
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
					currentpage, "userlist4.do", "共有" + total + "条记录"));

			//查询按钮
			request.setAttribute("url", "userlist4.do");

			//添加，更新，删除等按钮
			request.setAttribute("url4", "user");

			request.setAttribute("title", "普通客户信息查询");

			return "user/userlist4";

		}
	
	
	
	//日收入统计
	@RequestMapping("/rilist.do")
	public String rilist(HttpServletRequest request,String pagenum,String ri){
		
		List<Ri> rilist = riService.selectBeanList(0, 9999, null);
		
		for(Ri bean:rilist){
			riService.deleteBean(bean.getId());
		}
		
		List<Jilu> jilulist = jiluService.selectBeanList(0, 9999, null, null, null, "完成结算", 0, 0, 0);
		
		for(Jilu jilu:jilulist){
			
			String riqi = jilu.getShijian1().substring(0, 11);
			
			List<Ri> rilist2 = riService.selectBeanList(0, 1, riqi);
			
			if(rilist2.size()<=0){
				Ri bean = new Ri();
				
				bean.setRi(riqi);
				
				bean.setJine(jilu.getTzujin());
				bean.setWeihu(jilu.getWeixiu());
				
				riService.insertBean(bean);
				
			}else{
				Ri bean = rilist2.get(0);
				
				bean.setJine(bean.getJine()+jilu.getTzujin());
				bean.setWeihu(bean.getWeihu()+jilu.getWeixiu());
				
				riService.updateBean(bean);
			}
			
			
			
		}
		
		
		

		//查询条件返回页面
		if (ri != null && !"".equals(ri)) {

			request.setAttribute("ri", ri);
		}


		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Ri> list = riService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, ri);
		

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = riService.selectBeanCount(ri);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "rilist.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "rilist.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "ri");

		request.setAttribute("title", "日收入统计");

		return "ri/rilist";

	}
	
	
	//月收入统计
	@RequestMapping("/yuelist.do")
	public String yuelist(HttpServletRequest request,String pagenum,String month){
		
		List<Yue> yuelist = yueService.selectBeanList(0, 9999, null);
		
		for(Yue bean:yuelist){
			yueService.deleteBean(bean.getId());
		}
		
		List<Jilu> jilulist = jiluService.selectBeanList(0, 9999, null, null, null, "完成结算", 0, 0, 0);
		
		for(Jilu jilu:jilulist){
			
			String mon = jilu.getShijian1().substring(0, 7);
			
			List<Yue> yuelist2 = yueService.selectBeanList(0, 1, mon);
			
			if(yuelist2.size()<=0){
				Yue bean = new Yue();
				
				bean.setMonth(mon);
				
				bean.setJine(jilu.getTzujin());
				bean.setWeihu(jilu.getWeixiu());
				
				yueService.insertBean(bean);
				
			}else{
				Yue bean = yuelist2.get(0);
				
				bean.setJine(bean.getJine()+jilu.getTzujin());
				bean.setWeihu(bean.getWeihu()+jilu.getWeixiu());
				
				yueService.updateBean(bean);
			}

		}
		
		//查询条件返回页面
		if (month != null && !"".equals(month)) {

			request.setAttribute("month", month);
		}


		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<Yue> list = yueService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, month);
		

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = yueService.selectBeanCount(month);

		//分页信息返回页面
		request.setAttribute("pageyuenfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "yuelist.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "yuelist.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "yue");

		request.setAttribute("title", "日收入统计");

		return "yue/yuelist";

	}
	
	
	//车辆收入统计
	@RequestMapping("/carlist4.do")
	public String carlist4(HttpServletRequest request,String pagenum,String chepai,String pinpai,String xinghao,String yanse){

		//查询条件返回页面
		if (chepai != null && !"".equals(chepai)) {

			request.setAttribute("chepai", chepai);
		}
		if (pinpai != null && !"".equals(pinpai)) {

			request.setAttribute("pinpai", pinpai);
		}
		if (xinghao != null && !"".equals(xinghao)) {

			request.setAttribute("xinghao", xinghao);
		}
		if (yanse != null && !"".equals(yanse)) {

			request.setAttribute("yanse", yanse);
		}

		//分页功能默认第一页
		int currentpage = 1;
		//获取当前页
		if (pagenum != null) {
			currentpage = Integer.parseInt(pagenum);
		}

		//查询列表
		List<CarState> list = carService.selectBeanList((currentpage - 1)
				* pageSize, pageSize, chepai,pinpai,xinghao,yanse);

		//列表返回页面
		request.setAttribute("list", list);

		//获取总数量
		int total = carService.selectBeanCount(chepai,pinpai,xinghao,yanse);

		//分页信息返回页面
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pageSize,
				currentpage, "carlist4.do", "共有" + total + "条记录"));

		//查询按钮
		request.setAttribute("url", "carlist4.do");

		//添加，更新，删除等按钮
		request.setAttribute("url2", "car");

		request.setAttribute("title", "车辆收入统计");

		return "car/carlist4";

	}
	
	
	//跳转到购买/续费会员支付详情页面
	@RequestMapping("/vipcharge.do")
	public String vipcharge(HttpServletRequest request,String  username) throws ParseException{

		Vip bean = vipService.selectBeanByUsername(username);
		if(null==bean) {
			Vip bean1=new Vip();
			bean1.setUsername(username);
			Admin user=userService.selectBeanByUsername(username);
			if(null!=user) {
				bean1.setKehuid(user.getId());
			}
			bean1.setLevel(0);
			bean1.setPoints(0);
			request.setAttribute("bean", bean1);
			request.setAttribute("title", "会员充值/续费");
			return "vip/vipcharge";
		}else {			
			String enddate=bean.getEnddate().split(" ")[0];
			bean.setEnddate(enddate);
			request.setAttribute("bean", bean);
			request.setAttribute("title", "会员充值/续费");
			return "vip/vipcharge";
		}

	}
	
	
	//支付状态页面
	@RequestMapping("/vipcharge2.do")
	public void vipcharge2(HttpServletRequest request,HttpServletResponse response,String  username,int month,int points,int kehuid) throws ParseException{
		PrintWriter writer = this.getPrintWriter(response);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
		Calendar rightNow = Calendar.getInstance();
		String now=sdf.format(new Date());
		points += month*1000;
		Double consumed=0.0d;
		switch(month){
		case 12:
			consumed+=20*month*0.9;
			break;
		case 6:
			consumed+=20*month*0.95;
			break;
		default:
			consumed+=20*month;
			break;
		}
		

		Vip bean = vipService.selectBeanByUsername(username);
		
		if(bean!=null){//老vip客户
			bean.setPoints(points);
			consumed+=bean.getConsumed();
			int level=1+(int)Math.round(consumed)/1000;//等级根据消费金额确定，消费1000为1级
			bean.setConsumed(consumed);
			bean.setLevel(level);
			
			String enddate=bean.getEnddate().split(" ")[0];
			//会员未过期
			if(enddate.compareTo(now)>0){
				Date ed=sdf.parse(enddate);
				rightNow.setTime(ed);
				rightNow.add(Calendar.MONTH,month);//日期加*个月
				String newEndDate=sdf.format(rightNow.getTime());
				bean.setEnddate(newEndDate);

			}else{//已过期
				Calendar nowCal = Calendar.getInstance();
				nowCal.add(Calendar.MONTH,month);//日期加*个月
				String newEndDate=sdf.format(nowCal.getTime());
				//System.out.print(newEndDate+"newEndDate"+"p:"+points+"l:"+level);
				bean.setEnddate(newEndDate);
			}
			vipService.updateBean(bean);	
			
			
		}else{//新vip客户
			Vip bean1=new Vip();
			bean1.setUsername(username);
			bean1.setKehuid(kehuid);
			bean1.setPoints(points);
			bean1.setConsumed(consumed);
			int level=1+(int)Math.round(consumed)/1000;//等级根据消费金额确定，消费1000为1级
			bean1.setLevel(level);
			Calendar nowCal = Calendar.getInstance();
			nowCal.add(Calendar.MONTH,month);//日期加*个月
			String newEndDate=sdf.format(nowCal.getTime());

			bean1.setEnddate(newEndDate);
			vipService.insertBean(bean1);
		}
				
		request.setAttribute("bean", bean);
		request.setAttribute("title", "会员充值/续费页");
		
		writer.print("<script language=javascript>alert('充值成功');window.location.href='vipcharge.do?username="+username+"';</script>");
		//return "vip/vipcharge";

	}
	
}