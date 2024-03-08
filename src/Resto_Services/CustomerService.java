package Resto_Services;

import Resto_Model.CustomerModel;
import Resto_Repository.CustomerRepository;

public class CustomerService {

	CustomerRepository cRepo=new CustomerRepository();
	public boolean isAddCustomer(CustomerModel cmodel)
	{
		return cRepo.isAddCustomer(cmodel);
	}
	
	public boolean viewCustomer(CustomerModel cmodel)
	{
		return cRepo.viewCustomer(cmodel);
		
	}
	public boolean SearchByName(String name)
	{
		return cRepo.SearchByName(name);
	}
	public boolean DeleteCustomerByName(String name)
	{
		return cRepo.DeleteCustomerByName(name);
	}
}
