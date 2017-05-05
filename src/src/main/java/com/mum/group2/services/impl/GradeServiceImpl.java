package com.mum.group2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.repositories.GradeRepository;
import com.mum.group2.services.GradeService;

@Service
public class GradeServiceImpl implements GradeService {
	@Autowired
	GradeRepository gradeRepository;

	@Override
	public String findGrade(float grade) {
		return gradeRepository.findGrade(grade);
	}
	
 }
