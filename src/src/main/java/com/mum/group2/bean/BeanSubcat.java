package com.mum.group2.bean;

public class BeanSubcat {
	private int subCatId;
	private String description;

	public BeanSubcat(int subCatId, String description) {
		super();
		this.subCatId = subCatId;
		this.description = description;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
