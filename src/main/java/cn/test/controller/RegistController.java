package cn.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.test.entity.Login;
import cn.test.service.LoginService;

@Controller
public class RegistController {
	@Resource
	private LoginService loginService;
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ModelAndView UserRegister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new Login());
		mv.setViewName("register");
		return mv;
	}

	@RequestMapping("/verify")
	public ModelAndView processUser(HttpServletRequest request, HttpServletResponse response, @Valid Login user,
			BindingResult result) throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		if (result.hasErrors()) {
//			表单验证有误
			mv.setViewName("register");
		} else {
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (this.loginService.checkUser(username) != null) {
//				用户名存在
				out.println("<script language='javascript'>");
				out.println("alert('用户名存在,请重新注册')");
				out.println("</script>");
				out.flush();
				mv = new ModelAndView("forward:/register");
			} else {
//				注册成功
				Login newUser = new Login(username, email, password);
				this.loginService.insertNewUser(newUser);
				mv.setViewName("register_success");
			}
		}
		return mv;
	}

}