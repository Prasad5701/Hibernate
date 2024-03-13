package manytimanyunihibernate.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.security.auth.callback.LanguageCallback;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import manytimanyunihibernate.dao.LanguagesDao;
import manytimanyunihibernate.dao.PersonDao;
import manytimanyunihibernate.dto.Languages;
import manytimanyunihibernate.dto.Person;

public class Main {

	public static void main(String[] args) {

//		Languages lang = new Languages();
//		lang.setId(1);
//		lang.setName("Marathi");
//		lang.setOrigin("Maharashtra");
//
//		Languages lang1 = new Languages();
//		lang1.setId(4);
//		lang1.setName("Englist");
//		lang1.setOrigin("UK");
//		Languages lang2 = new Languages();
//		lang2.setId(2);
//		lang2.setName("Hindi");
//		lang2.setOrigin("India");
//		Languages lang3 = new Languages();
//		lang3.setId(3);
//		lang3.setName("kannada");
//		lang3.setOrigin("Karnataka");
//
//		List<Languages> list = new ArrayList<>();
//		list.add(lang3);
//		list.add(lang2);
//		list.add(lang1);
//		list.add(lang);
//
//		Person person = new Person();
//		person.setId(101);
//		person.setName("Prasad");
//		person.setPhone(987654321);
//		person.setAddress("Yeola");
//		person.setList(list);
//
//		List<Languages> list2 = new ArrayList<>();
//		list2.add(lang2);
//		list2.add(lang1);
//
//		Person person1 = new Person();
//		person1.setId(102);
//		person1.setName("Aditya");
//		person1.setPhone(654321987);
//		person1.setAddress("Shirdi");
//		person1.setList(list2);
//
//		List<Languages> list3 = new ArrayList<>();
//		list3.add(lang2);
//		list3.add(lang3);
//		list3.add(lang);
//
//		Person person2 = new Person();
//		person2.setId(103);
//		person2.setName("Tejas");
//		person2.setPhone(659874321);
//		person2.setAddress("Pune");
//		person2.setList(list3);
//
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//
//		transaction.begin();
//		manager.persist(lang);
//		manager.persist(lang1);
//		manager.persist(lang2);
//		manager.persist(lang3);
//		manager.persist(person);
//		manager.persist(person1);
//		manager.persist(person2);
//		transaction.commit();
		
//		next step
		
		
		
		
//		Languages lang = new Languages();
//		lang.setId(5);
//		lang.setName("Gujrati");
//		lang.setOrigin("Gujarat");
//		
//		Languages lang1 = new Languages();
//		lang1.setId(6);
//		lang1.setName("Tamil");
//		lang1.setOrigin("Tmail-Nadu");
//		
//		List<Languages> list = new ArrayList<>();
//		list.add(lang);
//		list.add(lang1);
//		
//		Person person = new Person();
//		person.setId(104);
//		person.setName("Prasad");
//		person.setPhone(987654321);
//		person.setAddress("Yeola");
//		person.setList(list);
//
////		List<Languages> list1 = new ArrayList<>();
////		list1.add(lang);
////		
////
////		Person person1 = new Person();
////		person1.setId(105);
////		person1.setName("Aditya");
////		person1.setPhone(654321987);
////		person1.setAddress("Shirdi");
////		person1.setList(list1);
//		
//		PersonDao personDao = new PersonDao();
//		personDao.savePerson(person);
		
		
		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("*******************");
		System.out.println("1. Insert Languages Data");
		System.out.println("2. Insert Persons Data");
		System.out.println("*******************");
		
		System.out.print("Enter Your Choice : ");
		
		switch(sc.nextInt())
		{
		case 1 :
			System.out.println("*******************");
			System.out.println("1. Insert Languages Data");
			System.out.println("2. Delete Languages ");
			System.out.println("3. Update Languages ");
			System.out.println("4. Fetch Languages ");
			System.out.println("5 Fetch All Languages ");
			System.out.println("*******************");
		
			
			
			System.out.print("Enter Your Choice : ");
			switch(sc.nextInt())
			{
			case 1:
				System.out.print("How Many Languages do you want to insert : ");
				int num = sc.nextInt();
				Languages [] lang = new Languages[num+1];
				for(int i=1;i<=num;i++)
				{
					
					lang[i] = new Languages();
					System.out.print("Enter Language ID : ");
					lang[i].setId(sc.nextInt());
					System.out.print("Enter Language Name : ");
					lang[i].setName(sc.next());
					System.out.print("Enter language Origin : ");
					lang[i].setOrigin(sc.next());
					LanguagesDao languagesDao = new LanguagesDao();				
					languagesDao.insertLanguages(lang[i]);
				}
				
//				LanguagesDao languagesDao = new LanguagesDao();
//				languagesDao.insertLanguages(lang);
				System.out.print("Saved Languages ");
						
				break;
			case 2:
				System.out.print("How Many Languages do you want to Delet : ");
				int num1 = sc.nextInt();
//				Languages [] lang1 = new Languages[num1+1];
				int [] ids = new int[num1+1] ;
				for(int i=1;i<=num1;i++)
				{
					System.out.print("Enter Language ID : ");
					ids[i]=sc.nextInt();
				}
				LanguagesDao languagesDao1 = new LanguagesDao();
				languagesDao1.deleteLanguages(ids);
				
				break;
			
			case 3:
				System.out.print("Enter Id you want to Update : ");
				int id1 =sc.nextInt();
				LanguagesDao languagesDao2 = new LanguagesDao();
				languagesDao2.updateLanguages(id1);
				break;
			
			case 4:
				System.out.print("Enter Id you want to Fetch : ");
				int id =sc.nextInt();
				LanguagesDao languagesDao3 = new LanguagesDao();
				languagesDao3.fetchLanguages(id);
				break;
			
			case 5:{
			
				LanguagesDao languagesDao4 = new LanguagesDao();
				languagesDao4.fetchAllLanguages();
				break;
			}
			default:
				System.out.print("Wrong Choice : ");
				break;
			}	
			break;
		case 2:
			System.out.println("*******************");
			System.out.println("1. Save Person Data With Existing languages");
			System.out.println("2. Delete Person ");
			System.out.println("3. Update Person ");
			System.out.println("4. Fetch Person ");
			System.out.println("5 Fetch All Person ");
			System.out.println("*******************");
			System.out.println();
			
			System.out.print("Enter Your Choice from Above :");
			int num = sc.nextInt();
			switch(num)
			{
			case 1:
			LanguagesDao languagesDao5 = new LanguagesDao();
			languagesDao5.fetchAllLanguages();
			Person person = new Person();
			
			System.out.print("How Many Languages do YOu Want to add :");
			int num1 = sc.nextInt();
			PersonDao personDao = new PersonDao();
			List<Languages> list = new ArrayList<Languages>();
			for(int i=1;i<=num1;i++)
			{
				System.out.print("Enter language Ids To Add :");
				int id = sc.nextInt();	
				list.add(personDao.fetchLanguage(id));
			}
			
			System.out.print("Enter Person id : ");
			person.setId(sc.nextInt());
			System.out.print("Enter Person Name : ");
			person.setName(sc.next());
			System.out.print("Enter Person Phone : ");
			person.setPhone(sc.nextLong());
			System.out.print("Enter Person Address : ");
			person.setAddress(sc.next());
			person.setList(list);
			
			personDao.savePerson(person);
				break;
			case 2:
				System.out.print("How Many Person do you want to delte: ");
				Integer num3 = sc.nextInt();
				for(int i=1;i<=num;i++)
				{
					System.out.print("Enter Person id you want to delte: ");
					int id2 = sc.nextInt();
					PersonDao personDao1 = new PersonDao();
					personDao1.deletPerson(id2);
				}
				System.out.println(num3 +" Deleted");
				
				break;
			case 3:
				System.out.print("Enter Person Id To Update Person: ");
				Integer id4 = sc.nextInt();
				PersonDao personDao5 = new PersonDao();
				personDao5.updatePerson(id4);
				break;
			case 4:
				System.out.print("Enter Person id you want to Fetch: ");
				int id2 = sc.nextInt();
				PersonDao personDao1 = new PersonDao();
				personDao1.fetchPerson(id2);
				break;
			case 5:
				PersonDao personDao2 = new PersonDao();
				personDao2.fetchAllPerson();
				break;
			default:
				System.out.println("Wrong Choice");
				break;
				
			}
			
				
			break;
		default :
			System.out.println("Wrong Choice");
			break;	
		}

		
		//add language remove language non owning side
	}
}
