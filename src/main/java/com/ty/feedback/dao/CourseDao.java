package com.ty.feedback.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.feedback.dto.Courses;

public class CourseDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public Courses createCourse(Courses courses) {
		entityTransaction.begin();
		entityManager.persist(courses);
		entityTransaction.commit();
		return courses;
	}
	public List<Courses> getAllCourse() {
		Query query=entityManager.createQuery("SELECT c FROM Courses c");
		return query.getResultList();
	}
	public Courses getCourseById(int id) {
		return entityManager.find(Courses.class, id);
	}
	public Courses updateCourse(Courses courses) {
		Courses courses2=entityManager.find(Courses.class, courses);
		courses2.setId(courses.getId());
		courses2.setCourseName(courses.getCourseName());
		courses2.setDuration(courses.getDuration());
		courses2.setFees(courses.getFees());
		entityTransaction.begin();
		entityManager.merge(courses2);
		entityTransaction.commit();
		return courses2;
	}
	public Courses deleteCourseById(int id) {
		Courses courses=entityManager.find(Courses.class, id);
		entityTransaction.begin();
		entityManager.remove(courses);
		entityTransaction.commit();
		return courses;
	}
}
