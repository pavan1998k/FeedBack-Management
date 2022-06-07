package com.ty.feedback.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.Participant;
import com.ty.feedback.service.ParticipantsService;

@WebServlet(value="/saveParticipants")
public class SaveParticipants extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		Long phone=Long.parseLong(req.getParameter("phone"));

		Participant participant=new Participant();
		participant.setName(name);
		participant.setEmail(email);
		participant.setPhone(phone);

		ParticipantsService participantsService=new ParticipantsService();
		Participant participant2=participantsService.saveParticipants(participant);

		if(participant2 != null) {
			req.setAttribute("participant", participant2);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("CreateFeedBack.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("HomePage.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}

