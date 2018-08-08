package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import org.apache.log4j.Logger;

import model.Employee;
import model.Request;
import dbms.JDBMSConnection;
import exception.UniqueEmailException;

import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDao {

	private static EmployeeDaoImpl employeeDao;

	private EmployeeDaoImpl() {

	}

	public static EmployeeDaoImpl makeDao() {
		if (employeeDao == null) {
			return new EmployeeDaoImpl();
		}
		return null;
	}

	@Override
	public Employee getEmployee(int e_id) {

		if (e_id == -1) {
			System.out.println("This Employee does not exist.");
			return null;
		}

		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT * FROM employees WHERE e_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Employee(rs.getInt("e_id"), rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("email"), rs.getString("password"), rs.getInt("is_manager"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT * FROM employees ORDER BY e_id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Employee> employees = new ArrayList<Employee>();
			Employee temp;
			while (rs.next()) {
				temp = new Employee(rs.getInt("e_id"), rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("email"), rs.getString("password"), rs.getInt("is_manager"));
				System.out.println(temp);
				employees.add(temp);
				System.out.println();
			}

			return employees;

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
		}
		return null;
	}

//	@Override
//	public ArrayList<Employee> getAllManagers() {
//		try {
//			Connection conn = JDBMSConnection.getConnection();
//			String sql = "SELECT * FROM employees ORDER BY e_id desc";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			ArrayList<Employee> managers = new ArrayList<Employee>();
//
//			while (rs.next()) {
//				if (rs.getInt("is_manager") == 1) {
//					managers.add(new Employee(rs.getInt("e_id"), rs.getString("firstname"), rs.getString("lastname"),
//							rs.getString("email"), rs.getString("password"), rs.getInt("is_manager")));
//				}
//			}
//
//			return managers;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			log(e);
//		}
//		return null;
//	}

	@Override
	public Employee getManagerWhoResolved(int r_id) {
		try {
			int e_id = 0;
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT resolved_by FROM requests WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e_id = rs.getInt("resolved_by");
			}
			return getEmployee(e_id);

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
		}

		return null;
	}

	@Override
	public Employee getEmployeeWhoRequested(int r_id) {
		try {
			int e_id = 0;
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT e_id FROM requests WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e_id = rs.getInt("e_id");
			}
			return getEmployee(e_id);

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
		} catch (Exception e) {
			e.printStackTrace();
			log(e);
		}

		return null;
	}

	@Override
	public String getEmail(int e_id) {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT email FROM employees WHERE e_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getString("email");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
		}

		return null;
	}

	@Override
	public ArrayList<Request> getAllPending() {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT * FROM requests WHERE outcome is null ORDER BY r_id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Request> requests = new ArrayList<Request>();

			while (rs.next()) {
				requests.add(new Request( rs.getInt("e_id"), rs.getInt("r_id"), rs.getDouble("amount"),
						rs.getString("request_body"), rs.getInt("resolved_by"), rs.getInt("outcome")));
			}

			return requests;

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
		}
		return null;
	}

	@Override
	public ArrayList<Request> getAllPending(int e_id) {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT * FROM pending_requests WHERE outcome = 0 ORDER BY r_id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Request> requests = new ArrayList<Request>();

			while (rs.next()) {
				if (rs.getInt("e_id") == e_id) {
					requests.add(new Request(rs.getInt("r_id"), rs.getInt("e_id"), rs.getDouble("amount"),
							rs.getString("request_body"), rs.getInt("resolved_by"), rs.getInt("outcome")));
				}
			}

			return requests;

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
		}
		return null;
	}

	@Override
	public ArrayList<Request> getAllResolved() {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT * FROM requests WHERE outcome != 0 ORDER BY r_id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Request> requests = new ArrayList<Request>();

			while (rs.next()) {
				requests.add(new Request(rs.getInt("r_id"), rs.getInt("e_id"), rs.getDouble("amount"),
						rs.getString("request_body"), rs.getInt("resolved_by"), rs.getInt("outcome")));

			}

			return requests;

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
		}
		return null;
	}

	@Override
	public ArrayList<Request> getAllResolved(int e_id) {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT * FROM requests WHERE outcome != 0 ORDER BY r_id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Request> requests = new ArrayList<Request>();

			while (rs.next()) {
				if (rs.getInt("e_id") == e_id) {
					requests.add(new Request(rs.getInt("r_id"), rs.getInt("e_id"), rs.getDouble("amount"),
							rs.getString("request_body"), rs.getInt("resolved_by"), rs.getInt("outcome")));

				}
			}

			return requests;

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
		}
		return null;
	}

	public ArrayList<Request> getAllRequests() {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT * FROM requests ORDER BY r_id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Request> requests = new ArrayList<Request>();

			while (rs.next()) {
				requests.add(new Request(rs.getInt("e_id"), rs.getInt("r_id"), rs.getDouble("amount"),
						rs.getString("request_body"), rs.getInt("resolved_by"), rs.getInt("outcome")));
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
		}
		return null;
	}

	@Override
	public ArrayList<Request> getAllRequests(int e_id) {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT * FROM requests WHERE e_id = ? ORDER BY r_id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e_id);
			ResultSet rs = ps.executeQuery();
			ArrayList<Request> requests = new ArrayList<Request>();

			while (rs.next()) {
				if (rs.getInt("e_id") == e_id) {
					requests.add(new Request(rs.getInt("e_id"), rs.getInt("r_id"), rs.getDouble("amount"),
							rs.getString("request_body"), rs.getInt("resolved_by"), rs.getInt("outcome")));
				}
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
		}
		return null;
	}

	@Override
	public boolean makeRequest(int e_id, double amount, String body) {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "call make_request (?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setInt(1, e_id);
			cs.setDouble(2, amount);
			cs.setString(3, body);
			cs.executeQuery();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
			System.out.println("Request did not include body, Or SQL Constraint Violation");
		}
		return false;
	}

	public boolean approveRequest(int r_id, int e_id) {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "call approve_request (?, ?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setInt(1, r_id);
			cs.setInt(2, e_id);
			cs.executeQuery();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
			System.out.println("Please make sure your request includes a body!");
		}
		return false;
	}

	public boolean denyRequest(int r_id, int e_id) {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "call deny_request (?, ?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setInt(1, r_id);
			cs.setInt(2, e_id);
			cs.executeQuery();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			log(e);
			System.out.println("Please make sure your request includes a body!");
		}
		return false;
	}

	@Override
	public int getRequestID(Request request) {

		return request.getR_id();
	}

	@Override
	public int getEmployeeIDByEmail(String email) {

		try {

			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT e_id FROM employees WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt("e_id");
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("CONNECTION DID NOT INITIALIZE");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	@Override
	public boolean registerNewEmployee(String firstname, String lastname, String email, String password)
			throws UniqueEmailException {
		try {

			Connection conn = JDBMSConnection.getConnection();
			System.out.println("Connection: " + conn);
			String sql = "call register_employee (?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setString(1, firstname);
			cs.setString(2, lastname);
			cs.setString(3, email);
			cs.setString(4, password);
			cs.executeQuery();
			System.out.println("Employee created: " + email);

			return true;

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("This email is already in use.");
			log(e);
			throw new UniqueEmailException("This email is already in use");
		} catch (SQLException e) {
			System.out.println("Please make sure you entered a valid firstname, lastname, email, and password");
			log(e);
		}
		return false;
	}

	@Override
	public boolean updateEmployee(int e_id, String firstname, String lastname, String email, String password,
			int isManager) {

		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "UPDATE employees SET firstname = ?, lastname = ?, email = ?, password = ?, is_manager = ? WHERE e_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setInt(5, isManager);
			ps.setInt(6, e_id);
			ps.executeQuery();
			System.out.println("Successfully updated employee.");
			return true;

		} catch (SQLException e) {
			System.out.println("Something went wrong while updating this employee.");
			e.printStackTrace();
			log(e);
			return false;
		}

	}

	@Override
	public boolean setManager(int e_id) {

		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "UPDATE employees SET is_manager = 1 WHERE e_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e_id);
			ps.executeQuery();
			System.out.println("Successfully promoted employee.");
			return true;

		} catch (SQLException e) {
			System.out.println("Something went wrong while promoting this employee.");
			e.printStackTrace();
			log(e);
			return false;
		}
	}

	@Override
	public boolean demote(int e_id) {

		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "UPDATE employees SET is_manager = 0 WHERE e_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e_id);
			ps.executeQuery();
			System.out.println("Successfully demoted employee.");
			return true;

		} catch (SQLException e) {
			System.out.println("Something went wrong while demoting this employee.");
			e.printStackTrace();
			log(e);
			return false;
		}
	}

	@Override
	public boolean authenticate(String email, String password) {
		try {
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT * FROM employees WHERE email = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("EmpoloyeeDaoImpl.authenticate failed.");
			log(e);
		}
		return false;
	}

	public boolean authenticateManager(String email, String password) {
		try {
			int isManager = 1;
			Connection conn = JDBMSConnection.getConnection();
			String sql = "SELECT * FROM employees WHERE email = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			System.out.println("manager is : " + rs.toString());
/////////////////////////////////////////////////////////////////////////////////
			while (rs.next()) {
				isManager = rs.getInt("is_manager");
				System.out.println(isManager);
				System.out.println("");
			}

			if (isManager == 1) {
				return true;
			}
			return false;
/////////////////////////////
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception in EmployeeDaoImpl.authenticateManager");
			log(e);
		}
		return false;
	}

	@Override
	public boolean login(String email, String password) {

		if (authenticate(email, password)) {
			return true;
		}

		return false;
	}

	@Override
	public void log(Throwable e) {
		final Logger log = Logger.getLogger(EmployeeDaoImpl.class);
		log.error(e);
	}

	////////////////////////////////////////////
	///// Included from example ///////////

	public String getEmployeeHash(Employee employee) {
		try (Connection connection = JDBMSConnection.getConnection()) {
			int statementIndex = 0;
			String command = "SELECT GET_CUSTOMER_HASH(?,?) AS HASH FROM DUAL";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getEmail());
			statement.setString(++statementIndex, employee.getPassword());
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				return result.getString("HASH");
			}

		} catch (SQLException e) {
			log(e);
		}
		return new String();
	}

	@Override
	public int getRequestingEmployee(Request request) {
		// TODO Auto-generated method stub
		return 0;
	}

}
