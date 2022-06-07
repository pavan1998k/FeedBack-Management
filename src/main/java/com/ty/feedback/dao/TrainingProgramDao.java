package com.ty.feedback.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.feedback.dto.TrainingPrograms;

public class TrainingProgramDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public TrainingPrograms addTrainingPrograms(TrainingPrograms trainingPrograms) {
		entityTransaction.begin();
		entityManager.persist(trainingPrograms);
		entityTransaction.commit();
		return trainingPrograms;
	}
	public List<TrainingPrograms> getAllTrainingPrograms(){
		Query query=entityManager.createQuery("SELECT tp FROM TrainingPrograms tp");
		return query.getResultList();
	}
	public TrainingPrograms getTrainingProgramById(int id) {
		return entityManager.find(TrainingPrograms.class, id);
	}
	public TrainingPrograms updateTrainingPrograms(TrainingPrograms trainingPrograms) {
		TrainingPrograms trainingPrograms2=entityManager.find(TrainingPrograms.class, trainingPrograms);
		trainingPrograms2.setId(trainingPrograms.getId());
		trainingPrograms2.setName(trainingPrograms.getName());
		trainingPrograms2.setStartingDate(trainingPrograms.getStartingDate());
		trainingPrograms2.setEndingdate(trainingPrograms.getEndingdate());
		trainingPrograms2.setFacultyName(trainingPrograms.getFacultyName());
		entityTransaction.begin();
		entityManager.merge(trainingPrograms2);
		entityTransaction.commit();
		return trainingPrograms2;
	}
	public TrainingPrograms deleteTrainingProgramById(int id) {
		TrainingPrograms trainingPrograms=entityManager.find(TrainingPrograms.class, id);
		entityTransaction.begin();
		entityManager.remove(trainingPrograms);
		entityTransaction.commit();
		return trainingPrograms;
	}
}
