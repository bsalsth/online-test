package com.mum.group2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
