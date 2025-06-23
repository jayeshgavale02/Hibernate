package com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.entity.Employee;

public class EmpDao_HQL {

    public SessionFactory sessionFactory;

    public EmpDao_HQL() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Employee.class);
        sessionFactory = cfg.buildSessionFactory();
    }

    public void insertData(Scanner s) {
        System.out.print("Enter Name: ");
        String name = s.nextLine();
        System.out.print("Enter Department: ");
        String department = s.nextLine();
        System.out.print("Enter Salary: ");
        double salary = s.nextDouble();
        s.nextLine(); 
        System.out.print("Enter Hire Date: ");
        String hireDate = s.nextLine();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "insert into EmployeeTable(name, department, salary, hireDate) values (:name, :department, :salary, :hireDate)";
        Query<?> query = session.createNativeQuery(sql);
        query.setParameter("name", name);
        query.setParameter("department", department);
        query.setParameter("salary", salary);
        query.setParameter("hireDate", hireDate);

        query.executeUpdate();
        tx.commit();
        session.close();

        System.out.println("Data inserted successfully.");
    }

    public void updateData(Scanner s) {
        System.out.print("Enter Employee ID to update: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("Enter New Name: ");
        String name = s.nextLine();
        System.out.print("Enter New Department: ");
        String department = s.nextLine();
        System.out.print("Enter New Salary: ");
        double salary = s.nextDouble();
        s.nextLine();
        System.out.print("Enter New Hire Date: ");
        String hireDate = s.nextLine();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "update Employee set name=:ename, department=:edepartment, salary=:esalary, hireDate=:ehireDate where id=:eid";
        MutationQuery query = session.createMutationQuery(hql);
        query.setParameter("ename", name);
        query.setParameter("edepartment", department);
        query.setParameter("esalary", salary);
        query.setParameter("ehireDate", hireDate);
        query.setParameter("eid", id);

        int updated = query.executeUpdate();
        tx.commit();
        session.close();

        System.out.println("Employee updated successfully.");

    }

    public void fetchUniqueData(Scanner s) {
        System.out.print("Enter Employee ID to fetch: ");
        int id = s.nextInt();
        s.nextLine();

        Session session = sessionFactory.openSession();
        String hql = "from Employee where id=:id";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("id", id);

        Employee emp = query.uniqueResult();
        session.close();

        System.out.println("Employee Details: " + emp);

    }

    public void fetchAllData() {
        Session session = sessionFactory.openSession();
        String hql = "from Employee";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        List<Employee> employeeList = query.getResultList();
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

        String hql = "delete from Employee where id=:id";
        MutationQuery query = session.createMutationQuery(hql);
        query.setParameter("id", id);

        int deleted = query.executeUpdate();
        tx.commit();
        session.close();
        System.out.println("Employee deleted successfully.");

    }
}
