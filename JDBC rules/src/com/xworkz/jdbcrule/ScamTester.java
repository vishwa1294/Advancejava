package com.xworkz.jdbcrule;
 import java.sql.Connection;

 import java.sql.DriverManager;
 import java.sql.SQLException;
 import java.sql.Statement;


	public class ScamTester {
		
		public static void  main(String[] args) {
				
				String username="root";
				String password="vcj2330";
				String url="jdbc:mysql://localhost:3306/java.jdbc";
				String fqnOfDriverImpl="com.mysql.cj.jdbc.Driver";
				
				try ( Connection connection=DriverManager.getConnection(url, username, password))
				{

					String query="insert into jdbc.scam_table values(60,'2G Spectrum','United Progressive Alliance',2017,'Politicians',70.000,'India',' biggest scam '), (61,'IPL','spot-fixing and betting case',2013,'Rajasthan Royals',500.0000,'Delhi',' the Rajasthan Royal'),(62,'Telgi','Money',2000,'Abdul Karim Telgi',20.0000,'Bengaluru','He earned money'), (63,'Bofors','Middlemen in Indian arms deals ',2019,'Chitra Subramaniam Duella',350.0000,'India','Bofors-India Howitzer deal '),(64,'Railgate Scam','Indian Railway Board',2012,' Pawan Kumar Bansal','India',7,'with the help of  telephonic conversations '),(65,'Hawala Scandal','Banking',1996,'N K Jain','India',1.8,'Money transfer based on owner')(66,'Hawala Scandal','Banking',1996,'N K Jain','India',1.8,'Money transfer based on owner'),(67,'Hawala Scandal','Banking',1996,'N K Jain','India',1.8,'Money transfer based on owner')(68,'Railgate Scam','Indian Railway Board',2017,' Pawan Kumar Bansal','India',7,'with the help of  telephonic conversations '),(69,'cash-for-votes scandal','Election',2008,'Soniya Gandhi','India',2,'to pursue the Indo-US nuclear deal '),(70,'Saradha Group chit fund scam','Financial',2013,' Debjani Mukhopadhdhay ','West Bengal.',15.3,'variety of collective investment schemes'),(71,'Antrix Devas scam','Scientific',2011,'G Madhavan Nair','Bengal.',14.8,'build the satellites without disclosing fact'),(72,'Chopper Scam','Helicaptors',2013,'Santosh Bagrodia, Satish Bagrodia','Italy',3.8,'VVIP helicopter deal'),(73,'Bellary mining scam','Mining leases',2006,'Reddy brothers','Bellary',16.0,'xchange for issuing mining leases '),(74,' Fodder scam','fictitious livestock',1996,'Jagannath Mishra','India',950,'medicines and animal husbandry equipment'),(75,'Coal scam','corruption',2000,' Abhishek Banerjee ','Bengal.',40,'imprisonment in a coal block ')";
						Statement statement = connection.createStatement();
						statement.execute(query);
						
						}catch(SQLException E) {
							E.printStackTrace();
						}
		}
	}
	

						
					
	