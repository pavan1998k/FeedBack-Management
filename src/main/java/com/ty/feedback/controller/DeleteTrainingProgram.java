package com.ty.feedback.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.TrainingPrograms;
import com.ty.feedback.service.TrainingProgramService;

public class DeleteTrainingProgram extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TrainingProgramService trainingProgramService=new TrainingProgramService();
		int id=Integer.valueOf((String)req.getParameter("id"));
		TrainingPrograms trainingPrograms=trainingProgramService.deleteTrainingProgramById(id);
		if(trainingPrograms!= null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ViewTrainingProgram.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Home.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
