package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 import java.util.List;

import com.configuration.DBConnect;
import com.model.Appraisal;
import com.model.Role;
 
public class AppraisalDaoImplement implements AppraisalDao {

 	public boolean addAppraisal(Appraisal a) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("insert into appraisal values(?,?)")) {
			pst.setInt(1, a.getAppraisalId());
			pst.setInt(1, a.getEmpid());
			pst.setString(2, a.getAppraisalDate());
			pst.setString(3, a.getCurrentRole());
			pst.setString(4, a.getNewRole());
 
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
public List<Appraisal> getAllappraisal () {
	ArrayList<Appraisal> appraisalList = new ArrayList<>();
	try (Connection connection = DBConnect.getConnection();
			PreparedStatement pst = connection.prepareStatement("select * from appraisal")) {
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Appraisal appraisal1=new Appraisal();
			appraisal1.setAppraisalId(rs.getInt(4));
			appraisal1.setEmpid(rs.getInt(2));
			appraisal1.setAppraisalDate(rs.getString(2));
			appraisal1.setCurrentRole(rs.getString(2));
			appraisal1.setNewRole(rs.getString(6));
			
				appraisalList.add(appraisal1);

		}			
	
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
return appraisalList;
	}
 
              
}
