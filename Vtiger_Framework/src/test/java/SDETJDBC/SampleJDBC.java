package SDETJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBC {
	public static void main(String[] args) throws SQLException {
		//use connection:its return type of connection, by the we can access by anywhere
		Connection con=null;
		//step1 : register the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//step2: get connection for database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		
		//step3: create statement
		Statement stat = con.createStatement();
		
		//step4:execute the query
		ResultSet result = stat.executeQuery("select* from project");
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		//step5: close connection
		con.close();
		
		
		
	}
}
