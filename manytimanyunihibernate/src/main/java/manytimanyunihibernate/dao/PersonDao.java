package manytimanyunihibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.xml.bind.v2.schemagen.xmlschema.Import;

import java.util.List;
import java.util.Scanner;

import manytimanyunihibernate.dto.Languages;
import manytimanyunihibernate.dto.Person;

public class PersonDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
	EntityManager manager = factory.createEntityManager();
	
	
	public void savePerson(Person person)
	{
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		List<Languages> list = person.getList();
		for(Languages lang:list)
		{
			manager.persist(lang);
			
		}
		manager.persist(person);
		transaction.commit();
	}
	public Languages fetchLanguage(int id)
	{
		Languages lang = manager.find(Languages.class, id);
		
		return lang;
	}
	public void deletPerson(int id)
	{
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Person person= manager.find(Person.class, id);
		if(person!=null)
		{
//			List<Languages> list = person.getList();
//			for(Languages lang:list)
//			{
//				manager.remove(lang);
//				
//			}
			manager.remove(person);
		}
		else {
			System.out.println("Id "+id+" not Found");
		}
		transaction.commit();
		
	}
	public void updatePerson(int id)
	{
		Scanner sc = new Scanner(System.in);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Person person= manager.find(Person.class, id);
		if(person!=null)
		{
			person.setId(id);
			System.out.print("Enter New Name : ");
			person.setName(sc.next());
			System.out.print("Enter New Address : ");
			person.setAddress(sc.next());
			System.out.print("Enter New Phone : ");
			person.setPhone(sc.nextLong());
			person.setList(person.getList());
		}
		else {
			System.out.println("Id "+id+" not Found");
		
		}
		
	}
	public void fetchPerson(int id)
	{
		Person person= manager.find(Person.class, id);
		System.out.println(person);
	}
	public void fetchAllPerson()
	{
		Query query = manager.createQuery("SELECT p From Person p");
		
		List<Person> list = query.getResultList();
		System.out.println(list);
		
	}
}
