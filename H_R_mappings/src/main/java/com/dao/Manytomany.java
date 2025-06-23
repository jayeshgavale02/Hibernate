package com.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.manytomany.Course;
import com.entity.manytomany.Student;
import com.entity.onetomany.Dep;
import com.entity.onetomany.Emp;

public class Manytomany {

    private SessionFactory sessionFactory;

    public Manytomany() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Dep.class);
        cfg.addAnnotatedClass(Emp.class);

        sessionFactory = cfg.buildSessionFactory();
    }

  

    public void manytomany() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student s1 = new Student();
        Student s2 = new Student();
        
        s1.setS_id(1);
        s1.setS_name("Jayesh");
        
        s2.setS_id(2);
        s2.setS_name("Ganesh");
        
        Course c1 = new Course();
        Course c2 = new Course();

        c1.setC_id(101);
        c1.setC_name("Java");
        
        c2.setC_id(102);
        c2.setC_name("C++");
        
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        
        list1.add(s1);
        list1.add(s2);
        
        
        list2.add(c1);
        list2.add(c2);
        
        s1.setCourses(list2);
        c2.setStudents(list1);
        
        session.persist(s1);
        session.persist(s2);
        session.persist(c2);
        session.persist(c1);

        




        System.out.println("Many-to-Many data inserted...");
        tx.commit();
        session.close();
    }
}
