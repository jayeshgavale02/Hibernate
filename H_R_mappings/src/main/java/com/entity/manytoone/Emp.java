package com.entity.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Emp {
	
	
    @Id
	private int e_id;
	private String e_name;

	@ManyToOne
	@JoinColumn(name = "depramtn_id")
	private Dep D;

	public Dep getD() {
		return D;
	}

	public void setD(Dep d) {
		D = d;
	}

	public Emp(int e_id, String e_name, Dep d) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		D = d;
	}

	public Emp() {

	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public Emp(int e_id, String e_name) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
	}

	@Override
	public String toString() {
		return "Emp [e_id=" + e_id + ", e_name=" + e_name + ", D=" + D + "]";
	}

}
