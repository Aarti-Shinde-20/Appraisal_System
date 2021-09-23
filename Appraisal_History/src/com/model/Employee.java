package com.model;

public class Employee {

	private int empid;
	private String empname;
	private String address;
	private long mobile;
	private int roleid;
	private int depid;
	private int salary;
	public Employee(int empid, String empname, String address, long mobile, int roleid, int depid, int salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.address = address;
		this.mobile = mobile;
		this.roleid = roleid;
		this.depid = depid;
		this.salary = salary;
	}

	 public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getDepid() {
		return depid;
	}

	public void setDepid(int depid) {
		this.depid = depid;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", address=" + address + ", mobile=" + mobile
				+ ", roleid=" + roleid + ", depid=" + depid + ", salary=" + salary + "]";
	}
}