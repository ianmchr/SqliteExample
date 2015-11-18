package com.example.sqliteexample;

public class Refugee {
	private String names, age, origin, gender;

	public Refugee(String names, String age, String origin, String gender) {
		super();
		this.names = names;
		this.age = age;
		this.origin = origin;
		this.gender = gender;
	}

	public String getNames() {
		return names;
	}

	public String getAge() {
		return age;
	}

	public String getOrigin() {
		return origin;
	}

	public String getGender() {
		return gender;
	}

}
