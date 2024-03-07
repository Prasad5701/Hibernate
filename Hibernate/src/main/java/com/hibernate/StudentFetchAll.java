package com.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.From;

import javax.persistence.Query;

import java.util.*;

public class StudentFetchAll {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager manager = factory.createEntityManager();
		
		
		Query query = manager.createQuery("SELECT s FROM Student s");
		
		List<Student>list = query.getResultList();
		
		System.out.println(list);
	}

}
