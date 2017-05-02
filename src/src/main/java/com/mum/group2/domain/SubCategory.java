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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity 
@Table (name = "sub_category")
public class SubCategory {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sub_cat_id")
	private int subCatId;
	
	private String description;
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="QUESTION_SUBCAT",
    		joinColumns=@JoinColumn(name="sub_cat_id", referencedColumnName="sub_cat_id"),
    		inverseJoinColumns=@JoinColumn(name="question_id", referencedColumnName="question_id"))
	private Collection<Question> questionCollection;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CAT_ID")
	private Category category;
	
	@OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Question> questions = new ArrayList<Question>();

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public Collection<Question> getQuestionCollection() {
		return questionCollection;
	}

	public void setQuestionCollection(Collection<Question> questionCollection) {
		this.questionCollection = questionCollection;
	}

	public SubCategory() {
		super();
	}

	public SubCategory(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public boolean equals(SubCategory subcategory) {
		return subCatId == subcategory.getSubCatId();
	}
	
	public int hashCode() {
		return subCatId;
	}
	
}
