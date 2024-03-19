package onetomany_uni_hibernate.dao;
import javax.persistence.Entity;

import java.awt.dnd.DropTargetListener;

//import javax.naming.ldap.ManageReferralControl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import onetomany_uni_hibernate.dto.Company;
import onetomany_uni_hibernate.dto.Employee;


public class CompanyDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prasad");
		EntityManager manager=entityManagerFactory.createEntityManager();

		return manager ;
	}

	public void saveCompany(Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		List<Employee> list = company.getList();
		for (Employee employee : list) {
			entityManager.persist(employee);
		}
		entityManager.persist(company);
		entityTransaction.commit();
		System.out.println("Saved successful");
	}
	public void updateCompany(int id,Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Scanner sc= new Scanner(System.in);
		Company receivedcompany = entityManager.find(Company.class, id);
		if (receivedcompany != null) {
			
			company.setList(receivedcompany.getList());
			
			entityTransaction.begin();
			entityManager.merge(company);
			entityTransaction.commit();
			System.out.println("Update Successful");
		} else {
			System.out.println("The Company doesn't exist");
		}

	}

	public void deleteCompany(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Company company = entityManager.find(Company.class, id);

		entityTransaction.begin();
		entityManager.remove(company);
		entityTransaction.commit();
		System.out.println("Delete Successful");
	}

	public Company getCompanyById(int id) {
		EntityManager entityManager = getEntityManager();
		Company company = entityManager.find(Company.class, id);
		return company;
	}

	public List<Company> getAllCompany() {
		EntityManager entityManager = getEntityManager();
		Query query =  entityManager.createQuery("SELECT c FROM Company c");
		List<Company> list = query.getResultList();
		return list;
	}
	
	//Completed till here
	
	
	public void insertEmployee(int id,List list)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Company company = entityManager.find(Company.class, id);
		
		if(company!=null)
		{
			company.setList(list);
			entityTransaction.begin();
			entityManager.persist(company);
			entityTransaction.commit();
			
			System.out.println("Update Successful");
			
		}
		else {
			System.out.println("Company not found");
		}
		
	}
	public void deleteEmployee(int cId,int eId)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Company company = entityManager.find(Company.class, cId);
		if(company!=null)
		{
			Employee emp = entityManager.find(Employee.class, eId);
			if(emp!=null)
			{
				
				entityTransaction.begin();
				entityManager.remove(emp);
				entityTransaction.commit();
			}
			
		}
		else {
			System.out.println("Company not found");
		}
		
		
	}

}



