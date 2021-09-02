package com.xworkz.camera.tester;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.camera.dao.CameraDAO;
import com.xworkz.camera.dao.CameraDAOImpl;
import com.xworkz.camera.entity.CameraEntity;

public class CameraSaveListTester {

	public static void main(String[] args) {

		CameraDAO dao = new CameraDAOImpl();

		CameraEntity entity1 = new CameraEntity("DSLR", "DSLR ICON", "DSLR", 48569, 455, "Li-Ion", 3, false, 34);
		CameraEntity entity2 = new CameraEntity("Nikon JAA830DA", "Nikon", "DSLR", 162990, 486, "Li-Ion", 4, true, 20);
		CameraEntity entity3 = new CameraEntity("Sony Cybershot DSC", "Sony", "Digital", 948666, 353, "Li-Ion", 5, true,
				50);

		List<CameraEntity> list = new ArrayList<>();
		list.add(entity1);
		list.add(entity2);
		list.add(entity3);

		dao.saveList(list);
	}
}
