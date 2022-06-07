package com.ty.feedback.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.feedback.dto.FeedBack;

public class FeedBackDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public FeedBack addFeedBack(FeedBack feedBack) {
		entityTransaction.begin();
		entityManager.persist(feedBack);
		entityTransaction.commit();
		return feedBack;
	}
	public List<FeedBack> getAllFeedBackPrograms(){
		Query query=entityManager.createQuery("SELECT f FROM FeedBack f");
		return query.getResultList();
	}
	public FeedBack getFeedBackById(int id) {
		return entityManager.find(FeedBack.class, id);
	}
	public FeedBack updateTrainingPrograms(FeedBack feedBack) {
		FeedBack feedBack2=entityManager.find(FeedBack.class, feedBack);
		feedBack2.setId(feedBack.getId());
		feedBack2.setName(feedBack.getName());
		feedBack2.setFacultyName(feedBack.getFacultyName());
		feedBack2.setCourseName(feedBack.getCourseName());
		feedBack2.setDescription(feedBack.getDescription());
		feedBack2.setRatings(feedBack.getRatings());
		entityTransaction.begin();
		entityManager.merge(feedBack2);
		entityTransaction.commit();
		return feedBack2;
	}
	public FeedBack deleteFeedBackById(int id) {
		FeedBack feedBack=entityManager.find(FeedBack.class, id);
		entityTransaction.begin();
		entityManager.remove(feedBack);
		entityTransaction.commit();
		return feedBack;
	}
}
