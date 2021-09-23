package com.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.dao.AppraisalDao;
import com.dao.AppraisalDaoImplement;
import com.dao.EmpDao;
import com.dao.EmpDaoImplement;
import com.dao.RoleDao;
import com.dao.RoleDaoImplements;
import com.model.Appraisal;
import com.model.Employee;
import com.model.Role;

public class AppraisalMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RoleDao roledao = new RoleDaoImplements();
		EmpDao empDao = new EmpDaoImplement();
		AppraisalDao appraisalDao = new AppraisalDaoImplement();

		do {
			System.out.println("**************Welcome in Appraisal System************** !!!");
			System.out.println(
					"1.Add \n2.Update \n3.Delete \n4.Add Appraisal Information \n5.View all roles \n6.view Appraisal Details \n7.Add employee details \n8.view employee details \n9. List of employees \n10 Employees list of Employees who did not have appraisal     \n11.  list of Employee with maximum appraisals  \n12.Exit");
			System.out.println("Enter your choice:-");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Insertion");
				System.out.println("Enter Role_id:-");
				int rid = scanner.nextInt();
				System.out.println("Enter Role_name:-");
				String name = scanner.next();
				Role role = new Role(rid, name);
				boolean isInsert = roledao.addRole(role);
				if (isInsert)
					System.out.println("Insertion Successful!!");
				else
					System.out.println("Insertion Failed..");
				break;

			case 2:
				System.out.println("Updation");
				System.out.println("Enter id to update:-");
				int roleid = scanner.nextInt();
				System.out.println("Enter new Role_name:-");
				String rolename = scanner.next();
				Role role1 = new Role(roleid, rolename);
				boolean isUpdated = roledao.updateRole(role1);
				if (isUpdated)
					System.out.println("Updation Succcessful!!");
				else
					System.out.println("Updation Failed!!!");
				break;

			case 3:
				System.out.println("Enter id to delete:-");
				int id = scanner.nextInt();
				boolean isdeleted = roledao.deleteRole(id);
				if (isdeleted)
					System.out.println("Role Deletion Successful!!");
				else
					System.out.println("Role Deletion Unsuccessful");
				break;

			case 4:
				System.out.println("---Add Information about appraisal---");
				System.out.println("Enter Employee id :-");
				int empid = scanner.nextInt();
				System.out.println("Enter Appraisal Date :-");
				String appraisaldate = scanner.next();
				System.out.println("Enter Employee Current role :-");
				String currentRole = scanner.next();
				System.out.println("Enter Employee New role :-");
				String newRole = scanner.next();
				System.out.println("Enter Appraisal id :-");
				int appraisalid = scanner.nextInt();

				Appraisal appraisal = new Appraisal();
				appraisal.setAppraisalId(appraisalid);
				appraisal.setEmpid(empid);
				appraisal.setAppraisalDate(appraisaldate);
				appraisal.setCurrentRole(currentRole);
				appraisal.setNewRole(newRole);
				appraisal.setAppraisalId(appraisalid);

				boolean isAdd = appraisalDao.addAppraisal(appraisal);
				if (isAdd)
					System.out.println("Added Information Successfully in Appraisal!!");
				else
					System.out.println("Add Information is Unsuccessful");
				break;

			case 5:
				List<Role> roleList = roledao.getAllRoles();
				Iterator<Role> itr = roleList.iterator();
				System.out.println(" ----Role Information---- ");
				System.out.println("Role_id " + "\t" + "Role_name");
				while (itr.hasNext()) {

					Role role11 = itr.next();

					System.out.println("   " + role11.getRoleid() + "     \t" + role11.getRolename());

				}
				System.out.println("Successful!!");

				break;
			case 6:
				List<Appraisal> list1 = appraisalDao.getALLAppraisal();
				System.out.println("view Appraisal Details");
				System.out.println("Empid" + "\tSalarydate" + "\tCurrent_Role" + "\tNew_Role");
				for (Appraisal rr : list1) {

					System.out.println(rr.getEmpid() + "\t " + rr.getAppraisalDate() + " \t" + rr.getCurrentRole()
							+ " \t" + rr.getNewRole());

				}
				System.out.println("------------------------------------------------------------------------------");
				break;

			case 7:
				System.out.println("enter employee details ");
				System.out.println("employee_id");
				int empid1 = scanner.nextInt();
				System.out.println("employee_Name");
				String empname = scanner.next();
				System.out.println("employee_Address");
				String address = scanner.next();
				System.out.println("employee_mobile_number");
				long mobile = scanner.nextLong();
				System.out.println("employee_role id");
				int roleid1 = scanner.nextInt();
				System.out.println("employee_deptid");
				int depid = scanner.nextInt();
				System.out.println("employee_salary");
				int salary = scanner.nextInt();

				Employee employee = new Employee(empid1, empname, address, mobile, roleid1, depid, salary);
				boolean addEmployee = empDao.addEmployee(employee);
				if (addEmployee)
					System.out.println("Record Added Successfully !!!");
				else
					System.out.println("Record Add Unsuccessful!!");

				break;

			case 8:
				System.out.println("view  employee details ");
				List<Employee> list2 = empDao.getAllEmployee();
				System.out.println("empid " + "\tempname " + "\taddress" + "\t\tmobile_no" + "\tRoleId " + "\tDepId"
						+ "\tSalary ");
				for (Employee abc : list2) {
					System.out.println(abc.getEmpid() + "\t" + abc.getEmpname() + "\t " + abc.getAddress() + " \t"
							+ abc.getMobile() + " \t" + abc.getRoleid() + " \t" + abc.getDepid() + " \t"
							+ abc.getSalary());
				}
				System.out.println("-----------------------------------------------------");
				break;
			}

			if (choice == 12)
				break;

		} while (true);

		System.out.println("Thank You!!!");

	}

}
