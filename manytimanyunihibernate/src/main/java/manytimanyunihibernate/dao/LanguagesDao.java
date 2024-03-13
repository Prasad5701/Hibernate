package manytimanyunihibernate.dao;

import javax.naming.ldap.ManageReferralControl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import manytimanyunihibernate.dto.Languages;


public class LanguagesDao {
	
	Scanner scanner =new Scanner(System.in);
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
	EntityManager manager = factory.createEntityManager();
	
	public void insertLanguages(Languages lang)
	{
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
//		for(Languages lang1: lang)
//		{
//		}
		manager.persist(lang);
		transaction.commit();
	}
	public void deleteLanguages(int []ids) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		for(int id: ids)
		{
			Languages lang = manager.find(Languages.class, id);
			if(lang!=null)
			{
				manager.remove(lang);
				System.out.println("Id "+id+" is Deleted");
			}
			else {
				System.out.println("Id "+id+" not Found");
			}
		}
		
		transaction.commit();
	}
	public void fetchLanguages(int id) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Languages lang = manager.find(Languages.class, id);
		if(lang!=null)
		{
			System.out.println(lang);
		}
		else {
			System.out.println("Id "+id+" not Found");
		}
		transaction.commit();
	}
	public void fetchAllLanguages() {
//		EntityTransaction transaction = manager.getTransaction();
//		transaction.begin();
		Query query = manager.createQuery("SELECT l From Languages l");
		
		List<Languages> list = query.getResultList();
		System.out.println(list);
		
//		transaction.commit();
		
		
	}
	public void updateLanguages(int id) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Languages lang = manager.find(Languages.class, id);
		if(lang!=null)
		{
			System.out.print("Enter New Id to Update : ");
			int id1= scanner.nextInt();
			lang.setId(id1);
			System.out.print("Enter New Name to Update : ");
			String name =scanner.next();
			lang.setName(name);
			System.out.print("Enter Origin to Update : ");
			String origin = scanner.next();
			lang.setOrigin(origin);
		}
		else {
			System.out.println("Id "+id+" not Found");
		}
		System.out.println("Id "+id+" Updated");
		transaction.commit();
	}
	
}
