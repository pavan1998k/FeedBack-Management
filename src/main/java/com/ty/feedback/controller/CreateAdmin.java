package com.ty.feedback.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.Admin;
import com.ty.feedback.service.AdminService;

@WebServlet(value="/RegisterAdmin")
public class CreateAdmin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("usrnm");
		String email=req.getParameter("email");
		String password =req.getParameter("psw");
		long phone=Long.parseLong(req.getParameter("pn"));
		
		Admin admin=new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(password);
		admin.setPhone(phone);
		
		AdminService adminService=new AdminService();
		Admin admin2=adminService.createAdmin(admin);
		if(admin2 !=  null) {
			req.setAttribute("Admin", admin2);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("AdminLogin.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("RegisterAdmin.jsp");
			requestDispatcher.include(req, resp);
		}
		
	}
}
