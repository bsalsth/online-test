package com.mum.group2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.Test;
import com.mum.group2.domain.User;

@Repository
public interface TestRepository extends CrudRepository<Test,Integer>{
//	@Query("select t from Test  t, User u where u.user_id = :studentID and tu.test_id = :testId and t.test_id = :testId")
//	public Test findTestTestID(@Param("studentID") int studentID, @Param("testId") int testID);
	
	public Test findByUserAndSessionKey(User user, String sessionKey);
	
	public List<Test> findByUserOrderByTestDateDesc(User user);
	
	@Query("select t from test t order by testDate desc")
	public List<Test> getAllOrderByTestDate();
	
	//2017-05-07: MT
	@Query("select t from test t where session_key = :accessKey")
	public Test findByAccessKey(@Param("accessKey") String accessKey);
}

