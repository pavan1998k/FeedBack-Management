package com.ty.feedback.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.Participant;
import com.ty.feedback.service.ParticipantsService;

@WebServlet(value="/validateParticipant")
public class ValidateParticipant extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ParticipantsService participantsService=new ParticipantsService();
		List<Participant> participants=participantsService.validateParticipant(req.getParameter("email"), req.getParameter("password"));
		if(participants.size()>0) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewTrainingProgram.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("HomePage.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
