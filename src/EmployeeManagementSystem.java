import java.util.*;

public class EmployeeManagementSystem
{
static ArrayList<EmployeeManagementSystem> empList = new ArrayList<EmployeeManagementSystem>();
	
	static Scanner scan = new Scanner(System.in);
	static Scanner scan1 = new Scanner(System.in);
	private int id, age, salary;
	private String name;
	
	private static boolean signIn()
	{
		boolean isAuthenticate = false;
		
		System.out.print("Enter username: ");
		String username = scan.nextLine();
		System.out.println("Enter password: ");
		String password = scan.nextLine();
		
		// getting data from DB file.
		if(ReadPropertyFile.getProperty("username").equals(username))
		{
			if(ReadPropertyFile.getProperty("password").equals(password))
			{
				isAuthenticate = true;
			}
			else
			{
				System.out.print("Password incorrect!");
			}
		}
		else
		{
			System.out.print("Username not found!");
		}
		
		return isAuthenticate;
	}
	
	// Constructor
	EmployeeManagementSystem(int id, int age, int salary, String name)
	{
		this.id = id;
		this.age = age;
		this.salary = salary;
		this.name = name;
	}
	
	public int getid()
	{
		return id;
	}
	
	public int getage()
	{
		return age;
	}
	
	public int getsalary()
	{
		return salary;
	}
	
	public String getname()
	{
		return name;
	}
	
	private static void createEmployee()
	{
		System.out.print("\nEnter Employee ID: ");
		int empid = scan.nextInt();
		
		System.out.print("Enter Employee Name: ");
		String empname = scan1.nextLine();
		
		System.out.print("Enter Employee Age: ");
		int empage = scan.nextInt();
		
		System.out.print("Enter Employee Salary: ");
		int empsalary = scan.nextInt();
		
		empList.add(new EmployeeManagementSystem(empid, empage, empsalary, empname));
	}
	
	private static void searchEmployee()
	{
		System.out.print("Enter Employee ID: ");
		int id = scan.nextInt();

		for(EmployeeManagementSystem employee:empList)
		{
			if(employee.getid()==id)
			{
				System.out.println("ID     "+"Name     "+"Age     "+"Salary");
				System.out.print(employee.getid()+"   "+employee.getname()+"   "+employee.getage()+"   "+employee.getsalary()+"\n");
			}
		}
	}
	
	private static void deleteEmployee()
	{
		System.out.print("Enter employee ID you want to delete: ");
		int id = scan.nextInt();
		for(EmployeeManagementSystem employee:empList)
		{
			if(employee.getid()==id)
			{
				empList.remove(employee);
				System.out.print("Record deleted successfully!\n");
			}
		}
	}
	
	private static void display()
	{
		System.out.println("ID     "+"Name     "+"Age     "+"Salary");
		for(EmployeeManagementSystem employee:empList)
		{
			System.out.print(employee.id+"   "+employee.getname()+"   "+employee.getage()+"   "+employee.getsalary()+"\n");
		}
	}
	
	private static void UpdateEmployeeInfo()
	{
		System.out.print("Enter employee id to edit information: ");
		int id = scan.nextInt();
		for(EmployeeManagementSystem employee:empList)
		{
			if(employee.getid()==id)
			{
				System.out.print("Enter number which information you want to edit: \n1.Name \n2.Age \n3.Salary \nEnter your choice: ");
				int input = scan.nextInt();
				if(input==1)
				{
					System.out.print("Enter new name: ");
					employee.name=scan1.nextLine();
					System.out.print("Record Updated successfully!\n");
				}
				else if(input==2)
				{
					System.out.print("Enter new age: ");
					employee.age=scan.nextInt();
					System.out.print("Record Updated successfully!\n");
				}
				else if(input==3)
				{
					System.out.print("Enter new salary: ");
					employee.salary=scan.nextInt();
					System.out.print("Record Updated successfully!\n");
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		
		if(signIn()==true)
		{
			System.out.print("Successfully login!\n");
			boolean temp = true;
			while(temp)
			{
				System.out.print("\n                            You're Welcome on employee management portal ");
				System.out.print("\n1.Create Employee \n2.Search Employee \n3.Delete Employee \n4.Display All Record \n5.Update Employee Information \n6.Exit \n\nEnter your choise: ");
				int input = scan.nextInt();
				
				if(input==1)
				{
					createEmployee();
				}
				
				else if(input==2)
				{
					searchEmployee();
				}
				else if(input==3)
				{
					deleteEmployee();
				}
				else if(input==4)
				{
					display();
				}
				else if(input==5)
				{
					UpdateEmployeeInfo();
				}
				else if(input==6)
				{
					temp = false;
					System.out.println("Have a nice day!");
				}
				else
				{
					System.out.println("Please ensert valid number!");
				}
			}
		}
	}
}
