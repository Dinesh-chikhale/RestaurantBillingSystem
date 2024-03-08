package Resto_Repository;

import Resto_Model.MenuModel;

public class MenuRepository extends DatabasesConn{
	
	int custid=0;
	public int getIdByMenu()
	{
		try {
		stmt=conn.prepareStatement("select max(fid) from menu");
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

	public boolean isAddMenu(MenuModel model)
	{
		try {
			
			int fid=this.getIdByMenu();
			stmt=conn.prepareStatement("insert into menu values(?,?,?)");
			stmt.setInt(1, fid);
			stmt.setString(2,model.getFname());
			stmt.setInt(3,model.getPrice());
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
	
	public boolean ViewFood()
	{
		try {
			stmt=conn.prepareStatement("select *from menu");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}
			return true;
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
	}
	
	public boolean searchByName(String name)
	{
		try {
			stmt=conn.prepareStatement("select *from menu  where fname='"+name+"'");
			rs=stmt.executeQuery();
			if(rs.next())
			{				
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
				return true;
			}
			else {
				return false;
			}
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			return false;
		}
		
	}
	public boolean deleteByName(String name)
	{
		try {
			stmt=conn.prepareStatement("delete from menu where fname=?");
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
			System.out.println("Error is"+ex);
			return false;
			
		}
		
	}
	public boolean updateByName(MenuModel model,String name)
	{
		try {
			stmt=conn.prepareStatement("update menu set fname=?,price=? where fname='"+name+"'");
			stmt.setString(1,model.getFname());
			stmt.setInt(2,model.getPrice());
			
			int v=stmt.executeUpdate();
		
			if(v>0)
			{
				System.out.println("Successfully");
				return true;
			}
			else {
				System.out.println("Not up");
				return false;
			}
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
		
	}
}
