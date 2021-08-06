package com.xworkz.jdbcrule;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateLocationById {
	public static void  main(String[] args) {
		
		String username="root";
		String password="vcj2330";
		String url="jdbc:mysql://localhost:3306/java.jdbc";
		String fqnOfDriverImpl="com.mysql.cj.jdbc.Driver";
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String updateSql = "update scam_table set s_location='India' where s_id=70 ";
			Statement state = connection.createStatement();
			state.execute(updateSql);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}


}
}
