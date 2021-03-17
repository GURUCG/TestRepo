package SDETJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TestJBDBC {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		//step1:register Database
		Driver dr = new Driver();
		DriverManager.registerDriver(dr);
		//step2:get connection for database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		//create statement
		Statement cst = con.createStatement();
		//execute the query
		ResultSet rst = cst.executeQuery("select * from project");
		while(rst.next())
		{
			System.out.println(rst.getString(1)+"\t"+rst.getString(2)+"\t"+rst.getString(3));
		}
		con.close();
	}
}
