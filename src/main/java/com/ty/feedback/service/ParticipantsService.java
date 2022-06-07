package com.ty.feedback.service;

import java.util.List;

import com.ty.feedback.dao.ParticipantDao;
import com.ty.feedback.dto.Participant;


public class ParticipantsService {
	ParticipantDao participantsDao = new ParticipantDao();
	public Participant saveParticipants(Participant participants) {
		return participantsDao.saveParticipants(participants);
	}

	public List<Participant> getAllParticipants() {
		return participantsDao.getAllParticipants();
	}

	public Participant updateParticipants(Participant participants) {
		return participantsDao.updateParticipants(participants);
	}

	public Participant deleteParticipants(int id) {
		return participantsDao.deleteParticipants(id);
	}
	public List<Participant> validateParticipant(String email, String password){
		return participantsDao.validateParticipant(email, password);
	}
}
