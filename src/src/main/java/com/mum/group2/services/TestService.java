package com.mum.group2.services;

import java.util.List;

import com.mum.group2.domain.Test;
import com.mum.group2.domain.User;

public interface TestService {
	public Test save(Test test);
	public Test get(int id);
	public List<Test> findAll();
	
//	public Test findTestWithStudentIDTestID(int studentID, int testID);
	
	public Test findByUserAndSessionKey(User user, String sessionKey);
	
	public List<Test> findByUser(User user);
	
}
