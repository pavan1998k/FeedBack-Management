package com.ty.feedback.controller;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.CoOrdinate;
import com.ty.feedback.service.CoOrdinateService;

@WebServlet(value="/saveCoOrdinate")
public class CoOrdinateSave extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		
		CoOrdinate coOrdinate = new CoOrdinate();
		coOrdinate.setName(name);
		coOrdinate.setEmail(email);
		coOrdinate.setPassword(password);
		coOrdinate.setPhone(phone);
		
		CoOrdinateService coOrdinateService = new CoOrdinateService();
		CoOrdinate coOrdinate1 = coOrdinateService.saveCoOrdinate(coOrdinate);
		if(coOrdinate1 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminHome.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CoOrdinateCreate.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
