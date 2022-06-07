package com.ty.feedback.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.TrainingPrograms;
import com.ty.feedback.service.TrainingProgramService;

@WebServlet(value="/saveTraining")
public class TrainingProgramSave extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		LocalDate startingDate=LocalDate.parse(req.getParameter("startingDate"));
		LocalDate endingDate=LocalDate.parse(req.getParameter("endingDate"));
		String facultyName=req.getParameter("facultyName");
		
		TrainingPrograms trainingPrograms=new TrainingPrograms();
		trainingPrograms.setName(name);
		trainingPrograms.setStartingDate(startingDate);
		trainingPrograms.setEndingdate(endingDate);;
		trainingPrograms.setFacultyName(facultyName);
		
		TrainingProgramService trainingProgramService=new TrainingProgramService();
		TrainingPrograms tPrograms=trainingProgramService.addTrainingPrograms(trainingPrograms);
		if(tPrograms!= null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ViewProgram");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Home.jsp");
			requestDispatcher.include(req, resp);
		}
		
	}
}
