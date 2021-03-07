package Edureka;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Basic extends HttpServlet {
	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = " welcome to all in First Servetlet";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");

	}

	public void destroy() {
		// do nothing
	}
}
