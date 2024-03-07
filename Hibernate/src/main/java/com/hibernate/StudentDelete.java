package com.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.border.EtchedBorder;

public class StudentDelete {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager eM  = factory.createEntityManager();
		
		Student std	= eM.find(Student.class, 4);
		
		if(std!=null)
		{
			EntityTransaction eT	= eM.getTransaction();
			
			eT.begin();
			
			eM.remove(std);
			eT.commit();
		}
		else {
			System.out.println("Student with given Id is Not Pressent");
		}
	}

}
