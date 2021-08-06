package com.xworkz.jdbcrule;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesterDeleteByName {


	
	public static void  main(String[] args) {
		
		String username="root";
		String password="vcj2330";
		String url="jdbc:mysql://localhost:3306/java.jdbc";
		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			String deleteSql = "delete from scam_table where s_name='2G Spectrum'";
			Statement state = connect.createStatement();
			state.execute(deleteSql);
			System.out.println(connect);
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
