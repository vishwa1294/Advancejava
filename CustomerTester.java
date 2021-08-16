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
		CustomerDTO dto=new CustomerDTO("Sachin","Bangalore","Bgk","Near Basav Road","Unmarried",346475,EducationType.BE);
		CustomerDTO dto1=new CustomerDTO("Pavitra","Jkd","Bjp","Ashok Circle near bjp road","Married",683475,EducationType.BSC);
		
		 CustomerDAO dao1 = new  CustomerDAOImpl();
		dao1.save(dto1);
		dao1.save(dto);
		
		System.out.println("Total customer saved :" +dao1.total());
		
		Collection<CustomerDTO> collection=dao1.findAll();
		
		collection.forEach(f->System.out.println("FindAll :"+f));
		
		Optional<CustomerDTO> findOne = dao1.findOne((g) -> g.getName().equals("Pavitra"));
		if (findOne.isPresent()) {
			CustomerDTO temp = findOne.get();
			System.out.println(" optional findOne():" + temp);
		}
		Collection<CustomerDTO> collection1 = dao1.findAllSortByNameDesc();
		collection1.forEach((desc) -> System.out.println("sorting name in descending order:" + desc));

		Collection<CustomerDTO> findAll = dao1.findAll((g) -> g.getPassportNo() >= 300);
		findAll.forEach((pre) -> System.out.println(" predicate:" + pre));
		
		CustomerServiceDAO dao = new CustomerServiceDAOImpl();
		dao.validateAndSave(dto);
		dao.validateAndSave(dto1);
		
		Collection<CustomerDTO> collect = Arrays.asList(dto, dto1);
		dao.validateAndSaveAll(collect);
		System.out.println("************************************");


		
	}

}

