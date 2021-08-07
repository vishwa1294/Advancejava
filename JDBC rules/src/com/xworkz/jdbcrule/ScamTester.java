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

					String query="insert into jdbc.scam_table values(60,'2G Spectrum','United Progressive Alliance',2017,'Politicians',70.000,'India',' biggest scam The coal allocation scam, also referred to as 'Coalgate' is a political scandal that swamped the UPA government in 2012 implicated the former Prime Minister'), (61,'IPL','spot-fixing and betting case',2013,'Rajasthan Royals',500.0000,'Delhi',' the Rajasthan Royal  financial institutions reported frauds worth Rs 1.38 trillion in 2020-21, down 25 per cent compared to the previous year, when the amount involved was Rs 1.85 trillion, according to the Reserve Bank of India's  '),(62,'Telgi','Money',2000,'Abdul Karim Telgi',20.0000,'Bengaluru','He earned money Banks and other financial institutions reported frauds worth Rs 1.38 trillion in 2020-21, down 25 per cent compared to the previous year, when the amount involved was Rs 1.85 trillion, according to the Reserve Bank of Teligi '), (63,'Bofors','Middlemen in Indian arms deals ',2019,'Chitra Subramaniam Duella',350.0000,'India','Bofors-India Howitzer deal '),(64,'Railgate Scam','Indian Railway Board',2012,' Pawan Kumar Bansal','India',7,'with the help of  telephonic conversations '),(65,'Hawala Scandal','Banking',1996,'N K Jain','India',1.8,'Money transfer based on owner Delhi Police files fresh FIR against Malvinder and Shivinder for Rs 400 crore 'fraud' , Malvinder and Shivinder Singh, the former')(66,'Kavya Scam','Banking',1997,'Kavya','India',190.00,'Money transfer based on owner based on the requriments in india has been disclosed'),(67,'Hawala Scandal','Banking',1960,'N K Jain','India',1.8,'Money transfer based on owner')(68,'Railgate Scam','Indian Railway Board',2017,' Pawan Kumar Bansal','India',7,'with the help of  telephonic conversations '),(69,'cash-for-votes scandal','Election',2008,'Soniya Gandhi','India',2,'to pursue the Indo-US nuclear deal '),(70,'Saradha Group chit fund scam','Financial',2013,' Debjani Mukhopadhdhay ','West Bengal.',15.3,'variety of collective investment schemes'),(71,'Antrix Devas scam','Scientific',2011,'G Madhavan Nair','Bengal.',14.8,'build the satellites without disclosing fact Delhi Police files fresh FIR against Malvinder and Shivinder for Rs 400 crore 'fraud' According to the FIR, Malvinder and Shivinder Singh, the former '),(72,'Chopper Scam','Helicaptors',2013,'Santosh Bagrodia, Satish Bagrodia','Italy',3.8,'VVIP helicopter deal'),(73,'Bellary mining scam','Mining leases',2006,'Reddy brothers','Bellary',16.0,' Delhi Police files fresh FIR against Malvinder and Shivinder for Rs 400 crore 'fraud' According to the FIR, Malvinder and Shivinder Singh, the former '),(74,' Fodder scam','fictitious livestock',1996,'Jagannath Mishra','India',950,'medicines and animal husbandry equipment'),(75,'Coal scam','corruption',2000,' Abhishek Banerjee ','Bengal.',40,'imprisonment in a coal block '),(76,'Telegi scam','Govt Problems',2016,' Poloticians ','Delhi',350.00,'imprisonment in a Telelgi block Delhi Police files fresh FIR against Malvinder and Shivinder for Rs 400 crore 'fraud' According to the FIR, Malvinder and Shivinder Singh, the former'),(77,'Satyam scam','Govt Problems',2019,' Indian Scam ','Delhi',140.00,'imprisonment in a Telelgi block '),(78,' HARSHAD MEHTAscam','Govt Problems',2014,' Indian Scam ','Delhi',160.00,'imprisonment in a Telelgi block Banks and other financial institutions reported frauds worth Rs 1.38 trillion in 2020-21, down 25 per cent compared to the previous year, when the amount involved was Rs 1.85 trillion, according to the Reserve Bank of India's (RBI's) '),(79,' COBBLER','United Progressive Alliance',2017,'Politicians',200.000,'India',' biggest Scam'),(80,' PWC Bank Scam','United Banks',2019,'Employes',400.000,'India',' biggest Scam Banks and other financial institutions reported frauds worth Rs 1.38 trillion in 2020-21, down 25 per cent compared to the previous year, when the amount involved was Rs  according to the Reserve Bank of India's (RBI's) '),";
						Statement statement = connection.createStatement();";
						Statement statement = connection.createStatement();
						statement.execute(query);
						
						}catch(SQLException E) {
							E.printStackTrace();
						}
		}
	}
	

						
					
	
