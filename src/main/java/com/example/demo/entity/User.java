package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "BUSINESS")
	private String business;
	
	@Column(name = "COVID19_EFFECT_ON_BUSINESS")
	private String covid19EffectOnBusiness;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getCovid19EffectOnBusiness() {
		return covid19EffectOnBusiness;
	}

	public void setCovid19EffectOnBusiness(String covid19EffectOnBusiness) {
		this.covid19EffectOnBusiness = covid19EffectOnBusiness;
	}

	
	public User() {
		super();
	}

	public User(String name, String role, String email, String phone, String business, String covid19EffectOnBusiness) {
		super();
		this.name = name;
		this.role = role;
		this.email = email;
		this.phone = phone;
		this.business = business;
		this.covid19EffectOnBusiness = covid19EffectOnBusiness;
	}
	

}
