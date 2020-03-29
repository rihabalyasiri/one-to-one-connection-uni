package com.example.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		
		
//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;

//			start transaction
			session.beginTransaction();

			Student studentFromDatabase = session.get(Student.class, studentId);
			
			session.delete(studentFromDatabase);
		
			System.out.print("my data to update ----->" + studentFromDatabase + "with id: " + studentId);
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
