package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.util.StringUtil;

import model.Employee;
import service.EmployeeService;

public class LoginManagerController {
	
	public static String login(HttpServletRequest request) {
		System.out.println("login from LoginController");
		
		//If it's a GET we just return the view.
		if(request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "login.jsp";
		}

		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		
		//POST logic
		// Wrong Credentials
		if(EmployeeService.authenticate(email, password) == false) {
			System.out.println("These credentials are invalid (LoginController.login)");
			return "index.jsp";
		}
		
		else {
			Employee loggedCustomer = EmployeeService.getEmployeeService().getEmployee(email, password);

			HttpSession oldSession = request.getSession(false);
			
			if(oldSession != null) {
				oldSession.invalidate();
			}
			
			HttpSession newSession = request.getSession(true);
			
			/* Storing loggedCustomer to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			newSession.setAttribute("e_id", loggedCustomer.getE_id());
			newSession.setAttribute("firstname", loggedCustomer.getFirstname());
			newSession.setAttribute("lastname", loggedCustomer.getLastname());
			newSession.setAttribute("email", loggedCustomer.getEmail());
			newSession.setAttribute("password", loggedCustomer.getPassword());
			newSession.setAttribute("isManager", loggedCustomer.getIs_manager());

			
			//Forward user to hit another controller
			return "/managerHome.do";
		}
	}
		
		String logout(HttpServletRequest request1) {
			System.out.println("logging out from LoginManagerController");

			return "index.jsp";
		}
	
}
