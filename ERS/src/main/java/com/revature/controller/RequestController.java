package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.StringUtil;

import model.Employee;
import service.ManagerService;

public class RequestController {

	
	//////////////////////////////////////////////////////////////////////////////////
	
	
	public static String makeRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("making a request from RequestController:");

		// If it's a GET we just return the view.
		if (request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "/managerHome.jsp";
		}
		
		int e_id = (int) request.getSession().getAttribute("e_id");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String body = request.getParameter("body");

		System.out.println("making request for amount: " + amount + " for " + body + " e_id " + e_id);
		ManagerService.getService().makeNewRequest(e_id, amount, body);
		return "Request is now pending";
	}
	
	public static String viewAllRequests(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("viewing all requests from RequestController");

		// If it's a GET we just return the view.
		if (request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "/managerHome.jsp";
		}
		
		return ManagerService.getService().getAllRequests().toString();
	}
	
	public static String viewEmployeeRequests(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("viewing employee requests from RequestController");
		int e_id = (int) request.getSession().getAttribute("e_id");


		// If it's a GET we just return the view.
		if (request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "/managerHome.jsp";
		}
		
		return ManagerService.getService().getAllRequests(e_id).toString();
	}
	
	public static String viewPendingRequests(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("viewing pending requests from RequestController");

		// If it's a GET we just return the view.
		if (request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "/managerHome.jsp";
		}
		
		return ManagerService.getService().getPendingRequests().toString();
	}
	
	public static String viewResolvedRequests(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("viewing resolved requests from RequestController");

		// If it's a GET we just return the view.
		if (request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "/managerHome.jsp";
		}
		
		return ManagerService.getService().getResolvedRequests().toString();
	}

	public static String approveRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("approving a request from RequestController:");

		// If it's a GET we just return the view.
		if (request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "/managerHome.jsp";
		}
		
		int e_id = (int) request.getSession().getAttribute("e_id");
		int r_id = Integer.parseInt(request.getParameter("r_id"));

		System.out.println("Approving request: e_id =" + e_id + ", r_id =" + r_id);
		ManagerService.getService().approveRequest(r_id, e_id);
		return "Request is approved.";
	}
	
	public static String denyRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("denying a request from RequestController:");

		// If it's a GET we just return the view.
		if (request.getMethod().equals(StringUtil.HTTP_GET)) {
			return "/managerHome.jsp";
		}
		
		int e_id = (int) request.getSession().getAttribute("e_id");
		int r_id = Integer.parseInt(request.getParameter("r_id"));

		System.out.println("Denying request: e_id =" + e_id + ", r_id =" + r_id);
		ManagerService.getService().denyRequest(r_id, e_id);
		return "Request is denied.";
	}


	
	
}
