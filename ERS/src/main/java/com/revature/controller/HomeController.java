package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HomeController {
	
	public static String employeeHome(HttpServletRequest request) {
		HttpSession employeeSession = request.getSession();
		System.out.println(employeeSession.getAttribute("email"));
		
		return "employeeHome.jsp";
	}
	public static String managerHome(HttpServletRequest request) {
		return "managerHome.jsp";
	}
	
}
