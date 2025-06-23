package com.entity.manytomany;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {

	@Id
	private int c_id;
	private String c_name;

	@ManyToMany(mappedBy = "courses")
//	@JoinTable(
//    name = "std_courses", 
//    joinColumns = { @JoinColumn(name = "std_id") }, 
//	inverseJoinColumns = { @JoinColumn(name = "c_id") })
	private List<Student> students;

	public Course() {
	}

	public Course(int c_id, String c_name, List<Student> students) {
		this.c_id = c_id;
		this.c_name = c_name;
		this.students = students;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [c_id=" + c_id + ", c_name=" + c_name + "]";
	}
}
