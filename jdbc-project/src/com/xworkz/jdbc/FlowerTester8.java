package com.xworkz.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FlowerTester8 {
	
	public static void main(String[] args) {
		String username = "root";
		String password = "vcj2330";
		String url = "jdbc:mysql://localhost:3306/java.jdbc ";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		Connection connection = null;
		try {
			Class.forName(fqnOfDriverImpl);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);

			String query = "insert into flower values (14,'Whiterose','white','female',6,21,true,false,false,false)";

			Statement statement = connection.createStatement();

			statement.execute(query);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}


