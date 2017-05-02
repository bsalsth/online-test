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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	
}
