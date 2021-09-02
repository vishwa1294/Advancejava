package com.xworkz.camera.tester;

import com.xworkz.camera.dao.CameraDAO;
import com.xworkz.camera.dao.CameraDAOImpl;
import com.xworkz.camera.entity.CameraEntity;

public class CameraSaveTester {

	public static void main(String[] args) {
		
		CameraDAO dao = new CameraDAOImpl();
		
		CameraEntity entity1 = new CameraEntity("DSLR","Nikon","DSLR",586953,576,"Li-Ion",1,false,45);
		CameraEntity entity2 = new CameraEntity("Nikon JAA830DA","Nikon","DSLR",839886,755,"Li-Ion",4,true,75);
		CameraEntity entity3 = new CameraEntity("Sony Cybershot DSC","Sony","Digital",934593,768,"Li-Ion",5,true,23);
		
		dao.save(entity1);
		dao.save(entity2);
		dao.save(entity3);
	}
}
