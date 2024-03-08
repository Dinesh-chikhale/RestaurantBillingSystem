package Main_Restaurant_App;
import java.util.*;

import Resto_Model.CustomerModel;
import Resto_Model.MenuModel;
import Resto_Model.TableModel;
import Resto_Services.CustomerService;
import Resto_Services.MenuService;
import Resto_Services.TableService;
public class MainApplication {

	
	public static void main(String x[])
	{
		MenuService mservice=new MenuService();
		MenuModel model=new MenuModel();
		TableService tservice=new TableService();
		Scanner s=new Scanner(System.in);
		int choice;
		do {
			System.out.println("Case 1:Admin Login");
			System.out.println("Case 2:Customer Login");
			System.out.println("Case 0:Exits Application");
			System.out.println("Enter your choice");
			 choice=s.nextInt();
			switch(choice)
			{
			case 1:
				s.nextLine();
				System.out.println("-_--_--_--_--_--_--_--_--_--_--_--_--_--_--_--_--_--_- ");
				System.out.println("---------------Welcome Our Restaurant ------------- ");
				System.out.println("\n\n");
				System.out.println("Enter the Admin UserName and Password");
				String username=s.nextLine();
				String password=s.nextLine();
				String user="admin";
				String pass="admin";
				if(user.equals(username) && pass.equals(password))
				{
					int ch;
					System.out.println("-------------------Login Sucessfully------------------------");
					System.out.println();
					do {
						System.out.println("Case 1: Food Menu");
						System.out.println("case 2: Add Tables Details");
						System.out.println("case 3: Add Customer Details");
						System.out.println("Case 4: Get Orders From Customer");
						System.out.println("Case 5: Calcuate bill of customer");
						System.out.println("Case 6: View date wise order list ");
						System.out.println("Case 7: View all customer ");
						System.out.println("Case 8: Search customer by name ");
						System.out.println("Case 9: View Table wise order ");
						System.out.println("Case 10: View Total Collection of the day ");
						System.out.println("Case 11: View All Customer date wise");
						System.out.println("Enter Zero for Exit");
						System.out.println();
						System.out.println("Enter your choice");
						ch=s.nextInt();
						switch(ch)
						{
						case 1:
							do {
								
								System.out.println("case 1:Add New Food In Menu");
								System.out.println("case 2:View Available Foods");
								System.out.println("case 3:Search Food by  Name");
								System.out.println("case 4:update food by Name");
								System.out.println("case 5:Delete Food by Name");
								System.out.println("Enter Zero For Exits");
								System.out.println("Enter Your Choice");
								ch=s.nextInt();
								switch(ch)
								{
								case 1:
									s.nextLine();
									System.out.println("Enter the food name");
									String name=s.nextLine();
									System.out.println("Enter the food price");
									int price=s.nextInt();
									model.setFname(name);
									model.setPrice(price);
									boolean b=mservice.isAddMenu(model);
									if(b)
									{
										System.out.println("Food Added Successfully");
									}
									else {
										System.out.println("Food Not Added Successfully");

									}
									break;
								case 2:
									b=mservice.ViewFood();
									break;
								case 3:
									s.nextLine();
									System.out.println("Enter food name for search ");
									name=s.nextLine();
									b=mservice.searchByName(name);
									if(b)
									{
										System.out.println("Food Found");
									}
									else {
										System.out.println("Food Not Found");
									}
									break;
								case 4:
									s.nextLine();
									System.out.println("Enter food name for update");
									name=s.nextLine();
									System.out.println("Enter food price for update");
									price=s.nextInt();
									model.setFname(name);
									model.setPrice(price);
									s.nextLine();
									System.out.println("Enter food name for Update");
									String update=s.nextLine();
									b=mservice.updateByName(model,update);
									if(b)
									{
										System.out.println("Updated Successfully......");
									}
									else {
										System.out.println("Some Problem is there.....");
									}
									
									
									break;
								case 5:
									s.nextLine();
									System.out.println("Enter food name for delete");
									String delete=s.nextLine();
									b=mservice.deleteByName(delete);
									if(b)
									{
										System.out.println("Delete Succesfully");
									}
									else {
										System.out.println(" Food Not Delete");
									}
									break;
								}
								
								
							}while(ch!=0);
							break;
						case 2:
							TableModel tmodel=new TableModel();
							System.out.println("Enter Add New Table");
							int no=s.nextInt();
							tmodel.setTableno(no);
							
							boolean b=tservice.isAddTable(tmodel);
							if(b)
							{
								System.out.println("Table Value Added Successfully");
							}
							else {
								System.out.println("Table Not Added");
							}
							
							break;
						case 3:
							s.nextLine();
							int adch;
							CustomerService cservice=new CustomerService();

							CustomerModel cmodel=new CustomerModel();
							do {
								System.out.println("case 1: Add New Customer");
								System.out.println("case 2: view Customer");
								System.out.println("case 3: Search Customer");
								System.out.println("case 4: Delete Customer");
								System.out.println("case 5: Update Customer");
								System.out.println("Enter zero for Exit");
								System.out.println("Enter your choice");
								adch=s.nextInt();
								switch(adch)
								{
								case 1:
									
									s.nextLine();
									String name,email,contact,address,date;
									System.out.println("Enter the Customer_Name");
									name=s.nextLine();
									System.out.println("Enter the Customer_Email");
									email=s.nextLine();
									System.out.println("Enter the Customer_Contact");
									contact=s.nextLine();
									System.out.println("Enter the Customer_Address");
									address=s.nextLine();
									System.out.println("Enter the year ,Month and day");
									date=s.nextLine();
									Date d=new Date(date);
									CustomerModel custmodel=new CustomerModel(name,email,contact,address,d);
									
									b=cservice.isAddCustomer(custmodel);
									if(b)
									{
										System.out.println("Customer Added Sucessfully");
									}
									else {
										System.out.println("Customer not Added");
									}
									
									
									break;
									
								case 2:
									cservice.viewCustomer(cmodel);

									break;
									
								case 3:
									s.nextLine();
									System.out.println("Enter the Customer Search name");
									name=s.nextLine();
									 b=cservice.SearchByName(name);
									if(b)
									{
										System.out.println("Customer Founded");
									}
									else {
										System.out.println("Customer Not Founded");
									}

									
									break;
								}
								
							}while(adch!=0);
							break;
						}
						
					}while(ch!=0);
					
				}
				else {
					System.out.println("please Enter the valid username and password");
				}
				break;
			case 2:
				s.nextLine();
				String custusername="customer";
				String custpass="customer";
				System.out.println("Enter the username and password for login");
				String cuser=s.nextLine();
				String cpass=s.nextLine();
				if((custusername.equals(cuser)) && custpass.equals(cpass))
				{
					int next;
					do {
						System.out.println();
						System.out.println("Case 1: Show Menu");
						System.out.println("Case 2: Show Tables");
						System.out.println("Enter zero for Exit");
						System.out.println("enter Your Choice");
						next=s.nextInt();
						switch(next)
						{
						case 1:
							mservice.ViewFood();
							break;
							
						case 2:
							tservice.viewTable();
							break;
							
						}
						
					}while(next!=0);
				}
				else {
					System.out.println("please Enter the valid username and password");
				}
				break;
			}
			
		}while(choice!=0);
	}
}
