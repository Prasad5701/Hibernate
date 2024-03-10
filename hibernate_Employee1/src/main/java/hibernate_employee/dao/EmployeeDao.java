package hibernate_employee.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.Query;
import javax.transaction.Transaction;

import java.util.Scanner;

import java.security.PublicKey;
import java.util.List;



import java.util.Scanner;
import hibernate_Employee1.dto.EmployeeHibernate;

public class EmployeeDao {
	
	
	public EntityManager getEntityManager()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager manager = factory.createEntityManager();
		
		return manager;
	}
	
	public void saveEmployee(EmployeeHibernate emp)
	{
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(emp);
		transaction.commit();
	}
	
	public void deletEmployee(int id)
	{
		EntityManager manager = getEntityManager();
		
		EmployeeHibernate emp=manager.find(EmployeeHibernate.class,  id);
		
		if(emp!=null)
		{
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(emp);
			transaction.commit();
			
		}
		else 
		{
			System.out.println("Id is Not Present");	
		}
	}
	
	public void updateEmployee(int id)
	{
		EntityManager manager = getEntityManager();
		EmployeeHibernate emp=manager.find(EmployeeHibernate.class, id );
		
		if(emp!=null)
		{
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter Name : ");
			emp.setName(sc.next());
			System.out.print("Enter Dept : ");
			emp.setDept(sc.next());
			System.out.print("Enter Phone : ");
			emp.setPhone(sc.nextLong());
			System.out.print("Enter Email : ");
			emp.setEmail(sc.next());
			System.out.print("Enter Salary : ");
			emp.setSalary(sc.nextDouble());
		
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(emp);
			transaction.commit();
			
		}
		else {
			System.out.println("Id Not Present");
		}
		
	}
	
	public void fetchById(int id)
	{
		EntityManager manager = getEntityManager();
		EmployeeHibernate emp=manager.find(EmployeeHibernate.class, id );
		
		if(emp!=null)
		{
			System.out.println(emp);
			
		}
		else {
			System.out.println("Id Not Found");
		}
		
		
	}
	
	public void fetchAll()
	{
		EntityManager manager = getEntityManager();
		
		Query query =  manager.createQuery("SELECT e FROM EmployeeHibernate e");
		
		List<EmployeeHibernate> list = query.getResultList();
		
		if(list.isEmpty())
		{
			System.out.println("Person Not Exist");
		}
		else {
			System.out.println(list);
		}
		
	}
	public void fetchByName(String name)
	{
		EntityManager manager = getEntityManager();
	
		Query query = manager.createQuery("SELECT e FROM EmployeeHibernate e where name =:name");
		
		query.setParameter("name", name);
		List<EmployeeHibernate>list = query.getResultList();
		if(list.isEmpty())
		{
			System.out.println("Person Not Exist");
		}
		else {
			System.out.println(list);
		}
		
	}
	public void fetchByDept(String dept)
	{
		EntityManager manager = getEntityManager();
	
		Query query = manager.createQuery("SELECT e FROM EmployeeHibernate e where dept =:dept");
		
		query.setParameter("dept", dept);
		List<EmployeeHibernate>list = query.getResultList();
		if(list.isEmpty())
		{
			System.out.println("Person Not Exist");
		}
		else {
			System.out.println(list);
		}
	}
	public void fetchByEmail(String email)
	{
		EntityManager manager = getEntityManager();
	
		Query query = manager.createQuery("SELECT e FROM EmployeeHibernate e where email =:email");
		
		query.setParameter("email", email);
		List<EmployeeHibernate>list = query.getResultList();
		if(list.isEmpty())
		{
			System.out.println("Person Not Exist");
		}
		else {
			System.out.println(list);
		}
	}
	public void fetchByPhone(long phone)
	{
		EntityManager manager = getEntityManager();
	
		Query query = manager.createQuery("SELECT e FROM EmployeeHibernate e where e.phone =?1");
		
		query.setParameter(1, phone);
		List<EmployeeHibernate>list = query.getResultList();
		if(list.isEmpty())
		{
			System.out.println("Person Not Exist");
		}
		else {
			System.out.println(list);
		}
	}
	public void fetchBySalary(double salary)
	{
		EntityManager manager = getEntityManager();
	
		Query query = manager.createQuery("SELECT e FROM EmployeeHibernate e where e.salary =?1");
		
		query.setParameter(1, salary);
		List<EmployeeHibernate>list = query.getResultList();
		if(list.isEmpty())
		{
			System.out.println("Person Not Exist");
		}
		else {
			System.out.println(list);
		}
	}
	
	public void updateEmail(int id)
	{
		EntityManager manager = getEntityManager();
		EmployeeHibernate emp=manager.find(EmployeeHibernate.class, id );
		EntityTransaction transaction = manager.getTransaction();
		
		
		if(emp!=null)
		{
			
			System.out.println(manager.find(EmployeeHibernate.class, id ));
				
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter New Email : ");
			emp.setEmail(sc.next());			
			
			transaction.begin();
			manager.merge(emp);
			transaction.commit();
			System.out.println("Email Updated Sucessfully Here is Your Data : ");
			System.out.println(manager.find(EmployeeHibernate.class, id ));
			
		}
		else {
			System.out.println("Id Not Present");
		}
	}
	
	
	public void updateName(int id)
	{
		EntityManager manager = getEntityManager();
		EmployeeHibernate emp=manager.find(EmployeeHibernate.class, id );
		EntityTransaction transaction = manager.getTransaction();
		
		
		if(emp!=null)
		{
			System.out.println(manager.find(EmployeeHibernate.class, id ));
			
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter New Name : ");
			emp.setName(sc.next());
					
			transaction.begin();
			manager.merge(emp);
			transaction.commit();
			System.out.println("Name is Updated Sucessfully Here is Your Data : ");
			System.out.println(manager.find(EmployeeHibernate.class, id ));
			
		}
		else {
			System.out.println("Id Not Present");
		}
		
		
	}
	public void updateDept(int id)
	{
		EntityManager manager = getEntityManager();
		EmployeeHibernate emp=manager.find(EmployeeHibernate.class, id );
		EntityTransaction transaction = manager.getTransaction();
		
		
		if(emp!=null)
		{
			System.out.println(manager.find(EmployeeHibernate.class, id ));
			
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter New Dept : ");
			emp.setDept(sc.next());					
			
			transaction.begin();
			manager.merge(emp);
			transaction.commit();
			System.out.println("Department is Updated Sucessfully Here is Your Data : ");
			System.out.println(manager.find(EmployeeHibernate.class, id ));
			
		}
		else {
			System.out.println("Id Not Present");
		}
		
	}
	
	public void updatePhone(int id)
	{
		EntityManager manager = getEntityManager();
		EmployeeHibernate emp=manager.find(EmployeeHibernate.class, id );
		EntityTransaction transaction = manager.getTransaction();
		
		
		if(emp!=null)
		{
			System.out.println(manager.find(EmployeeHibernate.class, id ));
			
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter New Phone : ");
			emp.setPhone(sc.nextLong());				
			
			transaction.begin();
			manager.merge(emp);
			transaction.commit();
			System.out.println("Phone Number is Updated Sucessfully Here is Your Data : ");
			System.out.println(manager.find(EmployeeHibernate.class, id ));
			
		}
		else {
			System.out.println("Id Not Present");
		}
		
	}

	public void updateSalary(int id) 
	{
		EntityManager manager = getEntityManager();
		EmployeeHibernate emp=manager.find(EmployeeHibernate.class, id );
		EntityTransaction transaction = manager.getTransaction();
		
		
		if(emp!=null)
		{
			System.out.println(manager.find(EmployeeHibernate.class, id )); 
			
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter New Salary : ");
			emp.setSalary(sc.nextDouble());
					
			transaction.begin();
			manager.merge(emp);
			transaction.commit();
			System.out.println("Salary is Updated Sucessfully Here is Your Data : ");
			System.out.println(manager.find(EmployeeHibernate.class, id ));
			
		}
		else {
			System.out.println("Id Not Present");
		}	
		
		
	}
	

	
}
