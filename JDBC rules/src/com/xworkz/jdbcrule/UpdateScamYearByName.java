package com.xworkz.jdbcrule;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateScamYearByName {

	
	public static void  main(String[] args) {
		
		String username="root";
		String password="vcj2330";
		String url="jdbc:mysql://localhost:3306/java.jdbc";
		String fqnOfDriverImpl="com.mysql.cj.jdbc.Driver";
		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			String updateSql = "update scam_table set s_year=2017 where s_name='IPL Scam' ";
			Statement state = connect.createStatement();
			state.execute(updateSql);
			System.out.println(connect);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
