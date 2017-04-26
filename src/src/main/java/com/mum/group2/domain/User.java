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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;

	@OneToOne
	@JoinColumn(name="coach_id")
	private User coach;
	
	private String userName;
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	private String email;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_role",
		    joinColumns=@JoinColumn(name="user_id", referencedColumnName="user_id"),
		    inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="role_id"))
	private Collection<Role> roleCollection;	
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_test",
    		joinColumns=@JoinColumn(name="user_id", referencedColumnName="user_id"),
    		inverseJoinColumns=@JoinColumn(name="test_id", referencedColumnName="test_id"))
	private Collection<Test> testCollection;
	
	public User() {
		super();
	}

	
	public User(String userName, String password, String firstName, String lastName, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getCoach() {
		return coach;
	}

	public void setCoach(User coach) {
		this.coach = coach;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<Role> getRoleCollection() {
		return roleCollection;
	}


	public void setRoleCollection(Collection<Role> roleCollection) {
		this.roleCollection = roleCollection;
	}


	public Collection<Test> getTestCollection() {
		return testCollection;
	}


	public void setTestCollection(Collection<Test> testCollection) {
		this.testCollection = testCollection;
	}
	
	
}
