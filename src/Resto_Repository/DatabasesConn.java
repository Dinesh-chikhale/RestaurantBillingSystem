package Resto_Repository;
import java.sql.*;
public class DatabasesConn {

	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	public DatabasesConn()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/RestoApp","root","root");
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
	}

}
