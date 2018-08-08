package dao;

import java.util.ArrayList;

import exception.UniqueEmailException;
import model.Employee;
import model.Request;

public interface EmployeeDao {

	Employee getEmployee(int e_id);
	
	ArrayList<Employee> getAllEmployees();
		
	Employee getManagerWhoResolved(int r_id);
	
	Employee getEmployeeWhoRequested(int r_id);
	
	String getEmail(int e_id);
	
	ArrayList<Request> getAllRequests();
	
	ArrayList<Request> getAllRequests(int e_id);

	ArrayList<Request> getAllPending();
	
	ArrayList<Request> getAllPending(int e_id);
	
	ArrayList<Request> getAllResolved();
	
	ArrayList<Request> getAllResolved(int e_id);
	
	boolean makeRequest(int e_id, double amount, String body);
	
	int getRequestID(Request request);
	
	int getRequestingEmployee(Request request);
		
	int getEmployeeIDByEmail(String email);
	
	boolean registerNewEmployee(String firstname, String lastname, String email, String password) throws UniqueEmailException;
	
	boolean updateEmployee(int e_id, String firstname, String lastname, String email, String password, int isManager);
	
	boolean setManager(int e_id);
	
	boolean demote(int e_id);
	
	boolean authenticate(String email, String password);
	
	boolean login(String email, String password);
	
	void log(Throwable e);






	
}
