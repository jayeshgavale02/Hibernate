package com.entity.manytomany;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student {

	@Id
	private int s_id;
	private String s_name;

	@ManyToMany
	@JoinTable(
	        name = "std_courses", 
	        joinColumns = { @JoinColumn(name = "std_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "c_id") })
	private List<Course> courses;

	public Student() {
	}

	public Student(int s_id, String s_name, List<Course> courses) {
		this.s_id = s_id;
		this.s_name = s_name;
		this.courses = courses;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + "]";
	}
}
