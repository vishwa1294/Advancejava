package com.xworkz.camera.tester;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.camera.dao.CameraDAO;
import com.xworkz.camera.dao.CameraDAOImpl;

public class CameraDeleteListTester {

	public static void main(String[] args) {

		CameraDAO dao = new CameraDAOImpl();
		List<Integer> ref = new ArrayList<>();
		ref.add(1);
		ref.add(2);
		dao.deleteList(ref);

	}
}