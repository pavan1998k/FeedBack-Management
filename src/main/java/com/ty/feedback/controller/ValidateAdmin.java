package com.ty.feedback.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.Admin;
import com.ty.feedback.service.AdminService;

@WebServlet(value="/adminValidate")
public class ValidateAdmin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		AdminService adminService = new AdminService();
		List<Admin> admin = adminService.vallidateAdmin(req.getParameter("email"),req.getParameter("password"));
		if(admin.size()>0) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Admin.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminLogin.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
