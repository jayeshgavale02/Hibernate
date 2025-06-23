package com.service;

import java.util.Scanner;

import com.dao.EmpDao_HQL;
import com.dao.EmpDao_Methods;

public class EmpService {
	
    Scanner s = new Scanner(System.in);

	public void crudusingmethod() {
		
		EmpDao_Methods dao = new EmpDao_Methods();

		
		 while (true) {
	            System.out.println("\n--- CRUD Menu ---");
	            System.out.println("1. Insert Employee");
	            System.out.println("2. Fetch All Employees");
	            System.out.println("3. Update Employee by ID");
	            System.out.println("4. Delete Employee by ID");
	            System.out.println("5. Fetch Unique Employee by ID");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");

	            int choice = s.nextInt();
	            s.nextLine();

	            switch (choice) {
	                case 1:
	                	dao.insertData(s);
	                    break;
	                case 2:
	                	dao.fetchAllData();
	                    break;
	                case 3:
	                	dao.updateData(s);
	                    break;
	                case 4:
	                	dao.deleteData(s);
	                    break;
	                case 5:
	                	dao.fetchUniqueData(s);
	                    break;
	                case 6:
	                    System.out.println("Exiting...");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	public void crudusingHQL() {
		 EmpDao_HQL dao = new EmpDao_HQL();

	        while (true) {
	            System.out.println("\n--- CRUD Menu ---");
	            System.out.println("1. Insert Employee");
	            System.out.println("2. Fetch All Employees");
	            System.out.println("3. Update Employee by ID");
	            System.out.println("4. Delete Employee by ID");
	            System.out.println("5. Fetch Unique Employee by ID");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");

	            int choice = s.nextInt();
	            s.nextLine(); 

	            switch (choice) {
	                case 1:
	                    dao.insertData(s);
	                    break;
	                case 2:
	                    dao.fetchAllData();
	                    break;
	                case 3:
	                    dao.updateData(s);
	                    break;
	                case 4:
	                    dao.deleteData(s);
	                    break;
	                case 5:
	                    dao.fetchUniqueData(s);
	                    break;
	                case 6:
	                    System.out.println("Exiting...");
	                    s.close();
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
		
	}

	


