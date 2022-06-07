package com.ty.feedback.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.FeedBack;
import com.ty.feedback.service.FeedBackService;

@WebServlet(value="/edit")
public class EditFeedBack extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String description=req.getParameter("description");
		String ratings=req.getParameter("ratings");
		
		FeedBack feedBack= new FeedBack();
		feedBack.setDescription(description);
		feedBack.setRatings(ratings);
		
		FeedBackService feedBackService=new FeedBackService();
		FeedBack feedBack1=feedBackService.deleteFeedBackById(id);
		
		if(feedBack1 != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ViewFeedBack.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Home.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
