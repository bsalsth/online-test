package com.mum.group2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.Test;
import com.mum.group2.domain.User;

@Repository
public interface TestRepository extends CrudRepository<Test,Integer>{
//	@Query("select t from Test  t, User u where u.user_id = :studentID and tu.test_id = :testId and t.test_id = :testId")
//	public Test findTestTestID(@Param("studentID") int studentID, @Param("testId") int testID);
	
	public Test findByUserAndSessionKey(User user, String sessionKey);
}

