package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.AuthenticationController;
import com.revature.controller.RegistrationController;
import com.revature.controller.RequestController;
import com.revature.controller.ViewEmployeeController;

/* Request helper specifically for AJAX requests */
public class RequestHelper {
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ERS/ViewPendingRequests.ajax": //TODO
			return RequestController.viewPendingRequests(request, response);
		case "/ERS/ViewResolvedRequests.ajax": //TODO
			return RequestController.viewResolvedRequests(request, response);
		case "/ERS/ViewAllRequests.ajax": //TODO
			return RequestController.viewAllRequests(request, response);
		case "/ERS/GetEmployee.ajax":
			return ViewEmployeeController.viewEmployee(request, response);
		case "/ERS/makeRequest.ajax":
			return RequestController.makeRequest(request, response);
		case "/ERS/approveRequest.ajax":
			return RequestController.approveRequest(request, response);
		case "/ERS/denyRequest.ajax":
			return RequestController.denyRequest(request, response);
		case "/ERS/viewAllEmployees.ajax":
			return ViewEmployeeController.viewAllEmployees(request, response);
		case "/ERS/registerEmployee.ajax":
			return RegistrationController.registerEmployee(request, response);
		case "/ERS/ViewEmployeeRequests.ajax":
			return RequestController.viewEmployeeRequests(request, response);
		default:
			return new AjaxMessage("NOT IMPLEMENTED");
		}
	}
}
