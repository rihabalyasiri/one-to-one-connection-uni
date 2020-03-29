package com.example.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		
		
//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
			
//			create java object
			Student student = new Student("daffy","duck","daffy@web.de");
			
//			start transaction
			session.beginTransaction();
			
//			save the student object
			session.save(student);
			
			
//			commit transaction
			session.getTransaction().commit();
			System.out.print("my data to create----->" + student + "with id: " + student.getId() + "\n");
			
			session.close();
			
//			read object from database
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student studentFromDatabase = session.get(Student.class, student.getId());
			System.out.println("is the object in database: " + session.contains(student) );
			Student newStudent = session.find(Student.class, 6);
			
			
			System.out.print("my data to read ----->" + studentFromDatabase + "with id: " + student.getId() + newStudent);
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
