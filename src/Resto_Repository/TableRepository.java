package Resto_Repository;

import Resto_Model.TableModel;

public class TableRepository  extends DatabasesConn{
	
	int tid=0;
	public int getIdByTables()
	{
		try {
		stmt=conn.prepareStatement("select max(tid) from tables");
		rs=stmt.executeQuery();
		if(rs.next())
		{
			tid=rs.getInt(1);
		}++tid;
	}catch(Exception ex)
	{
		System.out.println("Error is "+ex);
		return 0;
	}
	return tid;
}
	
	public boolean isAddTable(TableModel tmodel)
	{
		try {
			int tid=this.getIdByTables();
			stmt=conn.prepareStatement("insert into tables values(?,?)");
			stmt.setInt(1, tid);
			stmt.setInt(2,tmodel.getTableno());
			int v=stmt.executeUpdate();
			if(v>0)
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
	public boolean viewTable()
	{
		try
		{
			stmt=conn.prepareStatement("select distinct table_no as 'Table Number' from tables");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt(1));
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

}
