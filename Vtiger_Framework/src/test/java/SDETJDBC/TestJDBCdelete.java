package SDETJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TestJDBCdelete {
public static void main(String[] args) throws SQLException {
	Connection con=null;
	try {
	Driver dr=new Driver();
	DriverManager.registerDriver(dr);
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
	Statement cst = con.createStatement();
	int executeUpdate = cst.executeUpdate("update project set project_name='rk_508' where teamsize=50");
	System.out.println(executeUpdate);
	
	if(executeUpdate!=0)
	{
		System.out.println("update success");
		ResultSet executeQuery = cst.executeQuery("select * form project");
		while(executeQuery.next())
		{
			System.out.println(executeQuery.getString(1)+"\t"+executeQuery.getString(2)+"\t"+executeQuery.getString(3));
		}
		
	}
	else
	{
		System.out.println("not update");
	}
	}
	catch(Exception e)
	{
		
	}
	finally
	{
	con.close();
	System.out.println("connection closed");
	}
	
}
}
