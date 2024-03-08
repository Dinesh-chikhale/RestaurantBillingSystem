package Resto_Repository;

import java.sql.Date;
import java.sql.ResultSet;

import Resto_Model.CustomerModel;

public class CustomerRepository extends DatabasesConn{
	int custid=0;
	public int getIdByCustomer()
	{
		try {
		stmt=conn.prepareStatement("select max(custid) from customer");
		rs=stmt.executeQuery();
		if(rs.next())
		{
			custid=rs.getInt(1);
		}++custid;
	}catch(Exception ex)
	{
		System.out.println("Error is "+ex);
		return 0;
	}
	return custid;
}
	
	
	public boolean isAddCustomer(CustomerModel cmodel)
	{
		try {
			
			int custid=this.getIdByCustomer();
			@SuppressWarnings("deprecation")
			String custDate=cmodel.getDate().toLocaleString();
			String d[]=custDate.split(",");
			String datesplit[]=d[0].split("-");
			System.out.println(datesplit[0]+"\t"+datesplit[1]+"\t"+datesplit[2]);
			//int month[]=new int[] {0,1,2,3,4,5,6,7,8,9,10,11};
			int m=0;
			switch(datesplit[1])
			{
			case "Jan":
				m=0;
				break;
			case "Feb":
				m=1;
				break;
			case "Mar":
				m=2;
				break;
			case "April":
				m=3;
				break;
			case "May":
				m=4;
				break;
			case "June":
				m=5;
				break;
			case "July":
				m=6;
				break;
			case "August":
				m=7;
				break;
			case "September":
				m=8;
				break;
			case "Octamber":
				m=9;
				break;
			case "Nov":
				m=10;
				break;
			case "December":
				m=11;
				break;	
			}	
			System.out.println(datesplit[2]);
			String newYear=datesplit[2].substring(2,4).toString();
			@SuppressWarnings("deprecation")
			Date custdate=new Date(Integer.parseInt(newYear)+100,m,Integer.parseInt(datesplit[0]));
			stmt=conn.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			stmt.setInt(1, custid);
			stmt.setString(2, cmodel.getName());
			stmt.setString(3,cmodel.getEmail());
			stmt.setString(4,cmodel.getContact());
			stmt.setString(5,cmodel.getAddress());
			stmt.setDate(6, custdate);
			int val=stmt.executeUpdate();
			if(val>0)
			{
				return true;
			}
			else {
				return false;
			}
			
			
			
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
		
	}
	public boolean viewCustomer(CustomerModel cmodel)
	{
		try {
			stmt=conn.prepareStatement("select *from customer");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getDate(6));

				
			}
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
		return false;
	}
	
	public boolean SearchByName(String name)
	{
		try {
			stmt=conn.prepareStatement("select *from customer where name=?");
			stmt.setString(1,name);
			rs=stmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getDate(6));
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			return false;
		}
	}
	public boolean DeleteCustomerByName(String name)
	{
		try {
			stmt=conn.prepareStatement("delete from customer where name=?");
			stmt.setString(1, name);
			int val=stmt.executeUpdate();
			if(val!=0)
			{
				return true;
				
			}
			else {
				return false;
			}
			
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;

		}
	}

}
