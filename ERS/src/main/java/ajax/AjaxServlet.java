package ajax;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Enumeration<String> headers = request.getHeaderNames();
		
		while(headers.hasMoreElements()) {
			System.out.println("Header: " + headers.nextElement());
		}
		System.out.println(headers.toString());
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax doPost");
		doGet(request, response);
	}
	
	

}
