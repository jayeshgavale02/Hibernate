package com.entity.onetomany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Dep {
     
    @Id
	private int d_id;
	private String d_name;

    @OneToMany(mappedBy = "D")
	private List<Emp> e;

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public List<Emp> getE() {
		return e;
	}

	public void setE(List<Emp> e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return "Dep [d_id=" + d_id + ", d_name=" + d_name + ", e=" + e + "]";
	}

	public Dep(int d_id, String d_name, List<Emp> e) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
		this.e = e;
	}

	public Dep() {
	}

}
