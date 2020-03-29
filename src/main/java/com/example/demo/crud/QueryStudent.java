package com.example.demo.crud;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.entity.Student;

import antlr.collections.List;

public class QueryStudent {

	public static void main(String[] args) {
		
		
//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
			

//			start transaction
			session.beginTransaction();
			
//			query students
			ArrayList<Student> studentsList = (ArrayList<Student>) session.createQuery("from Student s where s.lastName = 'duck'")
					.getResultList();
			
			
			
//			display students
			System.out.println("*****************************");
			for(Student student: studentsList) {
				System.out.println(student);
			}
			

//			commit transaction
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}
	}

}
