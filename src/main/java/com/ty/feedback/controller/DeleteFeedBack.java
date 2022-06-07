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

@WebServlet(value="/deleteFeedBack")
public class DeleteFeedBack extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FeedBackService feedBackService=new FeedBackService();
		int id=Integer.valueOf((String)req.getParameter("id"));
		FeedBack feedBack=feedBackService.deleteFeedBackById(id);
		if(feedBack != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ViewFeedBack.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Home.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
