package onetomany_uni_hibernate.controller;

import java.util.List;
import java.util.Scanner;

import javax.management.remote.rmi.RMIJRMPServerImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.ArrayList;

import onetomany_uni_hibernate.dao.CompanyDao;
import onetomany_uni_hibernate.dto.Company;
import onetomany_uni_hibernate.dto.Employee;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		CompanyDao companyDao= new CompanyDao();
		
		System.out.println("*******************");
		System.out.println("1. Insert TO Company");
		System.out.println("2. Update To Comapny");
		System.out.println("3. Fetch To Comapny");
		System.out.println("4. Delete To Company");
		System.out.println("4.Fetch All Company");
		System.out.println("6. Insert Employee to Comapny");
		System.out.println("7. Insert Multiple Employee to Comapny");
		System.out.println("8. delete Employee from Comapny");
		System.out.println("9. delete Multiple Employee from Comapny");
		System.out.println("*******************");
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.print("Enter a Choice : ");
		switch(sc.nextInt())
		{
		case 1:
			
				Employee emp1= new Employee();
				System.out.print("Enter Employee Id: ");
				emp1.setId(sc.nextInt());
				System.out.print("Enter Employee Name: ");
				emp1.setName(sc.next());
				System.out.print("Enter Employee Phone: ");
				emp1.setPhone(sc.nextLong());
				System.out.print("Enter Employee Location: ");
				emp1.setAddress(sc.next());
				
				Employee emp2= new Employee();
				System.out.print("Enter Employee Id: ");
				emp2.setId(sc.nextInt());
				System.out.print("Enter Employee Name: ");
				emp2.setName(sc.next());
				System.out.print("Enter Employee Phone: ");
				emp2.setPhone(sc.nextLong());
				System.out.print("Enter Employee Location: ");
				emp2.setAddress(sc.next());
				
				List<Employee> employeeList = new ArrayList<>();
				employeeList.add(emp1);
				employeeList.add(emp2);
				
			
			Company comp = new Company();
			System.out.print("Enter Company Id: ");
			comp.setId(sc.nextInt());
			System.out.print("Enter Company Name: ");
			comp.setName(sc.next());
			System.out.print("Enter Company Location : ");
			comp.setCity(sc.next());
			
			comp.setList(employeeList);
			
			companyDao.saveCompany(comp);
			break;
			
		case 2:
			//not Updating data
			System.out.print("Enter Compnay Id : ");
			int id = sc.nextInt();
			Company company = new Company();
			System.out.print("Enter new ID : ");
			company.setId(sc.nextInt());
			System.out.print("Enter new City : ");
			company.setCity(sc.next());
			System.out.print("Enter new Name : ");
			company.setName(sc.next());
;			companyDao.updateCompany(id,company);
			break;
		case 3:
			System.out.print("Enter Compnay Id : ");
			int id1 = sc.nextInt();
			companyDao.getCompanyById(id1);
			break;
		case 4:
			System.out.print("Enter Compnay Id : ");
			int id2 = sc.nextInt();
			companyDao.deleteCompany(id2);
			break;
		case 5:
			System.out.println(companyDao.getAllCompany());
			
			break;
		case 6:
			System.out.print("Enter Company Id : ");
			int id3 = sc.nextInt();
			Employee emp3 = new Employee();
			System.out.print("Enter Employee Id: ");
			emp3.setId(sc.nextInt());
			System.out.print("Enter Employee Name: ");
			emp3.setName(sc.next());
			System.out.print("Enter Employee Phone: ");
			emp3.setPhone(sc.nextLong());
			System.out.print("Enter Employee Location: ");
			emp3.setAddress(sc.next());
			List<Employee>list = new ArrayList<>();
			list.add(emp3);
			companyDao.insertEmployee(id3,list);
			break;
			
			
			
						
		case 7:
			System.out.print("Enter Id : ");
			int num2 = sc.nextInt();
//			companyDao.insertMultipleEmployee();
			break;
		case 8:
			System.out.print("Enter Company Id : ");
			int id4 = sc.nextInt();
			System.out.print("Enter Employee Id : ");
			int id5 = sc.nextInt();
			companyDao.deleteEmployee(id4,id5);
			break;
		case 9:
			System.out.print("Enter Id : ");
			int num4 = sc.nextInt();
//			companyDao.deleteMultipleEmployee();
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
		
		
		
//		Scanner sc= new Scanner(System.in);
//		
//		Company comp1 = new Company();
//		Employee emp1 = new Employee();
//		
//		emp1.setId(7);
//		emp1.setName("Shantanu");
//		emp1.setPhone(548793621);
//		emp1.setAddress("Pune");
//	
//		List<Employee> employeeList = new ArrayList<>();
//		employeeList.add(emp1);
//		
//	
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prasad");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		
//		
//	Company com = manager.find(Company.class, 1);
//	if(com!=null)
//	{
//		transaction.begin();
//		
//		comp1.setList(employeeList);
//		manager.merge(com1);
//		transaction.commit();
//	}
//	else {
//		System.out.println("Id Not Found");
//	}
//	
		
	}

}
