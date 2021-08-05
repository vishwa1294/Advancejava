package com.xworkz.jdbc;
     import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
import java.sql.Statement;

	public class JdbcTester {

		public static void main(String[] args) {
			
			String username="root";
			String password="vcj2330";
			String url="jdbc:mysql://localhost:3306/java.jdbc";
			String fqnOfDriverImpl="com.mysql.cj.jdbc.Driver";
			
			try {
			
			Connection connection=DriverManager.getConnection(url, username, password);
			
			String query="insert into jdbc.insuranceof_table values(4,'Vaish','Car',2,'Max',50000)";
			String query1="insert into jdbc.insuranceof_table values(2,'Girija','Car',2,'Max',50000)";
			String query2="insert into jdbc.insuranceof_table values(3,'Pavitra','Car',4,'Mac',1000000)";
			
			
			Statement statement = connection.createStatement();
			statement.execute(query);
			statement.execute(query1);
			statement.execute(query2);
			System.out.println(connection);
			}catch(SQLException E) {
				E.printStackTrace();
			}
			
			

}
		}
