package com.mum.group2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findRoleByRoleName(String roleName);
}
