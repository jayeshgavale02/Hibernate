package com.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.onetomany.Dep;
import com.entity.onetomany.Emp;

public class ManytooneDao {

    private SessionFactory sessionFactory;

    public ManytooneDao() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Dep.class);
        cfg.addAnnotatedClass(Emp.class);

        sessionFactory = cfg.buildSessionFactory();
    }

  

    public void manyTOone() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Dep dep = new Dep();
        dep.setD_id(2);
        dep.setD_name("Manger");

        Emp emp1 = new Emp();
        emp1.setE_id(103);
        emp1.setE_name("Gaurav");
        emp1.setD(dep);

        Emp emp2 = new Emp();
        emp2.setE_id(104);
        emp2.setE_name("mayuri");
        emp2.setD(dep);

        
        ArrayList list = new ArrayList();
        list.add(emp1);
        list.add(emp2);
        session.persist(emp1);
        session.persist(emp2);
        dep.setE(list); 
        session.persist(dep);



        System.out.println("Many-to-one data inserted...");
        tx.commit();
        session.close();
    }
}
