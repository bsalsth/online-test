package com.mum.group2.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity (name = "sub_category")
public class SubCategory {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sub_cat_id")
	private int subCatId;
	
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="question_subcat",
    		joinColumns=@JoinColumn(name="sub_cat_id", referencedColumnName="sub_cat_id"),
    		inverseJoinColumns=@JoinColumn(name="question_id", referencedColumnName="question_id"))
	private Collection<Question> questionCollection;

	public SubCategory() {
		super();
	}

	public SubCategory(String description) {
		super();
		this.description = description;
	}

	public int getSubCategoryId() {
		return subCatId;
	}

	public void setSubCategoryId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
