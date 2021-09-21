package com.controller;

import java.util.List;
import java.util.Scanner;

import com.dao.RoleDao;
import com.dao.RoleDaoImplements;
import com.model.Role;

public class MainPojo {
   public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	RoleDao roledao=new RoleDaoImplements();
	do
	{
		System.out.println("Welcome in Appraisal System !!!");
		System.out.println("1.Add \n2.Update \n3.Delete \n4.View all roles \n5.Reports \n6.Exit");
		System.out.println("Enter your choice");
		int choice=scanner.nextInt();
		switch(choice)
		{
		
		case 1:System.out.println("Enter roleid and rolename");
		int rid=scanner.nextInt();
		String name=scanner.next();
		Role role=new Role(rid,name);
		boolean isInsert=roledao.addRole(role);
		if(isInsert)
			System.out.println("Insertion Successful!!");
		else
			System.out.println("Insertion Failed..");
		break;
		
		
		case 2:System.out.println("Updation");
		System.out.println("Enter id to update");
		int id=scanner.nextInt();
		System.out.println("Enter new Rolename");
		String rolename=scanner.next();
		Role ob=new Role (id,rolename);
		boolean isUpdated =roledao.updateRole(ob);
		if(isUpdated)
			System.out.println("Updation Succcessful!!");
		else
			System.out.println("Updation Failed!!!");
		break;
		
		
		case 3:System.out.println("Enter id to delete");
	    id=scanner.nextInt();
	    boolean isDelete=roledao.deleteRole(id);
	    break;
	     
		case 4: List<Role> list=roledao.getAllRoles();
		for(Role rr:list) {
			System.out.println(rr.getRoleid()+ " "+rr.getRolename());
			break;
		}
		}
                 		
		
		if(choice==6)  
			break;
		
	}while(true);
	System.out.println("Thank You !!");
}
}
