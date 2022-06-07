package com.ty.feedback.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.Faculties;
import com.ty.feedback.service.FacultiesService;

@WebServlet(value="/delete")
public class DeleteFacultyDetails extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FacultiesService facultiesService=new FacultiesService();
		int id=Integer.valueOf((String)req.getParameter("id"));
		Faculties faculties=facultiesService.deleteFaculties(id);
		if(faculties != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ViewFaculty.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("HomePage.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
