package com.mum.group2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.Configuration;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration,Integer> {
	
	@Query("select c.value from conf c where c.name=?1")
	public String findConfigurationValue(String name);

}
