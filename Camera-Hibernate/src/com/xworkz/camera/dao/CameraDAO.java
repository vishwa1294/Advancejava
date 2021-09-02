package com.xworkz.camera.dao;

import java.util.List;

import com.xworkz.camera.entity.CameraEntity;

public interface CameraDAO {

	void save(CameraEntity entity);
	CameraEntity readById(int id);
	void updateNameById(int id, String name);
	void deleteById(int id);
	void saveList(List<CameraEntity> entities);
	void deleteList(List<Integer> ids);
}
