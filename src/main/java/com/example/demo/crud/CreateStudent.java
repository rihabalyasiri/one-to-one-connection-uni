package com.example.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		
		
//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
			
//			create java object
			Student student = new Student("vanessa","vaksmann","rihab@web.de");
//			start transaction
			session.beginTransaction();
//			save the student object
			session.save(student);
//			commit transaction
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}
	}

}
