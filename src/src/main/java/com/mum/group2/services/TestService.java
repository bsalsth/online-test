package com.mum.group2.services;

import java.util.List;

import com.mum.group2.domain.Test;

public interface TestService {
	public Test save(Test member);
	public Test get(int id);
	public List<Test> findAll();
}
