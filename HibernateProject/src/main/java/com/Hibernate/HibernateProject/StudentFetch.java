package com.Hibernate.HibernateProject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentFetch {
	
	public static void main(String []args)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rajat");
		EntityManager manager = factory.createEntityManager();
		
		Student student = manager .find(Student.class, 1);
		if(student !=null)
		{
		System.out.println(student);
		
		}
		else 
		{
			System.out.println("Stdeunt with given id not found");
		}
	}

}
