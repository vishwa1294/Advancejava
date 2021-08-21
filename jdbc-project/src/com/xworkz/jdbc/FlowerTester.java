package com.xworkz.jdbc;
     import java.sql.Connection;

	import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.jdbc.constant.JdbcConnection;


  public class FlowerTester {

		public static void main(String[] args) {
			
			String username="root";
			String password="vcj2330";
			String url="jdbc:mysql://localhost:3306/java.jdbc";
			String fqnOfDriverImpl="com.mysql.cj.jdbc.Driver";
			
			try {
				Class.forName(fqnOfDriverImpl);
				Connection connection = DriverManager.getConnection(url, username, password);
				String query = "insert into flower_table values(1,'Rose','Tradtional'7,true,true,false,true,true,false,true)";
				String query1 = "insert into flower_table values(2,'Lotus','Custom',9,false,true,true,false,true,false,true)";
				String query2 = "insert into flower_table values(3,'Dasaval','Custom',1,false,true,false,false,true,false,true)";

				Statement statement = connection.createStatement();
				statement.execute(query);
				statement.execute(query1);
				statement.execute(query2);

				ResultSet resultSet = statement.getResultSet();
				while (resultSet.next()) {
					resultSet.getInt("f_id");
					resultSet.getString("f_name");
					resultSet.getString("f_type");

				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
	}