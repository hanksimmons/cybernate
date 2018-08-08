package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.StringUtil;

import exception.UniqueEmailException;
import service.ManagerService;

public class RegistrationController {

	public static String registerEmployee(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("registration from RegistrationController");

		// If it's a GET we just return the view.
		if (request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "/managerHome.jsp";
		}

		String firstname = (String) request.getParameter("firstname");
		String lastname = (String) request.getParameter("lastname");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");

		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(email);
		System.out.println(password);
		
		System.out.println("Registering New Employee from RegistrationController");
		try {
			ManagerService.getService().registerNewEmployee(firstname, lastname, email, password);
		} catch (UniqueEmailException e) {
			// TODO Auto-generated catch block
			return "Email already in use. Please try again.";
		}
		
		// Forward user to hit another controller
		return "Employee Registered.";
	}
}
