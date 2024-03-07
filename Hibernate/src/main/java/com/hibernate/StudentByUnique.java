package com.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class StudentByUnique {
	
	public static void main(String[] args) {
		
		//By Phone Number
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager manager = factory.createEntityManager();
		
		
		String jpql = "SELECT s FROM Student s WHERE s.phone=?1"; //**********************
		
		Query query =  manager.createQuery(jpql);
		query.setParameter(1,876543213);
		
		try {
			Student stud = (Student)query.getSingleResult();
			 System.out.println(stud);
			
		} catch (Exception e) {
			System.out.println("No Student Found");
		}
		 
		
//		//By Email
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
//		EntityManager manager = factory.createEntityManager();
//		
//		Query query = manager.createQuery("SELECT s FROM Student s WHERE s.email=:email"); //**********
//		query.setParameter("email", "a@gmail.com");
//		
//		
//		
//		try {
//			Student stud	= (Student) query.getSingleResult();
//			System.out.println(stud);
//			
//		} catch (Exception e) {
//			System.out.println("No Student Found");
//		}
		
		
		
		 
	}

}
