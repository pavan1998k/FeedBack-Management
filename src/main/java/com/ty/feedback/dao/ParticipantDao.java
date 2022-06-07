package com.ty.feedback.dao;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.feedback.dto.Participant;

public class ParticipantDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Participant saveParticipants(Participant participant) {
		entityTransaction.begin();
		entityManager.persist(participant);
		entityTransaction.commit();
		return participant;
	}

	public List<Participant> getAllParticipants() {
		Query query = entityManager.createQuery("select p from Participants p");
		return query.getResultList();
	}

	public Participant updateParticipants(Participant participants) {
		Participant participants1 = entityManager.find(Participant.class, participants.getId());
		participants1.setId(participants.getId());
		participants1.setName(participants.getName());
		participants1.setEmail(participants.getEmail());
		participants1.setPhone(participants.getPhone());

		entityTransaction.begin();
		entityManager.merge(participants1);
		entityTransaction.commit();
		return participants1;
	}

	public Participant deleteParticipants(int id) {
		Participant participants = entityManager.find(Participant.class, id);

		entityTransaction.begin();
		entityManager.remove(participants);
		entityTransaction.commit();
		return participants;
	}
	public List<Participant> validateParticipant(String email, String password){
		Query query=entityManager.createQuery("select p from Participant p where c.email=?1 and c.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		return query.getResultList();
	}
}
