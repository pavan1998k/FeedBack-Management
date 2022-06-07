package com.ty.feedback.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.feedback.dto.Courses;
import com.ty.feedback.dto.Faculties;

public class FacultiesDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public Faculties createFaculties(Faculties faculties) {
		entityTransaction.begin();
		entityManager.persist(faculties);
		entityTransaction.commit();
		return faculties;
	}
	public List<Faculties> getAllFaculties(){
		Query query=entityManager.createQuery("SELECT f FROM Faculties f");
		return query.getResultList();
	}
	public Faculties getFacultiesById(int id) {
		return entityManager.find(Faculties.class, id);
	}
	public Faculties updateFaculties(Faculties faculties) {
		Faculties faculties2=entityManager.find(Faculties.class, faculties);
		faculties2.setId(faculties.getId());
		faculties2.setName(faculties.getName());
		faculties2.setEmail(faculties.getEmail());
		faculties2.setPassword(faculties.getPassword());
		faculties2.setPhone(faculties.getPhone());
		faculties2.setSalary(faculties.getSalary());
		faculties2.setSkills(faculties2.getSkills());
		
		entityTransaction.begin();
		entityManager.persist(faculties2);
		entityTransaction.commit();
		return faculties2;
	}
	public Faculties deleteFaculties(int id) {
		Faculties faculties=entityManager.find(Faculties.class, id);
		entityTransaction.begin();
		entityManager.remove(faculties);
		entityTransaction.commit();
		return faculties;
	}
}
