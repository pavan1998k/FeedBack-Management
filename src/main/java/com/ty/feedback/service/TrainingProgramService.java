package com.ty.feedback.service;

import java.util.List;

import com.ty.feedback.dao.TrainingProgramDao;
import com.ty.feedback.dto.TrainingPrograms;

public class TrainingProgramService {
	TrainingProgramDao trainingProgramDao=new TrainingProgramDao();
	public TrainingPrograms addTrainingPrograms(TrainingPrograms trainingPrograms) {
		return trainingProgramDao.addTrainingPrograms(trainingPrograms);
	}
	public List<TrainingPrograms> getAllTrainingPrograms(){
		return trainingProgramDao.getAllTrainingPrograms();
	}
	public TrainingPrograms getTrainingProgramById(int id) {
		return trainingProgramDao.getTrainingProgramById(id);
	}
	public TrainingPrograms updateTrainingPrograms(TrainingPrograms trainingPrograms) {
		return trainingProgramDao.updateTrainingPrograms(trainingPrograms);
	}
	public TrainingPrograms deleteTrainingProgramById(int id) {
		return trainingProgramDao.deleteTrainingProgramById(id);
	}
}
