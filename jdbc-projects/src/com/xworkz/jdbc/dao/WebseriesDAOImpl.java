package com.xworkz.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.jdbc.dto.WebseriesDTO;
import com.xworkz.jdbc.dto.constants.Aspirants;
import com.xworkz.jdbc.dto.constants.Aspirants2;

import static com.xworkz.jdbc.dto.constants.JdbcConstant.*;

public class WebseriesDAOImpl implements WebseriesDAO {

	@Override
	public int save(WebseriesDTO dto) {
		System.out.println(dto);
		Connection tempConnection = null;
		int temp = 0;

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into websereis_table(w_name,w_noOfEpisodes,w_totalSeason,w_streamedIn,w_genre,w_yestAgeIndaNodbohudu)values(?,?,?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			prepare.setString(1, dto.getName());
			prepare.setInt(2, dto.getNoOfEpisodes());
			prepare.setInt(3, dto.getTotalSeason());
			prepare.setString(4, dto.getStreamedIn().toString());
			prepare.setString(5, dto.getGenre().toString());
			prepare.setInt(6, dto.getYestAgeIndaNodbohudu());
			prepare.execute();
			ResultSet result = prepare.getGeneratedKeys();
			if (result.next()) {
				temp = result.getInt(1);
				System.out.println(temp);
			}
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				}
		}
		return temp;
	}
	@Override
	public int total() {
		int count=0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT count(w_id) FROM websereis_table";
			ResultSet set = createdFromPreparedStatement(connection, query);

			if (set.next()) {
				 count = set.getInt(1);
				}
            } catch (SQLException e) {
			e.printStackTrace();
		}
	
		return count;
	}
	@Override
	public int findMaxSeason() {
		int count=0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT max(w_totalSeason) FROM websereis_table";
			ResultSet set = createdFromPreparedStatement(connection, query);

			if (set.next()) {
				 count = set.getInt(1);
				}
            } catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	private ResultSet createdFromPreparedStatement(Connection connection, String query) throws SQLException {
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.execute();

		ResultSet set = prepare.getResultSet();
		return set;
	}
	
@Override
public int findMinSeason() {
	int count=0;
	try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
        String query = "SELECT min(w_totalSeason) FROM websereis_table";
		ResultSet set = createdFromPreparedStatement(connection, query);

		if (set.next()) {
			 count = set.getInt(1);
			}
        } catch (SQLException e) {
		e.printStackTrace();
	}
	return count;
}
@Override
public Collection<WebseriesDTO> findAll() {
	Collection<WebseriesDTO> list=new ArrayList<WebseriesDTO>();
	try(Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD)){
		
		String query="select * from websereis_table";
		PreparedStatement prepare=connection.prepareStatement(query);
		ResultSet result=prepare.executeQuery();
		while(result.next()) {
			WebseriesDTO dto = createdValuesFromResultSet(result);
			list.add(dto);

		}
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
	return list;
}
private WebseriesDTO createdValuesFromResultSet(ResultSet result) throws SQLException {
	int id=result.getInt("w_id");
	String name=result.getString("w_name");
	int episodes=result.getInt("w_noOfEpisodes");
	int total=result.getInt("w_totalSeason");
	String stream=result.getString("w_streamedIn");
	String genre=result.getString("w_genre");
	int age=result.getInt("w_yestAgeIndaNodbohudu");

	WebseriesDTO dto=new WebseriesDTO( name, episodes, total, StreamedIn.valueOf(stream),Genre.valueOf(genre),age);
	dto.setId(id);
	return dto;
}
@Override
public Collection<WebseriesDTO> findAllSortByNameDesc() {
	Collection<WebseriesDTO> list=new ArrayList<WebseriesDTO>();
	try(Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD)){
		
		String query="select * from websereis_table order by w_name desc";
		PreparedStatement prepare=connection.prepareStatement(query);
		ResultSet result=prepare.executeQuery();
		while(result.next()) {
			WebseriesDTO dto = createdValuesFromResultSet(result);
			list.add(dto);

		}
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
	return list;
}
@Override
public Collection<WebseriesDTO> findAll(Predicate<WebseriesDTO> predicate) {
	Collection<WebseriesDTO> list=new ArrayList<WebseriesDTO>();

	try(Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD)){
		String query="select * from websereis_table";
		PreparedStatement prepare=connection.prepareStatement(query);
		ResultSet result=prepare.executeQuery();
		
		while(result.next()) {
			WebseriesDTO dto = createdValuesFromResultSet(result);
			if(predicate.test(dto)) {
			list.add(dto);
			}
		}
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
	return list;
}
@Override
public Optional<WebseriesDTO> findOne(Predicate<WebseriesDTO> predicate) {
	Optional<WebseriesDTO> optional=Optional.empty();
	try(Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD)){
		String query="select * from websereis_table";
		PreparedStatement prepare=connection.prepareStatement(query);
		ResultSet result=prepare.executeQuery();
		
		while(result.next()) {
			WebseriesDTO dto = createdValuesFromResultSet(result);
			if(predicate.test(dto)) {
				optional=Optional.of(dto);
				break;
			}
			}
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
		
	return optional;
}

}