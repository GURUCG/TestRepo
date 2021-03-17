package SDETJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TestJDBCForUpdate {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
		Driver dr=new Driver();
		DriverManager.registerDriver(dr);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		Statement cs = con.createStatement();
		int eup = cs.executeUpdate("insert into project(project_name,project_id, teamsize)values('rahul_101','kumar_121',50)");
		if(eup==1)
		{
			System.out.println("row insterted successfully");
			ResultSet eqs = cs.executeQuery("select* from project");
			while(eqs.next())
			{
				System.out.println(eqs.getString(1)+"\t"+eqs.getString(2)+"\t"+eqs.getString(3));
			}
		}
		else
		{
			System.out.println("row not instered");
		}}
		
		catch(Exception e)
		{
			
		}
		finally
		{
			con.close();
			System.out.println("connection closed succesfully");
		}
	}
}
