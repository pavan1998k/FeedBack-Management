package com.ty.feedback.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.Courses;
import com.ty.feedback.service.CourseService;

@WebServlet(value="/addCourses")
public class AddCourseDetails extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String courseName=req.getParameter("CourseName");
		double fees=Double.parseDouble(req.getParameter("fees"));
		String duration=req.getParameter("duration");

		Courses courses=new Courses();
		courses.setCourseName(courseName);
		courses.setDuration(duration);
		courses.setFees(fees);

		CourseService courseService=new CourseService();
		Courses courses1=courseService.createCourse(courses);
		if(courses1 != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ViewCourse");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("CreateCourse.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}

