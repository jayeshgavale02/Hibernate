package com.controller;

import com.service.EmpService;

public class home {
	
	public static void main(String[] args) {
		
		EmpService obj = new EmpService();
		
		
		// this method is usning HQL
		obj.crudusingHQL();
		
		// this metho is using HQL methods
//		obj.crudusingmethod();
		
		
	}
	}


