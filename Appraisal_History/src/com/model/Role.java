package com.model;

public class Role {
     private int roleid;
     private String rolename;
     public Role() {
		// TODO Auto-generated constructor stub
	}
	public Role(int roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + "]";
	}
}
