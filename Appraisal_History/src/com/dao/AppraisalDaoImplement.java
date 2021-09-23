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
import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;
 
public class AppraisalDaoImplement implements AppraisalDao {

 	public boolean addAppraisal(Appraisal a) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("insert into appraisal values(?,?,?,?,?)")) {
 			pst.setInt(1, a.getEmpid());
			pst.setString(2, a.getAppraisalDate());
			pst.setString(3, a.getCurrentRole());
			pst.setString(4, a.getNewRole());
			pst.setInt(5, a.getAppraisalId());
            pst.execute();
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
@Override
public List<Appraisal> getALLAppraisal() {
	
	// TODO Auto-generated method stub

	try(Connection con=DBConnect.getConnection();
			PreparedStatement pst=con.prepareStatement("select *  from appraisal"))
			{
		      ArrayList<Appraisal> Applist =new ArrayList<Appraisal>();
		      ResultSet  rs = pst.executeQuery();
		      while(rs.next())
		      {
		    	  Appraisal r =new Appraisal();
				 r.setEmpid(rs.getInt(1));
		    	 r.setAppraisalDate(rs.getString(2));
		    	 r.setCurrentRole(rs.getString(3));
		    	 r.setNewRole(rs.getString(4));
		    	 r.setAppraisalId(rs.getInt(5));
		    	 Applist.add(r);			      }
		      return Applist;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return null;
	 
	 
}

}
 
              

