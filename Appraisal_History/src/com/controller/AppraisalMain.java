package com.controller;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

import com.dao.AppraisalDao;
import com.dao.AppraisalDaoImplement;
import com.dao.EmpDao;
import com.dao.EmpDaoImplement;
import com.dao.RoleDao;
import com.dao.RoleDaoImplements;
import com.model.Appraisal;
import com.model.Role;

public class AppraisalMain {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RoleDao roledao = new RoleDaoImplements();
		EmpDao empDao = new EmpDaoImplement();
	    AppraisalDao appraisalDao=new AppraisalDaoImplement();
		 

		do {
			System.out.println("***********Welcome in Appraisal System************* !!!");
			System.out.println("1.Add \n2.Update \n3.Delete \n4.Add Appraisal Information \n5.View all roles \n6.Reports \n7.Exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();

			switch (choice) {

			
			case 1:
				System.out.println("Insertion");
				System.out.println("Enter roleid , rolename ");
				int rid = scanner.nextInt();
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
				System.out.println("Enter id to update");
				int roleid = scanner.nextInt();
				System.out.println("Enter new name");
				String rolename = scanner.next();
				Role role1 = new Role(roleid, rolename);
				boolean isUpdated = roledao.updateRole(role1);
				if (isUpdated)
					System.out.println("Updation Succcessful!!");
				else
					System.out.println("Updation Failed!!!");
				break;

				
			case 3:
				System.out.println("Enter id to delete");
				int id = scanner.nextInt();
				boolean isdeleted = roledao.deleteRole(id);
				if (isdeleted)
					System.out.println("Role Deletion Successful!!");
				else
					System.out.println("Role Deletion Unsuccessful");
				break;

				
			case 4:
				System.out.println("Add Information about appraisal");
                System.out.println("Enter appraisalid, empid,appraisaldate, current role and new role");
                int appraisalid=scanner.nextInt();
				int empid = scanner.nextInt();
				String appraisaldate = scanner.next();
				String currentRole = scanner.next();
				String newRole = scanner.next();
				
				Appraisal appraisal =new Appraisal();
				appraisal.setAppraisalId(appraisalid);
				appraisal.setEmpid(empid);
				appraisal.setAppraisalDate(appraisaldate);
				appraisal.setCurrentRole(currentRole);
				appraisal.setNewRole(newRole);
				boolean isAdd=appraisalDao.addAppraisal(appraisal);
				if(isAdd)
					System.out.println("Added Information Successfully in Appraisal!!");
				else
					System.out.println("Add Information is Unsuccessful");
				break;
 
				
//			case 6:
//				List<Role> list = roledao.getAllRoles();
//				for (Role rr : list) 
//					System.out.println(rr.getRoleid() + " | " + rr.getRolename());
//					break;
					
			case 5: System.out.println("Enter all roles");
			 int roleid1=scanner.nextInt();
			 String rolename1=scanner.next();
			 Role ob1 = new Role(roleid1, rolename1);
             boolean isadded=roledao.addRole(ob1);	
             if(isadded)
            	 System.out.println("Roles entered Successfully!!!");
             else
            	 System.out.println("Unsuccessful!!");
             break;
             
   			case 6:System.out.println("Reports");
			   System.out.println("1->ReportDeparmenttwise \n2->Report Rolewise");
			   int ch=scanner.nextInt();
			   if(ch==1)
			   {
				  Map<String, Integer> map = null;
				try {
					map = ((EmpDaoImplement) empDao).getDepartmentWiseCount();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  for(String dnm:map.keySet())
				  {  
					  System.out.println(dnm+"-->"+map.get(dnm));
				  }
			   }
			 break;   
			}
		
		
		if(choice==6)
			break;
		
	} while (true);
	
	System.out.println("Thanks!!!");

}

}
