package hibernate_employee.dto;
import java.util.*;
public class Controller {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("*************************");
		System.out.println("1: Insert data");
		System.out.println("2: Delet data with Id");
		System.out.println("3: Update data With ID");
		System.out.println("4: Fetch data with ID");
		System.out.println("5: FetchAll data");
		System.out.println("6: Fetch data by Name");
		System.out.println("*************************");
		System.out.println();
		System.out.println();
		System.out.print(" Enter Your Choice: ");
		int num = sc.nextInt();
		
		
		EmployeeCrud crud= new EmployeeCrud(num, null, null, num, null);
		switch(num)
		{
		case 1: System.out.println("Insert Data");
				System.out.print("Enter Id : ");
				int id = sc.nextInt();
				System.out.print("Enter Name : ");
				String name = sc.next();
				System.out.print("Enter Dept : ");
				String dept = sc.next();
				System.out.print("Enter Phone : ");
				long phone = sc.nextLong();
				System.out.print("Enter Email : ");
				String email = sc.next();
				
				
				EmployeeCrud crud1 = new EmployeeCrud(id, name, dept, phone, email);
				crud1.insert();
		
		
		break;
		case 2: System.out.println("Delet Data");
				System.out.print("Enter Id : ");
				int id1 = sc.nextInt();
				EmployeeCrud crud2= new EmployeeCrud(id1, null, null, num, null);
				crud2.delet();

		
		break;
		case 3: System.out.println("Update Data");
				crud.update();
		
		break;
		case 4: System.out.println("Fetch data with Id");
				crud.fetch();
		
		break;
		case 5: System.out.println("fetch All data");
			crud.fetchAll();
				
		break;
		case 6: System.out.println("Fetch data by name");
				crud.fetchByName();
		
		break;
		
		default: System.out.println("Entered Wrong choice ");
		break;
	
		}
		
		
	}

}
