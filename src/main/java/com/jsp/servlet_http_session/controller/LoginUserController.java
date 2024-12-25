package com.jsp.servlet_http_session.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/loginUser")
public class LoginUserController extends HttpServlet {

	@Override
	public void destroy() {
		System.out.println("destroy method of login controller called");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init method of login controller called");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service method of login controller called");

		HttpSession httpSession = req.getSession(); // this method first checks if there is a session already existing
													// or not...
													// if yes , then it will fetch the existing session otherwise it
													// will create a new session
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		httpSession.setMaxInactiveInterval(30);

		if (email.equalsIgnoreCase("sanky@gmail.com")) {
			if (password.equals("123")) {

				httpSession.setAttribute("userEmail", email);

				req.getRequestDispatcher("home.jsp").forward(req, resp);
			} else {

				req.setAttribute("msg", "password is wrong");

				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else {

			req.setAttribute("msg", "email is wrong");
			req.getRequestDispatcher("login.jsp").forward(req, resp);

		}
	}

}
