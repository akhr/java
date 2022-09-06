package com.akh.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {
	
	public static void printDebugInfoToWriter(HttpServletRequest req, HttpServletResponse resp, String servletName) throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().append("<h3>").append("ContextPath :: ").append(req.getContextPath()).append("</h3>");
		resp.getWriter().append("<h3>").append("ServletPath :: ").append(req.getServletPath()).append("</h3>");
		resp.getWriter().append("<h3>").append("PathInfo :: ").append(req.getPathInfo()).append("</h3>");
		resp.getWriter().append("<h3>").append("PathTranslated :: ").append(req.getPathTranslated()).append("</h3>");
		resp.getWriter().append("<h3>").append("Hello from the "+servletName+".doGet()").append("</h3>");
	}

}
