package com.model;

public class Employee {

   private int empid;
   private String empname;
   private String email;
   private long mobile;
   private int depid;
   private int roleid;
   public Employee() {
	// TODO Auto-generated constructor stub
}
public Employee(int empid, String empname, String email, long mobile, int depid, int roleid) {
	super();
	this.empid = empid;
	this.empname = empname;
	this.email = email;
	this.mobile = mobile;
	this.depid = depid;
	this.roleid = roleid;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public int getDepid() {
	return depid;
}
public void setDepid(int depid) {
	this.depid = depid;
}
public int getRoleid() {
	return roleid;
}
public void setRoleid(int roleid) {
	this.roleid = roleid;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", empname=" + empname + ", email=" + email + ", mobile=" + mobile + ", depid="
			+ depid + ", roleid=" + roleid + "]";
}
 
   
	}


