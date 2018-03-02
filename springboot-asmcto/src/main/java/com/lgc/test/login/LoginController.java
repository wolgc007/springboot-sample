package com.lgc.test.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
	static Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login/entry")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		return String.format("login sucess : name(%s) password(%s)", username, password);
	}

	@RequestMapping(value = "/logout")
	@ResponseBody
	public String logout(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/* 清除用户数据 */
		HttpSession session = request.getSession();
		session.setAttribute("userSn", null);
		session.setAttribute("userId", null);
		session.setAttribute("userPojo", null);
		return "success";
	}
	
    @RequestMapping("/test")
    @ResponseBody
    public String sayHello() {
        return "Hello,World!";
    }
}