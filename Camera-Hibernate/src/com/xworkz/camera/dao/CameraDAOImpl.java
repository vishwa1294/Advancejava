package com.xworkz.camera.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.camera.entity.CameraEntity;
import com.xworkz.camera.util.SFUtil;

public class CameraDAOImpl implements CameraDAO {

	private SessionFactory sf = SFUtil.getFactory();

	@Override
	public void save(CameraEntity entity) {
		try (Session session = sf.openSession()) {
			Transaction trans = session.beginTransaction();
			System.out.println("Saved entity : " + session.save(entity));
			session.flush();
			session.clear();
			trans.rollback();
		}
	}

	@Override
	public CameraEntity readById(int id) {
		try (Session session = sf.openSession()) {
			CameraEntity entity = session.get(CameraEntity.class, id);
			System.out.println("Read entity : ");
			return entity;
		}
	}

	@Override
	public void updateNameById(int id, String name) {
		try (Session session = sf.openSession()) {
			Transaction trans = session.beginTransaction();
			CameraEntity entity = session.get(CameraEntity.class, id);
			entity.setName(name);
			System.out.println("updated name by id : " + entity);
			trans.commit();
		}
	}

	@Override
	public void deleteById(int id) {
		try (Session session = sf.openSession()) {
			Transaction trans = session.beginTransaction();
			CameraEntity entity = session.get(CameraEntity.class, id);
			session.delete(entity);
			System.out.println("deleted by id : " + entity);
			trans.commit();
		}
	}

	@Override
	public void saveList(List<CameraEntity> entities) {
		try (Session session = sf.openSession()) {
			Transaction trans = session.beginTransaction();
			entities.forEach(entity -> {
				session.save(entity);
				System.out.println(entity);
			});
			trans.commit();
		}
	}

	@Override
	public void deleteList(List<Integer> ids) {
		try (Session session = sf.openSession()) {
			Transaction trans = session.beginTransaction();
			ref.forEach(entity -> {
				CameraEntity camEntity = session.get(CameraEntity.class, entity);
				if (ref.contains(entity)) {
					session.delete(camEntity);
					System.out.println(camEntity);
				}
			});
			trans.commit();
		}
	}
}
