package cn.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.test.entity.Login;
import cn.test.service.LoginService;

@Controller
public class LoginController {
	@Resource
	private LoginService loginService;
	@RequestMapping(value = "/login")
	public ModelAndView UserLogin(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ModelAndView mv = new ModelAndView();
		String username = String.valueOf(request.getParameter("username"));
		String password = String.valueOf(request.getParameter("password"));
		Login user = this.loginService.checkUser(username);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (user == null) {
			// 该用户不存在
			request.setAttribute("username", username);
			out.println("<script language='javascript'>");
			out.println("alert('该用户不存在！')");
			out.println("</script>");
			out.flush();
			mv.setViewName("login");
		} else if (user.getPassword().equals(password)) {
			// 该用户存在且用户名和密码匹配
			mv.setViewName("redirect:/index");
		} else {
			// 用户名或密码错误
			request.setAttribute("username", username);
			out.println("<script language='javascript'>");
			out.println("alert('用户名或密码不正确！')");
			out.println("</script>");
			out.flush();
			mv.setViewName("login");
		}
		return mv;
	}

}