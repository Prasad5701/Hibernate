package com.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentFetch {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager eM = factory.createEntityManager();
		
		
		//Find() used to find find data OR//Used to Fetch Data from data base
		Student std = eM.find(Student.class, 3);
	
		
		if(std != null)
		{
			System.out.println(std);
		}
		else {
			System.out.println("Student with given id is not Present in DataBase");
		}
	}
}
