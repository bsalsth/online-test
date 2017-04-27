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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Category {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	private String description;

	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="cat_subcat",
    		joinColumns=@JoinColumn(name="cat_id", referencedColumnName="cat_id"),
    		inverseJoinColumns=@JoinColumn(name="sub_cat_id", referencedColumnName="sub_cat_id"))
	private Collection<SubCategory> subCatCollection;	

	public Category() {
		super();
	}

	public Category(String description) {
		super();
		this.description = description;
	}

	public int getCategoryId() {
		return catId;
	}

	public void setCategoryId(int catId) {
		this.catId = catId;
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
	
}
