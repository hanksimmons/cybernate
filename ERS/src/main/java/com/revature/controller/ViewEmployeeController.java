package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ajax.AjaxMessage;
import com.revature.util.StringUtil;

import model.Employee;
import service.ManagerService;

public class ViewEmployeeController {

	public static String viewEmployee(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("viewing employee from employeecontroller");

		// If it's a GET we just return the view.
		if (request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "/managerHome.jsp";
		}

		int e_id = (int) request.getSession().getAttribute("e_id");
		String email = (String) request.getSession().getAttribute("email");
		String password = (String) request.getSession().getAttribute("password");
		String firstname = (String) request.getSession().getAttribute("email");
		String lastname = (String) request.getSession().getAttribute("password");
	//	int isManager = (int) request.getSession().getAttribute("is_manager");

		Employee loggedCustomer = ManagerService.getService().getEmployee(email, password);
		System.out.println("session as :" + email + " , " + password);
		// POST logic
		
		/*
		 * Storing loggedCustomer to current session SESSION SCOPE IS AVAILABLE ONLY IN
		 * THIS REQUEST (CLIENT)
		 */
		System.out.println("returning ajax message - viewEmployee");
		// Forward user to hit another controller
				
		return loggedCustomer.toString();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	
	
	public static String viewAllEmployees(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("viewing all employees from employeecontroller");

		// If it's a GET we just return the view.
		if (request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "/managerHome.jsp";
		}


		return ManagerService.getAllEmployees().toString();
	}
}
