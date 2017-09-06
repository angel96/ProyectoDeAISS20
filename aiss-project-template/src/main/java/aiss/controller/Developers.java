package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Developers extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(Developers.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Sample log
		log.log(Level.FINE, "Processing GET request");
		 
		resp.setContentType("text/html");
		resp.getWriter().println("<html>"
				+ "<head><title>Desarrolladores</title></head>"
				+ "<body> <h1>Desarrolladores</h1>"
				+ "<table> <p>Reyes Cabello Holgado</p> <p>Ángel Delgado Luna</p> </table>"
				+ "<p><a href = '/index.jsp'>Volver al inicio</a></p></body>"
				+ "</html>");
	}
}
