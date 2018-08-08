package service;


public class TestService {
	public static void main(String[] args) {
		System.out.println(ManagerService.getAllEmployees());
		//System.out.println(EmployeeDaoImpl.makeDao().getEmployee(EmployeeDaoImpl.makeDao().getEmployeeIDByEmail("bieber@gmail.com")));
		System.out.println(EmployeeService.getEmployeeService().getEmployee("bieber@gmail.com", "p4ssw0rd"));
	}
}
