package service;

import dao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeService {
	
	private static EmployeeService employeeService;

	private EmployeeService() {

	}

	public static EmployeeService getEmployeeService() {
		if (employeeService == null) {
			return new EmployeeService();
		}
		return null;
	}

	public static boolean makeNewRequest(int e_id, double amount, String body) {
		return EmployeeDaoImpl.makeDao().makeRequest(e_id, amount, body);
	}
	
	public static boolean authenticate(String email, String password) {
		return EmployeeDaoImpl.makeDao().authenticate(email, password);
	}
	
	public static boolean login(String email, String password) {
		return EmployeeDaoImpl.makeDao().login(email, password);
		
	}
		
	public static Employee getEmployee(String email, String password) {
		return EmployeeDaoImpl.makeDao().getEmployee(EmployeeDaoImpl.makeDao().getEmployeeIDByEmail(email));
	}
		
	
}
