package com.mum.group2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mum.group2.domain.User;

public interface UserRepository extends CrudRepository<User,Integer>{
}

