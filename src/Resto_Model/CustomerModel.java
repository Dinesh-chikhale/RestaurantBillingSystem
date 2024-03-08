package Resto_Model;

import java.util.Date;

public class CustomerModel {

	private int custid;
	private String name;
	private String email;
	private String contact;
	private String address;
	private Date date;
	public CustomerModel()
	{
		
	}
	public CustomerModel(String name,String email,String contact,String address,Date date)
	{
		this.name=name;
		this.email=email;
		this.contact=contact;
		this.address=address;
		this.date=date;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
