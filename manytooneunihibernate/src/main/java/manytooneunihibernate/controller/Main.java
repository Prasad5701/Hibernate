package manytooneunihibernate.controller;

import java.util.Scanner;

import manytooneunihibernate.dao.StudentDao;
import manytooneunihibernate.dto.College;
import manytooneunihibernate.dto.Student;


public class Main {

	
	public static void main(String[] args) {
		System.out.println("*******************");
		System.out.println("1. Insert TO Student");
		System.out.println("2. Update To Student");
		System.out.println("3. Fetch To Student");
		System.out.println("4. Delete To Student");
		System.out.println("4.Fetch All Student");
		System.out.println("6. Insert Employee to Comapny");
		System.out.println("7. Insert Multiple Employee to Comapny");
		System.out.println("8. delete Employee from Comapny");
		System.out.println("9. delete Multiple Employee from Comapny");
		System.out.println("*******************");
		System.out.println();
		System.out.println();
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter your Choice : ");
		switch(sc.nextInt())
		{
		case 1:
			
			College col = new College();
			System.out.print("Enter College Id : ");
			col.setId(sc.nextInt());
			System.out.print("Enter College Name : ");
			col.setName(sc.next());
			System.out.print("Enter College City : ");
			col.setCity(sc.next());
			
			Student emp1= new Student();
			System.out.print("Enter Student Id: ");
			emp1.setId(sc.nextInt());
			System.out.print("Enter Student Name: ");
			emp1.setName(sc.next());
			System.out.print("Enter Student Phone: ");
			emp1.setPhone(sc.nextLong());
			System.out.print("Enter Student Department: ");
			emp1.setDept(sc.next());
			
			emp1.setCollege(col);
			
//			Student emp2= new Student();
//			System.out.print("Enter Student Id: ");
//			emp2.setId(sc.nextInt());
//			System.out.print("Enter Student Name: ");
//			emp2.setName(sc.next());
//			System.out.print("Enter Student Phone: ");
//			emp2.setPhone(sc.nextLong());
//			System.out.print("Enter Student Department: ");
//			emp2.setDept(sc.next());
//			emp1.setCollege(col);
			
			StudentDao crud = new StudentDao();
			crud.saveStudent(emp1);
			break;
		case 2:
			
			break;
		case 3:
			
			break;
			
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		default:
			break;
		
		
		}
	}
	
}
