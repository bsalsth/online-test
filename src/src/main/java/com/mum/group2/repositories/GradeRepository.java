package com.mum.group2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.Grade;

@Repository
public interface GradeRepository extends CrudRepository<Grade,Integer> {
	
	@Query("select g.grade from grade g where g.min <= ?1 and g.max >= ?1")
	public String findGrade(float grade);
	
}

