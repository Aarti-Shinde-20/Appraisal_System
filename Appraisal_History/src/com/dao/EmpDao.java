package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmpDao {
    public boolean add(Employee e);
    public boolean delete(int empid);
    public List<Employee> getAllEmp();
    public boolean updateByName(int id);
    public Employee getEmpById(int id);
    
}
