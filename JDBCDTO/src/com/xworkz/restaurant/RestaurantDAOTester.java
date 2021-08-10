package com.xworkz.restaurant;

import com.xworkz.restaurant.constant.RestaurantType;
import com.xworkz.restaurant.dao.RestaurantDAO;
import com.xworkz.restaurant.dao.RestaurantDAOImpl;
import com.xworkz.restaurant.dto.RestaurantDTO;

public class RestaurantDAOTester {
	public static void main(String[] args) {
		RestaurantDTO dto=new RestaurantDTO("Dwaraka Restaurant","Desai Circle","PavBhaji",true,RestaurantType.FAST_FOOD);
		RestaurantDTO dto1=new RestaurantDTO("Ayodhya Restaurant","Ashok Circle","Dosa",false,RestaurantType.FAMILY);
		
		RestaurantDAO dao=new RestaurantDAOImpl();
		dao.save(dto);
		dao.save(dto1);
	}

}
