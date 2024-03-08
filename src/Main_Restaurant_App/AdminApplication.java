package Main_Restaurant_App;
import java.util.*;

import Resto_Model.CustomerModel;
import Resto_Services.CustomerService;
import Resto_Services.ViewCustomerServices;
public class AdminApplication {

	@SuppressWarnings({ "unused", "deprecation", "resource" })
	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		
			do {
				CustomerService cservice=new CustomerService();

				CustomerModel cmodel=new CustomerModel();
				
				System.out.println("Case 1: Add New Table in hotel /View All Tables/Delete Table ");
				System.out.println("Case 2: Add New Customer/view customer / search/delete/update ");
				int choice;
				choice=s.nextInt();
				switch(choice)
				{
				case 1:
					int cho;
					do {
						System.out.println("case 1: Add New Table in hotel");
						System.out.println("case 2: View All Tables");
						System.out.println("case 3: Delete Table");
						System.out.println("Enter your choice");
						cho=s.nextInt();
						switch(cho)
						{
						case 1:
							
							break;
						case 2:
							break;
						case 3:
							break;
						}
						
					}while(cho!=0);
					
					break;
				case 2:
					int ch;
					do {
						System.out.println("case 1: Add New Customer");
						System.out.println("case 2: view Customer");
						System.out.println("case 3: Search Customer");
						System.out.println("case 4: Delete Customer");
						System.out.println("case 5: Update Customer");
						System.out.println("case 0: Exits ");
						System.out.println("Enter your choice");
						ch=s.nextInt();
						switch(ch)
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
							
							boolean b=cservice.isAddCustomer(custmodel);
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
						case 4:
							s.nextLine();
							System.out.println("Enter the delete Customer Name");
							name=s.nextLine();
							b=cservice.DeleteCustomerByName(name);
							if(b)
							{
								System.out.println("customer Deleted Sucessfully");
							}
							else {
								System.out.println("some Problem is there..........");
							}
							break;
						case 5:
							
							break;
						default:
							System.out.println("wrong choice valid");
						}
						
					}while(ch!=0);
					
					
				
					
					break;
				}
				
			}while(true);
		}
		
		

	}

