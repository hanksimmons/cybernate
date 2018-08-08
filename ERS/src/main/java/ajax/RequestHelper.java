package ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.AuthenticationController;

/* Request helper specifically for AJAX requests */
public class RequestHelper {
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/FrontController/checkUsername.ajax":
			return AuthenticationController.checkUsername(request, response);
		default:
			return new AjaxMessage("NOT IMPLEMENTED");
		}
	}
}
