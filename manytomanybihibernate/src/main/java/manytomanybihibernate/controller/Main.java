package manytomanybihibernate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybihibernate.dto.Course;
import manytomanybihibernate.dto.Student;

public class Main {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Student std = new Student();
		std.setName("Prasad");
		std.setAddress("Pune");;
		std.setPhone(987654321);
		
		Student std1 = new Student();
		std1.setName("Aditya");
		std1.setAddress("Shirdi");;
		std1.setPhone(654329871);
		
		Student std2 = new Student();
		std2.setName("Tejas");
		std2.setAddress("Yeola");;
		std2.setPhone(765432198);
		
		
		
		
		Course cus = new Course();
		cus.setName("SQL");
		cus.setFee(8000);
		cus.setDuration(2);
//		cus.setList(std);
		
		Course cus1 = new Course();
		cus1.setName("Java");
		cus1.setFee(15000);
		cus1.setDuration(4);
//		cus2.setList(std);
		
		Course cus2 = new Course();
		cus2.setName("J2EE");
		cus2.setFee(15000);
		cus2.setDuration(2);
//		cus2.setList(std);
		
		Course cus3 = new Course();
		cus3.setName("Selenium");
		cus3.setFee(15000);
		cus3.setDuration(2);
		
		
		//Studnet
		List<Course>list1 = new ArrayList<>();
		list1.add(cus);
		list1.add(cus1);
		list1.add(cus2);
		
		List<Course>list2 = new ArrayList<>();
		list2.add(cus);
		list2.add(cus1);
		list2.add(cus3);
		
		std.setCourse(list1);
		std1.setCourse(list1);
		std2.setCourse(list2);
		
		
		//Course
		List<Student>list3 = new ArrayList<>();
		list3.add(std);
		list3.add(std1);
		list3.add(std2);
		
		List<Student>list4 = new ArrayList<>();
		list4.add(std);
		list4.add(std1);
		
		List<Student>list5 = new ArrayList<>();
		list5.add(std2);
		
		cus.setList(list3);
		cus1.setList(list3);
		cus2.setList(list4);
		cus3.setList(list5);
		
		transaction.begin();
		manager.persist(std);
		manager.persist(std1);
		manager.persist(std2);
		manager.persist(cus);
		manager.persist(cus1);
		manager.persist(cus2);
		manager.persist(cus3);
		transaction.commit();
		
	}

}
