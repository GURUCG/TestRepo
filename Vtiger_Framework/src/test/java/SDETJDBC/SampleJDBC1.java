package SDETJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBC1 {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
		//step: register the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		//step2: get connection for the database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		//step3:create statement;
		Statement cst = con.createStatement();
		//step4:execute the query
		int executeUpdate = cst.executeUpdate("insert into project(project_name,project_id, teamsize)values('project_101','proj101',20)");
		if(executeUpdate==1)
		{
			System.out.println("query executed");
			System.out.println(executeUpdate);
		}
		else
		{
			System.out.println("query failed");
			
		}
	}
	catch(Exception e)	
		{
		
		}
		//step 5
		finally
		{
			con.close();
			System.out.println("connection closed");
		}
		
	}
}
