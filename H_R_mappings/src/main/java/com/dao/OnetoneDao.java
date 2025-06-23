package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.onetoone.Passport;
import com.entity.onetoone.Person;

public class OnetoneDao {

	private SessionFactory sessionFactory;

	public OnetoneDao() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Passport.class);
	
		sessionFactory = cfg.buildSessionFactory();
	}

	public void oneTOone() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Person p = new Person();
		Passport passport = new Passport();

		p.setName("Jayesh");
		passport.setNumber(123);
		p.setPassport(passport);

		session.persist(passport);
		session.persist(p);

		System.out.println("One-to-one data inserted...");
		tx.commit();
		session.close();
	}

}
