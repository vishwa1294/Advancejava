package com.xworkz.jdbc;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 import java.sql.Statement;

	public class TechnologyTester {
		
		static Connection connection;
		

	public static void  main(String[] args) {
				
				String username="root";
				String password="vcj2330";
				String url="jdbc:mysql://localhost:3306/java.jdbc";
				String fqnOfDriverImpl="com.mysql.cj.jdbc.Driver";
				
				try {
					
				
				 connection=DriverManager.getConnection(url, username, password);
				
				String query="insert into jdbc.technology_table values(102,'Jdbc',16,'Writing the data integrationscript','Windows'), (103,'Sql',16,'Writing the queries','Windows'),(104,'CSS',16,'Develop the web designs','Jolicloud'), (105,'Python',3.5,'Control and managemen tand testing','Linux'),(106,'HTML',4.00,'Jolicloud','Develop the web applications')";
				
				
				
				
				Statement statement = connection.createStatement();
				statement.execute(query);
				
				
				System.out.println(connection);
				
				}catch(SQLException E) {
					E.printStackTrace();
				}
				finally {
					try {
						connection.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
				
	}			
	}
	
	


