package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.LoginManagerController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/ERS/login.do":
			return LoginController.login(request);
		case "/ERS/logout.do":
			return LoginController.logout(request);
		case "/ERS/loginmanager.do":
			return LoginManagerController.login(request);
		case "/ERS/employeeHome.do":
			return HomeController.employeeHome(request);
		case "/ERS/managerHome.do":
			return HomeController.managerHome(request);
		default:
			return "404.jsp";
		}
	}
}
