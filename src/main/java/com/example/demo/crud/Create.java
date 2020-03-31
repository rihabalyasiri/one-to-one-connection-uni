package com.example.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;

public class Create {

	public static void main(String[] args) {
		
		
//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
			
//			start transaction
			session.beginTransaction();
			
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			if(instructor != null) {
				session.delete(instructor);
			}


//			commit transaction
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}
	}

}
