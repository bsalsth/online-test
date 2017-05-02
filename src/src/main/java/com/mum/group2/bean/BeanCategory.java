package com.mum.group2.bean;

import java.util.ArrayList;

public class BeanCategory {
	private int catId;
	private String description;
	
	ArrayList<BeanSubcat> listSubcat = new ArrayList<BeanSubcat>();

	public BeanCategory(int catId, String description) {
		super();
		this.catId = catId;
		this.description = description;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<BeanSubcat> getListSubcat() {
		return listSubcat;
	}

	public void setListSubcat(ArrayList<BeanSubcat> listSubcat) {
		this.listSubcat = listSubcat;
	}

	
}
