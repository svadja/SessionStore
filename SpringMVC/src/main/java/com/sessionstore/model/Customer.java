package com.sessionstore.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Customer {

	int id;

	String customer_cid;
	
	String name;

	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_cid() {
		return customer_cid;
	}

	public void setCustomer_cid(String customer_cid) {
		this.customer_cid = customer_cid;
	}

	public Customer(int id, String customer_cid, String name, int age) {
		super();
		this.id = id;
		this.customer_cid = customer_cid;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer_cid=" + customer_cid
				+ ", name=" + name + ", age=" + age + "]";
	}
	

}