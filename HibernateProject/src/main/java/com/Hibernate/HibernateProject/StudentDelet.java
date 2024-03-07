package com.Hibernate.HibernateProject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentDelet {
	
	public static void main(String [] args)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rajat");
		EntityManager manager = factory.createEntityManager();
		
		Student student = manager.find(Student.class, 3);
		
		if(student != null)
		{
			
		}
	}

}
