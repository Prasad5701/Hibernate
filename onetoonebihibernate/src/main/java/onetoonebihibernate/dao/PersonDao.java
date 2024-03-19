package onetoonebihibernate.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetoonebihibernate.dto.AdharCard;
import onetoonebihibernate.dto.Person;

public class PersonDao {
	Scanner sc =new Scanner(System.in);
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();
	
	public void savePerson(Person person)
	{
		transaction.begin();
		manager.persist(person.getCard());
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
	public void fetchAllPerson()
	{
		
		Query query = manager.createQuery("SELECT p FROM Person p");
		List<Person> list = query.getResultList();
		System.out.println(list);
	
	}
	public void updatePerson(int id)
	{
		Person p1 = manager.find(Person.class, id);
		if(p1!=null)
		{
			transaction.begin();
			
			 System.out.print("Enter Person New Name : ");
			 p1.setName(sc.next());
			 System.out.print("Enter Person New Phone : ");
			 p1.setPhone(sc.nextLong());
			 System.out.print("Enter Person New Address : ");
			 p1.setAddress(sc.next());
			
//			 AdharCard aCard = new AdharCard();
//			 System.out.print("Enter adhar New Name : ");
//			 aCard.setName(sc.next());
//			 System.out.print("Enter Adhar New address : ");
//			 aCard.setAddress(sc.next());
			 
			 p1.setCard(p1.getCard());
//			 aCard.setPerson(p1);
//			 AdharCard acd = manager.find(AdharCard.class, id);
//			 if(acd!=null)
//			 {
//				 manager.merge(p1.getCard());
//			 }	 
			manager.merge(p1.getCard());
			manager.merge(p1);
			
			transaction.commit();
		}
		else 
		{
			System.out.println("Id not found");
		}
		
	}

}
