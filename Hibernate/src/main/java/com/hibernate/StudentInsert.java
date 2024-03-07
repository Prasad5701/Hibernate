package com.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentInsert {

	
	public static void main(String []args)
	{
		Student std = new Student();
		std.setId(1);
		std.setName("Prasad");
		std.setPhone(1987654334);
		std.setEmail("P@gmail.com");
		std.setAddress("pune");
		std.setMarks(78.34);
		
		Student std1 = new Student();
		std1.setId(2);
		std1.setName("Aditya");
		std1.setPhone(876543213);
		std1.setEmail("a@gmail.com");
		std1.setAddress("Shirdi");
		std1.setMarks(90.40);
		
		Student std2 = new Student();
		std2.setId(3);
		std2.setName("Tejas");
		std2.setPhone(433434363);
		std2.setEmail("t@gmail.com");
		std2.setAddress("Yeola");
		std2.setMarks(95.0);
		
		Student std3 = new Student();
		std3.setId(4);
		std3.setName("Shantanu");
		std3.setPhone(655443672);
		std3.setEmail("s@gmail.com");
		std3.setAddress("Warje");
		std3.setMarks(83.45);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager eM  = factory.createEntityManager();
		EntityTransaction  eT = eM.getTransaction();
			
		eT.begin();
		
//		persist() is used to insert
		
		eM.persist(std);
		eM.persist(std1);
		eM.persist(std2);
		eM.persist(std3);
		
		eT.commit();
		
	}
}
