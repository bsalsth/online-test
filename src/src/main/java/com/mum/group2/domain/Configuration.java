package com.mum.group2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "conf")
public class Configuration {
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CONF_ID")
	private int confId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="VALUE")
	private String value;

	
	public Configuration() {
		super();
	}

	public Configuration(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public int getConfId() {
		return confId;
	}

	public void setConfId(int confId) {
		this.confId = confId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}

