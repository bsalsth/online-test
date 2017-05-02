package com.mum.group2.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity (name = "category")
public class Category {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	private String description;

	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="CAT_SUBCAT",
    		joinColumns=@JoinColumn(name="cat_id", referencedColumnName="cat_id"),
    		inverseJoinColumns=@JoinColumn(name="sub_cat_id", referencedColumnName="sub_cat_id"))
	private Collection<SubCategory> subCatCollection;	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
	private List<SubCategory> subcategories = new ArrayList<SubCategory>();

	public Category() {
		super();
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public Category(String description) {
		super();
		this.description = description;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Collection<SubCategory> getSubCatCollection() {
		return subCatCollection;
	}

	public void setSubCatCollection(Collection<SubCategory> subCatCollection) {
		this.subCatCollection = subCatCollection;
	}
	
	public List<SubCategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<SubCategory> subcategories) {
		this.subcategories = subcategories;
	}
	
	public boolean equals(Category category) {
		return catId == category.getCatId();
	}
	
	public int hashCode() {
		return catId;
	}
	
}
