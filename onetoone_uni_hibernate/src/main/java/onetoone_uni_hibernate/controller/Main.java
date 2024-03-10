
package onetoone_uni_hibernate.controller;

import java.nio.channels.AcceptPendingException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone_uni_hibernate.dao.AdharCardDao;
import onetoone_uni_hibernate.dao.PersonDao;
import onetoone_uni_hibernate.dto.AdharCard;
import onetoone_uni_hibernate.dto.Person;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("*******************");
		System.out.println("1. Insert TO Person");
		System.out.println("2. Update To Person");
		System.out.println("3. Fetch To Person");
		System.out.println("4. Delete To Person");
		System.out.println("5. Delet TO AdharCard");
		System.out.println("6. fetch To AdharCard");
		System.out.println("7. update To AdharCard");
		System.out.println("*******************");
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		PersonDao personDao = new PersonDao();
		AdharCardDao acd = new AdharCardDao();
		
		System.out.print("Enter a Number : ");
		switch(sc.nextInt())
		{
		case 1:
			//insert
			AdharCard ac = new AdharCard();
			 ac.setId(101);
			 ac.setName("Prasad");
			 ac.setAddress("Pune");
			 
			 //insert
			 Person person =new Person();
			 person.setId(1);
			 person.setName("Prasad");
			 person.setPhone(948765321);
			 person.setAddress("Pune");
			 person.setAdharCard(ac);
			 
			 
			 personDao.savePerson(person);
			break;
		case 2:
			 //update
			 
			 Person person1 =new Person();
			 person1.setId(2);
			 person1.setName("Sanket");
			 person1.setPhone(215432932);
			 person1.setAddress("KarveNagar");
			 personDao.updatePerson(2,person1);
			break;
		case 3:
//			 fetch
			 System.out.print("Enter Id : ");
			 personDao.fetchPerson(sc.nextInt());
			break;
		case 4:
			// delete
			 System.out.print("Enter Id : ");
			 personDao.deletePerson(sc.nextInt());
			break;
		case 5:
			 
			System.out.print("Enter Id : ");
			acd.deleteAdharCard(sc.nextInt());
			break;
		case 6:
			 System.out.print("Enter Id : ");
			 acd.fetchAdhar(sc.nextInt());
			break;
		case 7:
		
			System.out.print("Enter Adhar Id: ");
			acd.updateAdhar(sc.nextInt());
			break;
		default:
				System.out.println("Incorrect Choice");
			break;
			
		
		}
		

	
		
		
	 
//	 EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
//	 EntityManager manager = factory.createEntityManager();
//	 
//	 
//	 EntityTransaction transaction = manager.getTransaction();
//	 
//	 transaction.begin();
//	 manager.persist(ac);
//	 manager.persist(person);
//
//	 transaction.commit();
	 
	 
	}
	
}
