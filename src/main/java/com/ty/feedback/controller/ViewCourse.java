package com.ty.feedback.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.Courses;
import com.ty.feedback.service.CourseService;

@WebServlet(value="/ViewCourse")
public class ViewCourse extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CourseService courseService=new CourseService();
		List<Courses> cList=courseService.getAllCourse();
		
		if(cList.size()>0) {
			req.setAttribute("viewCourse", cList);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ViewCourse.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("HomePage.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
