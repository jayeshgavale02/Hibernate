package com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Employee;

public class EmpDao_Methods {
	 public SessionFactory sessionFactory;

	    public EmpDao_Methods() {
	        Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        cfg.addAnnotatedClass(Employee.class);
	        sessionFactory = cfg.buildSessionFactory();
	    }

	    public void insertData(Scanner s) {
	        System.out.print("Enter Name: ");
	        String name = s.nextLine();

	        System.out.print("Enter Department: ");
	        String dept = s.nextLine();

	        System.out.print("Enter Hire Date: ");
	        String hireDate = s.nextLine();

	        System.out.print("Enter Salary: ");
	        double salary = s.nextDouble();
	        s.nextLine();

	        Employee employee = new Employee();
	        employee.setName(name);
	        employee.setDepartment(dept);
	        employee.setHireDate(hireDate);
	        employee.setSalary(salary);

	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();

	        session.persist(employee);

	        tx.commit();
	        session.close();

	        System.out.println("Employee inserted successfully.");
	    }

	    public void updateData(Scanner s) {
	        System.out.print("Enter Employee ID to update: ");
	        int id = s.nextInt();
	        s.nextLine();

	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();

	        Employee employee = session.get(Employee.class, id);

	            System.out.print("Enter new Name: ");
	            employee.setName(s.nextLine());

	            System.out.print("Enter new Department: ");
	            employee.setDepartment(s.nextLine());

	            System.out.print("Enter new Hire Date: ");
	            employee.setHireDate(s.nextLine());

	            System.out.print("Enter new Salary: ");
	            employee.setSalary(s.nextDouble());
	            s.nextLine();

	            session.update(employee);
	            tx.commit();
	            System.out.println("Employee updated successfully.");
	        

	        session.close();
	    }

	    public void fetchUniqueData(Scanner s) {
	        System.out.print("Enter Employee ID to fetch: ");
	        int id = s.nextInt();
	        s.nextLine();

	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();

	        Employee employee = session.get(Employee.class, id);
	        tx.commit();
	        session.close();

	        
	        System.out.println("Fetched Employee:");
            System.out.println(employee);
	       
	    }

	    public void fetchAllData() {
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();

	        Query<Employee> query = session.createQuery("from Employee", Employee.class);
	        List<Employee> employeeList = query.getResultList();

	        tx.commit();
	        session.close();

	        System.out.println("All Employee Records:");
	        for (Employee e : employeeList) {
	            System.out.println(e);
	        }
	    }

	    public void deleteData(Scanner s) {
	        System.out.print("Enter Employee ID to delete: ");
	        int id = s.nextInt();
	        s.nextLine();

	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();

	        Employee employee = session.get(Employee.class, id);
	        
	        
	        session.remove(employee);
            tx.commit();
            System.out.println("Employee deleted successfully.");

	        
	        session.close();
	    }

	   
	}
