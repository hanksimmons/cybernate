package service;

import java.util.ArrayList;

import dao.EmployeeDaoImpl;
import exception.UniqueEmailException;
import model.Employee;
import model.Request;

public class ManagerService {
	

	private static ManagerService service;

	private ManagerService() {

	}

	public static ManagerService getService() {
		if (service == null) {
			return new ManagerService();
		}
		return null;
	}

	public ArrayList<Request> getAllRequests() {
		return EmployeeDaoImpl.makeDao().getAllRequests();
	}
	
	public ArrayList<Request> getAllRequests(int e_id) {
		return EmployeeDaoImpl.makeDao().getAllRequests(e_id);
	}
	
	public ArrayList<Request> getPendingRequests() {
		return EmployeeDaoImpl.makeDao().getAllPending();
	}
	
	public ArrayList<Request> getResolvedRequests() {
		return EmployeeDaoImpl.makeDao().getAllResolved();
	}
	
	public boolean registerNewEmployee(String firstname, String lastname, String email, String password) throws UniqueEmailException {
		return EmployeeDaoImpl.makeDao().registerNewEmployee(firstname, lastname, email, password);
	}
	
	public boolean makeNewRequest(int e_id, double amount, String body) {
		return EmployeeDaoImpl.makeDao().makeRequest(e_id, amount, body);
	}
	
	public boolean approveRequest(int r_id, int e_id) {
		return EmployeeDaoImpl.makeDao().approveRequest(r_id, e_id);
	}
	
	public boolean denyRequest(int r_id, int e_id) {
		return EmployeeDaoImpl.makeDao().denyRequest(r_id, e_id);
	}
	
	public static ArrayList<Employee> getAllEmployees() {
		return EmployeeDaoImpl.makeDao().getAllEmployees();
	}
	
	public static boolean authenticateManager(String email, String password) {
		return EmployeeDaoImpl.makeDao().authenticateManager(email, password);
	}
	
	public static Employee getEmployee(String email, String password) {
		return EmployeeDaoImpl.makeDao().getEmployee(EmployeeDaoImpl.makeDao().getEmployeeIDByEmail(email));
	}


	
}
