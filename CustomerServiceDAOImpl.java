package com.xworkz.customer.service;

import java.util.Collection;

import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customer.dao.CustomerDAO;
import com.xworkz.customer.dao.CustomerDAOImpl;
import com.xworkz.customer.dto.CustomerDTO;

public class CustomerServiceDAOImpl  implements CustomerServiceDAO {

	private CustomerDAO dao = new CustomerDAOImpl();
	 
	boolean nameValid = false;
	boolean fromValid = false;
	boolean toValid = false;
	boolean addressValid = false;
	boolean marriedValid = false;
	boolean passportValid = false;
	boolean educationValid = false;

	@Override
	public int validateAndSave(CustomerDTO dto) {
		int validation = 0;
		if (dto != null) {
			String name = dto.getName();
			if (name != null && !name.isEmpty() && name.length() > 3 && name.length() <= 20)
				System.out.println("name valid");
				validation++;
			String education = dto.getEducation().toString();
			if (education != null && !education.isEmpty())
				System.out.println("education valid");
				validation++;
			int passportNo = dto.getPassportNo();
			if (passportNo != 0)
				System.out.println("passport no valid");
				validation++;
			String from = dto.getFrom();
			if (from != null && !from.isEmpty())
				System.out.println("from valid");
				validation++;
			String to = dto.getTo();
			if (to != null && !to.isEmpty())
				System.out.println("to valid");
				validation++;
			if (validation == 5)
				validation = dao.save(dto);
		}
		return validation;
	}

	@Override
	public void validateAndSaveAll(Collection<CustomerDTO> collection) {
		if (!collection.isEmpty()) {
			collection.forEach(dto -> {
				this.validateAndSave(dto);
			});
		}
		
		}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		return dao.findOne(predicate);
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		return dao.findAll();
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		return dao.findAll(predicate);
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameAsc() {
		return dao.findAllSortByNameDesc();
	}

	@Override
	public int total() {
		return dao.total();
	}

}


