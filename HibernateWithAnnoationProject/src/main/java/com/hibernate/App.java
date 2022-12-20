package com.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		System.out.println("step-1");
		Configuration cfg = new Configuration();
		cfg = cfg.configure("hibernate.cfg.xml");
		
		System.out.println("step-2");
		SessionFactory factory = cfg.buildSessionFactory();
		
		System.out.println("step-3");
		Session session = factory.openSession();
		
		System.out.println("step-4");
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setName("Shyam");
		employee.setSalary(20000);
		
		Serializable id = session.save(employee);
		transaction.commit();
		
		System.out.println("Record added successfully..id>> "+id);
	}
}
