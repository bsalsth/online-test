package com.mum.group2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.Test;

@Repository
public interface TestRepository extends CrudRepository<Test,Integer>{
//	@Query("select t from Test  t where t.user_id = :studentID and t.test_id = :testId")
//	public Test findTestWithStudentIDTestID(@Param("studentID") int studentID, @Param("testId") int testID);
}

