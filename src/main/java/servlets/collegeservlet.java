package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.collegedb;
import models.college;
import services.collegeservice;

@WebServlet("/register")

public class collegeservlet extends HttpServlet{

	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		
		String branch = req.getParameter("branch");
		
		String email = req.getParameter("email");
//				
//		college clg = new college(name,branch,email);
		college clg = new college(name,branch,email);
		collegeservice service = new collegeservice(collegedb.conn());
		
		boolean i = service.addcollege(clg);
		
		if (i) {
			
			resp.sendRedirect("welcome.jsp");

		} else {
		
			resp.sendRedirect("register.jsp");
		
		}
		
		
	}
}
