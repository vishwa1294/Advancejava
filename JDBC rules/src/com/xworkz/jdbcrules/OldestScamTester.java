package com.xworkz.jdbcrules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.jdbc.constants.JdbcConstants;
import com.xworkz.jdbc.dto.ScamDTO;

public class OldestScamTester {

	public static void main(String[] args) {
		
		try (Connection connect = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {

			String query = "select * from scam where s_year = (select min(s_year) from scam)";

			Statement statement = connect.createStatement();
			statement.execute(query);
			ResultSet set = statement.getResultSet();
			ScamDTO dto = null;
			List<ScamDTO> list = new ArrayList<ScamDTO>();
			while (set.next()) {
				ScamDTO obj = new ScamDTO();
				obj.setYear(set.getInt("s_year"));
				int sId = set.getInt("s_id");
				String sName = set.getString("s_name");
				String sType = set.getString("s_type");
				int sAmount = set.getInt("s_amountincrores");
				String sBy = set.getString("s_by");
				String sLocation = set.getString("s_location");
				String sDescr = set.getString("s_description");
				int sYear = set.getInt("s_year");

				System.out.println(sName);

				dto = new ScamDTO(sId, sName, sType, sBy, sAmount, sLocation, sYear, sDescr);
				System.out.println(dto);
				System.out.println(dto.hashCode());
				list.add(obj);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}

