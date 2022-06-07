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

@WebServlet(value="/createFaculty")
public class SaveFaculty extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		double salary=Double.parseDouble(req.getParameter("salary"));
		String skills=req.getParameter("skill");

		Faculties faculties=new Faculties();
		faculties.setName(name);
		faculties.setEmail(email);
		faculties.setPhone(phone);
		faculties.setPassword(password);
		faculties.setSalary(salary);
		faculties.setSkills(skills);
		faculties.setGender(gender);

		FacultiesService facultiesService=new FacultiesService();
		Faculties faculties1=facultiesService.createFaculties(faculties);
		if(faculties1 != null) {
			req.setAttribute("faculties", faculties1);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("ViewFaculty.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("HomePage.jsp");
			requestDispatcher.include(req, resp);
		}
	}

}

