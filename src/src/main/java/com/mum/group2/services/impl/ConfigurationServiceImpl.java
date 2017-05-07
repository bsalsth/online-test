package com.mum.group2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.repositories.ConfigurationRepository;
import com.mum.group2.services.ConfigurationService;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
	
	@Autowired
	ConfigurationRepository configurationRepository;

	@Override
	public String findConfigurationValue(String name) {
		return configurationRepository.findConfigurationValue(name);
	}

}
