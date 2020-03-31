package com.example.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;

public class Delete {

	public static void main(String[] args) {
		
		
//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
			
//			create java object
			
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/rihab", "swimming");
			
			Instructor instructor = new Instructor("rihab", "ali", "rihab@gmail.com");
			
//			associate Instructor to InstructorDetail
			instructor.setInstructorDetail(instructorDetail);
			
//			start transaction
			session.beginTransaction();
//			save the student object
			session.save(instructor);
//			commit transaction
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}
	}

}
