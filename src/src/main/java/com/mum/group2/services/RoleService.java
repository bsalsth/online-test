package com.mum.group2.services;

import com.mum.group2.domain.Role;

public interface RoleService {

	 void save(Role role);
	    Role findRoleByRoleName(String roleName);
	    Role findOne(int id);
}
