package com.ty.feedback.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.TrainingPrograms;
import com.ty.feedback.service.TrainingProgramService;

@WebServlet(value="/ViewProgram")
public class TrainingProgramView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TrainingProgramService trainingProgramService=new TrainingProgramService();
		List<TrainingPrograms> list=trainingProgramService.getAllTrainingPrograms();
		
		if(list.size()>0){
			req.setAttribute("viewProgram", list);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ViewTrainingProgram.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("HomePage.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
