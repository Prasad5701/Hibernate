package manytooneunihibernate.dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytooneunihibernate.dto.Student;

public class StudentDao {
	
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	

	public void saveStudent(Student emp1) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(emp1);
		transaction.commit();
	}
	public void fetchStudent()
	{
		//fetch perticilar stduent
	}
	public void fetchAllStduent()
	{
		//fetch all student of perticular college id based on College id
	}
	
	public void updateStudent()
	{
		//update student data
	}
	public void deleteStudent()
	{
	
		//delete student from perticular college
	}
	public void deleteMultiStudent()
	{
		//delete multiple data from perticilar college based on College id
		
	}
	public void insertStudent()
	{
		//insert Stduent data in existing College
	}
	public void insertMultiStudent()
	{
		//insert multiple student into existing collge
	}
	

}
