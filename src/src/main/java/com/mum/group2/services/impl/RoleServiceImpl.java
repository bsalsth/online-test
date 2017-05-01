package com.mum.group2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.Role;
import com.mum.group2.repositories.RoleRepository;
import com.mum.group2.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	
    private RoleRepository roleRepository;
    @Autowired
	 public RoleServiceImpl(RoleRepository roleRepository) {
			this.roleRepository = roleRepository;
		}
	
	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
		
	}

	@Override
	public Role findRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleRepository.findRoleByRoleName(roleName);
	}

	@Override
	public Role findOne(int id) {
		// TODO Auto-generated method stub
		return roleRepository.findOne(id);
	}

}
