package com.xworkz.restaurant;

import java.util.Collection;

import com.xworkz.restaurant.constant.RestaurantType;
import com.xworkz.restaurant.dao.RestaurantDAO;
import com.xworkz.restaurant.dao.RestaurantDAOImpl;
import com.xworkz.restaurant.dto.RestaurantDTO;

public class RestaurantTester {

	public static void main(String[] args) {

		RestaurantDTO dto = new RestaurantDTO("Dwaraka", "Ashok Circle", "PavBhaji", true, RestaurantType.FAST_FOOD);
		RestaurantDTO dto1 = new RestaurantDTO("Ayodhya", "Desai Circle", "Dosa", false, RestaurantType.SELF_SERVICE);
		RestaurantDTO dto2 = new RestaurantDTO("SecondWife", "Mudhol Road", "KajuKari", true,RestaurantType.FAMILY);

		RestaurantDAO dao = new RestaurantDAOImpl();
		dao.save(dto);
		dao.save(dto1);
		dao.save(dto2);

		System.out.println(dao.findByName("Ayodhya"));

		Collection<RestaurantDTO> collection = dao.findByType(RestaurantType.FAMILY);
		collection.forEach(ref -> System.out.println(ref));

		System.out.println(dao.updateTypeByName(RestaurantType.FAST_FOOD, "Dwaraka"));

		System.out.println(dao.deleteByTypeAndName(RestaurantType.SELF_SERVICE, "SecondWife"));
	}

}