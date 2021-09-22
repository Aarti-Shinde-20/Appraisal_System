package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.configuration.DBConnect;
import com.model.Employee;
import com.model.Role;
import com.mysql.cj.protocol.Resultset;

public  class EmpDaoImplement implements EmpDao {
	public boolean addEmployee(Employee e) {
		try (Connection connection = DBConnect.getConnection();
			PreparedStatement pst = connection.prepareStatement("insert into employee values(?,?,?,?)")) {
			pst.setInt(1, e.getEmpid());
			pst.setString(2, e.getEmpname());
			pst.executeUpdate();
			return true;
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return false;
	}

	public boolean deleteEmployee(int id) {
		try (Connection connection = DBConnect.getConnection();
			PreparedStatement pst = connection.prepareStatement("delete from employee where empid=?")) {
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return false;
	}

	public boolean updateEmployee(Employee e) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("update employee set empname=? where empid=?")) {
			pst.setString(1, e.getEmpname());
			pst.setInt(2, e.getEmpid());
			pst.execute();
			return true;

		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return false;
	}

	public List<Employee> getAllEmployee() {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("select * from employee")) {
			ArrayList<Employee> employee = new ArrayList<>();
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				Employee emp = new Employee();
				emp.setEmpid(resultset.getInt(1));
				emp.setEmpname(resultset.getString(2));
				employee.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<Employee> employee = null;
		return employee;
	}

	
	public boolean UpdateEmployee(Employee employee) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("update role set role_name=? where role_id=?")) {
			pst.setString(1, employee.getEmpname());
			pst.setInt(2, employee.getEmpid());
			pst.setInt(3, employee.getDepid());
			pst.setLong(4, employee.getMobile());
			pst.setInt(5, employee.getRoleid());
			pst.execute();
			return true;

		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return false;

 	}
	public Map<String,Integer> getDepartmentWiseCount() throws SQLException
	{
		HashMap <String,Integer> hashmap=new HashMap<>();
		try(Connection connection=DBConnect.getConnection();
				Statement statement=connection.createStatement())
		{
			try {
				ResultSet rs=statement.executeQuery("SELECT * FROM employee INNER JOIN department ON employee.empid = department.depid;");
				while(rs.next())
				{
					hashmap.put(rs.getString(1), rs.getInt(2));
				}
			} catch (SQLException e) {
				 e.printStackTrace();
			}
		}
		return hashmap;
		
	}
	 public boolean updateByName(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	 public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}