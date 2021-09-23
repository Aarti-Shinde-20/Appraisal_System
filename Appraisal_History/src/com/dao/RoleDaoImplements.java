package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.configuration.DBConnect;
import com.model.Role;

public class RoleDaoImplements implements RoleDao {

	public boolean addRole(Role r) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("insert into role values(?,?)")) {
			pst.setInt(1, r.getRoleid());
			pst.setString(2, r.getRolename());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteRole(int id) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("delete from role where role_id=?")) {
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateRole(Role r) {
		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("update role set role_name=? where role_id=?")) {
			pst.setString(1, r.getRolename());
			pst.setInt(2, r.getRoleid());
			pst.execute();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Role> getAllRoles() {
		ArrayList<Role> roleList = new ArrayList<>();

		try (Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("select * from role")) {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setRoleid(rs.getInt(1));
				role.setRolename(rs.getString(2));
				roleList.add(role);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return roleList;
	}
}
