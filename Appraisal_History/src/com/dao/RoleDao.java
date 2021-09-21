package com.dao;

import java.util.List;

import com.model.Role;

public interface RoleDao {
     boolean addRole(Role r);
     boolean deleteRole(int id);
     boolean updateRole(Role r);
     List<Role> getAllRoles ();
}
