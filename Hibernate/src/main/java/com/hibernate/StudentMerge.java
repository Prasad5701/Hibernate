package com.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.dialect.identity.JDataStoreIdentityColumnSupport;

public class StudentMerge {
	
	public static void main(String[] args) {
		
		//Update Whole Data / All Columns
		
		//Merge() performs Both Insertion new Data and 
		//Updating Specific data According to Condition
		
		Student std = new Student();
		std.setId(6);
		std.setName("Prasad");
		std.setPhone(234253634);
		std.setEmail("pr@gmail.com");
		std.setAddress("Nashik");
		std.setMarks(67.8);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager manager = factory.createEntityManager();
		
	
		EntityTransaction transaction = manager.getTransaction();
			
			transaction.begin();
			manager.merge(std);  //here Merge() performs Inserting data
			transaction.commit();
		
		
		
//		//Updating Specific Data/Column
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
//		EntityManager manager = factory.createEntityManager();
//		
//		Student std1 = manager.find(Student.class, 3);
//		
//		if(std1 != null)
//		{
//			std1.setPhone(657489394);
//			std1.setMarks(79.9);
//			
//			EntityTransaction transaction = manager.getTransaction();
//			
//			transaction.begin();
//			manager.merge(std1); //here Merge() updating Specific columns
//			transaction.commit();
//			
//		}
//		else {
//			System.out.println("Student with Given Id is Not Present");
//		}
		
	}

}
