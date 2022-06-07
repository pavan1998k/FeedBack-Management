package com.ty.feedback.service;

import java.util.List;

import com.ty.feedback.dao.FacultiesDao;
import com.ty.feedback.dto.Faculties;

public class FacultiesService {
	FacultiesDao facultiesDao=new FacultiesDao();
	public Faculties createFaculties(Faculties faculties) {
		return facultiesDao.createFaculties(faculties);
	}
	public List<Faculties> getAllFaculties(){
		return facultiesDao.getAllFaculties();
	}
	public Faculties getFacultiesById(int id) {
		return facultiesDao.getFacultiesById(id);
	}
	public Faculties updateFaculties(Faculties faculties) {
		return facultiesDao.updateFaculties(faculties);
	}
	public Faculties deleteFaculties(int id) {
		return facultiesDao.deleteFaculties(id);
	}
}
