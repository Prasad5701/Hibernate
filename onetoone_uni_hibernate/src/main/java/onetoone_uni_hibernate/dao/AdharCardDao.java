package onetoone_uni_hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone_uni_hibernate.dto.AdharCard;
import onetoone_uni_hibernate.dto.Person;

public class AdharCardDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
	EntityManager manager = factory.createEntityManager();
	
	EntityTransaction transaction = manager.getTransaction();
	public void deleteAdharCard(int id)
	{
		AdharCard adharCard = manager.find(AdharCard.class, id);
		if(adharCard!=null)
		{
			transaction.begin();
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
			AdharCard ac = new AdharCard();
			 ac.setId(104);
			 ac.setName("Sanskruti");
			 ac.setAddress("Nashik");
			manager.merge(ac);
			transaction.commit();
		}
		else 
		{
			System.out.println("Id not found");
		}
	}

}

