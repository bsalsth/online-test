package com.mum.group2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.Configuration;
import com.mum.group2.repositories.ConfigurationRepository;
import com.mum.group2.services.ConfigurationService;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
	@Autowired
	ConfigurationRepository cr;

	private boolean isInit = false;

	@Override
	public String findConfigurationValue(String name) {
		if (isInit == false) {
			init();
		}
		isInit = true;
		return cr.findConfigurationValue(name);
	}

	public void init() {
		if (cr.findConfigurationValue(NUM_OF_QUESTIONS) == "") {
			cr.save(new Configuration(NUM_OF_QUESTIONS, "20"));
		}
		if (cr.findConfigurationValue(NUM_OF_SUBCATEGORIES_MIN) == "") {
			cr.save(new Configuration(NUM_OF_SUBCATEGORIES_MIN, "1"));
		}
		if (cr.findConfigurationValue(NUM_OF_SUBCATEGORIES_MAX) == "") {
			cr.save(new Configuration(NUM_OF_SUBCATEGORIES_MAX, "4"));
		}
		if (cr.findConfigurationValue(TEST_DURATION) == "") {
			cr.save(new Configuration(TEST_DURATION, "120"));
		}
		if (cr.findConfigurationValue(WARNING_TIME) == "") {
			cr.save(new Configuration(WARNING_TIME, "10"));
		}
		if (cr.findConfigurationValue(DANGER_TIME) == "") {
			cr.save(new Configuration(DANGER_TIME, "5"));
		}
	}

}
