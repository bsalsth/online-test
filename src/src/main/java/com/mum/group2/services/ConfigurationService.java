package com.mum.group2.services;

public interface ConfigurationService {
	public static final String NUM_OF_QUESTIONS = "numberOfQuestions";
	public static final String NUM_OF_SUBCATEGORIES_MIN = "numberOfSubCategoriesMin";
	public static final String NUM_OF_SUBCATEGORIES_MAX = "numberOfSubCategoriesMax";
	public static final String TEST_DURATION = "testDuration";
	public static final String WARNING_TIME = "warningTime";
	public static final String DANGER_TIME = "dangerTime";

	public String findConfigurationValue(String name);
	
}
