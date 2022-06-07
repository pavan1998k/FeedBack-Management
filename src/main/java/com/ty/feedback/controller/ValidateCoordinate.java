package com.ty.feedback.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.feedback.dto.CoOrdinate;
import com.ty.feedback.service.CoOrdinateService;

@WebServlet(value="/validateCoOrdinate")
public class ValidateCoordinate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CoOrdinateService coOrdinateService = new CoOrdinateService();
		List<CoOrdinate> list = coOrdinateService.validateCoOrdinate(req.getParameter("email"),req.getParameter("password"));
		if(list.size()>0) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CoOrdinateHome.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CoordinateLogin.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
