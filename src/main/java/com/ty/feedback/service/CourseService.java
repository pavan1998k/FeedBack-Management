package com.ty.feedback.service;

import java.util.List;

import javax.persistence.Query;

import com.ty.feedback.dao.CourseDao;
import com.ty.feedback.dto.Courses;

public class CourseService {
	CourseDao courseDao=new CourseDao();
	public Courses createCourse(Courses courses) {
		return courseDao.createCourse(courses);
	}
	public List<Courses> getAllCourse() {
		return courseDao.getAllCourse();
	}
	public Courses getCourseById(int id) {
		return courseDao.getCourseById(id);
	}
	public Courses updateCourse(Courses courses) {
		return courseDao.updateCourse(courses);
	}
	public Courses deleteCourseById(int id) {
		return courseDao.deleteCourseById(id);
	}
}
