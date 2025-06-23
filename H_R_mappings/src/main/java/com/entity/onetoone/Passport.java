package com.entity.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

 public class Passport {

     @Id
	private int number;

	public Passport( int number) {
		super();
		this.number = number;
	}

	public Passport() {

	}


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	@Override
	public String toString() {
		return "Passport [ number=" + number + "]";
	}

}
