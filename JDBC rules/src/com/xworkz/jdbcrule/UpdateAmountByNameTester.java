package com.xworkz.jdbcrule;

	 import java.sql.Connection;

	 import java.sql.DriverManager;
	 import java.sql.SQLException;
	 import java.sql.Statement;


	 public class UpdateAmountByNameTester {
			
			public static void  main(String[] args) {
					
					String username="root";
					String password="vcj2330";
					String url="jdbc:mysql://localhost:3306/java.jdbc";
					String fqnOfDriverImpl="com.mysql.cj.jdbc.Driver";
					
					try ( Connection connection=DriverManager.getConnection(url, username, password)){
					
					String updateSql="update jdbc.scam_table set s_amount=500 where s_name='Bofors'";
							Statement temp = connection.createStatement();
							temp.execute(updateSql);
							
							}catch(SQLException E) {
								E.printStackTrace();
							}
			}
		
							
					{

}
}