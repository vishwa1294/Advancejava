package com.xworkz.customer.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customer.constant.*;
import com.xworkz.customer.dto.CustomerDTO;


public class CustomerDAOImpl implements CustomerDAO {
	@Override

	public int save(CustomerDTO dto ) {
		int aiId = 0;
		System.out.println("*****saving dto ******" + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(JDBCconnection.URL, JDBCconnection.USERNAME,JDBCconnection.PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into jdbc.customer_table(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_EducationType)values(?,?,?,?,?,?,?)";
			PreparedStatement pre = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pre.setString(1, dto.getName());
			pre.setString(2, dto.getFrom());
			pre.setString(3, dto.getTo());
			pre.setString(4, dto.getAddress());
			pre.setString(5, dto.getMarried());
			pre.setInt(6, dto.getPassportNo());
			pre.setString(7,dto.getEducation().toString());
			pre.execute();
			ResultSet resultSet = pre.getGeneratedKeys();
			if (resultSet.next()) {
				aiId = resultSet.getInt(1);
			}
			dto.setId(aiId);
			connection.commit();
			System.out.println(dto);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();

			}
		}
		return aiId;
	}
	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		int aiId = 0;
		
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(JDBCconnection.USERNAME,JDBCconnection.PASSWORD,JDBCconnection.URL)){
			tempConnection = connection;
	        connection.setAutoCommit(false);
	String query = "insert into jdbc.customer_table(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_EducationType)values(?,?,?,?,?,?,?)";
	PreparedStatement pre = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);;
	PreparedStatement statement = connection.prepareStatement(query);
	collection.forEach(dto->{
		try {
			pre.setString(1, dto.getName());
			pre.setString(2, dto.getFrom());
			pre.setString(3, dto.getTo());
			pre.setString(4, dto.getAddress());
			pre.setString(5, dto.getMarried());
			pre.setInt(6, dto.getPassportNo());
			pre.setString(7, dto.getEducation().toString());

	statement.execute();

	System.out.println(dto);
		}
		catch(Exception e)

		
		{

		}

		});
	connection.commit();

		}
		catch(Exception e)

		{

		e.printStackTrace();try
		{
			tempConnection.rollback();
		}catch(
		SQLException e1)
		{
			e1.printStackTrace();
		}

		return;
		}
	}

	
	@Override
	public int total() {
		int total = 0;
		try (Connection connection = DriverManager.getConnection(JDBCconnection.URL, JDBCconnection.USERNAME, JDBCconnection.PASSWORD)) {
			String query = "SELECT count(c_id) FROM jdbc.customer_table";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				total = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return total;
	}

	
	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(JDBCconnection.URL,JDBCconnection.USERNAME,JDBCconnection.PASSWORD)) {
			String query = "select * from jdbc.customer_table order by c_name desc";

			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		Optional<CustomerDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(JDBCconnection.URL, JDBCconnection.USERNAME,JDBCconnection.PASSWORD)) {
			String query = "select * from jdbc.customer_table";

			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}

	private ResultSet createdFromPreparedStatement(Connection connection, String query) throws SQLException {
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.execute();
		ResultSet result = prepare.getResultSet();
		return result;
	}

	private CustomerDTO createdValuesFromResultSet(ResultSet result) throws SQLException {
		int id = result.getInt("c_id");
		String name = result.getString("c_name");
		String from = result.getString("c_from");
		String to = result.getString("c_to");
		String address = result.getString("c_address");
		String married = result.getString("c_married");
		int passportNo = result.getInt("c_passportNo");
		String education = result.getString("c_educationType");

		CustomerDTO dto = new CustomerDTO(name, from, to, address,married,passportNo,EducationType.valueOf(education));
		dto.setId(id);
		return dto;
	}
	
	

	@Override
	public Collection<CustomerDTO> findAll() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(JDBCconnection.URL,JDBCconnection.USERNAME,JDBCconnection.PASSWORD) ){
			String query = "select * from jdbc.customer_table";

			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				collection.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(JDBCconnection.URL, JDBCconnection.USERNAME,JDBCconnection.PASSWORD)) {
			String query = "select * from jdbc.customer_table";
			ResultSet result = createdFromPreparedStatement(connection, query);
			while (result.next()) {
				CustomerDTO dto = createdValuesFromResultSet(result);
				if (predicate.test(dto)) {
					collection.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

}