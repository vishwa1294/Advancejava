package com.xworkz.customer;
import java.util.Arrays;

import java.util.Collection;
import java.util.Optional;

import com.xworkz.customer.constant.EducationType;

import com.xworkz.customer.dao.CustomerDAO;
import com.xworkz.customer.dao.CustomerDAOImpl;
import com.xworkz.customer.dto.CustomerDTO;
import com.xworkz.customer.service.CustomerServiceDAO;
import com.xworkz.customer.service.CustomerServiceDAOImpl;

public class CustomerTester {

	public static void main(String[] args) {
		CustomerDTO dto=new CustomerDTO("Sachin","Bangalore","Bgk","Near Basav Road",true,346475,EducationType.BE);
		CustomerDTO dto1=new CustomerDTO("Pavitra","Jkd","Bjp","Ashok Circle near bjp road",false,683475,EducationType.BSC);
		
		CustomerServiceDAO service = new CustomerServiceDAOImpl();
		service.validateAndSave(dto);
		service.validateAndSave(dto1);
		
		CustomerDAO dao = new CustomerDAOImpl();
		Collection<CustomerDTO> collection = dao.findAll();
		service.validateAndSaveAll(collection);
		Optional<CustomerDTO> findOne = dao.findOne((g) -> g.getName().equalsIgnoreCase("Pavitra"));
		if (findOne.isPresent()) {
			CustomerDTO temp = findOne.get();
			System.out.println(" optional findOne():" + temp);
		}
		Collection<CustomerDTO> collection1 = dao.findAllSortByNameDesc();
		collection1.forEach((desc) -> System.out.println("sorting name in descending order:" + desc));

		Collection<CustomerDTO> findAll = dao.findAll((g) -> g.isMarried() == true);
		findAll.forEach((pre) -> System.out.println(" predicate:" + pre));

		dao.saveAll(collection);

	}

}
