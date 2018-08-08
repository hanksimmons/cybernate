package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.revature.ajax.AjaxMessage;
import com.revature.util.StringUtil;

import service.EmployeeService;

/* AJAX controller that checks if specific username is taken */
public class AuthenticationController {
	
	public static Object checkUsername(HttpServletRequest request, HttpServletResponse response) {
		
		if(EmployeeService.authenticate(request.getParameter("email"), request.getParameter("password"))) {
				
			return new AjaxMessage(StringUtil.USERNAME_TAKEN);
		}
		else {
			return new AjaxMessage(StringUtil.USERNAME_AVAILABLE);
		}
	}
}
