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

public class EmpDaoImplement implements EmpDao {
	public boolean addEmployee(Employee employee) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?)")) {
			pst.setInt(1, employee.getEmpid());
			pst.setString(2, employee.getEmpname());
			pst.setString(3, employee.getAddress());
			pst.setLong(4, employee.getMobile());
			pst.setInt(5, employee.getRoleid());
			pst.setInt(6, employee.getDepid());
			pst.setInt(7, employee.getSalary());
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

	public boolean updateEmployee(Employee employee) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("update employee set empname=? where empid=?")) {
			pst.setString(1, employee.getEmpname());
			pst.setInt(2, employee.getEmpid());
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
				emp.setAddress(resultset.getString(3));
				emp.setMobile(resultset.getLong(4));
				emp.setRoleid(resultset.getInt(5));
				emp.setDepid(resultset.getInt(6));
				emp.setSalary(resultset.getInt(7));
				employee.add(emp);
			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//List<Employee> employee = null;
		return null;
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

 
	public List<Employee> getAllEmployee1() {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("select * from employee")) {
			ArrayList<Employee> employee = new ArrayList<>();
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				Employee emp = new Employee();
				emp.setEmpid(resultset.getInt(1));
				emp.setEmpname(resultset.getString(2));
				emp.setAddress(resultset.getString(3));
				emp.setMobile(resultset.getLong(4));
				emp.setRoleid(resultset.getInt(5));
				emp.setDepid(resultset.getInt(6));
				emp.setSalary(resultset.getInt(7));
				employee.add(emp);
				return employee;

			}
 		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getAllEmployee();
		

		// List<Employee> employee = null;

	}

	public boolean updateByName(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}