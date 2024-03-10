package onetoone_uni_hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone_uni_hibernate.dto.AdharCard;
import onetoone_uni_hibernate.dto.Person;

public class PersonDao {
	
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();
	
	public void savePerson(Person person)
	{
		transaction.begin();
		manager.persist(person.getAdharCard());
		manager.persist(person); 
		
		transaction.commit();
	}
	public void deletePerson(int id)
	{
		Person person = manager.find(Person.class, id);
		if(person!=null)
		{
			transaction.begin();
			manager.remove(person);
			transaction.commit();
		}
		else 
		{
			System.out.println("Id not found");
		}
	}
	public void fetchPerson(int id)
	{
		Person person = manager.find(Person.class, id);
		if(person!=null)
		{
			System.out.println(person);
		}
		else 
		{
			System.out.println("Id not found");
		}
		
	}
	public void updatePerson(int id,Person person)
	{
		Person p1 = manager.find(Person.class, id);
		if(p1!=null)
		{
			transaction.begin();
			person.setAdharCard(p1.getAdharCard());
			manager.merge(person);
			transaction.commit();
		}
		else 
		{
			System.out.println("Id not found");
		}
		
	}

	
}
