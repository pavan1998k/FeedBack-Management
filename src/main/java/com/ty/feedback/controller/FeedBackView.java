package com.ty.feedback.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.FeedBack;
import com.ty.feedback.service.FeedBackService;

@WebServlet(value="/viewFeedBack")
public class FeedBackView extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FeedBackService feedBackService=new FeedBackService();
		List<FeedBack> feedBack=feedBackService.getAllFeedBackPrograms();
		
		if(feedBack.size()>0) {
			req.setAttribute("viewFeedBack", feedBack);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ViewFeedBack.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("HomePage.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
