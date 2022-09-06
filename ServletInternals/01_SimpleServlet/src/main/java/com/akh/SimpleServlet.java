package com.akh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akh.util.Util;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(
		name = "simpleServletName", //just a name to the servlet. Not used in the URL.
		description = "Simple servlet implementation", 
		urlPatterns = { "/mypath" }
)
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SimpleServlet doGet()");
		Util.printDebugInfoToWriter(req, resp, getServletName());
	}
	
	

}
	