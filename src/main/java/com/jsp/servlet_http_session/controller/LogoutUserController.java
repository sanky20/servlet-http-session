package com.jsp.servlet_http_session.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value="/logoutUser")
public class LogoutUserController extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("init method of logout controller called");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method of logout controller called");

	}
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service method of logout controller called");

		HttpSession httpSession = req.getSession();
		
		String email= (String)httpSession.getAttribute("userEmail");
		
		if(email!=null)
		{
			httpSession.invalidate();
			req.setAttribute("msg", "logout successful...");

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("msg", "login first..");

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}
	
}
