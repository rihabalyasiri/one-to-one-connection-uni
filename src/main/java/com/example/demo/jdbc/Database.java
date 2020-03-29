package com.example.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class Database {

	public static void main(String[] args) {
		String jdbc = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "********";
		try {
			System.out.println("connecting to database" +jdbc);
			Connection connection = DriverManager.getConnection(jdbc,user,pass);
			System.out.println("connected successful");
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
