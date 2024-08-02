package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.collegedb;
import services.collegeservice;

@WebServlet("/delete")

public class deleteservlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		collegeservice service = new collegeservice(collegedb.conn());
		
		boolean f = service.deletebyid(id);
	
		if(f) {
			
			resp.sendRedirect("welcome.jsp");
			
		} else {
			
			resp.sendRedirect("welcome.jsp");
			
		}
	}
	

}
