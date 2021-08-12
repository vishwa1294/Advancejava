package com.xworkz.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.restaurant.constant.JdbcConnection;
import com.xworkz.restaurant.dto.RestaurantDTO;

public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public int save(RestaurantDTO dto) {

		System.out.println("saving dto into DB " + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(JdbcConnection.url, JdbcConnection.username,
				JdbcConnection.password)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into jdbc.restaurant_table values(2,'" + dto.getName() + "','" + dto.getLocation() + "'," + "'"
					+ dto.getSpecialFood() + "'," + dto.isBest() + ",'" + dto.getType() + "')";
			Statement statement = connection.createStatement();
			statement.execute(query);
			
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}
	@Override
	public RestaurantDTO findByName(String name) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "select * from restaurant where r_name='" + name + "'";
			Statement st = conn.createStatement();
			st.execute(query);
			ResultSet set = st.getResultSet();
			if (set.next()) {
				int id = set.getInt("r_id");
				String rname = set.getString("r_name");
				String rlocation = set.getString("r_location");
				String rspcl = set.getString("r_specialFood");
				boolean rbest = set.getBoolean("r_best");
				String rtype = set.getString("r_type");

				RestaurantDTO res = new RestaurantDTO(rname, rlocation, rspcl, rbest, RestaurantType.valueOf(rtype));
				res.setId(id);
				return res;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<RestaurantDTO> findByType(RestaurantType type) {
		Collection coll = new ArrayList();
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String str = "select * from restaurant where r_type='" + type + "'";
			Statement st = con.createStatement();
			st.execute(str);
			ResultSet st = st.getResultSet();
			if (st.next()) {
				int resid = st.getInt("r_id");
				String resname = st.getString("r_name");
				String reslocation = st.getString("r_location");
				String resspcl = st.getString("r_specialFood");
				boolean resbest = st.getBoolean("r_best");
				String restype = st.getString("r_type");

				RestaurantDTO dto = new RestaurantDTO(resname, reslocation, resspcl, resbest,
						RestaurantType.valueOf(restype));
				dto.setId(resid);
				coll.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coll;
	}

}


