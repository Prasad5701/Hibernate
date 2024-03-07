package com.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

public class StudentByNonUnique {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager manager = factory.createEntityManager();
		
		
		Query query = manager.createQuery("SELECT s FROM Student s Where s.name=:name");
		
		query.setParameter("name", "Yash");
		List<Student>list = query.getResultList();
		
		if (list.isEmpty()) {
			
			System.out.println("No Data Found");	
		}
		else {			
			System.out.println(list);
		}
		
	
	}
}
