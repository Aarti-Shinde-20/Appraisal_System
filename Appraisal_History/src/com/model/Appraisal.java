package com.model;

 public class Appraisal {
 private int empid;
 private String appraisalDate;
 private String currentRole;
  
private String newRole;
  public Appraisal() {
	// TODO Auto-generated constructor stub
}
public Appraisal(int empid, String appraisalDate, String currentRole, String newRole) {
	super();
	this.empid = empid;
	this.appraisalDate = appraisalDate;
	this.currentRole = currentRole;
	this.newRole = newRole;
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getAppraisalDate() {
	return appraisalDate;
}
public void setAppraisalDate(String appraisalDate) {
	this.appraisalDate = appraisalDate;
}
public String getCurrentRole() {
	return currentRole;
}
public void setCurrentRole(String currentRole) {
	this.currentRole = currentRole;
}
public String getNewRole() {
	return newRole;
}
public void setNewRole(String newRole) {
	this.newRole = newRole;
}
@Override
public String toString() {
	return "Appraisal [empid=" + empid + ", appraisalDate=" + appraisalDate + ", currentRole=" + currentRole
			+ ", newRole=" + newRole + "]";
}
}
