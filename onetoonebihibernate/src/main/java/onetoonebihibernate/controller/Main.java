package onetoonebihibernate.controller;

import java.util.Scanner;
import onetoonebihibernate.dao.PersonDao;
import onetoonebihibernate.dao.AdharCardDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebihibernate.dto.AdharCard;
import onetoonebihibernate.dto.Person;

public class Main {
	
	public static void main(String[] args) {
		
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		
//		
//		Person person = new Person();
//		AdharCard adharCard = new AdharCard();
//		adharCard.setName("PrasadSomvanshi");
//		adharCard.setAddress("KarveNagarPune");
//		adharCard.setPerson(person);
//		
//		
//		
//		person.setName("Prasad");
//		person.setPhone(987654321);
//		person.setAddress("Pune");
//		person.setCard(adharCard);
//		
//		
//		
////		transaction.begin();
////		manager.persist(adharCard);
////		manager.persist(person);
////		transaction.commit();
//		
//		Person person1 =manager.find(Person.class, 1);
//		System.out.println(person1);
//		
//		AdharCard adharCard2 =manager.find(AdharCard.class, 1);
//		System.out.println(adharCard2);
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("*******************");
		System.out.println("1. Insert TO Person");
		System.out.println("2. Update To Person");
		System.out.println("3. Fetch To Person");
		System.out.println("4. Fetch All Person");
		System.out.println("5. Delete To Person");
		System.out.println("6. Delet TO AdharCard");
		System.out.println("7. fetch To AdharCard");
		System.out.println("8. update To AdharCard");
		System.out.println("9. Fetch All AdharData");
		System.out.println("*******************");
		
		System.out.println();
		System.out.println();
		
		
		PersonDao personDao = new PersonDao();
		AdharCardDao acd = new AdharCardDao();
		
		System.out.print("Enter a Number For your Choice : ");
		switch(sc.nextInt())
		{
		case 1:
			//insert
			AdharCard ac = new AdharCard();
			 System.out.print("Enter Adhar Name : ");
			 ac.setName(sc.next());
			 System.out.print("Enter Adhar  Address ");
			 ac.setAddress(sc.next());
			
			 
			 //insert
			 Person person =new Person();
			 System.out.print("Enter Person Name : ");
			 person.setName(sc.next());
			 System.out.print("Enter Person Phone : ");
			 person.setPhone(sc.nextLong());
			 System.out.print("Enter Person Address : ");
			 person.setAddress(sc.next());
			 
			 person.setCard(ac); 
			 ac.setPerson(person);
			 
			 personDao.savePerson(person);
			 
			break;
		case 2:
			 //update Person
			System.out.print("Enter Id You want to update : ");
			int id = sc.nextInt();
			 
			 personDao.updatePerson(id);
			break;
		case 3:
//			 fetch Person
			 System.out.print("Enter Id : ");
			 personDao.fetchPerson(sc.nextInt());
			break;
		case 4:
			// delete Person
			 System.out.print("Enter Id : ");
			 personDao.deletePerson(sc.nextInt());
			break;
		case 5:
			 personDao.fetchAllPerson();
			break;
		case 6:	 
			System.out.print("Enter Id : ");
			acd.deleteAdharCard(sc.nextInt());
			break;
		case 7:
			 System.out.print("Enter Id : ");
			 acd.fetchAdhar(sc.nextInt());
			break;
		case 8:
			System.out.print("Enter Adhar Id: ");
			acd.updateAdhar(sc.nextInt());
			break;
		case 9:
			acd.fetchAlladhar();
			break;
		default:
				System.out.println("Incorrect Choice");
			break;
			
		
		}
		
	}
	
	

}
