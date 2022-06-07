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

@WebServlet(value="/createFeedBack")
public class FeedBackCreate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String fname=req.getParameter("fname");
		String cname=req.getParameter("cname");
		String description=req.getParameter("description");
		String ratings=req.getParameter("ratings");
		
		FeedBack feedBack= new FeedBack();
		feedBack.setName(name);
		feedBack.setFacultyName(fname);
		feedBack.setCourseName(cname);
		feedBack.setDescription(description);
		feedBack.setRatings(ratings);
		
		FeedBackService feedBackService=new FeedBackService();
		FeedBack feedBack1=feedBackService.addFeedBack(feedBack);
		
		if(feedBack1 != null) {
			//req.setAttribute("createFeedBack", feedBack1);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("DisplayFeedBack.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Home.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
