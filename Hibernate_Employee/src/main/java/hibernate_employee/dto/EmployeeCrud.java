package hibernate_employee.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeeCrud {
	int id;
	String name ;
	String dept ;
	long phone;
	String email;
	EmployeeCrud(int id,String name,String dept,long phone, String email)
	{
		this.id=id;
		this.name=name;
		this.dept=dept;
		this.phone=phone;
		this.email=email;
		
	}

	public void insert()
	{
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager  manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		Employee emp = new Employee();
		
		emp.setId(id);
		emp.setName(name);
		emp.setDept(dept);
		emp.setPhone(phone);
		emp.setEmail(email);
		
		transaction.begin();
		manager.persist(emp);
		transaction.commit();
		
	}
	
	public void delet()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager  manager = factory.createEntityManager();
		
		
		
		Employee emp = manager.find(Employee.class, id);
		
		
		if(emp!=null)
		{
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(emp);
			transaction.commit();
			
		}
		else {
			System.out.println("Id Not Present");
		}
		
	}
	public void fetch()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager manager = factory.createEntityManager();
		
		Employee emp = manager.find(Employee.class, 1);
		if(emp!=null)
		{
			System.out.println(emp);
		}
		else 
		{
			System.out.println("Given id is not Present");
		}
		
	}
	public void update()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager  manager = factory.createEntityManager();
		
		
		
		Employee emp = manager.find(Employee.class, 1);
		
		
		if(emp!=null)
		{
			emp.setDept("Testing");
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(emp);
			transaction.commit();
			
		}
		else {
			System.out.println("Id Not Present");
		}
		
		
	}
	
	public void fetchAll()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager  manager = factory.createEntityManager();
		
		Query query = manager.createQuery("Select s FROM Employee s");
		
		List<Employee> list = query.getResultList();
		
		System.out.println(list);
		
	}
	
	public void fetchByName()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager  manager = factory.createEntityManager();
		
		Query query = manager.createQuery("Select s FROM Employee s where name=:name");
		
		query.setParameter("name", "prasad");
		
		List<Employee> list = query.getResultList();
		
		if(list.isEmpty())
		{
			System.out.println("Person Not Exist");
		}
		else {
			System.out.println(list);
		}
		
	}
	

}
