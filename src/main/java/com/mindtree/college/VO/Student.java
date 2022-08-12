package com.mindtree.college.VO;

public class Student {
	
	private long id;
	private String name;
	private String stream;
	private String gender;
	private int age;
	private long col_id;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getCol_id() {
		return col_id;
	}
	public void setCol_id(long col_id) {
		this.col_id = col_id;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String stream, String gender, int age, long col_id) {
		super();
		this.name = name;
		this.stream = stream;
		this.gender = gender;
		this.age = age;
		this.col_id = col_id;
	}
	
	
	

}
