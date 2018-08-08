package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class GetEmployee
 */
public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee employee;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Spoof an employee and return DOM component to managerhome.js
    	employee = new Employee(0, "Henry", "Simon", "h.simon93@gmail.com", "p4ssw0rd", 0);
    	System.out.println(employee.toString());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + employee.toString() + "</h1>");
		System.out.println(response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
