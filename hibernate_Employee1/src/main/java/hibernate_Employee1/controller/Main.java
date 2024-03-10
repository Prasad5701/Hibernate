package hibernate_Employee1.controller;

import java.util.Scanner;

import hibernate_Employee1.dto.EmployeeHibernate;
import hibernate_employee.dao.EmployeeDao;


public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("*************************");
	System.out.println("1: Insert data");
	System.out.println("2: Delet data with Id");
	System.out.println("3: Update data With ID");
	System.out.println("4: Fetch data with ID");
	System.out.println("5: FetchAll data");
	System.out.println("6: Fetch data by Name");
	System.out.println("7: Fetch data by dept");
	System.out.println("8: Fetch data by email");
	System.out.println("9: Fetch data by phone");
	System.out.println("10: Fetch data by Salary");
	System.out.println("11: Update data Email");
	System.out.println("12: Update data Name");
	System.out.println("13: Update data Dept");
	System.out.println("14: Update data Phone");
	System.out.println("15: Update data Salary");
	System.out.println("*************************");
	System.out.println();
	System.out.println();
	System.out.print(" Enter Your Choice: "); 
	
	EmployeeHibernate emp = new EmployeeHibernate(); 
	EmployeeDao employeeDao=new EmployeeDao();
	
	
	
	switch(sc.nextInt())
	{
	case 1: System.out.println("Insert Data");
			System.out.print("Enter Id : ");
			int id = sc.nextInt();
			emp.setId(id);
			System.out.print("Enter Name : ");
			String name = sc.next();
			emp.setName(name);
			System.out.print("Enter Dept : ");
			String dept = sc.next();
			emp.setDept(dept);
			System.out.print("Enter Phone : ");
			long phone = sc.nextLong();
			emp.setPhone(phone);
			System.out.print("Enter Email : ");
			String email = sc.next();
			emp.setEmail(email);
			System.out.print("Enter Salary : ");
			double sal = sc.nextDouble();
			emp.setSalary(sal);
			
			employeeDao.saveEmployee(emp);
	
	break;
	
	case 2 :
		System.out.print("Enter Id : ");
		employeeDao.deletEmployee(sc.nextInt());
		
		break;
	case 3 :
		
		System.out.print("Enter Id to Update : ");
		employeeDao.updateEmployee(sc.nextInt());
		break;
	case 4: 
		System.out.print("Enter Id to Fetch: ");
		employeeDao.fetchById(sc.nextInt());
		break;
	case 5: 
		employeeDao.fetchAll();
		break;
	case 6: 
		System.out.print("Enter Name : ");
		employeeDao.fetchByName(sc.next());
		break;
	case 7:
		System.out.println("Enter Dept : ");
		employeeDao.fetchByName(sc.next());
		break;
	case 8:
		System.out.print("Enter Email : ");
		employeeDao.fetchByEmail(sc.next());
		break;
	case 9:
		System.out.print("Enter Phone : ");
		employeeDao.fetchByPhone(sc.nextLong());
		break;
	case 10:
		System.out.print("Enter salary : ");
		employeeDao.fetchBySalary(sc.nextDouble());
		break;
	case 11:
		System.out.print("Enter Id : ");
		employeeDao.updateEmail(sc.nextInt());
		
		break;
	case 12:
		System.out.print("Enter Id : ");
		employeeDao.updateName(sc.nextInt());
		break;
	case 13:
		System.out.print("Enter Id : ");
		employeeDao.updateDept(sc.nextInt());
		break;
	case 14:
		System.out.print("Enter Id : ");
		employeeDao.updatePhone(sc.nextInt());
		break;
	case 15:
		System.out.print("Enter Id : ");
		employeeDao.updateSalary(sc.nextInt());
		break;
		
	default : 
	{
		System.out.println("Enteres Wrong Choice");
		break;
	}

	}
}
}
