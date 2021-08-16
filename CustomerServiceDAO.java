package com.xworkz.customer.service;

import java.util.Collection;

import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customer.dto.CustomerDTO;

public interface CustomerServiceDAO {

	int validateAndSave(CustomerDTO dto);
	
	Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate);
	
	Collection<CustomerDTO> findAll();
	
	Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate);
	
	Collection<CustomerDTO> findAllSortByNameAsc();
	
	int total();

	void validateAndSaveAll(Collection<CustomerDTO> collect);

	
}


