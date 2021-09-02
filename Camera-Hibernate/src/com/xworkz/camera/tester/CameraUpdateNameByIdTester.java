package com.xworkz.camera.tester;

import com.xworkz.camera.dao.CameraDAO;
import com.xworkz.camera.dao.CameraDAOImpl;

public class CameraUpdateNameByIdTester {

	public static void main(String[] args) {
		
		CameraDAO dao = new CameraDAOImpl();
		dao.updateNameById(1, "DSLR");

	}
}

