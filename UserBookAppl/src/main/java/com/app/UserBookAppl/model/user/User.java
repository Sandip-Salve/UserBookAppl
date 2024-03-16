package com.app.UserBookAppl.model.user;

import javax.persistence.*;

@Entity
@Table(name = "USER_ENTITY")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String name;

	private int age;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", age=" + age + "]";
	}

}
