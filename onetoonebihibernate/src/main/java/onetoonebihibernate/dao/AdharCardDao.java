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
public class AdharCardDao {
	Scanner scanner = new Scanner(System.in);
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();
	public void deleteAdharCard(int id)
	{
		AdharCard adharCard = manager.find(AdharCard.class, id);
		if(adharCard!=null)
		{
			transaction.begin();
			manager.remove(adharCard.getPerson());
			manager.remove(adharCard);
			transaction.commit();
		}
		else 
		{
			System.out.println("Id not found");
		}
	}
	
	public void fetchAdhar(int id)
	{
		AdharCard person = manager.find(AdharCard.class, id);
		if(person!=null)
		{
			System.out.println(person);
		}
		else 
		{
			System.out.println("Id not found");
		}
		
	}
	public void updateAdhar(int id)
	{
		AdharCard a1 = manager.find(AdharCard.class, id);
		if(a1!=null)
		{		
			transaction.begin();
		
			System.out.print("Enter New Adhar name : ");
			 a1.setName(scanner.next());
			 System.out.print("Enter new adhar Address : ");
			 a1.setAddress(scanner.next());
			 Person pc = new Person(); 
			 a1.setPerson(a1.getPerson());
			manager.merge(a1);
			transaction.commit();
		}
		else 
		{
			System.out.println("Id not found");
		}
	}
	public void fetchAlladhar()
	{
		Query query = manager.createQuery("SELECT ac FROM AdharCard ac");
		List<AdharCard> list = query.getResultList();
		System.out.println(list);
	}


}
